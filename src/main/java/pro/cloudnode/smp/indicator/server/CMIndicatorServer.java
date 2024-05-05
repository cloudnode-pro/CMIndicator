package pro.cloudnode.smp.indicator.server;

import net.fabricmc.api.ModInitializer;

import java.util.logging.LogManager;

public class CMIndicatorServer implements ModInitializer
{
	/**
	 * Runs the mod initializer.
	 * @implNote This will get called if someone places this mod on a fabric server by mistake.
	 */
	@Override
	public void onInitialize()
	{
		LogManager.getLogManager()
				.getLogger("CMIndicator")
				.info("You should not run this mod on a server.");
	}
}
