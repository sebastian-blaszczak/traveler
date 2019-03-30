package travel.app.traveler.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Trip {

    private final List<Day> days;

    public Trip() {
        this.days = new ArrayList<>();
    }

    public void addDay(Day day) {
        days.add(day);
    }

    public List<Day> getDays() {
        return days;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return Objects.equals(days, trip.days);
    }

    @Override
    public int hashCode() {
        return Objects.hash(days);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "days=" + days +
                '}';
    }
}
