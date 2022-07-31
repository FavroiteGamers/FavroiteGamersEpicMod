package net.favroitegamers.epicmod;

import com.mojang.logging.LogUtils;
import net.favroitegamers.epicmod.block.ModBlock;
import net.favroitegamers.epicmod.item.ModItems;
import net.favroitegamers.epicmod.networking.ModMessages;
import net.favroitegamers.epicmod.painting.ModPaintings;
import net.favroitegamers.epicmod.villager.ModVillagers;
import net.favroitegamers.epicmod.world.feature.ModConfiguredFeatures;
import net.favroitegamers.epicmod.world.feature.ModPlacedFeatures;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
@Mod(EpicMod.MOD_ID)
public class EpicMod
{

    public static final String MOD_ID = "epicmod";
    private static final Logger LOGGER = LogUtils.getLogger();


    public EpicMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlock.register(modEventBus);
        ModPaintings.register(modEventBus);

        ModVillagers.register(modEventBus);

        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);

        modEventBus.addListener(this::commonSetup);


        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event){
         event.enqueueWork(() -> {
             ModMessages.register();
            ModVillagers.registerPOIs();
         });

        ModMessages.register();
    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
