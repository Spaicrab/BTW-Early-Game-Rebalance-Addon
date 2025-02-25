package btw.community.spaicrab.earlygamerebalance.mixins;

import btw.util.status.PlayerStatusEffects;
import btw.util.status.StatusEffect;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = PlayerStatusEffects.class, remap = false)
public abstract class PlayerStatusEffectsMixin {

	@Mutable @Shadow @Final
    public static StatusEffect GLOOM;

	@Mutable @Shadow @Final
    public static StatusEffect
		HURT, INJURED, WOUNDED, CRIPPLED, DYING;

	@Unique
	private static void earlygamerebalance_makeGloomLessAnnoying(StatusEffect gloom) {
		((StatusEffectMixinAccessor) gloom).earlygamerebalance_setEffectivenessMultiplier(0.75f);
	}

	@Unique
	private static void earlygamerebalance_revertLowHealthDamageDebuff(StatusEffect healthStatusEffect) {
		((StatusEffectMixinAccessor) healthStatusEffect).earlygamerebalance_setAffectsAttackDamage(false);
	}

	@Inject(method = "<clinit>", at = @At("RETURN"))
	private static void earlygamerebalance_playerStatusEffectsInit(CallbackInfo ci) {
		earlygamerebalance_makeGloomLessAnnoying(GLOOM);

		earlygamerebalance_revertLowHealthDamageDebuff(HURT);
		earlygamerebalance_revertLowHealthDamageDebuff(INJURED);
		earlygamerebalance_revertLowHealthDamageDebuff(WOUNDED);
		earlygamerebalance_revertLowHealthDamageDebuff(CRIPPLED);
		earlygamerebalance_revertLowHealthDamageDebuff(DYING);
	}

}
