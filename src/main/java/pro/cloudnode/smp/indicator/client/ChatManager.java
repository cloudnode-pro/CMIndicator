package pro.cloudnode.smp.indicator.client;

import org.jetbrains.annotations.NotNull;
import pro.cloudnode.smp.indicator.lib.Chat;
import pro.cloudnode.smp.indicator.lib.Predicate;

public class ChatManager
{
	private static @NotNull ChatManager instance = new ChatManager();

	public @NotNull Chat chat;
	public @NotNull String channel;
	public @NotNull boolean showBadge = true;

	/**
	 * Get the ChatManager instance
	 * @return a chat manager instance
	 */
	public static @NotNull ChatManager getInstance()
	{
		return instance;
	}

	public ChatManager()
	{
		// the default chat type is public
		this.chat = Chat.Public;
		this.channel = "Public";
	}

	/**
	 * Apply chat settings from a predicate
	 * @param predicate the predicate to apply from
	 */
	public void apply(Predicate predicate)
	{
		this.chat = predicate.chat;
		this.channel = predicate.recipient;
	}
}
