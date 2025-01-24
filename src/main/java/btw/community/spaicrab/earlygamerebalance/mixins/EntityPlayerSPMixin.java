package btw.community.spaicrab.earlygamerebalance.mixins;

import net.minecraft.src.EntityPlayerSP;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(EntityPlayerSP.class)
public abstract class EntityPlayerSPMixin {

    @ModifyConstant(method = "updateGloomState", constant = @Constant(floatValue = 1200.0f))
    private float earlygamerebalance_lessenGloomStageDurationSP(float gloomStageDuration) {
        return 450.0f;
    }

}
