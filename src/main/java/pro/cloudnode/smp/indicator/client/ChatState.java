package pro.cloudnode.smp.indicator.client;

import org.jetbrains.annotations.NotNull;
import pro.cloudnode.smp.indicator.lib.Chat;

public class ChatState
{
	public @NotNull Chat chat;
	public @NotNull String channel;

	public ChatState(Chat chat, String channel)
	{
		this.chat = chat;
		this.channel = channel;
	}
}
