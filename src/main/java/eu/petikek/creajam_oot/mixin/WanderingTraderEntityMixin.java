package eu.petikek.creajam_oot.mixin;


import eu.petikek.creajam_oot.oracle.OracleCompanionable;
import net.minecraft.entity.passive.WanderingTraderEntity;
import net.minecraft.nbt.CompoundTag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Mixin(WanderingTraderEntity.class)
abstract public class WanderingTraderEntityMixin implements OracleCompanionable {
    private UUID oracleCompanion = null;

    @Override
    public UUID getOracleCompanion() { return oracleCompanion; }

    @Override
    public void setOracleCompanion(UUID oracleCompanion) { this.oracleCompanion = oracleCompanion; }

    @Inject(at = @At("TAIL"), method = "writeCustomDataToTag")
    public void afterWriteCustomDataToTag(CompoundTag tag, CallbackInfo info) {
        if (this.oracleCompanion != null) {
            tag.putUuid("OracleCompanion", this.oracleCompanion);
        }
    }

    @Inject(at = @At("TAIL"), method = "writeCustomDataToTag")
    public void afterReadCustomDataFromTag(CompoundTag tag, CallbackInfo info) {
        if (tag.contains("OracleCompanion")) {
            this.oracleCompanion = tag.getUuid("OracleCompanion");
        }
    }
}
