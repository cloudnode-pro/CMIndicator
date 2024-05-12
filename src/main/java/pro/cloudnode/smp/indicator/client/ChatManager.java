package pro.cloudnode.smp.indicator.client;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import org.jetbrains.annotations.NotNull;
import pro.cloudnode.smp.indicator.CMIndicator;
import pro.cloudnode.smp.indicator.PersistentStorage;
import pro.cloudnode.smp.indicator.lib.Chat;
import pro.cloudnode.smp.indicator.lib.Predicate;

import java.util.HashMap;

public class ChatManager
{
	public final static String Path = FabricLoader.getInstance().getConfigDir() + "/cmindicator.json";
	private static ChatManager instance;
	public boolean showBadge = true;

	public @NotNull HashMap<String, ChatState> state;
	public @NotNull String currentServer = "localhost";

	private ChatManager()
	{
		this.state = new HashMap<>();

		// try load
		if (PersistentStorage.Exists(Path)) {
			this.fromJSON(PersistentStorage.Load(Path));
		}
	}

	/**
	 * Get the ChatManager instance
	 *
	 * @return a chat manager instance
	 */
	public static @NotNull ChatManager getInstance()
	{
		if (instance == null) instance = new ChatManager();
		return instance;
	}

	/**
	 * Get the state in the current server
	 * @return a state object
	 */
	public ChatState currentState()
	{
		return this.state.get(currentServer());
	}

	public @NotNull String currentServer()
	{
		return currentServer;
	}

	/**
	 * Get the state chat
	 */
	public Chat chat()
	{
		return this.state.get(currentServer()).chat();
	}

	/**
	 * Get the state channel
	 *
	 * @return the channel as a string
	 */
	public String channel()
	{
		return this.state.get(currentServer()).channel();
	}

	public void createIfNotExists()
	{
		if (MinecraftClient.getInstance().player == null) return;
		if (this.state.containsKey(currentServer())) return;

		// the default chat type is public
		this.state.put(currentServer(), new ChatState(
				Chat.Public,
				"Public",
				Chat.Public.getColor()
		));
	}

	/**
	 * Apply chat settings from a predicate
	 *
	 * @param predicate the predicate to apply from
	 */
	public void apply(Text message, Predicate predicate)
	{
		predicate.apply(message);
	}

	/**
	 * Apply chat settings from a state
	 *
	 * @param state the state to apply
	 */
	public void apply(ChatState state)
	{
		this.state.put(currentServer(), state);
		this.save();
	}

	/**
	 * Saves to disk
	 */
	public void save()
	{
		PersistentStorage.Save(this.toJSON(), Path);
	}

	/**
	 * Gets the state as a JSON string
	 *
	 * @return the state as a json string
	 * @implNote uses gson#toJson
	 */
	public String toJSON()
	{
		Gson gson = CMIndicator.gsonBuilder.create();
		return gson.toJson(this.state);
	}

	/**
	 * Sets the state from a JSON string
	 *
	 * @implNote uses gson#fromJson
	 */
	public void fromJSON(String json)
	{
		Gson gson = CMIndicator.gsonBuilder.create();
		this.state = gson.fromJson(json, new TypeToken<HashMap<String, ChatState>>() {}.getType());
	}
}
