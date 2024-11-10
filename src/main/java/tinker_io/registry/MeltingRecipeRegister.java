package tinker_io.registry;

import com.google.common.collect.Lists;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.smeltery.MeltingRecipe;

import java.util.List;

public class MeltingRecipeRegister {

    public static final List<MeltingRecipe> customMeltingRecipes = Lists.newLinkedList();

    public static void register() {

    }


    public static void registerMeltingWithNBT(ItemStack inputItem, FluidStack outputFluidStack, int meltingTime){
        MeltingRecipe recipe = new MeltingRecipe(RecipeMatch.ItemCombination.ofNBT(inputItem, outputFluidStack.amount), outputFluidStack, meltingTime);
        TinkerRegistry.registerMelting(recipe);
        customMeltingRecipes.add(recipe);
    }

    public static void registerMelting(Item item, Fluid fluid, int outputAmount, int meltingTime){
        TinkerRegistry.registerMelting(new MeltingRecipe(RecipeMatch.of(item, outputAmount), fluid, meltingTime));
    }

}
