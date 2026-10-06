package z3roco01.bingo.client.goal;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

/**
 * Stripped down goal for just display
 */
public class ClientGoal {
    public ItemStack stack;
    public float progress;
    public float completionProgress;

    public ClientGoal(ItemStack stack, float progress, float completionProgress) {
        this.stack = stack;
        this.progress = progress;
        this.completionProgress = completionProgress;
    }

    public ClientGoal() {
        this(new ItemStack(Items.AIR), 0f, 1f);
    }
}
