package pro.cloudnode.smp.indicator.lib;

import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

public class Predicate
{
	private final @NotNull Pattern pattern;

	public Predicate(@NotNull Pattern pattern)
	{
		this.pattern = pattern;
	}

	public Predicate(@NotNull String pattern)
	{
		this.pattern = Pattern.compile(pattern);
	}

	public boolean test(@NotNull String string)
	{
		return pattern.matcher(string).matches();
	}

	public boolean test(@NotNull Text text)
	{
		return pattern.matcher(text.getString()).matches();
	}
}
