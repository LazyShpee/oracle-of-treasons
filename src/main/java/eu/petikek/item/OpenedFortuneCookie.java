package eu.petikek.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class OpenedFortuneCookie extends Item {
    public OpenedFortuneCookie(Settings settings) {
        super(settings.maxCount(1));
    }
}
