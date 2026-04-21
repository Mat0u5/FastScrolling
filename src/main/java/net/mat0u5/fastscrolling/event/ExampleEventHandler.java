package net.mat0u5.fastscrolling.event;

import net.mat0u5.fastscrolling.Main;
import net.minecraft.server.level.ServerPlayer;

public class ExampleEventHandler {

	public static void onPlayerHurt(ServerPlayer player) {
		Main.LOGGER.info("{} took damage.", player.getDisplayName());
	}
}
