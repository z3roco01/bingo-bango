package z3roco01.bingo.features.goals.types;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.UUID;

/**
 * Goal for a player to collect one of the specific item
 */
public class CollectOneItemGoal extends Goal {
    private final ItemStack stack;
    /**
     * @param item the item to collect
     */
    public CollectOneItemGoal(Item item) {
        this.stack = new ItemStack(item);
    }

    @Override
    public ItemStack getDisplayStack() {
        return stack;
    }

    @Override
    public void update(UUID uuid, Inventory inventory) {
        // if it exists at all, its complete
        if(inventory.findSlotMatchingItem(stack) != -1)
            complete(uuid);
    }
}
