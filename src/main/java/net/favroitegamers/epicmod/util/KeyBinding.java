package net.favroitegamers.epicmod.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY_EPICMOD = "key.category.epicmod.epicmodkeybinds";
    public static final String KEY_HELP = "key.epicmod.help";

    public static final KeyMapping HELP_KEY = new KeyMapping(KEY_HELP, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_RIGHT_CONTROL, KEY_CATEGORY_EPICMOD);
}
