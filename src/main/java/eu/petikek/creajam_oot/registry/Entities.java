package eu.petikek.creajam_oot.registry;

import eu.petikek.creajam_oot.OracleOfTreasons;
import eu.petikek.creajam_oot.oracle.OracleEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.Registry;

public class Entities {
    public static final EntityType<OracleEntity> ORACLE_ENTITY_TYPE = Registry.register(
            Registry.ENTITY_TYPE,
            OracleOfTreasons.id("oracle"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, OracleEntity::new).dimensions(EntityDimensions.fixed(0.75f, 2.12f)).build()
    );

    public static void init() {
        FabricDefaultAttributeRegistry.register(ORACLE_ENTITY_TYPE, OracleEntity.createMobAttributes());
    }
}
