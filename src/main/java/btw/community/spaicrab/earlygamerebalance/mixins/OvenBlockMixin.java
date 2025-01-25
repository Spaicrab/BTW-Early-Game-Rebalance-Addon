package btw.community.spaicrab.earlygamerebalance.mixins;

import btw.block.blocks.OvenBlock;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(OvenBlock.class)
public abstract class OvenBlockMixin {

	@Inject(
        method = "onBlockActivated",
        at = @At(value = "INVOKE", target =
            "Lbtw/block/tileentity/OvenTileEntity;givePlayerCookStack(Lnet/minecraft/src/EntityPlayer;I)V"
        ),
        cancellable = true
    )
	private void earlygamerebalance_needAltUseToGrabOvenItem(
        World world, int i, int j, int k, EntityPlayer player, int iFacing,
        float fXClick, float fYClick, float fZClick,
        CallbackInfoReturnable cir
    ) {
        if (!player.isUsingSpecialKey()) {
            cir.setReturnValue(false);
        }
	}

}