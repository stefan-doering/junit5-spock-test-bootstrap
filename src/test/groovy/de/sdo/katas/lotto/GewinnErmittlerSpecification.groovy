package de.sdo.katas.lotto

import spock.lang.Specification

class GewinnErmittlerSpecification extends Specification {

    private static final ArrayList<Integer> valideDummyGewinnzahlen = [1, 2, 3, 4, 5, 6]

    def "sollte 6 Gewinnzahlen annehmen"() {
        when:
        new GewinnErmittler(valideDummyGewinnzahlen)

        then:
        noExceptionThrown()
    }

    def "sollte bei != 6 Gewinnzahlen eine Exception werfen"() {
        when:
        new GewinnErmittler(gewinnZahlen)

        then:
        thrown(IllegalArgumentException.class)

        where:
        gewinnZahlen                   | _
        null                           | _
        []                             | _
        [1]                            | _
        [1, 2, 3, 4, 5, 6, 7]          | _
        ["a", "b", "c", "d", "e", "f"] | _
    }

    def "sollte nur Gewinnzahlen von 1 bis 49 akzeptieren"() {
        when:
        new GewinnErmittler(gewinnZahlen)

        then:
        thrown(IllegalArgumentException.class)

        where:
        gewinnZahlen             | _
        [0, 1, 2, 3, 4, 5]       | _
        [45, 46, 47, 48, 49, 50] | _
    }

    def "sollte einen Tipp mit 6 Stellen und annehmen"() {
        given:
        def gewinnErmittler = new GewinnErmittler(valideDummyGewinnzahlen)

        when:
        gewinnErmittler.ermittleGewinn(new Tipp(valideDummyGewinnzahlen))

        then:
        noExceptionThrown()
    }

    def "sollte bei != 6 Zahlen für einen Tipp eine Exception werfen"() {
        when:
        new Tipp(tippZahlen)

        then:
        thrown(IllegalArgumentException.class)

        where:
        tippZahlen                     | _
        null                           | _
        []                             | _
        [1]                            | _
        [1, 2, 3, 4, 5, 6, 7]          | _
        ["a", "b", "c", "d", "e", "f"] | _
    }

    def "sollte einen Tipp annehmen und die Anzahl an richtigen Treffern zurückgeben"() {
        given:
        def gewinnErmittler = new GewinnErmittler(valideDummyGewinnzahlen)

        when:
        Integer richtige = gewinnErmittler.ermittleGewinn(new Tipp(valideDummyGewinnzahlen))

        then:
        richtige
    }

    def "sollte bei keiner Übereinstimmung 0 Richtige zurückgeben"() {
        given:
        def gewinnErmittler = new GewinnErmittler(valideDummyGewinnzahlen)

        when:
        Integer richtige = gewinnErmittler.ermittleGewinn(new Tipp([10, 11, 12, 13, 14, 15]))

        then:
        richtige == 0
    }

    def "sollte für die selben Gewinn- und Tipp-zahlen 6 Richtige zurückgeben"() {
        given:
        def gewinnErmittler = new GewinnErmittler(valideDummyGewinnzahlen)

        when:
        Integer richtige = gewinnErmittler.ermittleGewinn(new Tipp(valideDummyGewinnzahlen))

        then:
        richtige == 6
    }

}
