package com.rebirthofthenight.rotntweaker.modules.betternether.blocks;

import net.minecraft.block.BlockNetherrack;
import net.minecraft.block.SoundType;
import com.rebirthofthenight.rotntweaker.modules.betternether.BetterNether;

public class BlockNetherrackMoss extends BlockNetherrack
{
	public BlockNetherrackMoss()
	{
		this.setHardness(0.4F);
		this.setSoundType(SoundType.STONE);
		this.setRegistryName("netherrack_moss");
		this.setUnlocalizedName("netherrack_moss");
		this.setCreativeTab(BetterNether.BN_TAB);
	}
}