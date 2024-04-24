package net.marsh.tutorialmod.datagen;

import net.marsh.tutorialmod.TutorialMod;
import net.marsh.tutorialmod.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, TutorialMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ZIRCON_BLOCK);
        blockWithItem(ModBlocks.ZIRCON_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ZIRCON_ORE);
        blockWithItem(ModBlocks.JUMPY_BLOCK);


    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get());
        simpleBlockItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));


    }
}
