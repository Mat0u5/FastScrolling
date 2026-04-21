package net.mat0u5.fastscrolling.mixin;

import dev.kikugie.fletching_table.annotation.MixinEnvironment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(OptionInstance.class)
@MixinEnvironment(type = MixinEnvironment.Env.CLIENT)
public class OptionInstanceMixin {

	@Shadow
	private Object value;

	@Inject(method = "get", at = @At("HEAD"), cancellable = true)
	private void modifyScrollSpeed(CallbackInfoReturnable<Object> cir) {
		OptionInstance thisInstance = (OptionInstance) (Object) this;
		Options options = Minecraft.getInstance().options;
		if (options == null || thisInstance == null) return;
		if (thisInstance != options.mouseWheelSensitivity()) return;

		int multiplier = 1;
		//? if <= 1.21.6 {
		/*boolean controlDown = Screen.hasControlDown();
		boolean shiftDown = Screen.hasShiftDown();
		*///?} else {
		boolean controlDown = Minecraft.getInstance().hasControlDown();
		boolean shiftDown = Minecraft.getInstance().hasShiftDown();
		//?}

		if (controlDown) {
			if (shiftDown) {
				multiplier = 8;
			}
			else {
				multiplier = 3;
			}
		}
		cir.setReturnValue(((Double)value) * multiplier);
	}
}
