package tinker_io.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import tinker_io.inventory.slots.SlotSolidFuel;
import tinker_io.tileentity.TileEntityFuelInputMachine;

public class ContainerFuelInputMachine extends ContainerBase {

    private TileEntityFuelInputMachine te;
    public static final int SPEED_UPG = 0, FUEL = 1;

    public ContainerFuelInputMachine(InventoryPlayer playerInv, final TileEntityFuelInputMachine tileEntity) {
        this.te = tileEntity;
        addOwnSlots();
        addPlayerSlots(playerInv);
    }

    private void addOwnSlots(){
        IItemHandler inventory = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

        addSlotToContainer(new SlotSolidFuel(inventory, FUEL, 79, 34));
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }
}
