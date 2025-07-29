package com.jampmasters.dossier;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class DossierClient implements ClientModInitializer {
    public static KeyBinding openKey;

    @Override
    public void onInitializeClient() {
        openKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.dossier.open", 
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_Z,
            "category.dossier"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (openKey.wasPressed()) {
                client.setScreen(new DossierScreen());
            }
        });
    }
}
