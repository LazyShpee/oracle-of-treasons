package eu.petikek.creajam_oot.item;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

public class OpenedFortuneCookie extends Item  {
    private static final FoodComponent OPENED_FORTUNE_COOKIE = (new FoodComponent.Builder()).hunger(-2).alwaysEdible().build();

    public OpenedFortuneCookie(Settings settings) {
        super(settings.maxCount(1).food(OPENED_FORTUNE_COOKIE));
    }
}
