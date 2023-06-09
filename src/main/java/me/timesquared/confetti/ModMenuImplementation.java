package me.timesquared.confetti;

import me.shedaniel.autoconfig.AutoConfig;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import com.terraformersmc.modmenu.api.ModMenuApi;

@Environment(EnvType.CLIENT)
public class ModMenuImplementation implements ModMenuApi {
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return parent -> AutoConfig.getConfigScreen(ConfigScreen.class, parent).get();
	}
}
