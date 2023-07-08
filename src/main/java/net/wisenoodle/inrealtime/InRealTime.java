package net.wisenoodle.inrealtime;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InRealTime implements ModInitializer {
	public static boolean timeSyncToggle = true;
	public static final String MOD_ID = "inrealtime";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	@Override
	public void onInitialize() {
		LOGGER.info("In Real-Time 1.0.0 Loaded Successfully!");
	}
}
