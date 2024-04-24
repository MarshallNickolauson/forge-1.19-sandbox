package net.marsh.tutorialmod.datagen;

import net.marsh.tutorialmod.block.ModBlocks;
import net.marsh.tutorialmod.item.ModItems;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        oreSmelting(consumer, List.of(
                ModItems.RAW_ZIRCON.get(),
                ModBlocks.ZIRCON_ORE.get(),
                ModBlocks.DEEPSLATE_ZIRCON_ORE.get()),
                ModItems.ZIRCON.get(), 0.7f, 200, "zircon");

        oreBlasting(consumer, List.of(
                        ModItems.RAW_ZIRCON.get(),
                        ModBlocks.ZIRCON_ORE.get(),
                        ModBlocks.DEEPSLATE_ZIRCON_ORE.get()),
                ModItems.ZIRCON.get(), 0.7f, 200, "zircon");

        nineBlockStorageRecipes(consumer, ModItems.ZIRCON.get(), ModBlocks.ZIRCON_BLOCK.get());

        ShapedRecipeBuilder.shaped(ModBlocks.ZIRCON_BLOCK.get(), 1)
                .define('Z', ModItems.ZIRCON.get())
                .define('D', Items.DIAMOND)
                .pattern("ZZZ")
                .pattern("ZDZ")
                .pattern("ZZZ")
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .save(consumer);
    }
}
