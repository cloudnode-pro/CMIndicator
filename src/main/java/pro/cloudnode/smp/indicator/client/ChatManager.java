package pro.cloudnode.smp.indicator.client;

import net.fabricmc.loader.api.FabricLoader;
import org.jetbrains.annotations.NotNull;
import pro.cloudnode.smp.indicator.PersistentStorage;
import pro.cloudnode.smp.indicator.lib.Chat;
import pro.cloudnode.smp.indicator.lib.Predicate;

import java.io.Serializable;

public class ChatManager implements Serializable
{
	private static @NotNull ChatManager instance = new ChatManager();

	public static String Path = FabricLoader.getInstance().getConfigDir() + "/chat.ser";

	public @NotNull Chat chat;
	public @NotNull String channel;
	public @NotNull boolean showBadge = true;

	public ChatManager()
	{
		// the default chat type is public
		this.chat = Chat.Public;
		this.channel = "Public";
	}

	/**
	 * Get the ChatManager instance
	 *
	 * @return a chat manager instance
	 */
	public static @NotNull ChatManager getInstance()
	{
		return instance;
	}

	public static void setInstance(Object object) throws ClassCastException
	{
		instance = (ChatManager) object;
	}

	/**
	 * Apply chat settings from a predicate
	 *
	 * @param predicate the predicate to apply from
	 */
	public void apply(Predicate predicate)
	{
		this.chat = predicate.chat;
		this.channel = predicate.recipient;

		PersistentStorage.getInstance().Save(this, Path);
	}
}
