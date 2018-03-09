package com.chrmills.fishbowl.common.blocks;

import com.sun.istack.internal.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TestBlock extends Block {
    public TestBlock() {
        super(Material.CACTUS);
        setCreativeTab(CreativeTabs.BREWING);
        setHardness(0.75F);
        setRegistryName("fishbowl", "cactusthree");
        setUnlocalizedName(getRegistryName().toString());
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
                                    EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (playerIn.getHeldItemMainhand().getItem().getRegistryName().toString().equals("fishbowl:cactusthree")) {
            return false;
        }
        playerIn.onKillCommand();
        return true;
    }

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        playerIn.setSpawnPoint(pos.add(0, 5, 0), true);
    }
}
