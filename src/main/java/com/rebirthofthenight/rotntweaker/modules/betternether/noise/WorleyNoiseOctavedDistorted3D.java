package com.rebirthofthenight.rotntweaker.modules.betternether.noise;

public class WorleyNoiseOctavedDistorted3D
{
	private WorleyNoiseOctaved3D idNoise;
	private WorleyNoiseOctaved noiseX;
	private WorleyNoiseOctaved noiseY;
	private WorleyNoiseOctaved noiseZ;
	
	public WorleyNoiseOctavedDistorted3D(long seed, int maxID)
	{
		idNoise = new WorleyNoiseOctaved3D(seed, maxID);
		noiseX = new WorleyNoiseOctaved(seed + 9L, 3);
		noiseY = new WorleyNoiseOctaved(seed + 19L, 3);
		noiseZ = new WorleyNoiseOctaved(seed + 29L, 3);
	}
	
	public double GetValue(double x, double y, double z)
	{
		double nx = x;
		double ny = y;
		double nz = z;
		x *= 0.5;
		y *= 0.5;
		z *= 0.5;
		nx += noiseX.GetValue(y, z);
		ny += noiseY.GetValue(x, -z);
		nz += noiseZ.GetValue(-x, -y);
		return idNoise.GetValue(nx, ny, nz);
	}
}
