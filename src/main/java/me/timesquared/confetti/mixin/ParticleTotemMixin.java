package me.timesquared.confetti.mixin;

import me.shedaniel.autoconfig.AutoConfig;
import me.timesquared.confetti.ConfigScreen;
import net.minecraft.client.particle.AnimatedParticle;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.particle.TotemParticle;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TotemParticle.class)
public class ParticleTotemMixin extends AnimatedParticle {
	protected ParticleTotemMixin(ClientWorld world, double x, double y, double z, SpriteProvider spriteProvider, float upwardsAcceleration) {
		super(world, x, y, z, spriteProvider, upwardsAcceleration);
	}
	
	@Inject(method = "<init>", at = @At("RETURN"))
	public void onInit(ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ, SpriteProvider spriteProvider, CallbackInfo ci) {
		ConfigScreen config = AutoConfig.getConfigHolder(ConfigScreen.class).getConfig();
		
		if (config.isRandomColors()) {
			this.setColor((float) Math.random(), (float) Math.random(), (float) Math.random());
		} else {
			if (config.isDoubleColors()) {
				if (Math.random() <= 0.5) {
					this.setColor(config.getRedL(), config.getGreenL(), config.getBlueL());
				} else {
					this.setColor(config.getRedL2(), config.getGreenL2(), config.getBlueL2());
				}
			} else {
				this.setColor(config.getRedL(), config.getGreenL(), config.getBlueL());
			}
		}
		
		long totemPercent = config.getParticlePercent();
		
		if (!shouldRender(totemPercent)) {
			this.markDead();
		}
	}
	
	public boolean shouldRender(long chance) {
		return ((double) chance / 100) >= Math.random();
	}
}
