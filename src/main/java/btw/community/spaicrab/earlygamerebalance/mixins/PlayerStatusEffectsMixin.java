package btw.community.spaicrab.earlygamerebalance.mixins;

import btw.util.status.PlayerStatusEffects;
import btw.util.status.StatusEffect;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = PlayerStatusEffects.class, remap = false)
public abstract class PlayerStatusEffectsMixin {

	@Mutable @Shadow @Final
    static StatusEffect
		HURT, INJURED, WOUNDED, CRIPPLED, DYING;

	@Inject(method = "<clinit>", at = @At("TAIL"))
	private static void earlygamerebalance_revertLowHealthDamageDebuff(CallbackInfo ci) {
		((StatusEffectMixin) HURT).earlygamerebalance_setAffectsAttackDamage(false);
		((StatusEffectMixin) INJURED).earlygamerebalance_setAffectsAttackDamage(false);
		((StatusEffectMixin) WOUNDED).earlygamerebalance_setAffectsAttackDamage(false);
		((StatusEffectMixin) CRIPPLED).earlygamerebalance_setAffectsAttackDamage(false);
		((StatusEffectMixin) DYING).earlygamerebalance_setAffectsAttackDamage(false);
	}

}
