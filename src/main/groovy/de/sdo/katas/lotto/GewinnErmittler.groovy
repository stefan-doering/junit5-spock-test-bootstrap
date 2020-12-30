package de.sdo.katas.lotto

class GewinnErmittler {
    private final List<Integer> gewinnzahlen

    GewinnErmittler() {
        throw new IllegalAccessException("Es müssen Gewinnzahlen angegeben werden")
    }

    GewinnErmittler(List<Integer> gewinnzahlen) {
        Zahlenpruefer.pruefeEingabe(gewinnzahlen)
        this.gewinnzahlen = gewinnzahlen
    }

    def Integer ermittleGewinn(Tipp tipp) {
        tipp.tippzahlen.retainAll(gewinnzahlen)
        return tipp.tippzahlen.size()
    }
}
