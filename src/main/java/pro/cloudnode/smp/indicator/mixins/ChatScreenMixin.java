package pro.cloudnode.smp.indicator.mixins;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ChatScreen;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import pro.cloudnode.smp.indicator.client.ChatManager;
import pro.cloudnode.smp.indicator.client.ui.ChatUI;

@Mixin(ChatScreen.class)
public class ChatScreenMixin
{

	@Inject(at = @At("HEAD"), method = "keyPressed")
	public void onKeyPress(CallbackInfoReturnable<Boolean> cir)
	{
		ChatManager.getInstance().showBadge = false;
	}

	@Inject(at = @At("HEAD"), method = "init")
	private void onChatInit(CallbackInfo ci)
	{
		ChatManager.getInstance().showBadge = true;
	}

	@Inject(at = @At("HEAD"), method = "render", locals = LocalCapture.CAPTURE_FAILHARD)
	private void render(@NotNull DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo info)
	{
		ChatManager.getInstance().createIfNotExists();
		new ChatUI(context, ChatManager.getInstance().currentState()).draw((ChatScreen) (Object) this);
	}

}
