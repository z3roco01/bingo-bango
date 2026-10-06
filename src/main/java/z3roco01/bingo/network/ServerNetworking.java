package z3roco01.bingo.network;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;

public class ServerNetworking {
    public static void registerPayloads() {
        PayloadTypeRegistry.clientboundPlay().register(ClientboundUpdateGoalPacket.TYPE, ClientboundUpdateGoalPacket.CODEC);
    }
}
