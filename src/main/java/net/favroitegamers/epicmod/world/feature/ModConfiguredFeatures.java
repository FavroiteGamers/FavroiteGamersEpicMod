package net.favroitegamers.epicmod.world.feature;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.favroitegamers.epicmod.EpicMod;
import net.favroitegamers.epicmod.block.ModBlock;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, EpicMod.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_METAL_ORES = Suppliers.memoize(() -> List.of(

            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlock.METAL_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlock.DEEPSLATE_METAL_ORE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> METAL_ORE = CONFIGURED_FEATURES.register("metal_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_METAL_ORES.get(), 7)));

    public static void register(IEventBus eventbus) {
        CONFIGURED_FEATURES.register(eventbus);
    }
}
