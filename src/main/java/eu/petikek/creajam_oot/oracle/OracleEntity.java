package eu.petikek.creajam_oot.oracle;

import eu.petikek.creajam_oot.registry.Items;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.ListTag;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.village.TradeOffer;
import net.minecraft.world.World;




public class OracleEntity extends WanderingTraderEntity {

    public OracleEntity(EntityType<? extends WanderingTraderEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void afterUsing(TradeOffer offer) {

    }

    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        ListTag enchants = stack.getEnchantments();
        if (stack.getItem() == Items.MYSTERY_FORTUNE_COOKIE && enchants.size() == 0) {
            stack.addEnchantment(Enchantments.FORTUNE, 1);
            return ActionResult.SUCCESS;
        }
        return ActionResult.FAIL;
    }

    @Override
    public PassiveEntity createChild(PassiveEntity mate) {
        return null;
    }

    protected void fillRecipes() {

    }

    @Override
    public void tickMovement() {
        super.tickMovement();
    }
}