package org.dawnoftimebuilder;

import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.dawnoftimebuilder.registries.DoTBBlocksRegistry;
import org.dawnoftimebuilder.registries.DoTBItemsRegistry;

import java.util.Objects;

import static org.dawnoftimebuilder.DawnOfTimeBuilder.MOD_ID;
import static org.dawnoftimebuilder.registries.DoTBBlocksRegistry.BLOCKS;
import static org.dawnoftimebuilder.registries.DoTBContainersRegistry.CONTAINER_TYPES;
import static org.dawnoftimebuilder.registries.DoTBItemsRegistry.ITEMS;
import static org.dawnoftimebuilder.registries.DoTBTileEntitiesRegistry.TILE_ENTITY_TYPES;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = MOD_ID)
public class DoTBEvents {

	public static final DoTBEvents INSTANCE = new DoTBEvents();

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event){
		BLOCKS.forEach(block -> event.getRegistry().register(block));
		BLOCKS.clear();
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event){
		ITEMS.forEach(item -> event.getRegistry().register(item));
		ITEMS.clear();
	}

	@SubscribeEvent
	public static void registerTileEntityTypes(RegistryEvent.Register<TileEntityType<?>> event){
		TILE_ENTITY_TYPES.forEach(type -> event.getRegistry().register(type));
		TILE_ENTITY_TYPES.clear();
	}

	@SubscribeEvent
	public static void registerContainerTypes(final RegistryEvent.Register<ContainerType<?>> event){
		CONTAINER_TYPES.forEach(type -> event.getRegistry().register(type));
		CONTAINER_TYPES.clear();
	}
/*
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void registerModels(ModelRegistryEvent event){
		DoTBItemsRegistry.registerItemsModels();
	}

	@SubscribeEvent
	public void registerRecipes(RegistryEvent.Register<IRecipe> event){
		DoTBRecipesRegistry.registerRecipes(event);
	}*/
}
