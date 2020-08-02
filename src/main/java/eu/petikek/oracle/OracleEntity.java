package eu.petikek.oracle;

import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Arm;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.util.Hand;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.TraderOfferList;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;

import static net.minecraft.village.TradeOffers.copyToFastUtilMap;


public class OracleEntity extends WanderingTraderEntity {

    public OracleEntity(EntityType<? extends WanderingTraderEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void afterUsing(TradeOffer offer) {

    }

    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (player.getStackInHand(hand).getItem() == Items.ACACIA_LOG) {
            
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
