package z3roco01.bingo.client.render;

import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElement;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import z3roco01.bingo.BingoBango;
import z3roco01.bingo.client.goal.ClientGoal;
import z3roco01.bingo.client.goal.ClientGoals;

public class BingoCardHudElement implements HudElement {
    private static final int firstSlotX = 10;
    private static final int firstSlotY = 19;

    @Override
    public void extractRenderState(GuiGraphicsExtractor graphics, DeltaTracker deltaTracker) {
        // draw background
        graphics.blitSprite(RenderPipelines.GUI_TEXTURED, BingoBango.id("bingo_card"), 2, 2, 104, 113);

        // render goals
        for(int i = 0; i < 25; ++i) {
            ClientGoal goal = ClientGoals.goals[i];
            if(goal == null)
                continue;

            int xi = i % 5;
            int yi = i/5;

            int x = firstSlotX + xi*18;
            int y = firstSlotY + yi*18;
            graphics.fakeItem(goal.stack, x, y);
            graphics.itemDecorations(Minecraft.getInstance().font, goal.stack, x, y);
        }
    }
}
