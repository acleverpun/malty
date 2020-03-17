package family.hadden.malty;

import family.hadden.malty.block.MaltyChest;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class Tab extends ItemGroup {
	public Tab() {
		super(Main.modId);
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(new MaltyChest());
	}
}
