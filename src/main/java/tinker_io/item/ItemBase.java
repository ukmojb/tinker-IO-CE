package tinker_io.item;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.Item;
import org.lwjgl.input.Keyboard;
import tinker_io.TinkerIO;

public class ItemBase extends Item {
    protected String name;

    public ItemBase(String name) {
        this.name = name;
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(TinkerIO.creativeTabs);
    }

    public static boolean isShiftKeyDown(){
        return Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54);
    }

    public String getName(){
        return name;
    }

    public void registerItemModel() {
        TinkerIO.proxy.registerItemRenderer(this, 0, name);
    }

    public void registerItemModel(String name) {
        TinkerIO.proxy.registerItemRenderer(this, 0, name);
    }

    public void registerItemColor(IItemColor iItemColor){
        TinkerIO.proxy.registerItemColor(this, iItemColor);
    }
}
