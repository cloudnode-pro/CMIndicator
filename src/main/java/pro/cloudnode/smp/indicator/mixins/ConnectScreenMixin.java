package pro.cloudnode.smp.indicator.mixins;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ConnectScreen;
import net.minecraft.client.network.ServerAddress;
import net.minecraft.client.network.ServerInfo;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pro.cloudnode.smp.indicator.client.ChatManager;

@Mixin(ConnectScreen.class)
public class ConnectScreenMixin
{
	@Inject(at = @At("HEAD"), method = "connect(Lnet/minecraft/client/MinecraftClient;Lnet/minecraft/client/network/ServerAddress;Lnet/minecraft/client/network/ServerInfo;)V")
	public void connect(MinecraftClient client, ServerAddress address, @Nullable ServerInfo info, CallbackInfo ci)
	{
		ChatManager.getInstance().currentServer = String.format("%s:%s", address.getAddress(), address.getPort());
	}
}
