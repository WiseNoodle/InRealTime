package net.wisenoodle.inrealtime.mixin;

import net.minecraft.SharedConstants;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.level.ServerWorldProperties;
import net.wisenoodle.inrealtime.InRealTime;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.time.LocalTime;

// HUGE thanks and credit to:
// - Code Hammering Specialist
// - Project Unfinisher
// - Koshka
// For helping me make this mod


@Mixin(ServerWorld.class)
public abstract class MainMixin {
		@Shadow
		@Final
		private ServerWorldProperties worldProperties;
		@Unique
		private static final double CONSTANT_OF_MULTIPLICATION = (double)SharedConstants.TICKS_PER_SECOND/72d;
		@Inject(method = "setTimeOfDay(J)V", at = @At(value = "HEAD"), cancellable = true)
		public void setTimeOfDayCallback(long timeOfDay, CallbackInfo ci) {
			long equivalentTime = Math.round(((LocalTime.now().toSecondOfDay() * CONSTANT_OF_MULTIPLICATION) - 6000));
			if (equivalentTime < 0) equivalentTime = SharedConstants.TICKS_PER_IN_GAME_DAY + equivalentTime ;
			if(InRealTime.timeSyncToggle) {
				this.worldProperties.setTimeOfDay(equivalentTime);
			}
			ci.cancel();
	}
}


