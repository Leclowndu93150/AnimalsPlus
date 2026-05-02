package com.leclowndu93150.animalsplus;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class PlayerEventHandler {
    public AnimalsPlus animalsPlus;

    public PlayerEventHandler(AnimalsPlus animalsPlus) {
        this.animalsPlus = animalsPlus;
    }

    @SubscribeEvent
    public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        animalsPlus.onPlayerLoggedIn(event.player);
    }
}
