package eu.petikek.oracle;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AbstractTraderEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import net.minecraft.village.TradeOffer;
import net.minecraft.world.World;

public class OracleEntity extends AbstractTraderEntity {

    public OracleEntity(EntityType<? extends AbstractTraderEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void afterUsing(TradeOffer offer) {

    }

    @Override
    protected void fillRecipes() {

    }

    ;

    @Override
    public PassiveEntity createChild(PassiveEntity mate) {
        return null;
    }


}
