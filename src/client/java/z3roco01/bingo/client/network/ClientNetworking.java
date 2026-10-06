package z3roco01.bingo.client.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import z3roco01.bingo.client.goal.ClientGoal;
import z3roco01.bingo.client.goal.ClientGoals;
import z3roco01.bingo.network.ClientboundUpdateGoalPacket;

public class ClientNetworking {
    public static void registerPayloads() {

    }

    public static void registerReceivers() {
        ClientPlayNetworking.registerGlobalReceiver(ClientboundUpdateGoalPacket.TYPE, (payload, ctx) -> {
            int id = payload.id();
            ClientGoal oldGoal = ClientGoals.goals[payload.id()];
            if(oldGoal == null) {
                ClientGoal goal = new ClientGoal(payload.stack(), payload.progress(), payload.completionProgress());
                ClientGoals.goals[id] = goal;
            }else {
                oldGoal.stack = payload.stack();
                oldGoal.progress = payload.progress();
                oldGoal.completionProgress = payload.completionProgress();
            }
        });
    }
}
