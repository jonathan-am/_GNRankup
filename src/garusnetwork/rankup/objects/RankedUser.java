/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garusnetwork.rankup.objects;

import garusnetwork.rankup.enums.Ranks;

/**
 *
 * @author Jhow
 */
public class RankedUser {

    private String name;
    private Ranks rank;

    public RankedUser setName(String name) {
        this.name = name;
        return this;
    }

    public RankedUser setRank(Ranks rank) {
        this.rank = rank;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Ranks getRank() {
        return this.rank;
    }
}
