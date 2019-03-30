package travel.app.traveler

import spock.lang.Specification
import travel.app.traveler.model.Address

class addressModelTest extends Specification {

    def "address city print test"() {
        expect:
        address.toString() == city

        where:
        address                              || city
        new Address("Warsaw", "Puławska 14") || "Address{city='Warsaw', street='Puławska 14'}"
    }
}
