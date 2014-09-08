package evilcraft.block;

import net.minecraft.item.ItemBlock;
import evilcraft.core.config.BlockConfig;
import evilcraft.core.config.ElementTypeCategory;
import evilcraft.core.config.configurable.ConfigurableProperty;
import evilcraft.item.ExcrementPileItemBlock;

/**
 * Config for the {@link ExcrementPile}.
 * @author rubensworks
 *
 */
public class ExcrementPileConfig extends BlockConfig {
    
    /**
     * The unique instance.
     */
    public static ExcrementPileConfig _instance;
    
    /**
     * If Excrement can also poison any mob next to players.
     */
    @ConfigurableProperty(category = ElementTypeCategory.GENERAL, comment = "If Excrement can also poison any mob next to players.", isCommandable = true)
    public static boolean poisonEntities = false;
    
    /**
     * The relative effectiveness when compared to bonemeal if shift right click using.
     */
    @ConfigurableProperty(category = ElementTypeCategory.GENERAL, comment = "The relative effectiveness when compared to bonemeal if shift right click using.", isCommandable = true)
    public static int effectiveness = 3;

    /**
     * Make a new instance.
     */
    public ExcrementPileConfig() {
        super(
        	true,
            "excrementPile",
            null,
            ExcrementPile.class
        );
    }
    
    @Override
    public Class<? extends ItemBlock> getItemBlockClass() {
        return ExcrementPileItemBlock.class;
    }
    
}