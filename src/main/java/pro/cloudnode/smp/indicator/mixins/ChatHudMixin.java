package pro.cloudnode.smp.indicator.mixins;

import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.gui.hud.MessageIndicator;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChatHud.class)
public class ChatHudMixin
{
	@Inject(at = @At("HEAD"), method = "logChatMessage")
	public void onMessage(Text message, MessageIndicator indicator, CallbackInfo ci) {

	}
}
