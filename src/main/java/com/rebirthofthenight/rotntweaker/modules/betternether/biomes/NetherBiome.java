package com.rebirthofthenight.rotntweaker.modules.betternether.biomes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import com.rebirthofthenight.rotntweaker.modules.betternether.world.BNWorldGenerator;

public class NetherBiome
{
	static NoiseGeneratorOctaves featureScatter  = new NoiseGeneratorOctaves(new Random(1337), 3);
	float plantDensity = 1;
	String name;
	NetherBiome edge;
	int edgeSize;
	List<NetherBiome> subbiomes;
	int sl;
	
	public NetherBiome(String name)
	{
		this.name = name;
		edge = this;
		edgeSize = 0;
		sl = 0;
		subbiomes = new ArrayList<NetherBiome>();
	}
	
	public void genSurfColumn(World world, BlockPos pos, Random random) {}
	
	public void genFloorObjects(World world, BlockPos pos, Random random) {}
	
	public void genWallObjects(World world, BlockPos origin, BlockPos pos, Random random) {}
	
	public void genCeilObjects(World world, BlockPos pos, Random random) {}
	
	protected double getFeatureNoise(BlockPos pos)
	{
		double[] value = new double[1];
		value = featureScatter.generateNoiseOctaves(value, pos.getX(), pos.getZ(), 1, 1, 0.1, 0.1, 1.0);
		return value[0];
	}
	
	public void setDensity(float density)
	{
		plantDensity = density;
	}
	
	public String getName()
	{
		return name;
	}

	public NetherBiome getEdge()
	{
		return edge;
	}
	
	public void setEdge(NetherBiome edge)
	{
		this.edge = edge;
	}

	public int getEdgeSize()
	{
		return edgeSize;
	}
	
	public void setEdgeSize(int size)
	{
		edgeSize = size;
	}
	
	public void addSubBiome(NetherBiome biome)
	{
		subbiomes.add(biome);
		sl = subbiomes.size() << 3;
	}
	
	public NetherBiome getSubBiome(int x, int y, int z)
	{
		if (sl > 0)
		{
			int id = BNWorldGenerator.getSubBiome(x, y, z, sl);
			if (id < subbiomes.size())
				return subbiomes.get(id);
			else
				return this;
		}
		else
			return this;
	}
}
