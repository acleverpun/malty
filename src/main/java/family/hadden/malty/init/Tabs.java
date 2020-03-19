package family.hadden.malty.init;

import java.util.function.Supplier;

import javax.annotation.Nonnull;

import family.hadden.malty.Main;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public final class Tabs {
	public static final ItemGroup malty = new MaltyTab(Main.modId, () -> new ItemStack(Items.GOLD_NUGGET));

	public static final class MaltyTab extends ItemGroup {
		@Nonnull
		private final Supplier<ItemStack> iconSupplier;

		public MaltyTab(@Nonnull final String name, @Nonnull final Supplier<ItemStack> iconSupplier) {
			super(name);
			this.iconSupplier = iconSupplier;
		}

		@Override
		@Nonnull
		public ItemStack createIcon() {
			return iconSupplier.get();
		}
	}
}
