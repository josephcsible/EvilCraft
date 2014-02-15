package evilcraft.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import evilcraft.blocks.NetherfishSpawn;
import evilcraft.blocks.NetherfishSpawnConfig;

/**
 * WorldGenerator for netherfish spawn blocks.
 * @author rubensworks
 *
 */
public class NetherfishSpawnGenerator extends WorldGenMinableConfigurable{
    
    /**
     * Make a new instance.
     */
    public NetherfishSpawnGenerator() {
        super(NetherfishSpawn.getInstance(), 1, NetherfishSpawnConfig.veinsPerChunk, 1, 127);
    }
    
    @Override
    public void loopGenerate(World world, Random rand, int chunkX, int chunkZ) {
        for(int k = 0; k < veinsPerChunk; k++){
            int firstBlockXCoord = chunkX + rand.nextInt(16);
            int firstBlockYCoord = startY + rand.nextInt(endY - startY);
            int firstBlockZCoord = chunkZ + rand.nextInt(16);
            
            Block block = world.getBlock(firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
            int meta = NetherfishSpawn.getInstance().getMetadataFromBlock(block);
            if(meta != -1) {
                this.generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
                world.setBlockMetadataWithNotify(firstBlockXCoord, firstBlockYCoord, firstBlockZCoord, meta, 2);
            }
        }
    }
}
