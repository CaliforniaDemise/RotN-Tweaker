package com.codetaylor.mc.pyrotech.modules.tech.machine.tile.spi;

import net.minecraft.item.ItemStack;

public class TileLense {

    public static boolean isPowered(TileCogWorkerBase tile){
        return tile.isPowered();
    }

    public static int getUpdateIntervalTicks(TileCogWorkerBase tile){
        return tile.getUpdateIntervalTicks();
    }

    public static int doWork(TileCogWorkerBase tile, ItemStack cog){
        return tile.doWork(cog);
    }


}
