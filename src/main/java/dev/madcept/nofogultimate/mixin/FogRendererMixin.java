package dev.madcept.nofogultimate.mixin;

import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.fog.FogData;
import net.minecraft.client.renderer.fog.FogRenderer;
import net.minecraft.world.level.material.FogType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FogRenderer.class)
public class FogRendererMixin {
	@Inject(method = "getFogType", at = @At("HEAD"), cancellable = true)
	private void nofogultimate$useAtmosphericFogType(Camera camera, CallbackInfoReturnable<FogType> cir) {
		cir.setReturnValue(FogType.ATMOSPHERIC);
	}

	@Inject(method = "setupFog", at = @At("RETURN"))
	private void nofogultimate$removeAllFog(
			Camera camera,
			int renderDistanceInChunks,
			DeltaTracker deltaTracker,
			float darkenWorldAmount,
			ClientLevel level,
			CallbackInfoReturnable<FogData> cir
	) {
		FogData fog = cir.getReturnValue();
		fog.environmentalStart = Float.MAX_VALUE;
		fog.environmentalEnd = Float.MAX_VALUE;
		fog.renderDistanceStart = Float.MAX_VALUE;
		fog.renderDistanceEnd = Float.MAX_VALUE;
		fog.cloudEnd = Float.MAX_VALUE;
		fog.skyEnd = Math.max(fog.skyEnd, Math.max(512.0F, renderDistanceInChunks * 16.0F));
	}
}
