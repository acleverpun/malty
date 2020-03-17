package family.hadden.malty;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class Tab extends ItemGroup {
	public Tab(String label) {
		super(label);
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(Items.GOLD_NUGGET);
		// return new ItemStack(new MaltyChest());
	}
}
