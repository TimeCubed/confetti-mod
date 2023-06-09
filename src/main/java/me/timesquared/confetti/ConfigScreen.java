package me.timesquared.confetti;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "confetti")
public class ConfigScreen implements ConfigData {
	@ConfigEntry.BoundedDiscrete(max = 100L)
	long redL = 0L, greenL = 0L, blueL = 0L;
	boolean randomColors = true;
	
	public float getRedL() {
		return (float) redL / 100;
	}
	public float getGreenL() {
		return (float) greenL / 100;
	}
	public float getBlueL() {
		return (float) blueL / 100;
	}
	
	public boolean isRandomColors() {
		return randomColors;
	}
	
	
}
