package z3roco01.bingo.features.goals.types;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.UUID;

/**
 * Goal to collect a random amount of a common item
 */
public class CollectXItemGoal extends Goal {
    private final ItemStack stack;
    /**
     * @param item the item to collect
     */
    public CollectXItemGoal(Item item, int count) {
        this.stack = new ItemStack(item, count);
    }

    @Override
    public float getCompletionProgress() {
        return stack.count();
    }

    @Override
    public ItemStack getDisplayStack() {
        return stack;
    }

    @Override
    public void update(UUID uuid, Inventory inventory) {
        int itemCount = inventory.countItem(stack.getItem());
        if(itemCount >= getCompletionProgress())
            complete(uuid);
    }
}
