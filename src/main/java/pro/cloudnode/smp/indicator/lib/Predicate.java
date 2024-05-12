package pro.cloudnode.smp.indicator.lib;

import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import org.jetbrains.annotations.NotNull;
import pro.cloudnode.smp.indicator.CMIndicator;
import pro.cloudnode.smp.indicator.PersistentStorage;
import pro.cloudnode.smp.indicator.client.ChatManager;
import pro.cloudnode.smp.indicator.client.ChatState;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Predicate
{
	public final @NotNull Chat chat;
	private final @NotNull Pattern pattern;
	public @NotNull String channel;

	public int color;

	/**
	 * Constructor for Predicate
	 *
	 * @param pattern - the pattern to match
	 * @param chat    - the chat type associated with this predicate
	 */
	public Predicate(@NotNull String pattern, @NotNull Chat chat)
	{
		this.pattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
		this.chat = chat;
		this.channel = "";
	}

	/**
	 * Match a string against a list of predicates
	 *
	 * @param string - the string to match
	 * @return the matched predicate
	 * @see CMIndicator#PREDICATES
	 */
	public static Optional<Predicate> match(String string)
	{
		for (Predicate predicate : CMIndicator.PREDICATES) {
			if (predicate.test(string)) {
				return Optional.of(predicate.with(
						predicate.recipient(string)
				));
			}
		}
		return Optional.empty();
	}

	public boolean test(@NotNull String string)
	{
		return pattern.matcher(string).matches();
	}

	public String recipient(@NotNull String string)
	{
		Matcher matcher = pattern.matcher(string);
		if (matcher.find() && matcher.groupCount() > 0) {
			return matcher.group(1);
		}
		return "";
	}

	/**
	 * Get the predicate data as a chat state
	 *
	 * @return the chat state
	 */
	public ChatState state()
	{
		return new ChatState(
				this.chat,
				this.channel,
				(this.chat == Chat.Team) ? this.color : chat.getColor()
		);
	}

	public Predicate with(@NotNull String recipient)
	{
		this.channel = recipient;
		return this;
	}

	public void apply(Text message)
	{
		ChatManager.getInstance().state.put(ChatManager.getInstance().currentServer(), this.state());
		ChatManager.getInstance().save();
	};
}
