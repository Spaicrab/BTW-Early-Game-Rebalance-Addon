package btw.community.spaicrab.earlygamerebalance.mixins;

import btw.world.util.difficulty.Difficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = btw.world.util.difficulty.Difficulty.class, remap = false)
public abstract class DifficultyMixin {

    @Inject(method = "getNoToolBlockHardnessMultiplier", at = @At("HEAD"), cancellable = true)
    private void earlygamerebalance_fasterNoToolBlockBreakingSpeed(CallbackInfoReturnable<Float> cir) {
        if (((Difficulty)(Object) this).NAME.equals("standard")) {
            cir.setReturnValue(0.85f);
        }
    }

}
