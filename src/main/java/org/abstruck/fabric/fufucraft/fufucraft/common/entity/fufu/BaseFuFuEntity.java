package org.abstruck.fabric.fufucraft.fufucraft.common.entity.fufu;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.LiteralTextContent;
import net.minecraft.text.MutableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EntityView;
import net.minecraft.world.World;
import org.abstruck.fabric.fufucraft.fufucraft.common.entity.goal.StareGoal;
import org.abstruck.fabric.fufucraft.fufucraft.common.item.plant.LargePackOfRiceItem;
import org.abstruck.fabric.fufucraft.fufucraft.registry.ItemRegistry;
import org.abstruck.fabric.fufucraft.fufucraft.util.ModUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Astrack
 * @date 2023/7/10
 */
public abstract class BaseFuFuEntity extends TameableEntity {
    /**
     * fufu 喜欢的食物
     */
    protected int foodAteCount = 0;
    protected int hungryTickCount = 0;
    protected boolean isBaby = true;
    protected int tickCount = 0;
    protected static final Item[] ingredientItems = new Item[]{ItemRegistry.LARGE_PACK_OF_RICE,ItemRegistry.SMALL_PACK_OF_RICE};

    protected BaseFuFuEntity(EntityType<? extends BaseFuFuEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        for (Item ingredientItem : ingredientItems) {
            if (ingredientItem.equals(stack.getItem())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (canPickFuFu(player, hand)){
            return ride(player);
        }
        if (isTamed() && isOwner(player)){
            return super.interactMob(player,hand);
        }
        if (!isTamed()){
            ItemStack itemStack = player.getStackInHand(hand);
            if (!isBreedingItem(itemStack)){
                return ActionResult.PASS;
            } else if (itemStack.getItem() instanceof LargePackOfRiceItem) {
                //尝试驯服
                this.eat(player, hand, itemStack);
                if (this.random.nextInt(tameRateDenominator()) == 0) {
                    this.setOwner(player);
                    this.setSitting(true);
                    this.getWorld().sendEntityStatus(this, (byte)7);
                } else {
                    this.getWorld().sendEntityStatus(this, (byte)6);
                }
                this.setPersistent();
                return ActionResult.CONSUME;
            }
        }
        return ActionResult.PASS;
    }

    @NotNull
    private ActionResult ride(PlayerEntity player) {
        return startRiding(player) ? ActionResult.SUCCESS : ActionResult.FAIL;
    }

    private static boolean canPickFuFu(PlayerEntity player, Hand hand) {
        return player.isSneaking() && player.getStackInHand(hand).isEmpty();
    }

    @Override
    protected void eat(PlayerEntity player, Hand hand, ItemStack stack) {
        hungryTickCount = 1;
        foodAteCount++;
        if (foodAteCount>=128){
            setBaby(false);
        }
        super.eat(player, hand, stack);
    }

    @Override
    public void tick() {
        super.tick();
        effect();
        if (!isTamed()){
            return;
        }
        if (getWorld().getPlayerByUuid(getOwnerUuid()) == null) {
            return;
        }
        hungryTickCount++;
        tickCount++;
        if (hungryTickCount%(30*60*20)==0){
            searchInventoryForFood();
        }
        if (hungryTickCount>(30*60*20)){
            if (tickCount%(5*20)==0){
                if (getOwner() != null){
                    if (squaredDistanceTo(getOwner()) <= 16) {
                        getOwner().sendMessage(MutableText.of(new LiteralTextContent("")));
                    }
                }
            }
        }
        if (hungryTickCount%(150*60*20) == 0){
            rewild();
        }
    }

    protected void rewild() {
        setTamed(false);
        setOwner(null);
    }

    @Override
    public boolean isBaby() {
        return isBaby;
    }

    @Override
    public void setBaby(boolean baby) {
        this.isBaby = baby;
    }

    protected void searchInventoryForFood() {
        int startX = getBlockX() - 16;
        int stopX = getBlockX() + 16;
        int startY = getBlockY() - 16;
        int stopY = getBlockY() + 16;
        int startZ = getBlockZ() - 16;
        int stopZ = getBlockZ() + 16;

        for (int x = startX;x<=stopX;x++){
            for (int y = startY;y<=stopY;y++){
                for (int z = startZ;z<=stopZ;z++){
                    BlockPos blockPos = new BlockPos(x, y, z);
                    if (getWorld().getBlockEntity(blockPos) instanceof Inventory chest) {
                        if (getOwner() instanceof PlayerEntity player){
                            if (chest.canPlayerUse(player)) {
                                for (int i = 0;i<chest.size();++i){
                                    ItemStack itemStack = chest.getStack(i);
                                    if (itemStack.getItem() instanceof LargePackOfRiceItem){
                                        itemStack.decrement(1);
                                        hungryTickCount = 1;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        NbtCompound data = new NbtCompound();
        data.putBoolean("IsBaby",isBaby);
        data.putInt("HungryTickCount",hungryTickCount);
        data.putInt("FoodAteCount", foodAteCount);
        nbt.put(ModUtils.MOD_ID+":FuFuData",data);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        NbtCompound data = nbt.getCompound(ModUtils.MOD_ID+":FuFuData");
        this.isBaby = data.getBoolean("IsBaby");
        this.hungryTickCount = data.getInt("HungryTickCount");
        this.foodAteCount = data.getInt("FoodAteCount");
    }

    /**
     * @param source 伤害来源
     * @param amount 伤害大小
     * @return 永远是false 因为fufu不会受到伤害
     */
    @Override
    public boolean damage(DamageSource source, float amount) {
        return false;
    }

    /**
     * 设置fufu看着手拿喜欢的食物的玩家
     * 设置fufu看着玩家
     * 设置fufu四处环视
     */
    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(0, new StareGoal(this,Ingredient.ofItems(ingredientItems)));
        this.goalSelector.add(1, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(2, new LookAroundGoal(this));
    }

    /**
     *
     * @return fufu 不会自己动
     */
    @Override
    public boolean canMoveVoluntarily() {
        return false;
    }

    @Override
    public boolean canTakeDamage() {
        return false;
    }

    @Override
    public boolean canAttackWithOwner(LivingEntity target, LivingEntity owner) {
        return false;
    }

    @Override
    protected boolean canAddPassenger(Entity passenger) {
        return false;
    }

    @Override
    public boolean canTarget(LivingEntity target) {
        return false;
    }

    @Override
    protected boolean canStartRiding(Entity entity) {
        return false;
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    protected final EntityDimensions babyDimension = new EntityDimensions(1.0f,1.0f,false);
    protected final EntityDimensions dimension = new EntityDimensions(1.5f,1.5f,false);
    @Override
    public EntityDimensions getDimensions(EntityPose pose) {
        return isBaby() ? babyDimension : dimension;
    }

    protected int tameRateDenominator(){
        return 22;
    }
    abstract protected void effect();

    @Override
    public EntityView method_48926() {
        //what is this?
        return getEntityWorld();
    }
}
