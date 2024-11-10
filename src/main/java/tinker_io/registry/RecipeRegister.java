package tinker_io.registry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;
import slimeknights.tconstruct.tools.TinkerTools;
import tinker_io.TinkerIO;

public class RecipeRegister {

    //TODO: use json file instead...
    public static void register() {
        registerRecipe();
    }

    static ItemStack FIM = new ItemStack(BlockRegistry.fuelInputMachine,1);
    static ItemStack hopper = new ItemStack(Blocks.HOPPER, 1);

    static ItemStack searedBrick = new ItemStack(TinkerSmeltery.searedBlock, 1, 0);
    static ItemStack SO = new ItemStack(BlockRegistry.smartOutput, 1);
    static ItemStack ice = new ItemStack(Blocks.ICE, 1);
    private static void registerRecipe() {

        ItemStack manyullyn_hammer_head = new ItemStack(TinkerTools.hammerHead);
        NBTTagCompound nbt = new NBTTagCompound();
        manyullyn_hammer_head.setTagCompound(nbt);
        manyullyn_hammer_head.getTagCompound().setString("Material", "manyullyn");

        String ingotAluminumOrLeadOrGold = "ingotAluminum";


        if(OreDictionary.getOres("ingotAluminum").isEmpty()){
            if(!OreDictionary.getOres("ingotLead").isEmpty()){
                ingotAluminumOrLeadOrGold = "ingotLead";
            }else{
                ingotAluminumOrLeadOrGold = "ingotGold";
            }
        }

        ForgeRegistries.RECIPES.register(new ShapedOreRecipe(new ResourceLocation(TinkerIO.MOD_ID), FIM, new Object[]{"AAA", "ABA","AAA", 'A', searedBrick, 'B', hopper}).setRegistryName("RIM"));
        ForgeRegistries.RECIPES.register(new ShapelessOreRecipe(new ResourceLocation(TinkerIO.MOD_ID), new ItemStack(ItemRegistry.solidFuel,8), ingotAluminumOrLeadOrGold,Items.GUNPOWDER,Items.COAL).setRegistryName("SolidFuel_0"));
        ForgeRegistries.RECIPES.register(new ShapelessOreRecipe(new ResourceLocation(TinkerIO.MOD_ID), new ItemStack(ItemRegistry.solidFuel,8), "dustAluminium",Items.GUNPOWDER,"dustCoal").setRegistryName("SolidFuel_1"));

        ForgeRegistries.RECIPES.register(new ShapedOreRecipe(new ResourceLocation(TinkerIO.MOD_ID), SO, new Object[]{"ABA", "B B","ABA", 'A', searedBrick, 'B', ice}).setRegistryName("SO"));

        ForgeRegistries.RECIPES.register(new ShapelessOreRecipe(new ResourceLocation(TinkerIO.MOD_ID), new ItemStack(ItemRegistry.cdLonesomeAvenue,1), BlockRegistry.smartOutput, BlockRegistry.fuelInputMachine, ItemRegistry.solidFuel).setRegistryName("Lonesome_Avenue"));

    }

}
