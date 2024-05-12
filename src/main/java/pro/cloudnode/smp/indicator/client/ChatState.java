package pro.cloudnode.smp.indicator.client;

import org.jetbrains.annotations.NotNull;
import pro.cloudnode.smp.indicator.lib.Chat;

public record ChatState(@NotNull Chat chat, @NotNull String channel, int color)
{
	public ChatState(Chat chat, String channel, int color)
	{
		this.chat = chat;
		this.channel = channel;
		// add 255 alpha to the colour since what we get is RGB and we need ARGB
		this.color = color + 0xFF000000;
	}
}
