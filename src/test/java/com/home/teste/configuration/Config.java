package com.home.teste.configuration;

public class Config {

    private static Settings settings;

    public static void configuration(Settings settings) {
        Config.settings = settings;
    }

    public String getUrl() {
        return settings.getUrl();
    }

}
