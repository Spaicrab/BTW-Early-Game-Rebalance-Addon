package btw.community.spaicrab.earlygamerebalance.mixins;

import btw.util.status.StatusEffect;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = StatusEffect.class, remap = false)
public interface StatusEffectMixinAccessor {
    
    @Accessor("effectivenessMultiplier")
    public void earlygamerebalance_setEffectivenessMultiplier(float effectivenessMultiplier);
    
    @Accessor("affectsAttackDamage")
    public void earlygamerebalance_setAffectsAttackDamage(boolean affectsAttackDamage);

}
