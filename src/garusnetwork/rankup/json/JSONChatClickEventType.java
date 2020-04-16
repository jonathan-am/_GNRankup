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
public enum JSONChatClickEventType {
    RUN_COMMAND("run_command"),
    SUGGEST_COMMAND("suggest_command"),
    OPEN_URL("open_url");
    private final String type;

    JSONChatClickEventType(String type) {
        this.type = type;
    }

    public String getTypeString() {
        return type;
    }
}

