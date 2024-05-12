package pro.cloudnode.smp.indicator.predicates;

import net.minecraft.text.Text;
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

	@Override
	public void apply(Text message)
	{
		// filter through the children and find the one which contains the team colour
		// in this case it would be in a Text component that equals "{TEAM}"
		message.getSiblings().stream()
					.filter((child) ->
						child.getString().equalsIgnoreCase(this.channel)
				).forEach((child) -> {
					if (child.getStyle().getColor() != null) {
						this.color = child.getStyle().getColor().getRgb();
					}
				});

		super.apply(message);
	}
}
