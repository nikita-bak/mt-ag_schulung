package de.rewe.schulungen.kasseclient;

import java.math.BigDecimal;
import java.util.UUID;

public class Tankvorgang {

    UUID uuid;
    int säulenNummer;
    BigDecimal preisProLiter;
    BigDecimal gesamtMenge;

    public Tankvorgang(final int säulenNummer, final BigDecimal preisProLiter, final BigDecimal gesamtMenge) {
        this.uuid = UUID.randomUUID();
        this.säulenNummer = säulenNummer;
        this.preisProLiter = preisProLiter;
        this.gesamtMenge = gesamtMenge;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(final UUID uuid) {
        this.uuid = uuid;
    }

    public int getSäulenNummer() {
        return säulenNummer;
    }

    public void setSäulenNummer(final int säulenNummer) {
        this.säulenNummer = säulenNummer;
    }

    public BigDecimal getPreisProLiter() {
        return preisProLiter;
    }

    public void setPreisProLiter(final BigDecimal preisProLiter) {
        this.preisProLiter = preisProLiter;
    }

    public BigDecimal getGesamtMenge() {
        return gesamtMenge;
    }

    public void setGesamtMenge(final BigDecimal gesamtMenge) {
        this.gesamtMenge = gesamtMenge;
    }
}
