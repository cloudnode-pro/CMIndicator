package pro.cloudnode.smp.indicator.client;

import org.jetbrains.annotations.NotNull;
import pro.cloudnode.smp.indicator.lib.Chat;

public record ChatState(@NotNull Chat chat, @NotNull String channel)
{
	public ChatState(Chat chat, String channel)
	{
		this.chat = chat;
		this.channel = channel;
	}
}
