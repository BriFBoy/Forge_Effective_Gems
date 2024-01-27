package net.brifboy.effectivegems.Blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class GreenGemBlock extends Block {
    public GreenGemBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if (!pLevel.isClientSide) {
            if (pEntity.isAlwaysTicking() && !((Player) pEntity).hasEffect(MobEffects.SATURATION)) {
                ((Player) pEntity).addEffect(new MobEffectInstance(MobEffects.SATURATION,
                        500, 5, true,false, true));
            }
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
