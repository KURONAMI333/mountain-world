package com.kuronami.mountainworld;

import com.kuronami.isekaiapi.api.Isekai;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(MountainWorld.MODID)
public final class MountainWorld {
    public static final String MODID = "mountain_world";
    public static final String VERSION = "0.1.0";
    public static final Logger LOGGER = LogUtils.getLogger();

    public MountainWorld(IEventBus modBus) {
        LOGGER.info("Mountain World v{} loading", VERSION);
        LOGGER.info("Mountain World: Isekai API facade ready (query={}, remap={})",
                Isekai.query().getClass().getSimpleName(),
                Isekai.remap().getClass().getSimpleName());
    }
}
