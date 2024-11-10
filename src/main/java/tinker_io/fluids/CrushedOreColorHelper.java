package tinker_io.fluids;

import java.awt.Color;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

public class CrushedOreColorHelper {

    static Minecraft mc = Minecraft.getMinecraft();

    /**
     *
     * @param itemStack A ItemStack with string NBT Tag "oreDic".
     * @return The color from the oreDic.
     */
    public static int getColor(ItemStack itemStack){
        int colorRGB = Color.gray.getRGB();
        if(itemStack == null){
            return colorRGB;
        }

        NBTTagCompound nbt = itemStack.getTagCompound();
        if(nbt != null){
            String oreDicName = nbt.getString("oreDict");
            ItemStack oreItem;

            if(getOreByOreDic(oreDicName) != null && !getOreByOreDic(oreDicName).isEmpty()){
                oreItem = getOreByOreDic(oreDicName).get(0);
            }else{
                return colorRGB;
            }

            TextureAtlasSprite particleIcon = mc.getRenderItem().getItemModelMesher().getParticleIcon(oreItem.getItem(), oreItem.getMetadata());
            if(particleIcon != null){
                int[] frameTextureData = particleIcon.getFrameTextureData(0)[0];
                int index = (int) ((float) 151 / (float)256 * (float) frameTextureData.length);
                colorRGB = frameTextureData[index];
//                if(frameTextureData.length != 256){
//                    int index = 151 / 256 * frameTextureData.length;
//                    colorRGB = frameTextureData[index];
//                }else{
//                    colorRGB = frameTextureData[151];
//                }
            }

				/*if(oreDicName.equals("oreIron")){colorRGB = hex2Rgb("#B39886").getRGB();}
				if(oreDicName.equals("oreGold")){colorRGB = hex2Rgb("#FCEE4B").getRGB();}*/
        }
        return colorRGB;
    }

    /**
     *
     * @param fluidStack A FluidStack with string NBT Tag "oreDic".
     * @return The color from the oreDic.
     */
    public static int getColor(FluidStack fluidStack){
        int colorRGB = Color.gray.getRGB();

        NBTTagCompound nbt = fluidStack.tag;
        if(nbt != null){
            String oreDicName = nbt.getString("oreDict");
            ItemStack oreItem;

            if(getOreByOreDic(oreDicName) != null && !getOreByOreDic(oreDicName).isEmpty()){
                oreItem = getOreByOreDic(oreDicName).get(0);
            }else{
                return colorRGB;
            }

            TextureAtlasSprite particleIcon = mc.getRenderItem().getItemModelMesher().getParticleIcon(oreItem.getItem(), oreItem.getMetadata());
            if(particleIcon != null){
                int[] frameTextureData = particleIcon.getFrameTextureData(0)[0];
                int index = (int) ((float) 151 / (float)256 * (float) frameTextureData.length);
                colorRGB = frameTextureData[index];
            }
        }
        return colorRGB;
    }

    public static Color hex2Rgb(String colorStr) {
        return new Color(
                Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
                Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
                Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
    }

    public static List<ItemStack> getOreByOreDic(String oreDicName){
        return OreDictionary.getOres(oreDicName);
    }
}
