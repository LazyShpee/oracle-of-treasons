package eu.petikek.oracle;

import eu.petikek.registry.Items;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
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
        if (player.getStackInHand(hand).getItem() == Items.MYSTERY_FORTUNE_COOKIE) {
            player.getStackInHand(hand).addEnchantment(Enchantments.FIRE_ASPECT, 1);
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
