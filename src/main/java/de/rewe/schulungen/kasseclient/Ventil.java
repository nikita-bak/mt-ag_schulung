package de.rewe.schulungen.kasseclient;

public class Ventil {
    int säulenNummer;
    KraftstoffArt kraftStoffArt;

    public Ventil(final int säulenNummer, final KraftstoffArt kraftStoffArt) {
        this.säulenNummer = säulenNummer;
        this.kraftStoffArt = kraftStoffArt;
    }

    public int getSäulenNummer() {
        return säulenNummer;
    }

    public void setSäulenNummer(final int säulenNummer) {
        this.säulenNummer = säulenNummer;
    }

    public KraftstoffArt getKraftStoffArt() {
        return kraftStoffArt;
    }

    public void setKraftStoffArt(final KraftstoffArt kraftStoffArt) {
        this.kraftStoffArt = kraftStoffArt;
    }
}
