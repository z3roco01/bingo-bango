package z3roco01.bingo.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import z3roco01.bingo.BingoBango;
import z3roco01.bingo.client.network.ClientNetworking;
import z3roco01.bingo.client.render.BingoCardHudElement;

public class BingoBangoClient implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger(BingoBango.MOD_ID);

	@Override
	public void onInitializeClient() {
		// bingo card renderer #yea
		HudElementRegistry.addLast(BingoBango.id("bingocard"), new BingoCardHudElement());

		ClientNetworking.registerPayloads();
		ClientNetworking.registerReceivers();
	}
}