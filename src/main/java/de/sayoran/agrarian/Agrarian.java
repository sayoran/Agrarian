package de.sayoran.agrarian;

import de.sayoran.agrarian.recipe.ModRecipes;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import de.sayoran.agrarian.proxy.CommonProxy;
import de.sayoran.agrarian.client.AgrarianTab;
import de.sayoran.agrarian.item.ModItems;
import de.sayoran.agrarian.block.ModBlocks;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import de.sayoran.agrarian.network.PacketUpdateAnalyzer;
import de.sayoran.agrarian.network.PacketRequestUpdateAnalyzer;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

//import net.shadowfacts.tutorial.recipe.ModRecipes;






@Mod(modid = Agrarian.modId, name = Agrarian.name, version = Agrarian.version, acceptedMinecraftVersions = "[1.12.1]")
public class Agrarian {

    public static final String modId = "agrarian";
    public static final String name = "Agrarian";
    public static final String version = "0.0.1";

    @Mod.Instance(modId)
    public static Agrarian instance;

    @SidedProxy(serverSide = "de.sayoran.agrarian.proxy.CommonProxy", clientSide = "de.sayoran.agrarian.proxy.ClientProxy")
    public static CommonProxy proxy;

    public static final AgrarianTab creativeTab = new AgrarianTab();

    public static SimpleNetworkWrapper network;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new ModGuiHandler());
        proxy.registerRenderers();

        network = NetworkRegistry.INSTANCE.newSimpleChannel(modId);
        network.registerMessage(new PacketUpdateAnalyzer.Handler(), PacketUpdateAnalyzer.class, 0, Side.CLIENT);
        network.registerMessage(new PacketRequestUpdateAnalyzer.Handler(), PacketRequestUpdateAnalyzer.class, 1, Side.SERVER);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ModRecipes.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    @Mod.EventBusSubscriber
    public static class RegsitrationHandler {

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            ModItems.register(event.getRegistry());
            ModBlocks.registerItemBlocks(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            ModBlocks.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event) {
            ModItems.registerModels();
            ModBlocks.registerModels();
        }

    }

}