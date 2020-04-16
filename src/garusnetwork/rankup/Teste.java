/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garusnetwork.rankup;

import garusnetwork.rankup.enums.Ranks;

/**
 *
 * @author Jhow
 */
public class Teste {

    public static void main(String args[]) {
        for (Ranks rank : Ranks.values()) {
            System.out.println(rank.getPosition());
        }
    }

}
