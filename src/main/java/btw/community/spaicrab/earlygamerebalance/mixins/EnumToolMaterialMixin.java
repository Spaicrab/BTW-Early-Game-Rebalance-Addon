package btw.community.spaicrab.earlygamerebalance.mixins;

import net.minecraft.src.EnumToolMaterial;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EnumToolMaterial.class)
public abstract class EnumToolMaterialMixin {

	@Mutable @Shadow @Final
    public static EnumToolMaterial STONE;

	@Mutable @Shadow @Final
    private float efficiencyOnProperMaterial;

	@Inject(method = "<clinit>", at = @At("RETURN"))
	private static void earlygamerebalance_fasterStoneTools(CallbackInfo ci) {
        ((EnumToolMaterialMixin)(Object) STONE).efficiencyOnProperMaterial = 1.60f;
	}

}
