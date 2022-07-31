package net.favroitegamers.epicmod.event;

import net.favroitegamers.epicmod.EpicMod;
import net.favroitegamers.epicmod.util.KeyBinding;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = EpicMod.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.HELP_KEY);
        }
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if(KeyBinding.HELP_KEY.consumeClick()) {
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("Thank you for playing my mod here are some links to pages that may be useful!" +
                        "Curseforge Mod Page:" +
                        "My Youtube: https://www.youtube.com/channel/UCvNxM0dbuaQG01tNcZFmlkQ]" +
                        "My Twitch: https://www.twitch.tv/favroitegamers"
                ));
            }
        }
        @Mod.EventBusSubscriber(modid = EpicMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
        public static class ClientModBusEvent {
            @SubscribeEvent
            public static void onKeyRegister(RegisterKeyMappingsEvent event) {
                    event.register(KeyBinding.HELP_KEY);
                }
            }
        }

    }





