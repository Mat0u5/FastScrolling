package net.mat0u5.fastscrolling.mixin;

import dev.kikugie.fletching_table.annotation.MixinEnvironment;
import net.minecraft.client.Minecraft;
//? if <= 1.20.6 {
/*import net.minecraft.client.gui.screens.VideoSettingsScreen;
*///?} else {
import net.minecraft.client.gui.screens.options.VideoSettingsScreen;
//?}
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(VideoSettingsScreen.class)
@MixinEnvironment(type = MixinEnvironment.Env.CLIENT)
public class VideoSettingsScreenMixin {
	//? if >= 1.20 {
	@Redirect(method = "mouseScrolled", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;hasControlDown()Z"))
	private boolean stopGuiScaleChange(Minecraft instance) {
		return false;
	}
	//?}
}
