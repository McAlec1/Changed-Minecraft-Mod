package net.ltxprogrammer.changed.block;

import net.ltxprogrammer.changed.block.properties.Direction8Step;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ClipboardBlock extends AbstractCustomShapeBlock {
    public static final EnumProperty<Direction8Step> FACING = EnumProperty.create("facing", Direction8Step.class, Direction8Step.values());
    public static final VoxelShape SHAPE_WHOLE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 2.0D, 13.0D);
    public static final VoxelShape SHAPE_OCC = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 32.0D, 16.0D);

    public ClipboardBlock(Properties properties) {
        super(properties);
    }


    public boolean canSurvive(BlockState p_52783_, LevelReader p_52784_, BlockPos p_52785_) {
        return p_52784_.getBlockState(p_52785_.below()).isFaceSturdy(p_52784_, p_52785_.below(), Direction.UP);
    }

    @Override
    public VoxelShape getInteractionShape(BlockState p_60547_, BlockGetter p_60548_, BlockPos p_60549_) {
        return SHAPE_WHOLE;
    }


}
