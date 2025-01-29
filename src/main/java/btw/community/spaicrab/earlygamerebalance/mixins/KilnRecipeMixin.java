package btw.community.spaicrab.earlygamerebalance.mixins;

import btw.crafting.recipe.types.KilnRecipe;
import net.minecraft.src.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = KilnRecipe.class, remap = false)
public abstract class KilnRecipeMixin {
    
    @Redirect(
        method = "matchesRecipe",
        at = @At(value = "INVOKE", target =
            "Ljava/lang/Object;equals(Ljava/lang/Object;)Z"
        )
    )
    private boolean earlygamerebalance_fixEqualsBug(Object object1, Object object2) {
        ItemStack[] recipeOutput1 = ((ItemStack[]) object1);
        ItemStack[] recipeOutput2 = ((ItemStack[]) object2);

        boolean match = false;
        if (recipeOutput1.length == recipeOutput2.length){
            match = true;
            for (int i = 0; i < recipeOutput1.length; i++) {
                ItemStack currentStack = recipeOutput1[i];
                if (currentStack != null && recipeOutput2[i] != null && currentStack.isItemEqual(recipeOutput2[i])) {
                    continue;
                } else {
                    match = false;
                    break;
                }
            }
        }
        return match;
    }

}
