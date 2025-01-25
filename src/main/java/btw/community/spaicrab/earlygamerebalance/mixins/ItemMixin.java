package btw.community.spaicrab.earlygamerebalance.mixins;

import net.minecraft.src.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Item.class)
public class ItemMixin {
    
	@Mutable @Shadow
    static Item pickaxeStone;

	@Inject(method = "<clinit>", at = @At("RETURN"))
	private static void earlygamerebalance_fasterStonePickaxe(CallbackInfo ci) {
        // Default is 1.01f
        ((ToolItemMixin) pickaxeStone).earlygamerebalance_setEfficiencyOnProperMaterial(
            1.40f
        );
	}

}
