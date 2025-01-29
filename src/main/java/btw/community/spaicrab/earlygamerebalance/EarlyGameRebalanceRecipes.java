package btw.community.spaicrab.earlygamerebalance;

import btw.crafting.recipe.RecipeManager;
import btw.crafting.manager.KilnCraftingManager;
import btw.crafting.manager.CrucibleStokedCraftingManager;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import btw.item.BTWItems;
import btw.block.BTWBlocks;

public class EarlyGameRebalanceRecipes {

    public static void earlygamerebalance_lessExpensiveIronIngotsRecipes() {
        RecipeManager.removeVanillaRecipe(
            new ItemStack(Item.ingotIron),
            new Object[]{"###", "###", "###", '#', BTWItems.ironNugget}
        );
        RecipeManager.addRecipe(
            new ItemStack(Item.ingotIron),
            new Object[]{"###", "###", '#', BTWItems.ironNugget}
        );

        RecipeManager.removeVanillaShapelessRecipe(
            new ItemStack(BTWItems.ironNugget, 9),
            new ItemStack[]{new ItemStack(Item.ingotIron)}
        );
        RecipeManager.addShapelessRecipe(
            new ItemStack(BTWItems.ironNugget, 6),
            new ItemStack[]{new ItemStack(Item.ingotIron)}
        );

        KilnCraftingManager kilnCraftingManager = KilnCraftingManager.instance;
        kilnCraftingManager.removeRecipe(
            new ItemStack[]{new ItemStack(Item.ingotIron)},
            BTWBlocks.ironOreChunkStorage,
            new int[]{Short.MAX_VALUE},
            (byte)8
        );
        RecipeManager.addKilnRecipe(
            new ItemStack[]{new ItemStack(Item.ingotIron), new ItemStack(BTWItems.ironNugget, 3)},
            BTWBlocks.ironOreChunkStorage,
            (byte)8
        );

        CrucibleStokedCraftingManager crucibleStokedCraftingManager = CrucibleStokedCraftingManager.getInstance();

        crucibleStokedCraftingManager.removeRecipe(
            new ItemStack(Item.ingotIron),
            new ItemStack[]{new ItemStack(BTWItems.ironNugget, 9)}
        );
        RecipeManager.addStokedCrucibleRecipe(
            new ItemStack(Item.ingotIron),
            new ItemStack[]{new ItemStack(BTWItems.ironNugget, 6)}
        );

        crucibleStokedCraftingManager.removeRecipe(
            new ItemStack(BTWItems.ironNugget, 12),
            new ItemStack[]{new ItemStack(Item.axeIron, 1, Short.MAX_VALUE)}
        );
        RecipeManager.addStokedCrucibleRecipe(
            new ItemStack(BTWItems.ironNugget, 8),
            new ItemStack[]{new ItemStack(Item.axeIron, 1, Short.MAX_VALUE)}
        );

        crucibleStokedCraftingManager.removeRecipe(
            new ItemStack(BTWItems.ironNugget, 12),
            new ItemStack[]{new ItemStack(Item.swordIron, 1, Short.MAX_VALUE)}
        );
        RecipeManager.addStokedCrucibleRecipe(
            new ItemStack(BTWItems.ironNugget, 8),
            new ItemStack[]{new ItemStack(Item.swordIron, 1, Short.MAX_VALUE)}
        );

        crucibleStokedCraftingManager.removeRecipe(
            new ItemStack(BTWItems.ironNugget, 12),
            new ItemStack[]{new ItemStack(Item.shears, 1, Short.MAX_VALUE)}
        );
        RecipeManager.addStokedCrucibleRecipe(
            new ItemStack(BTWItems.ironNugget, 8),
            new ItemStack[]{new ItemStack(Item.shears, 1, Short.MAX_VALUE)}
        );

        crucibleStokedCraftingManager.removeRecipe(
            new ItemStack(BTWItems.ironNugget, 6),
            new ItemStack[]{new ItemStack(Item.hoeIron, 1, Short.MAX_VALUE)}
        );
        RecipeManager.addStokedCrucibleRecipe(
            new ItemStack(BTWItems.ironNugget, 4),
            new ItemStack[]{new ItemStack(Item.hoeIron, 1, Short.MAX_VALUE)}
        );

        crucibleStokedCraftingManager.removeRecipe(
            new ItemStack(BTWItems.ironNugget, 6),
            new ItemStack[]{new ItemStack(Item.shovelIron, 1, Short.MAX_VALUE)}
        );
        RecipeManager.addStokedCrucibleRecipe(
            new ItemStack(BTWItems.ironNugget, 4),
            new ItemStack[]{new ItemStack(Item.shovelIron, 1, Short.MAX_VALUE)}
        );

        crucibleStokedCraftingManager.removeRecipe(
            new ItemStack(BTWItems.ironNugget, 30),
            new ItemStack[]{new ItemStack(Item.helmetIron, 1, Short.MAX_VALUE)}
        );
        RecipeManager.addStokedCrucibleRecipe(
            new ItemStack(BTWItems.ironNugget, 20),
            new ItemStack[]{new ItemStack(Item.helmetIron, 1, Short.MAX_VALUE)}
        );

        crucibleStokedCraftingManager.removeRecipe(
            new ItemStack(BTWItems.ironNugget, 48),
            new ItemStack[]{new ItemStack(Item.plateIron, 1, Short.MAX_VALUE)}
        );
        RecipeManager.addStokedCrucibleRecipe(
            new ItemStack(BTWItems.ironNugget, 32),
            new ItemStack[]{new ItemStack(Item.plateIron, 1, Short.MAX_VALUE)}
        );

        crucibleStokedCraftingManager.removeRecipe(
            new ItemStack(BTWItems.ironNugget, 42),
            new ItemStack[]{new ItemStack(Item.legsIron, 1, Short.MAX_VALUE)}
        );
        RecipeManager.addStokedCrucibleRecipe(
            new ItemStack(BTWItems.ironNugget, 28),
            new ItemStack[]{new ItemStack(Item.legsIron, 1, Short.MAX_VALUE)}
        );

        crucibleStokedCraftingManager.removeRecipe(
            new ItemStack(BTWItems.ironNugget, 24),
            new ItemStack[]{new ItemStack(Item.bootsIron, 1, Short.MAX_VALUE)}
        );
        RecipeManager.addStokedCrucibleRecipe(
            new ItemStack(BTWItems.ironNugget, 16),
            new ItemStack[]{new ItemStack(Item.bootsIron, 1, Short.MAX_VALUE)}
        );

        crucibleStokedCraftingManager.removeRecipe(
            new ItemStack(BTWItems.ironNugget, 6),
            new ItemStack[]{new ItemStack(BTWBlocks.pulley)}
        );
        RecipeManager.addStokedCrucibleRecipe(
            new ItemStack(BTWItems.ironNugget, 4),
            new ItemStack[]{new ItemStack(BTWBlocks.pulley)}
        );

        crucibleStokedCraftingManager.removeRecipe(
            new ItemStack(BTWItems.ironNugget, 30),
            new ItemStack[]{new ItemStack(Item.minecartEmpty)}
        );
        RecipeManager.addStokedCrucibleRecipe(
            new ItemStack(BTWItems.ironNugget, 20),
            new ItemStack[]{new ItemStack(Item.minecartEmpty)}
        );

        crucibleStokedCraftingManager.removeRecipe(
            new ItemStack(BTWItems.ironNugget, 30),
            new ItemStack[]{new ItemStack(Item.minecartCrate)}
        );
        RecipeManager.addStokedCrucibleRecipe(
            new ItemStack(BTWItems.ironNugget, 20),
            new ItemStack[]{new ItemStack(Item.minecartCrate)}
        );

        crucibleStokedCraftingManager.removeRecipe(
            new ItemStack(BTWItems.ironNugget, 30),
            new ItemStack[]{new ItemStack(Item.minecartPowered)}
        );
        RecipeManager.addStokedCrucibleRecipe(
            new ItemStack(BTWItems.ironNugget, 20),
            new ItemStack[]{new ItemStack(Item.minecartPowered)}
        );

        crucibleStokedCraftingManager.removeRecipe(
            new ItemStack(BTWItems.ironNugget, 18),
            new ItemStack[]{new ItemStack(Block.fenceIron, 8)}
        );
        RecipeManager.addStokedCrucibleRecipe(
            new ItemStack(BTWItems.ironNugget, 12),
            new ItemStack[]{new ItemStack(Block.fenceIron, 8)}
        );

        crucibleStokedCraftingManager.removeRecipe(
            new ItemStack(BTWItems.ironNugget, 42),
            new ItemStack[]{new ItemStack(Item.cauldron)}
        );
        RecipeManager.addStokedCrucibleRecipe(
            new ItemStack(BTWItems.ironNugget, 28),
            new ItemStack[]{new ItemStack(Item.cauldron)}
        );

        crucibleStokedCraftingManager.removeRecipe(
            new ItemStack(BTWItems.ironNugget, 42),
            new ItemStack[]{new ItemStack(BTWBlocks.cauldron)}
        );
        RecipeManager.addStokedCrucibleRecipe(
            new ItemStack(BTWItems.ironNugget, 28),
            new ItemStack[]{new ItemStack(BTWBlocks.cauldron)}
        );

        crucibleStokedCraftingManager.removeRecipe(
            new ItemStack(BTWItems.ironNugget, 20),
            new ItemStack[]{new ItemStack(BTWItems.screw)}
        );
        RecipeManager.addStokedCrucibleRecipe(
            new ItemStack(BTWItems.ironNugget, 13),
            new ItemStack[]{new ItemStack(BTWItems.screw)}
        );

        crucibleStokedCraftingManager.removeRecipe(
            new ItemStack(BTWItems.ironNugget, 20),
            new ItemStack[]{new ItemStack(BTWBlocks.screwPump)}
        );
        RecipeManager.addStokedCrucibleRecipe(
            new ItemStack(BTWItems.ironNugget, 13),
            new ItemStack[]{new ItemStack(BTWBlocks.screwPump)}
        );

        crucibleStokedCraftingManager.removeRecipe(
            new ItemStack(BTWItems.ironNugget, 6),
            new ItemStack[]{new ItemStack(BTWItems.gimpHelmet)}
        );
        RecipeManager.addStokedCrucibleRecipe(
            new ItemStack(BTWItems.ironNugget, 4),
            new ItemStack[]{new ItemStack(BTWItems.gimpHelmet)}
        );

        crucibleStokedCraftingManager.removeRecipe(
            new ItemStack(BTWItems.ironNugget, 12),
            new ItemStack[]{new ItemStack(BTWItems.gimpChest)}
        );
        RecipeManager.addStokedCrucibleRecipe(
            new ItemStack(BTWItems.ironNugget, 8),
            new ItemStack[]{new ItemStack(BTWItems.gimpChest)}
        );

        crucibleStokedCraftingManager.removeRecipe(
            new ItemStack(BTWItems.ironNugget, 6),
            new ItemStack[]{new ItemStack(BTWItems.gimpLeggings)}
        );
        RecipeManager.addStokedCrucibleRecipe(
            new ItemStack(BTWItems.ironNugget, 4),
            new ItemStack[]{new ItemStack(BTWItems.gimpLeggings)}
        );

        crucibleStokedCraftingManager.removeRecipe(
            new ItemStack(BTWItems.ironNugget, 12),
            new ItemStack[]{new ItemStack(BTWItems.gimpBoots)}
        );
        RecipeManager.addStokedCrucibleRecipe(
            new ItemStack(BTWItems.ironNugget, 8),
            new ItemStack[]{new ItemStack(BTWItems.gimpBoots)}
        );

        crucibleStokedCraftingManager.removeRecipe(
            new ItemStack(BTWItems.ironNugget, 42),
            new ItemStack[]{new ItemStack(Block.anvil)}
        );
        RecipeManager.addStokedCrucibleRecipe(
            new ItemStack(BTWItems.ironNugget, 28),
            new ItemStack[]{new ItemStack(Block.anvil)}
        );

        crucibleStokedCraftingManager.removeRecipe(
            new ItemStack(BTWItems.ironNugget, 6),
            new ItemStack[]{new ItemStack(BTWItems.metalFragment)}
        );
        RecipeManager.addStokedCrucibleRecipe(
            new ItemStack(BTWItems.ironNugget, 4),
            new ItemStack[]{new ItemStack(BTWItems.metalFragment)}
        );

        crucibleStokedCraftingManager.removeRecipe(
            new ItemStack(BTWItems.ironNugget, 36),
            new ItemStack[]{new ItemStack(BTWBlocks.pistonShovel)}
        );
        RecipeManager.addStokedCrucibleRecipe(
            new ItemStack(BTWItems.ironNugget, 24),
            new ItemStack[]{new ItemStack(BTWBlocks.pistonShovel)}
        );

        crucibleStokedCraftingManager.removeRecipe(
            new ItemStack(BTWItems.ironNugget, 8),
            new ItemStack[]{new ItemStack(BTWBlocks.ironSpike)}
        );
        RecipeManager.addStokedCrucibleRecipe(
            new ItemStack(BTWItems.ironNugget, 6),
            new ItemStack[]{new ItemStack(BTWBlocks.ironSpike)}
        );
    }

}
