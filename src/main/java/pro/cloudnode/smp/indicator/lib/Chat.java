package pro.cloudnode.smp.indicator.lib;

import org.jetbrains.annotations.NotNull;

public enum Chat
{
	Private(0xFF3B82F6),
	Public(0xFFE4F3F7),
	Team(0xFF12DB55);

	// the accent colour of the chat
	private final int color;

	/**
	 * Enum for chat types
	 *
	 * @param color - accent color of the chat (#RGBA
	 */
	Chat(@NotNull int color)
	{
		this.color = color;
	}

	/**
	 * Get the color of the chat
	 *
	 * @return the color of the chat
	 */
	public int getColor()
	{
		return color;
	}

	public boolean borderless()
	{
		return this == Chat.Public;
	}
}
