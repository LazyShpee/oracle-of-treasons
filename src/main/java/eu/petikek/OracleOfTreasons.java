package eu.petikek;

import eu.petikek.oracle.OracleEntity;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OracleOfTreasons implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "creajam_oot";
    public static final String MOD_NAME = "Oracle of Treasons";

    public static final EntityType<OracleEntity> ORACLE_ENTITY_TYPE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("creajam_oot", "oracle"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, OracleEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
        FabricDefaultAttributeRegistry.register(ORACLE_ENTITY_TYPE, OracleEntity.createMobAttributes());
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}