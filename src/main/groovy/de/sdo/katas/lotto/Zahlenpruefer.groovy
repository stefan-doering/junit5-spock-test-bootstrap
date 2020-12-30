package de.sdo.katas.lotto

class Zahlenpruefer {
    static def pruefeEingabe(List<Integer> zahlen) {
        if (!zahlen || zahlen.size() != 6) {
            throw new IllegalArgumentException("Es müssen 6 Zahlen angegeben werden")
        }
        try {
            zahlen.each { Integer.parseInt(it.toString()) }
        } catch (Exception e) {
            throw new IllegalArgumentException("Eingabe kann nicht in Integer-Array überführt werden")
        }
        zahlen.each {
            if (it < 1 || it > 49) {
                throw new IllegalArgumentException("Es dürfen nur Zahlen zwischen 1 und 49 angegeben werden")
            }
        }
    }
}
