package pro.cloudnode.smp.indicator.server;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;

import java.util.logging.Logger;

@Environment(EnvType.SERVER)
public class CMIndicatorServer implements DedicatedServerModInitializer
{
	/**
	 * Runs the mod initializer.
	 * @implNote This will get called if someone places this mod on a fabric server by mistake.
	 */
	@Override
	public void onInitializeServer()
	{
		Logger.getLogger("CMIndicator")
				.severe("CMIndicator is a client-side mod and should not be installed on a server.");
	}
}
