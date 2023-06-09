package me.timesquared.confetti;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import org.slf4j.LoggerFactory;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import org.slf4j.Logger;
import net.fabricmc.api.ModInitializer;

public class Main implements ModInitializer
{
	public static final Logger LOGGER = LoggerFactory.getLogger("Confetti");
	
	public void onInitialize() {
		AutoConfig.register(ConfigScreen.class, GsonConfigSerializer::new);
		Main.LOGGER.info("Confetti initialized! Have fun with the confetti!");
	}
}
