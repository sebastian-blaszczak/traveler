package travel.app.traveler

import spock.lang.Specification
import travel.app.traveler.model.Account

class accountModelTest extends Specification {

    def "account's name's print test"() {

        expect:
        account.getFirstName() == name

        where:
        account                         || name
        new Account("Sebastian", "Bzz") || "Sebastian"
        new Account("Natalia", "Baa")   || "Natalia"

    }

    def "account's last name's print test"() {

        expect:
        account.getLastName() == LastName

        where:
        account                         || LastName
        new Account("Sebastian", "Bzz") || "Bzz"
        new Account("Natalia", "Baa")   || "Baa"

    }
}
