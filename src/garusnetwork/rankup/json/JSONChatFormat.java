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
public enum JSONChatFormat {
    BOLD("bold"),
    UNDERLINED("underlined"),
    STRIKETHROUGH("strikethrough"),
    ITALIC("italic"),
    OBFUSCATED("obfuscated");
    private final String format;

    JSONChatFormat(String format) {
        this.format = format;
    }

    public String getFormatString() {
        return format;
    }
}
