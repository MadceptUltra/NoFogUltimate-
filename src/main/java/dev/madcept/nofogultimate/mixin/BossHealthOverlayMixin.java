package dev.madcept.nofogultimate.mixin;

import net.minecraft.client.gui.components.BossHealthOverlay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BossHealthOverlay.class)
public class BossHealthOverlayMixin {
	@Inject(method = "shouldCreateWorldFog", at = @At("HEAD"), cancellable = true)
	private void nofogultimate$disableBossWorldFog(CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(false);
	}
}
