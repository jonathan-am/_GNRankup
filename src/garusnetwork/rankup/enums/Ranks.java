/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garusnetwork.rankup.enums;

/**
 *
 * @author Jhow
 */
public enum Ranks {

    Zeus(0),
    Poseidon(1),
    Hades(2),
    Afrodite(3),
    Apolo(4),
    Ares(5),
    Artemis(6),
    Atena(7),
    Demeter(8),
    Dionisio(9),
    Eos(10),
    Eros(11),
    Helios(12),
    Hermes(13),
    Hera(14),
    Hestia(15),
    Horas(16),
    Mnemosine(17),
    Persefone(18),
    Selene(19),
    Temis(20),
    Perseu(21),
    Teseu(22),
    Hercules(23);

    private final int z;

    private Ranks(int s) {
        this.z = s;
    }

    public int getPosition() {
        return this.z;
    }

    public String getInfo() {
        String s = "";
        switch (this) {
            case Zeus:
                s = "Deus dos Deuses";
                break;
            case Poseidon:
                s = "Deus dos Mares";
                break;
            case Hades:
                s = "Deus do SubMundo";
                break;
            case Afrodite:
                s = "Deusa da Beleza e do Amor";
                break;
            case Apolo:
                s = "Deus da Luz";
                break;
            case Ares:
                s = "Deus da Guerra";
                break;
            case Artemis:
                s = "Deusa da Lua";
                break;
            case Atena:
                s = "Deusa da Sabedoria";
                break;
            case Demeter:
                s = "Deus da Terra Fertil";
                break;
            case Dionisio:
                s = "Deus da Festa, do Vinho e do Prazer";
                break;
            case Eos:
                s = "Deus do Amanhecer";
                break;
            case Eros:
                s = "Deus do Amor";
                break;
            case Helios:
                s = "Deus do Sol";
                break;
            case Hermes:
                s = "Deus do Vento";
                break;
            case Hera:
                s = "Deusa dos Ceus, Maternidade e Matrimonio";
                break;
            case Hestia:
                s = "Deusa do Fogo";
                break;
            case Horas:
                s = "Deusa das Estacoes";
                break;
            case Mnemosine:
                s = "Deusa da Memoria";
                break;
            case Persefone:
                s = "Rainha do SubMundo";
                break;
            case Selene:
                s = "Deusa da Lua";
                break;
            case Temis:
                s = "Deusa das Leis";
                break;
            case Perseu:
                s = "Filho de Zeus";
                break;
            case Teseu:
                s = "Matador do Minotauro";
                break;
            case Hercules:
                s = "Libertador do Grande Titã, Prometeu";
                break;
        }
        return s;
    }

    public double getPrice() {
        double x = 0.0;
        switch (this) {
            case Zeus:
                x = 1000000.0;
                break;
            case Poseidon:
                x = 850000.0;
                break;
            case Hades:
                x = 700000.0;
                break;
            case Afrodite:
                x = 500000.0;
                break;
            case Apolo:
                x = 380000.0;
                break;
            case Ares:
                x = 280000.0;
                break;
            case Artemis:
                x = 220000.0;
                break;
            case Atena:
                x = 170000.0;
                break;
            case Demeter:
                x = 130000.0;
                break;
            case Dionisio:
                x = 100000.0;
                break;
            case Eos:
                x = 90000.0;
                break;
            case Eros:
                x = 80000.0;
                break;
            case Helios:
                x = 70000.0;
                break;
            case Hermes:
                x = 60000.0;
                break;
            case Hera:
                x = 55000.0;
                break;
            case Hestia:
                x = 50000.0;
                break;
            case Horas:
                x = 45000.0;
                break;
            case Mnemosine:
                x = 40000.0;
                break;
            case Persefone:
                x = 35000.0;
                break;
            case Selene:
                x = 30000.0;
                break;
            case Temis:
                x = 25000.0;
                break;
            case Perseu:
                x = 20000.0;
                break;
            case Teseu:
                x = 15000.0;
                break;
            case Hercules:
                x = 10000.0;
                break;
        }
        return x;
    }

    public double getCalc() {
        double x = 0.0;
        switch (this) {
            case Zeus:
                x = 3.4;
                break;
            case Poseidon:
                x = 3.3;
                break;
            case Hades:
                x = 3.2;
                break;
            case Afrodite:
                x = 3.1;
                break;
            case Apolo:
                x = 3.0;
                break;
            case Ares:
                x = 2.9;
                break;
            case Artemis:
                x = 2.8;
                break;
            case Atena:
                x = 2.7;
                break;
            case Demeter:
                x = 2.6;
                break;
            case Dionisio:
                x = 2.5;
                break;
            case Eos:
                x = 2.4;
                break;
            case Eros:
                x = 2.3;
                break;
            case Helios:
                x = 2.2;
                break;
            case Hermes:
                x = 2.1;
                break;
            case Hera:
                x = 2.0;
                break;
            case Hestia:
                x = 1.9;
                break;
            case Horas:
                x = 1.8;
                break;
            case Mnemosine:
                x = 1.7;
                break;
            case Persefone:
                x = 1.6;
                break;
            case Selene:
                x = 1.5;
                break;
            case Temis:
                x = 1.4;
                break;
            case Perseu:
                x = 1.3;
                break;
            case Teseu:
                x = 1.2;
                break;
            case Hercules:
                x = 1.1;
                break;
        }
        return x;
    }
}
