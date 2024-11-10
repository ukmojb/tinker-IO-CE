package tinker_io.registry;

import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import tinker_io.TinkerIO;
import tinker_io.item.ItemCdLonesomeAvenue;
import tinker_io.item.ItemSolidFuel;
import tinker_io.item.ItemUpgrade;

public class ItemRegistry {

    public static ItemCdLonesomeAvenue cdLonesomeAvenue = new ItemCdLonesomeAvenue("Lonesome_Avenue");
    //TODO Change name of solid fuel, Speed Upg and Crushed Ore
    public static ItemSolidFuel solidFuel = new ItemSolidFuel("SolidFuel");




    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                cdLonesomeAvenue,
                solidFuel
        );
    }

    @SideOnly(Side.CLIENT)
    public static void registerModels() {
        TinkerIO.proxy.registerItemRenderer(cdLonesomeAvenue, 0, "cd_lonesome_avenue");
        solidFuel.registerItemModel("solid_fuel");
    }

    @SideOnly(Side.CLIENT)
    public static void registerItemColors(){
    }
}
