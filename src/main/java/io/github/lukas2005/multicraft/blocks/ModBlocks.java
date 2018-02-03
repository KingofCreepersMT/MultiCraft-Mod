package io.github.lukas2005.multicraft.blocks;

import io.github.lukas2005.multicraft.Main;
import io.github.lukas2005.multicraft.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLogic;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;

public class ModBlocks {

    public static final HashMap<String, Block> ModBlocks = new HashMap<>();
    public static final HashMap<IBlockState, IBlockState> chiselMapping = new HashMap<>();

    public static BlockBase blockAncientStone = new BlockBase(Material.ROCK, true);

    public static void init() {
        // Building Blocks
        registerBlock(new ColoredPlanks().setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "colored_planks");
        registerBlock(new BlockPath(Material.ROCK).setResistance(30).setHardness(3).setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "rock_path");
        registerBlock(blockAncientStone.setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "ancient_stone");
        registerBlock(new BlockBase(Material.ROCK, true).setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "engraved_ancient_stone");
        registerBlock(new BlockBase(Material.ROCK, true).setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "volcanic_stone");

        registerBlock(new BlockAncientStoneStairs(blockAncientStone.getDefaultState()), "ancient_stone_stairs");

        registerBlock(new BlockBase((new MaterialLogic(MapColor.SNOW)), true).setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "snow_brick");
        registerBlock(new BlockBase(Material.SNOW, true).setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "chiseled_snow_brick");
        registerBlock(new BlockBase(Material.IRON, false)
                .addDrop(new ItemStack(ModItems.getItem("rust_dust"), 9))
                .addDrop(new ItemStack(Items.IRON_NUGGET, 5))
                .setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "rusty_iron_block");
        registerBlock(new BlockPaneBase(Material.IRON, false)
                .addDrop(new ItemStack(ModItems.getItem("rust_dust"), 6))
                .addDrop(new ItemStack(Items.IRON_NUGGET, 3))
                .setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "rusty_iron_bars");
        registerBlock(new BlockDoorBase(Material.IRON, false)
                .addDrop(new ItemStack(ModItems.getItem("rust_dust"), 6))
                .addDrop(new ItemStack(Items.IRON_NUGGET, 3))
                .setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "rusty_iron_door");
        registerBlock(new BlockAdobeBrick().setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "block_adobe_brick");

        chiselMapping.put(getBlock("ancient_stone").getDefaultState(), getBlock("engraved_ancient_stone").getDefaultState());
    }

    private static void registerBlock(Block block, String name) {
        block.setRegistryName(new ResourceLocation(Main.MODID, name));
        block.setUnlocalizedName(Main.MODID + "." + name);
        ModBlocks.put(block.getUnlocalizedName(), block);
    }

    public static Block getBlock(String itemName) {
        return ModBlocks.get("tile." + Main.MODID + "." + itemName);
    }
}
