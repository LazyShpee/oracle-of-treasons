package eu.petikek.creajam_oot.mixin;

import eu.petikek.creajam_oot.oracle.OracleCompanionable;
import eu.petikek.creajam_oot.oracle.OracleEntity;
import eu.petikek.creajam_oot.registry.Entities;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.WanderingTraderEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.world.WanderingTraderManager.class)
public abstract class WanderingTraderManagerMixin {
    @Shadow
    abstract BlockPos getNearbySpawnPos(WorldView worldView, BlockPos blockPos, int i);

    @Inject(at = @At("HEAD"), method = "spawnLlama")
    private void onSpawnLlama(WanderingTraderEntity wanderingTrader, int range, CallbackInfo info) {
        if (((OracleCompanionable) wanderingTrader).getOracleCompanion() != null) {
            return;
        }

        BlockPos blockPos = this.getNearbySpawnPos(wanderingTrader.world, wanderingTrader.getBlockPos(), range);

        if (blockPos != null) {
            OracleEntity oracle = Entities.ORACLE_ENTITY_TYPE.spawn(wanderingTrader.world, null, null, null, blockPos, SpawnReason.EVENT, false, false);
            if (oracle != null) {
                oracle.setDespawnDelay(48000);
                ((OracleCompanionable) wanderingTrader).setOracleCompanion(oracle.getUuid());
            }
        }
    }
}
