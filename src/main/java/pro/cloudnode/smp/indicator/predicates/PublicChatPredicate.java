package pro.cloudnode.smp.indicator.predicates;

import pro.cloudnode.smp.indicator.lib.Chat;
import pro.cloudnode.smp.indicator.lib.Predicate;

public class PublicChatPredicate extends Predicate
{
	/**
	 * Predicate for public chat messages
	 */
	public PublicChatPredicate()
	{
		super(
				"\\(!\\) Your chat messages will now be public\\.",
				Chat.Public
		);
	}
}
