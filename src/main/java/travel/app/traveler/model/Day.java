package travel.app.traveler.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Day {

    private final int dayNumber;
    private final List<Attraction> attractions;
    private final Accommodation accommodation;

    public Day(int dayNumber, Accommodation accommodation) {
        this.dayNumber = dayNumber;
        this.accommodation = accommodation;
        this.attractions = new ArrayList<>();
    }

    public void addPlace(Attraction attraction){
        attractions.add(attraction);
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Day day = (Day) o;
        return dayNumber == day.dayNumber &&
                Objects.equals(attractions, day.attractions) &&
                Objects.equals(accommodation, day.accommodation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dayNumber, attractions, accommodation);
    }

    @Override
    public String toString() {
        return "Day{" +
                "dayNumber=" + dayNumber +
                ", attractions=" + attractions +
                ", accommodation=" + accommodation +
                '}';
    }
}
