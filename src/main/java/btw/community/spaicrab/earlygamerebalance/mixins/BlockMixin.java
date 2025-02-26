package btw.community.spaicrab.earlygamerebalance.mixins;

import net.minecraft.src.Block;
import btw.community.spaicrab.earlygamerebalance.EarlyGameRebalance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import btw.block.blocks.TorchBlockBase;
import btw.block.blocks.FiniteUnlitTorchBlock;
import btw.block.blocks.FiniteBurningTorchBlock;
import btw.block.tileentity.FiniteTorchTileEntity;
import net.minecraft.src.World;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import btw.item.util.ItemUtils;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import btw.world.util.WorldUtils;

@Mixin(Block.class)
public abstract class BlockMixin {
    
	@Inject(method = "onBlockActivated", at = @At("RETURN"), cancellable = true)
	private void earlygamerebalance_pickupTorch(
        World world, int i, int j, int k, EntityPlayer player, int iFacing,
        float fXClick, float fYClick, float fZClick,
        CallbackInfoReturnable<Boolean> cir
    ) {
        //noinspection ConstantValue
        if (
            !( EarlyGameRebalance.altUseToPickUpTorches == player.isUsingSpecialKey() ) ||
            !( ((Object) this) instanceof TorchBlockBase ) ||
            player.getHeldItem() != null
        ) {
            cir.cancel();
            return;
        }

        if ( ((Object) this) instanceof FiniteUnlitTorchBlock ) {
            int iMetadata = world.getBlockMetadata(i, j, k);
            if (FiniteUnlitTorchBlock.getIsBurnedOut(iMetadata)) {
                cir.cancel();
                return;
            }
        }

        ItemStack stack;
        if ( ((Object) this) instanceof FiniteBurningTorchBlock ) {
            FiniteTorchTileEntity tileEntity = ((FiniteTorchTileEntity) world.getBlockTileEntity(i, j, k));
            int iBurnCountdown = tileEntity.burnTimeCountdown;
            long iExpiryTime = WorldUtils.getOverworldTimeServerOnly() + (long)iBurnCountdown;
            int iNewItemDamage = (int)(0.0013333333f * (float)(24000 - tileEntity.burnTimeCountdown));
            iNewItemDamage = MathHelper.clamp_int(iNewItemDamage, 1, 31);

            stack = new ItemStack(world.getBlockId(i, j, k), 1, iNewItemDamage);
            stack.setTagCompound(new NBTTagCompound());
            stack.getTagCompound().setLong("outTime", iExpiryTime);
        } else {
            stack = new ItemStack(world.getBlockId(i, j, k), 1, 0);
        }

        ItemUtils.givePlayerStackOrEjectFavorEmptyHand(player, stack, i, j, k);
        world.removeBlockTileEntity(i, j, k);
        world.setBlockWithNotify(i, j, k, 0);
        cir.setReturnValue(true);
    }

}
