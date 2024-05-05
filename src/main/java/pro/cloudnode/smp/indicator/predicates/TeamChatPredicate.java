package pro.cloudnode.smp.indicator.predicates;

import pro.cloudnode.smp.indicator.lib.Chat;
import pro.cloudnode.smp.indicator.lib.Predicate;

public class TeamChatPredicate extends Predicate
{
	/**
	 * Predicate for team chat messages
	 */
	public TeamChatPredicate()
	{
		super(
				"\\(!\\) Your chat messages will now be sent as private team messages in (\\w+)\\. To re-enable public messages, run \\/teammsg",
				Chat.Team
		);
	}
}
