package com.example;

import com.hypixel.hytale.server.core.event.events.ecs.DropItemEvent;
import com.hypixel.hytale.server.core.event.events.player.PlayerConnectEvent;
import com.hypixel.hytale.server.core.event.events.player.PlayerDisconnectEvent;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.hypixel.hytale.server.core.util.Config;
import com.example.commands.ClearInventory;
import com.example.listeners.PlayerEvents;
import lombok.Getter;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

@Getter
public class Plugin extends JavaPlugin {

    public static Plugin instance;
    private final Config<PluginConfiguration> config;

    public Plugin(@NonNullDecl JavaPluginInit init) {
        super(init);
        this.config = this.withConfig("Config", PluginConfiguration.CODEC);
        instance = this;
    }

    @Override
    protected void setup() {
        getCommandRegistry().registerCommand(new ClearInventory());
        getEventRegistry().registerGlobal(PlayerReadyEvent.class, PlayerEvents::onReady);
        getEventRegistry().register(PlayerConnectEvent.class, PlayerEvents::onJoin);
        getEventRegistry().register(PlayerDisconnectEvent.class, PlayerEvents::onQuit);
    }

    @Override
    protected void start() {
        config.save();
    }

    @Override
    protected void shutdown() {
        config.save();
    }
}
