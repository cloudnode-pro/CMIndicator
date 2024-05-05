package pro.cloudnode.smp.indicator;

import net.fabricmc.api.ClientModInitializer;
import org.jetbrains.annotations.NotNull;
import pro.cloudnode.smp.indicator.lib.Predicate;
import pro.cloudnode.smp.indicator.predicates.TeamChatPredicate;

import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Client initializer
 */
public class CMIndicator implements ClientModInitializer
{
	public static final Logger logger = LogManager.getLogManager().getLogger("CMIndicator");
	public static final @NotNull Predicate[] PREDICATES = { new TeamChatPredicate() };

	/**
	 * Runs the mod initializer on the client environment.
	 */
	@Override
	public void onInitializeClient()
	{
		logger.info("Initializing CMIndicator");
	}
}
