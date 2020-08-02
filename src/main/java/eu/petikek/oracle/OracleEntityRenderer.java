package eu.petikek.oracle;

import eu.petikek.oracle.OracleEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class OracleEntityRenderer extends MobEntityRenderer<OracleEntity, OracleEntityModel<OracleEntity>> {

    public OracleEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new OracleEntityModel<>(0.0F), 0.5f);
    }

    @Override
    public Identifier getTexture(OracleEntity entity) {
        return new Identifier("creajam_oot", "textures/entity/oracle/oracle.png");
    }
}
