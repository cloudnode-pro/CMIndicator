package pro.cloudnode.smp.indicator;

import net.fabricmc.api.ClientModInitializer;
import org.jetbrains.annotations.NotNull;
import pro.cloudnode.smp.indicator.client.ChatManager;
import pro.cloudnode.smp.indicator.lib.Predicate;
import pro.cloudnode.smp.indicator.predicates.OfflinePredicate;
import pro.cloudnode.smp.indicator.predicates.PrivateChatPredicate;
import pro.cloudnode.smp.indicator.predicates.PublicChatPredicate;
import pro.cloudnode.smp.indicator.predicates.TeamChatPredicate;

/**
 * Client initializer
 */
public class CMIndicator implements ClientModInitializer
{
	public static final @NotNull Predicate[] PREDICATES = {
			new TeamChatPredicate(),
			new OfflinePredicate(),
			new PublicChatPredicate(),
			new PrivateChatPredicate()
	};

	/**
	 * Runs the mod initializer on the client environment.
	 */
	@Override
	public void onInitializeClient() {
		ChatManager.getInstance();
	}
}
