package tinker_io.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import tinker_io.tileentity.TileEntitySmartOutput;

public class MessageShiftTo extends MessageBase<MessageShiftTo> {

    private NBTTagCompound data;

    //We need to create a empty constructor or the server will crash!
    public MessageShiftTo(){}

    public MessageShiftTo(BlockPos pos, int mode){
        data = new NBTTagCompound();
        data.setInteger("x", pos.getX());
        data.setInteger("y", pos.getY());
        data.setInteger("z", pos.getZ());
        data.setInteger("mode", mode);
    }

    @Override
    public void handleClientSide(MessageShiftTo message, EntityPlayer player) {
        //TODO
        //https://www.youtube.com/watch?v=DhuCk0H71Ks
    }

    @Override
    public void handleServerSide(MessageShiftTo message, EntityPlayer player) {
        int x = message.data.getInteger("x");
        int y = message.data.getInteger("y");
        int z = message.data.getInteger("z");

        int mode = message.data.getInteger("mode");

        if(!player.world.isRemote){
            TileEntity tileEntity = player.world.getTileEntity(new BlockPos(x, y, z));
            if(tileEntity instanceof TileEntitySmartOutput) {
                ((TileEntitySmartOutput) tileEntity).setCurrentMode(mode);
            }
        }
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        data = ByteBufUtils.readTag(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeTag(buf, data);
    }
}
