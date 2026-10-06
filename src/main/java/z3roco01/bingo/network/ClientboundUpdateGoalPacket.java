package z3roco01.bingo.network;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import z3roco01.bingo.BingoBango;

public record ClientboundUpdateGoalPacket(int id, ItemStack stack, float progress, float completionProgress) implements CustomPacketPayload {
    public static final StreamCodec<RegistryFriendlyByteBuf, ClientboundUpdateGoalPacket> CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT, ClientboundUpdateGoalPacket::id,
            ItemStack.STREAM_CODEC, ClientboundUpdateGoalPacket::stack,
            ByteBufCodecs.FLOAT, ClientboundUpdateGoalPacket::progress,
            ByteBufCodecs.FLOAT, ClientboundUpdateGoalPacket::completionProgress,
            ClientboundUpdateGoalPacket::new
    );


    public static final Identifier IDENT = BingoBango.id("update_goal");
    public static final Type<ClientboundUpdateGoalPacket> TYPE = new Type(IDENT);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
