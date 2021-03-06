package com.irtimaled.bbor.mixin.server.dedicated;

import com.irtimaled.bbor.common.CommonProxy;
import com.irtimaled.bbor.common.interop.CommonInterop;
import net.minecraft.server.dedicated.DedicatedServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DedicatedServer.class)
public class MixinDedicatedServer {
    @Inject(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/dedicated/DedicatedServer;loadAllWorlds(Ljava/lang/String;Ljava/lang/String;JLnet/minecraft/world/WorldType;Lcom/google/gson/JsonElement;)V"))
    private void init(CallbackInfoReturnable<Boolean> cir) {
        CommonInterop.init();
        new CommonProxy().init();
    }
}
