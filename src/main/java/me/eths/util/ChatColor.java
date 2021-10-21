package me.eths.util;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class ChatColor {

    public String get(String message) {
        return org.bukkit.ChatColor.translateAlternateColorCodes('&', message);
    }

    public List<String> get(List<String> message) {
        List<String> translatedMessage = new ArrayList<>();
        for (String loopMessage : message) {
            translatedMessage.add(get(loopMessage));
        }
        return translatedMessage;
    }

}
