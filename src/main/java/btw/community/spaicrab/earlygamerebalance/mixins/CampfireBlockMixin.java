package btw.community.spaicrab.earlygamerebalance.mixins;

import btw.block.blocks.CampfireBlock;
import btw.community.spaicrab.earlygamerebalance.EarlyGameRebalance;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CampfireBlock.class)
public abstract class CampfireBlockMixin {

	@Inject(
        method = "onBlockActivated",
        at = @At(value = "INVOKE", target =
            "Lbtw/item/util/ItemUtils;givePlayerStackOrEject(Lnet/minecraft/src/EntityPlayer;Lnet/minecraft/src/ItemStack;III)V"
        ),
        cancellable = true
    )
	private void earlygamerebalance_needAltUseToGrabCampfireItem(
        World world, int i, int j, int k, EntityPlayer player, int iFacing,
        float fXClick, float fYClick, float fZClick,
        CallbackInfoReturnable<Boolean> cir
    ) {
        if (EarlyGameRebalance.altUseToPickUpOvenItems && !player.isUsingSpecialKey()) {
            cir.setReturnValue(false);
        }
	}

}