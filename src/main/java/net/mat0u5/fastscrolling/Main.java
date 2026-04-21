package net.mat0u5.fastscrolling;

import net.mat0u5.fastscrolling.platform.Platform;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//? fabric {
import net.mat0u5.fastscrolling.platform.fabric.FabricPlatform;
//?} neoforge {
/*import net.mat0u5.fastscrolling.platform.neoforge.NeoforgePlatform;
 *///?} forge {
/*import net.mat0u5.fastscrolling.platform.forge.ForgePlatform;
*///?}

public class Main {

	public static final String MOD_ID = "fastscrolling";
	public static final String MOD_VERSION = "1.0.0";
	public static final String MOD_FRIENDLY_NAME = "Fast Scrolling";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final Platform PLATFORM = createPlatformInstance();

	public static void onInitialize() {
		LOGGER.info("Initializing {} on {}", MOD_FRIENDLY_NAME, platform().loader());
	}

	public static void onInitializeClient() {
		LOGGER.info("Initializing {} Client on {}", MOD_FRIENDLY_NAME, platform().loader());
	}

	static Platform platform() {
		return PLATFORM;
	}

	private static Platform createPlatformInstance() {
		//? fabric {
		return new FabricPlatform();
		//?} neoforge {
		/*return new NeoforgePlatform();
		 *///?} forge {
		/*return new ForgePlatform();
		*///?}
	}
}
