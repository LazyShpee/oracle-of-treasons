package eu.petikek.creajam_oot.oracle;

import eu.petikek.creajam_oot.registry.Items;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
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
        ItemStack stack = player.getStackInHand(hand);
        ListTag enchants = stack.getEnchantments();
        if (stack.getItem() == Items.MYSTERY_FORTUNE_COOKIE && enchants.size() == 0) {
            CompoundTag tag = stack.getOrCreateTag();
            tag.putInt("HideFlags", 1);

            CompoundTag displayTag = stack.getOrCreateSubTag("display");
            ListTag lTag = new ListTag();

            lTag.add(StringTag.of(Text.Serializer.toJson(new TranslatableText("Blessed by an Oracle"))));

            displayTag.put("Lore", lTag);

            stack.addEnchantment(Enchantments.FORTUNE, 1);
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
