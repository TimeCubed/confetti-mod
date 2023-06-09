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
		float max = 1f;
		float min = 0.5f;
		
		if (config.isRandomColors()) {
			this.setColor((float) Math.random() * (max - min) + min, (float) Math.random() * (max - min) + min, (float) Math.random() * (max - min) + min);
		} else {
			this.setColor(config.getRedL(), config.getGreenL(), config.getBlueL());
		}
	}
}
