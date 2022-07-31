package net.favroitegamers.epicmod.villager;

import com.google.common.collect.ImmutableSet;
import net.favroitegamers.epicmod.EpicMod;
import net.favroitegamers.epicmod.block.ModBlock;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers {
    //register static definition of poi_types
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, EpicMod.MOD_ID);
    //register profession static
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, EpicMod.MOD_ID);
//Register point of interest
    public static final RegistryObject<PoiType> WORKBENCH_POI = POI_TYPES.register("workbench_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlock.WORKBENCH.get().getStateDefinition().getPossibleStates()),
                    1,  1));
//Register Villager
    public static final RegistryObject<VillagerProfession> METAL_SMITH = VILLAGER_PROFESSIONS.register("metal_smith",
            () -> new VillagerProfession("metal_smith", x -> x.get() == WORKBENCH_POI.get(),
                    x -> x.get() == WORKBENCH_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_TOOLSMITH));

public static void registerPOIs() {
    try {
        ObfuscationReflectionHelper.findMethod(PoiType.class,
                "registerBlockStates", PoiType.class).invoke(null, WORKBENCH_POI.get());
    } catch (InvocationTargetException | IllegalAccessException exception) {
        exception.printStackTrace();
    }

}
    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
