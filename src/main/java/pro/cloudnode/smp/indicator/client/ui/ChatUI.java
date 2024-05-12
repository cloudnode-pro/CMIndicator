package pro.cloudnode.smp.indicator.client.ui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Formatting;
import org.jetbrains.annotations.NotNull;
import pro.cloudnode.smp.indicator.client.ChatManager;
import pro.cloudnode.smp.indicator.client.ChatState;
import pro.cloudnode.smp.indicator.lib.Chat;
import pro.cloudnode.smp.indicator.lib.Utils;

import java.util.Objects;

import static pro.cloudnode.smp.indicator.lib.Utils.LUMINOSITY_BORDER;

public class ChatUI
{
	private final @NotNull DrawContext context;
	private final @NotNull ChatState state;

	public ChatUI(@NotNull DrawContext context, @NotNull ChatState state)
	{
		this.context = context;
		this.state = state;
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

		if (state.chat().borderless()) return;
		context.drawBorder(1, height - 15, width - 2, 14, state.color() );

		if (!ChatManager.getInstance().showBadge) return;

		int color = state.color();
		boolean shadow = !(Utils.luminosity(color) > LUMINOSITY_BORDER);

		context.fill(1, height - 28, getWidth(), height - 15, color);
		context.drawText(MinecraftClient.getInstance().textRenderer, Text.of(format()), 6, height - 25, Utils.contrast(color), shadow);


	}
}
