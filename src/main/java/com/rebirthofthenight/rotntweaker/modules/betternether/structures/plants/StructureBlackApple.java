package com.rebirthofthenight.rotntweaker.modules.betternether.structures.plants;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockNetherrack;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import com.rebirthofthenight.rotntweaker.modules.betternether.blocks.BlocksRegister;
import com.rebirthofthenight.rotntweaker.modules.betternether.structures.IStructure;

public class StructureBlackApple implements IStructure
{
	@Override
	public void generate(World world, BlockPos pos, Random random)
	{
		Block under = world.getBlockState(pos).getBlock();
		if (under instanceof BlockNetherrack || under == Blocks.SOUL_SAND)
		{
			IBlockState state = BlocksRegister.BLOCK_BLACK_APPLE.getDefaultState();
			for (int i = 0; i < 8; i++)
			{
				int x = pos.getX() + (int) (random.nextGaussian() * 2);
				int z = pos.getZ() + (int) (random.nextGaussian() * 2);
				int y = pos.getY() + random.nextInt(6);
				for (int j = 0; j < 6; j++)
				{
					BlockPos npos = new BlockPos(x, y - j, z);
					under = world.getBlockState(npos.down()).getBlock();
					if ((under instanceof BlockNetherrack || under == Blocks.SOUL_SAND) && (world.getBlockState(pos).getBlock() == Blocks.AIR || world.getBlockState(pos).getMaterial() != Material.LAVA))
					{
						if (world.getBlockState(npos).getMaterial().isReplaceable())
							world.setBlockState(npos, state);
						break;
					}
				}
			}
		}
	}
}
