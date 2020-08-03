package eu.petikek.creajam_oot;

import eu.petikek.creajam_oot.oracle.OracleEntityRenderer;
import eu.petikek.creajam_oot.registry.Entities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

@Environment(EnvType.CLIENT)
public class OracleOfTreasonsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(Entities.ORACLE_ENTITY_TYPE, (dispatcher, context) -> new OracleEntityRenderer(dispatcher));
    }
}
