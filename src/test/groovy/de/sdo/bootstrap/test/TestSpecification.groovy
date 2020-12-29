package de.sdo.bootstrap.test

import spock.lang.Specification

class TestSpecification extends Specification {

    def "should execute a test"() {
        when:
        def booleanValue = true

        then:
        booleanValue
    }

}
