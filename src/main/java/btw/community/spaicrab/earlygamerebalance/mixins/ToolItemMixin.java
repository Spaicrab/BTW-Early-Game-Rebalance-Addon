package btw.community.spaicrab.earlygamerebalance.mixins;

import btw.item.items.ToolItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = ToolItem.class, remap = false)
public interface ToolItemMixin {

    @Accessor("efficiencyOnProperMaterial")
    public void earlygamerebalance_setEfficiencyOnProperMaterial(float efficiencyOnProperMaterial);

}
