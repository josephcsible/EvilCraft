package evilcraft.inventory.container;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import evilcraft.block.SpiritReanimator;
import evilcraft.core.inventory.container.ContainerWorking;
import evilcraft.core.inventory.slot.SlotFluidContainer;
import evilcraft.core.inventory.slot.SlotRemoveOnly;
import evilcraft.core.inventory.slot.SlotSingleItem;
import evilcraft.core.inventory.slot.SlotWorking;
import evilcraft.tileentity.TileSpiritReanimator;

/**
 * Container for the {@link SpiritReanimator}.
 * @author rubensworks
 *
 */
public class ContainerSpiritReanimator extends ContainerWorking<TileSpiritReanimator> {
    
    private static final int INVENTORY_OFFSET_X = 8;
    private static final int INVENTORY_OFFSET_Y = 84;
    
    /**
     * Container slot X coordinate.
     */
    public static final int SLOT_CONTAINER_X = 8;
    /**
     * Container slot Y coordinate.
     */
    public static final int SLOT_CONTAINER_Y = 36;
    
    /**
     * Box slot X coordinate.
     */
    public static final int SLOT_BOX_X = 97;
    /**
     * Box slot Y coordinate.
     */
    public static final int SLOT_BOX_Y = 22;
    
    /**
     * Egg slot X coordinate.
     */
    public static final int SLOT_EGG_X = 135;
    /**
     * Egg slot Y coordinate.
     */
    public static final int SLOT_EGG_Y = 22;
    
    /**
     * Output slot X coordinate.
     */
    public static final int SLOT_OUTPUT_X = 116;
    /**
     * Output slot Y coordinate.
     */
    public static final int SLOT_OUTPUT_Y = 52;

    /**
     * Make a new instance.
     * @param inventory The inventory of the player.
     * @param tile The tile entity that calls the GUI.
     */
    public ContainerSpiritReanimator(InventoryPlayer inventory, TileSpiritReanimator tile) {
        super(inventory, tile);

        // Adding inventory
        addSlotToContainer(new SlotFluidContainer(tile, TileSpiritReanimator.SLOT_CONTAINER,
        		SLOT_CONTAINER_X, SLOT_CONTAINER_Y,
        		tile.getTank())); // Container emptier
        addSlotToContainer(new SlotWorking<TileSpiritReanimator>(TileSpiritReanimator.SLOT_BOX, SLOT_BOX_X, SLOT_BOX_Y, tile)); // Box slot
        addSlotToContainer(new SlotSingleItem(tile, TileSpiritReanimator.SLOT_EGG, SLOT_EGG_X, SLOT_EGG_Y, Items.egg));
        addSlotToContainer(new SlotRemoveOnly(tile, TileSpiritReanimator.SLOTS_OUTPUT, SLOT_OUTPUT_X, SLOT_OUTPUT_Y));

        this.addPlayerInventory(inventory, INVENTORY_OFFSET_X, INVENTORY_OFFSET_Y);
    }
    
}