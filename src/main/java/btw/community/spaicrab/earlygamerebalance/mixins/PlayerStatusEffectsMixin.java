package btw.community.spaicrab.earlygamerebalance.mixins;

import btw.util.status.PlayerStatusEffects;
import btw.util.status.StatusEffect;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = PlayerStatusEffects.class, remap = false)
public abstract class PlayerStatusEffectsMixin {

	@Mutable @Shadow @Final
    static StatusEffect GLOOM;

	@Mutable @Shadow @Final
    static StatusEffect
		HURT, INJURED, WOUNDED, CRIPPLED, DYING;

	private static void earlygamerebalance_makeGloomLessAnnoying(StatusEffect gloom) {
		((StatusEffectMixin) gloom).earlygamerebalance_setEffectivenessMultiplier(0.75f);
	}

	private static void earlygamerebalance_revertLowHealthDamageDebuff(StatusEffect healthStatusEffect) {
		((StatusEffectMixin) healthStatusEffect).earlygamerebalance_setAffectsAttackDamage(false);
	}

	@Inject(method = "<clinit>", at = @At("RETURN"))
	private static void earlygamerebalance_PlayerStatusEffectsInitMixin(CallbackInfo ci) {
		earlygamerebalance_makeGloomLessAnnoying(GLOOM);

		earlygamerebalance_revertLowHealthDamageDebuff(HURT);
		earlygamerebalance_revertLowHealthDamageDebuff(INJURED);
		earlygamerebalance_revertLowHealthDamageDebuff(WOUNDED);
		earlygamerebalance_revertLowHealthDamageDebuff(CRIPPLED);
		earlygamerebalance_revertLowHealthDamageDebuff(DYING);
	}

}
