package pro.cloudnode.smp.indicator.lib;

import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;
import pro.cloudnode.smp.indicator.CMIndicator;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Predicate
{
	public final @NotNull Chat chat;
	private final @NotNull Pattern pattern;
	public @NotNull String recipient;

	/**
	 * Constructor for Predicate
	 *
	 * @param pattern - the pattern to match
	 * @param chat    - the chat type associated with this predicate
	 */
	public Predicate(@NotNull Pattern pattern, @NotNull Chat chat)
	{
		this.pattern = pattern;
		this.chat = chat;
	}

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
	}

	/**
	 * Match a string against a list of predicates
	 *
	 * @param string - the string to match
	 * @return the matched predicate
	 * @see pro.cloudnode.smp.indicator.CMIndicator#PREDICATES
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

	public boolean test(@NotNull Text text)
	{
		return pattern.matcher(text.getString()).matches();
	}

	public String recipient(@NotNull String string)
	{
		Matcher matcher = pattern.matcher(string);
		if (matcher.find() && matcher.groupCount() > 0) {
			return matcher.group(1);
		}
		return "";
	}

	public Predicate with(@NotNull String recipient)
	{
		this.recipient = recipient;
		return this;
	}
}
