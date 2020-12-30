package de.sdo.katas.lotto

class Tipp {

    final List<Integer> tippzahlen

    Tipp() {
        throw new IllegalArgumentException("Es müssen Zahlen für den Tipp angegeben werden")
    }

    Tipp(List<Integer> tippzahlen) {
        Zahlenpruefer.pruefeEingabe(tippzahlen)
        this.tippzahlen = tippzahlen
    }


}
