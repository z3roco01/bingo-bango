package z3roco01.bingo.features.goals;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import z3roco01.bingo.BingoBango;
import z3roco01.bingo.features.goals.types.*;
import z3roco01.bingo.features.goals.types.Goal;
import z3roco01.bingo.network.ClientboundUpdateGoalPacket;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Goals {
    private static ArrayList<Goal> goals = new ArrayList<>();

    // TODO: MAKE REAL JUST FOR TESTING
    public static void populateGoals() {
        // TEMPORARY ITEM LIST
        List<Identifier> items = new ArrayList<Identifier>();
        for(Identifier id : BuiltInRegistries.ITEM.keySet()) {
            if(!id.equals(BuiltInRegistries.ITEM.getKey(Items.AIR)))
                items.add(id);
        }

        Random random = new Random();
        for(int i = 0; i < 25; ++i) {
            Identifier id = items.get(random.nextInt(items.size()));
            Item item = BuiltInRegistries.ITEM.get(id).get().value();
            //goals.add(new CollectXItemGoal(item, random.nextInt(1, item.getDefaultMaxStackSize()+1)));
            goals.add(new CollectOneItemGoal(item));
        }

        syncAllGoals();
    }

    /**
     * Syncs every goal to all players
     */
    public static void syncAllGoals() {
        for(ServerPlayer player : BingoBango.server.getPlayerList().getPlayers()) {
            for(int i = 0; i<25; ++i)
                syncGoalToPlayer(i, player);
        }
    }

    /**
     * Syncs one goal to all players
     * @param id slot id of the goal
     */
    public static void syncGoal(int id) {
        for(ServerPlayer player : BingoBango.server.getPlayerList().getPlayers())
            syncGoalToPlayer(id, player);
    }

    /**
     * Syncs a goal just to one player
     * @param id slot id of the goal
     */
    public static void syncGoalToPlayer(int id, ServerPlayer player) {
        Goal goal = goals.get(id);
        ClientboundUpdateGoalPacket packet = new ClientboundUpdateGoalPacket(id, goal.getDisplayStack(), goal.getProgressForPlayer(player.getUUID()), goal.getCompletionProgress());
        ServerPlayNetworking.send(player, packet);
    }
}
