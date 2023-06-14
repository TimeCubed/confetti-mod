package me.timesquared.confetti;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "confetti")
public class ConfigScreen implements ConfigData {
	@ConfigEntry.BoundedDiscrete(max = 100L)
	long particlePercent = 100L;
	
	@ConfigEntry.Gui.CollapsibleObject
	@ConfigEntry.Gui.Tooltip(count = 3)
	SingleColors singleColors = new SingleColors();
	
	@ConfigEntry.Gui.CollapsibleObject
	@ConfigEntry.Gui.Tooltip(count = 2)
	DoubleColors doubleColors = new DoubleColors();
	
	boolean randomColors = true;
	boolean doubleColorsBool = false;
	
	@ConfigEntry.Gui.Tooltip
	boolean vanilla = false;
	
	static class SingleColors {
		@ConfigEntry.BoundedDiscrete(max = 255L)
		long red = 0L, blue = 0L, green = 0L;
	}
	
	static class DoubleColors {
		@ConfigEntry.BoundedDiscrete(max = 255L)
		long red = 0L, green = 0L, blue = 0L;
	}
	
	
	public float getRedL() {
		return (float) singleColors.red / 255;
	}
	public float getGreenL() {
		return (float) singleColors.green / 255;
	}
	public float getBlueL() {
		return (float) singleColors.blue / 255;
	}
	
	public float getRedL2() {
		return (float) doubleColors.red / 255;
	}
	public float getBlueL2() {
		return (float) doubleColors.blue / 255;
	}
	public float getGreenL2() {
		return (float) doubleColors.green / 255;
	}
	
	public long getParticlePercent() {
		return particlePercent;
	}
	
	public boolean isRandomColors() {
		return randomColors;
	}
	public boolean isDoubleColors() {
		return doubleColorsBool;
	}
	public boolean isVanilla() {
		return vanilla;
	}
}
