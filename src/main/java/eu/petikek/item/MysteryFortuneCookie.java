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

    private static String[][] RECOMMENDATIONS = {
            {"Eat rotten flesh to quench your thirst."},
            {"Dig straight down,", "minerals don’t wait !"},
            {"Bath in some lava,", "the cold never bothered you anyways."},
            {"TNT and redstone blocks are your new best friend,", "put ‘em in your house."},
            {"Go to the nether without any armor,", "the strong shall be rewarded."},
            {"Hug some creepers,", "your resolve will impress the Gods."},
            {"Have you tried to harvest", "some carrots without water ?"},
            {"Kill the oracl- wait no noooo", "it’s not what’s written !!!!!!!!!!"},
            {"Find some gravel by digging straight up."},
            {"Zombie pigmen don't actually feel pain."},
            {"Fist fight some wolves,", "knives are for sissies."},
            {"Jump from above 256 meters,", "touch the sky…", "for a fleeting moment."},
            {"Using torches isn’t a good idea,", "darkmode is superior."},
            {"Burn your tools to get the materials back."},
            {"Scaffoldings can float,", "use sand for your roofs."},
            {"Breed two Ender Dragons together to obtain their egg."},
            {"Screw gravel & diorite,", "they’re shit anyway."},
            {"Be careful, your sword is cursed,", "get rid of it RIGHT NOW !"},
            {"Drop your anvil from up high,", "it’s a common smithing technique."},
            {"You should get another cookie and eat this one."},
            {"Stop killing animals dude,", "they’re trying to have a good time."},
            {"Ghast are a blast at parties,", "you're going to have yourself a real good time."},
            {"It's dangerous to go alone", "and not informed of your future,", "have another cookie."},
            {"Shulkers are great friends,", "they're never gonna let you down."},
            {"The cookie is a lie,", "but the oracle’s prediction isn’t."},
            {"Find the Oracle’s Temple,", "it’s this way."},
            {"Mending is a bad enchant,", "it means begging in french."},
    };

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        ItemStack stack = playerEntity.getStackInHand(hand);
        ListTag enchants = stack.getEnchantments();

        if (enchants.size() == 0) {
            return new TypedActionResult<>(ActionResult.FAIL, playerEntity.getStackInHand(hand));
        }

        stack.decrement(1);
        ItemStack newStack = new ItemStack(Items.OPENED_FORTUNE_COOKIE);

        CompoundTag displayTag = newStack.getOrCreateSubTag("display");
        ListTag lTag = new ListTag();

        String[] rec = RECOMMENDATIONS[RANDOM.nextInt(RECOMMENDATIONS.length)];

        for (String l : rec) {
            lTag.add(StringTag.of(Text.Serializer.toJson(new TranslatableText(l))));
        }
        displayTag.put("Lore", lTag);

        playerEntity.giveItemStack(newStack);
        playerEntity.playSound(SoundEvents.BLOCK_WOOL_BREAK, 1.0F, 1.0F);
        return new TypedActionResult<>(ActionResult.SUCCESS, playerEntity.getStackInHand(hand));
    }
}
