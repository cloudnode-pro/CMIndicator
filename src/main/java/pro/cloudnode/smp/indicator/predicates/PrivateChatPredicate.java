package pro.cloudnode.smp.indicator.predicates;

import pro.cloudnode.smp.indicator.lib.Chat;
import pro.cloudnode.smp.indicator.lib.Predicate;

public class PrivateChatPredicate extends Predicate
{
	/**
	 * Predicate for private/msg chat messages
	 */
	public PrivateChatPredicate()
	{
		super(
				"\\(!\\) Your chat messages will now be sent as private messages to (\\w+)\\. To re-enable public messages, run \\/msg (\\w+)",
				Chat.Private
		);
	}
}
