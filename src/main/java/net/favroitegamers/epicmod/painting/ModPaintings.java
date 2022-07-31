package net.favroitegamers.epicmod.painting;

import net.favroitegamers.epicmod.EpicMod;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    //register object type painting in mod
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, EpicMod.MOD_ID);
           //add a painting
    public static final RegistryObject<PaintingVariant> TREE = PAINTING_VARIANTS.register("tree",
            () -> new PaintingVariant(32, 16));

    public static void register(IEventBus eventBus) {
        PAINTING_VARIANTS.register(eventBus);
    }
}
