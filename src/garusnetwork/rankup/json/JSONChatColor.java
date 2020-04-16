/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garusnetwork.rankup.json;

/**
 *
 * @author Jhow
 */
public enum JSONChatColor {
    WHITE("white"),
    YELLOW("yellow"),
    LIGHT_PURPLE("light_purple"),
    RED("red"),
    AQUA("aqua"),
    GREEN("green"),
    BLUE("blue"),
    DARK_GRAY("dark_gray"),
    GRAY("gray"),
    GOLD("gold"),
    DARK_PURPLE("dark_purple"),
    DARK_RED("dark_red"),
    DARK_AQUA("dark_aqua"),
    DARK_GREEN("dark_green"),
    DARK_BLUE("dark_blue"),
    BLACK("black");
    private final String color;

    JSONChatColor(String color) {
        this.color = color;
    }

    String getColorString() {
        return color;
    }
}

