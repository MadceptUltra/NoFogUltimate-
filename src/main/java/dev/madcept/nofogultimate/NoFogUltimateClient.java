package dev.madcept.nofogultimate;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoFogUltimateClient implements ClientModInitializer {
	public static final String MOD_ID = "nofog-ultimate";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitializeClient() {
		LOGGER.info("NoFog Ultimate initialized - all fog disabled.");
	}
}
