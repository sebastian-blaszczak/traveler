package travel.app.traveler.model;
import java.util.Objects;

public final class Account {

    private final String name;
    private final String lastName;

    private Trip trip;


    public Account(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(name, account.name) &&
                Objects.equals(lastName, account.lastName) &&
                Objects.equals(trip, account.trip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, trip);
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
