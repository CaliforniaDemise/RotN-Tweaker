package com.rebirthofthenight.rotntweaker.modules.betternether.blocks;

import net.minecraft.block.BlockPressurePlateWeighted;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import com.rebirthofthenight.rotntweaker.RotNTweaker;

public class BlockCincinnasitePlate extends BlockPressurePlateWeighted
{
	protected BlockCincinnasitePlate()
	{
		super(Material.IRON, 150, MapColor.YELLOW);
		this.setRegistryName("cincinnasite_plate");
		this.setUnlocalizedName("cincinnasite_plate");
		this.setCreativeTab(RotNTweaker.BN_TAB);
		this.setHardness(0.5F);
		this.setResistance(0.5F);
		this.setSoundType(SoundType.METAL);
	}
}
