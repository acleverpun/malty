package family.hadden.malty;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import family.hadden.malty.init.Registrar;
import family.hadden.malty.init.Tab;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.common.Mod;

@Mod(Main.modId)
public class Main {
	public static final String modId = "malty";
	public static final ItemGroup tab = new Tab(modId);

	public static final Registrar registrar = new Registrar();

	public static final Logger log = LogManager.getLogger();

	public Main() {
		registrar.register();
	}
}
