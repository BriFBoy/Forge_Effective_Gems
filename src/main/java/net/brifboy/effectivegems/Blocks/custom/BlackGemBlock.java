package net.brifboy.effectivegems.Blocks.custom;

import net.minecraft.client.gui.components.Button;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class BlackGemBlock extends Block {
    public BlackGemBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {

        if (!pLevel.isClientSide) {
            if (pEntity.isAlwaysTicking() && !((Player) pEntity).hasEffect(MobEffects.BLINDNESS)
                    && !((Player) pEntity).hasEffect(MobEffects.WITHER)
                    && !((Player) pEntity).hasEffect(MobEffects.CONFUSION)) {
                ((Player) pEntity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS,
                        500, 50, true, false, true));
                ((Player) pEntity).addEffect(new MobEffectInstance(MobEffects.WITHER,
                        500, 99, true, false, true));
                ((Player) pEntity).addEffect(new MobEffectInstance(MobEffects.CONFUSION,
                        500, 50, true, false, true));

            }
        }
        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
