package z3roco01.bingo.features.goals.types;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.UUID;

public abstract class Goal {
    protected final HashMap<UUID, Float> progressMap = new HashMap<UUID, Float>();
    // when null it is incomplete, otherwise has been completed
    @Nullable
    protected UUID completedBy = null;
    protected boolean hasBeenCompleted = false;

    /**
     * Returns the stack used for displaying this goal
     */
    public abstract ItemStack getDisplayStack();

    /**
     * Returns the progress towards this goal for a player, with
     * @param uuid Players uuid
     */
    public float getProgressForPlayer(UUID uuid) {
        return progressMap.getOrDefault(uuid, 0f);
    }

    /**
     * Returns the progress value that means when the goal is completed
     */
    public float getCompletionProgress() {
        return 1;
    }

    /**
     * Sets the specified players progress to the completed progress (from getCompletionProgress)
     * @param uuid uuid of the player
     */
    protected void complete(UUID uuid) {
        progressMap.put(uuid, getCompletionProgress());
        completedBy = uuid;
        hasBeenCompleted = true;
    }

    /**
     * Updates progress for a player based on their progress
     * @param player player to update for.
     */
    public void updateForPlayer(ServerPlayer player) {
        // dont need to update if its been completed
        if(!hasBeenCompleted)
            update(player.getUUID(), player.getInventory());
    }

    public boolean completed() {
        return hasBeenCompleted;
    }

    protected abstract void update(UUID uuid, Inventory inventory);
}
