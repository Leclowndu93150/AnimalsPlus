package com.leclowndu93150.animalsplus;

import com.leclowndu93150.animalsplus.init.*;
import com.leclowndu93150.animalsplus.client.ClientProxy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = AnimalsPlus.MODID, name = "AnimalsPlus", version = AnimalsPlus.VERSION, acceptedMinecraftVersions = "[1.12.2]")
public class AnimalsPlus {
    public static final String MODID = "animalsplus";
    public static final String VERSION = "1.7";

    @Mod.Instance(MODID)
    public static AnimalsPlus instance;

    @SidedProxy(clientSide = "com.leclowndu93150.animalsplus.client.ClientProxy", serverSide = "com.leclowndu93150.animalsplus.CommonProxy")
    public static CommonProxy proxy;

    public static Logger logger = LogManager.getLogger(MODID);

    private boolean isOutdated = false;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModConfiguration.init(event.getSuggestedConfigurationFile());
        ModSounds.init();
        ModEntities.preInit();
        ModItems.init();
        ModCrafting.init();
        proxy.registerEntityRenderers();
        proxy.registerItemRenderers();
        MinecraftForge.EVENT_BUS.register(new PlayerEventHandler(this));
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ModEntities.init();
        proxy.registerColouring();
        proxy.registerBlockRenderers();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }

    protected void onPlayerLoggedIn(EntityPlayer player) {
        if (FMLCommonHandler.instance().getSide().isClient() && isOutdated) {
            player.sendMessage(new TextComponentTranslation("animals.outdated"));
            String updateUrl = "http://animalsplus.net/";
            TextComponentString url = new TextComponentString(updateUrl);
            url.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, updateUrl));
            url.getStyle().setUnderlined(true);
            player.sendMessage(new TextComponentTranslation("animals.download", url));
        }
    }
}
