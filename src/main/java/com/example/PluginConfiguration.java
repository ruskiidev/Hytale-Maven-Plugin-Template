package com.example;

import com.hypixel.hytale.codec.builder.BuilderCodec;

public class PluginConfiguration {

    public static final BuilderCodec<PluginConfiguration> CODEC = BuilderCodec.builder(
            PluginConfiguration.class, PluginConfiguration::new
    ).build();
}
