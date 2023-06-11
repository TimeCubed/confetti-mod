package me.timesquared.confetti;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "confetti")
public class ConfigScreen implements ConfigData {
	@ConfigEntry.BoundedDiscrete(max = 100L)
	long redL = 0L, greenL = 0L, blueL = 0L, redL2 = 0L, greenL2 = 0L, blueL2 = 0L;
	
	@ConfigEntry.BoundedDiscrete(max = 100L)
	long particlePercent = 0l;
	boolean randomColors = true;
	boolean doubleColors = false;
	
	public float getRedL() {
		return (float) redL / 100;
	}
	public float getGreenL() {
		return (float) greenL / 100;
	}
	public float getBlueL() {
		return (float) blueL / 100;
	}
	
	public long getRedL2() {
		return redL2;
	}
	public long getBlueL2() {
		return blueL2;
	}
	public long getGreenL2() {
		return greenL2;
	}
	
	public long getParticlePercent() {
		return particlePercent;
	}
	
	public boolean isRandomColors() {
		return randomColors;
	}
	public boolean isDoubleColors() {
		return doubleColors;
	}
	
	
}
