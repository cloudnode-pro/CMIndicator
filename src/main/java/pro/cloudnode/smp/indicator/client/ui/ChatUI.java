package pro.cloudnode.smp.indicator.client.ui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;
import pro.cloudnode.smp.indicator.client.ChatManager;
import pro.cloudnode.smp.indicator.lib.Chat;

public class ChatUI
{
	private final @NotNull DrawContext context;
	private final @NotNull Chat chat;

	public ChatUI(@NotNull DrawContext context, @NotNull Chat chat)
	{
		this.context = context;
		this.chat = chat;
	}

	public String format()
	{
		return ChatManager.getInstance().channel();
	}

	/**
	 * Get the width of the format() text
	 *
	 * @return the width in px
	 * @see this.format()
	 */
	public int getWidth()
	{
		return MinecraftClient.getInstance().textRenderer.getWidth(format()) + 12;
	}

	/**
	 * Draw the border and badge on the chat
	 *
	 * @param screen the chat screen to draw on
	 */
	public void draw(@NotNull ChatScreen screen)
	{
		int width = screen.width;
		int height = screen.height;

		if (chat.borderless()) return;
		context.drawBorder(1, height - 15, width - 2, 14, chat.getColor());

		if (!ChatManager.getInstance().showBadge) return;

		context.fill(1, height - 28, getWidth(), height - 15, chat.getColor());
		context.drawText(MinecraftClient.getInstance().textRenderer, Text.of(format()), 6, height - 25, 0xFFFFFFFF, true);
	}
}
