package z3roco01.bingo.client.goal;

import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;

/**
 * Client side list of goals just for display
 */
public class ClientGoals {
    public static final ClientGoal[] goals = new ClientGoal[25];

    private void checkId(int id) {
        if(id > 24)
            throw new RuntimeException("Id cannot be bigger than 24 (is: " + id + ")");
    }

    public void setStack(int id, ItemStack stack) {
        checkId(id);
        goals[id].stack = stack;
    }

    public void setProgress(int id, float progress) {
        checkId(id);
        goals[id].progress = progress;
    }
}
