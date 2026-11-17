package dev.madcept.nofogultimate.mixin;

import com.mojang.blaze3d.framegraph.FrameGraphBuilder;
import com.mojang.renderpearl.api.buffers.GpuBufferSlice;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.world.level.material.FogType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LevelRenderer.class)
public class LevelRendererMixin {
	@Inject(method = "addSkyPass", at = @At("HEAD"))
	private void nofogultimate$allowSkyPassEverywhere(
			FrameGraphBuilder frameGraphBuilder,
			CameraRenderState cameraRenderState,
			GpuBufferSlice fogBuffer,
			CallbackInfo ci
	) {
		cameraRenderState.fogType = FogType.NONE;
		if (cameraRenderState.entityRenderState != null) {
			cameraRenderState.entityRenderState.doesMobEffectBlockSky = false;
		}
	}
}
