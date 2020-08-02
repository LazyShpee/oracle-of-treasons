package eu.petikek.registry;

import eu.petikek.OracleOfTreasons;
import eu.petikek.item.MysteryFortuneCookie;
import eu.petikek.item.OpenedFortuneCookie;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;

public class Items {
    public static final ItemGroup GROUP = FabricItemGroupBuilder.build(
            OracleOfTreasons.id("group"),
           () -> new ItemStack(Items.MYSTERY_FORTUNE_COOKIE));

    public static final Item MYSTERY_FORTUNE_COOKIE = new MysteryFortuneCookie(new Item.Settings().group(GROUP));
    public static final Item OPENED_FORTUNE_COOKIE = new OpenedFortuneCookie(new Item.Settings().group(GROUP));

    public static void init() {
        Registry.register(Registry.ITEM, OracleOfTreasons.id("mystery_fortune_cookie"), MYSTERY_FORTUNE_COOKIE);
        Registry.register(Registry.ITEM, OracleOfTreasons.id("opened_fortune_cookie"), OPENED_FORTUNE_COOKIE);
    }
}
