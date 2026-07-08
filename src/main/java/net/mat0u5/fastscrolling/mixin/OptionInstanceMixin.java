package net.mat0u5.fastscrolling.mixin;

//? if <= 1.18 {
/*import dev.kikugie.fletching_table.annotation.MixinEnvironment;
import net.minecraft.client.Minecraft;
//? if forge && <= 1.16 {
/^import net.minecraft.client.GameSettings;
import net.minecraft.client.gui.screen.Screen;
^///?} else {
import net.minecraft.client.Options;
import net.minecraft.client.gui.screens.Screen;
//?}
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
@Mixin(Minecraft.class)
@MixinEnvironment(type = MixinEnvironment.Env.CLIENT)
public class OptionInstanceMixin {
	@Inject(method = "runTick", at = @At("HEAD"), cancellable = true)
	//? if forge && <= 1.15 {
	/^private void modifyScrollSpeed(CallbackInfo ci) {
	^///?} else {
	private void modifyScrollSpeed(boolean bl, CallbackInfo ci) {
	//?}
		Minecraft minecraft = (Minecraft) (Object) this;
		//? if forge && <= 1.15 {
		/^GameSettings options = minecraft.gameSettings;
		^///?} else if forge && <= 1.16 {
		/^GameSettings options = minecraft.options;
		^///?} else {
		Options options = minecraft.options;
		//?}
		if (options == null) return;

		int multiplier = 1;
		//? if forge && <= 1.16 {
		/^boolean controlDown = Screen.hasControlDown();
		boolean shiftDown = Screen.hasShiftDown();
		^///?} else {
		boolean controlDown = Screen.hasControlDown();
		boolean shiftDown = Screen.hasShiftDown();
		//?}

		if (controlDown) {
			if (shiftDown) {
				multiplier = 8;
			}
			else {
				multiplier = 3;
			}
		}
		//? if forge && <= 1.16 {
		//?} else {
		//?}
		options.mouseWheelSensitivity = multiplier;
	}
}
*///?} else {
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
//?}
