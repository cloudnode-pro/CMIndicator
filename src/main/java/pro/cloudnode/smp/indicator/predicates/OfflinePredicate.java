package pro.cloudnode.smp.indicator.predicates;

import pro.cloudnode.smp.indicator.lib.Chat;
import pro.cloudnode.smp.indicator.lib.Predicate;

public class OfflinePredicate extends Predicate
{
	/**
	 * Predicate for public chat messages
	 * (as seen from 'Player xxxx is offline')
	 */
	public OfflinePredicate()
	{
		super(
				"\\(!\\) Player \\(\\w+\\) is offline\\. Your chat messages have been switched back to public\\.",
				Chat.Public
		);
	}
}