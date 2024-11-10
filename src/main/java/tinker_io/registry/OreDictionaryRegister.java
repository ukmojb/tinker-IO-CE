package tinker_io.registry;

import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.shared.TinkerCommons;

public class OreDictionaryRegister {

    public static void init() {
        OreDictionary.registerOre("oreCobalt", TinkerCommons.oreCobalt);
        OreDictionary.registerOre("oreArdite", TinkerCommons.oreArdite);
    }

}
