package org.dawnoftimebuilder.block.templates;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import org.dawnoftimebuilder.utils.DoTBBlockStateProperties;

public abstract class SidedPlaneConnectibleBlock extends SidedColumnConnectibleBlock {

	public static final EnumProperty<DoTBBlockStateProperties.HorizontalConnection> HORIZONTAL_CONNECTION = DoTBBlockStateProperties.HORIZONTAL_CONNECTION;

	public SidedPlaneConnectibleBlock(String name, Material materialIn, float hardness, float resistance) {
		this(name, Properties.create(materialIn).hardnessAndResistance(hardness, resistance));
	}

	public SidedPlaneConnectibleBlock(String name, Properties properties) {
		super(name, properties);
		this.setDefaultState(this.getStateContainer().getBaseState().with(HORIZONTAL_CONNECTION, DoTBBlockStateProperties.HorizontalConnection.NONE));
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(HORIZONTAL_CONNECTION);
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return super.getStateForPlacement(context).with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	@Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		stateIn = super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
		return (facing.getAxis() == stateIn.get(FACING).rotateY().getAxis()) ? stateIn.with(HORIZONTAL_CONNECTION, this.getLineState(worldIn, currentPos, stateIn)) : stateIn;
	}

	public DoTBBlockStateProperties.HorizontalConnection getLineState(IWorld worldIn, BlockPos pos, BlockState stateIn){
		Direction direction = stateIn.get(FACING).rotateY();
		if(isConnectible(worldIn, pos.offset(direction, -1), stateIn)){
			return (isConnectible(worldIn, pos.offset(direction), stateIn)) ? DoTBBlockStateProperties.HorizontalConnection.BOTH : DoTBBlockStateProperties.HorizontalConnection.LEFT;
		}else{
			return (isConnectible(worldIn, pos.offset(direction), stateIn)) ? DoTBBlockStateProperties.HorizontalConnection.RIGHT : DoTBBlockStateProperties.HorizontalConnection.NONE;
		}
	}
}