package tinker_io.fluids;

import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.TConstruct;

import java.util.List;

public class FluidPureMetal extends Fluid {
    private static String tinkersDomain = TConstruct.modID + ":";

    public FluidPureMetal(String fluidName) {
        super(fluidName, new ResourceLocation(tinkersDomain + "blocks/fluids/molten_metal"), new ResourceLocation(tinkersDomain + "blocks/fluids/molten_metal_flow"));
        this.setLuminosity(10).setDensity(1600).setViscosity(1500).setTemperature(600);
    }

    @Override
    public int getColor(FluidStack stack){
        return CrushedOreColorHelper.getColor(stack);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getLocalizedName(FluidStack stack){
        String s = this.getUnlocalizedName();
        String name = s == null ? "" : I18n.format(s);
        NBTTagCompound nbt = stack.tag;
        if(nbt != null){
            String oreDicName = nbt.getString("oreDict");
            List<ItemStack> oreList = OreDictionary.getOres(oreDicName);
            if(!oreList.isEmpty()){
                ItemStack oreItem = oreList.get(0);
                String oreName = oreItem.getDisplayName();
                name = name + " (" + oreName + ")";
            }
        }
        return name;
    }
}
