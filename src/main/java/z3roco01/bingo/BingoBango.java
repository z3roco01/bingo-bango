package z3roco01.bingo;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.commands.Commands;
import net.minecraft.resources.Identifier;

import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import z3roco01.bingo.features.goals.Goals;
import z3roco01.bingo.network.ServerNetworking;

public class BingoBango implements ModInitializer {
	public static final String MOD_ID = "bingo_bango";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Nullable
	public static MinecraftServer server = null;

	@Override
	public void onInitialize() {
		LOGGER.info("BINGOOOOOOO");

		ServerLifecycleEvents.SERVER_STARTED.register((mcServer) -> {
			server = mcServer;
		});
		ServerLifecycleEvents.SERVER_STOPPING.register((mcServer) -> {
			server = null;
		});

		ServerNetworking.registerPayloads();


		// TODO: TEMPORARY COMMANDS !!!!
		CommandRegistrationCallback.EVENT.register(((dispatcher, buildContext, selection) -> {
			dispatcher.register(Commands.literal("populate").executes(ctx -> {
				Goals.populateGoals();
				return 1;
			}));
		}));
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
