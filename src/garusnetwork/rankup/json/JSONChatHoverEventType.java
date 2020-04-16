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
public enum JSONChatHoverEventType {
    SHOW_TEXT("show_text"),
    SHOW_ITEM("show_item"),
    SHOW_ACHIEVEMENT("show_achievement");
    private final String type;

    JSONChatHoverEventType(String type) {
        this.type = type;
    }

    public String getTypeString() {
        return type;
    }
}

