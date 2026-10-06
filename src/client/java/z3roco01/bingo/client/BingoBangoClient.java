package z3roco01.bingo.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.minecraft.client.renderer.RenderPipelines;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import z3roco01.bingo.BingoBango;

public class BingoBangoClient implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger(BingoBango.MOD_ID);

	@Override
	public void onInitializeClient() {
		// bingo card renderer #yea
		HudElementRegistry.addLast(BingoBango.id("bingocard"), (graphics, deltaTracker) -> {
			graphics.blitSprite(RenderPipelines.GUI_TEXTURED, BingoBango.id("bingo_card"), 2, 2, 104, 113);
		});
	}
}