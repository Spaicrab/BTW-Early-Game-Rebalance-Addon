package btw.community.spaicrab.earlygamerebalance.mixins;

import net.minecraft.src.EntityPlayerMP;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(EntityPlayerMP.class)
public abstract class EntityPlayerMPMixin {

    @ModifyConstant(method = "updateGloomState", constant = @Constant(intValue = 1200))
    private int earlygamerebalance_lessenGloomStageDurationMP(int gloomStageDuration) {
        return 450;
    }

    @ModifyConstant(method = "updateGloomState", constant = @Constant(floatValue = 1200.0f))
    private float earlygamerebalance_lessenGloomStageDurationMP(float gloomStageDuration) {
        return 450.0f;
    }

}
