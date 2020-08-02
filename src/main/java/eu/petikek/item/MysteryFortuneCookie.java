package eu.petikek.item;

import eu.petikek.registry.Items;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class MysteryFortuneCookie extends Item {
    public MysteryFortuneCookie(Settings settings) {
        super(settings.maxCount(1));
    }

    private static String[] RECOMMENDATIONS = {
            "Bathing in lava builds you fire immunity",
            "Test"
    };

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        ItemStack stack = playerEntity.getStackInHand(hand);
        stack.decrement(1);

        ItemStack newStack = new ItemStack(Items.OPENED_FORTUNE_COOKIE);

        CompoundTag displayTag = newStack.getOrCreateSubTag("display");
        ListTag lTag = new ListTag();

        lTag.add(StringTag.of(
                    Text.Serializer.toJson(
                            new TranslatableText(RECOMMENDATIONS[RANDOM.nextInt(RECOMMENDATIONS.length)])
                    )
                )
        );
        displayTag.put("Lore", lTag);

        playerEntity.giveItemStack(newStack);
        playerEntity.playSound(SoundEvents.BLOCK_WOOL_BREAK, 1.0F, 1.0F);
        return new TypedActionResult<>(ActionResult.SUCCESS, playerEntity.getStackInHand(hand));
    }
}
