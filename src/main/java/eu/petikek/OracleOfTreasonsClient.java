package eu.petikek;

import eu.petikek.oracle.OracleEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

@Environment(EnvType.CLIENT)
public class OracleOfTreasonsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(OracleOfTreasons.ORACLE_ENTITY_TYPE, (dispatcher, context) -> {
            return new OracleEntityRenderer(dispatcher);
        });
    }
}
