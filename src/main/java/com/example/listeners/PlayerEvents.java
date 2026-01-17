package com.example.listeners;

import com.hypixel.hytale.server.core.event.events.player.PlayerConnectEvent;
import com.hypixel.hytale.server.core.event.events.player.PlayerDisconnectEvent;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;

public class PlayerEvents {

    public static void onReady(PlayerReadyEvent event) {}
    public static void onJoin(PlayerConnectEvent event) {}
    public static void onQuit(PlayerDisconnectEvent event) {}

}
