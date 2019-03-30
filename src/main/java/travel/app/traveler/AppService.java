package travel.app.traveler;

import org.springframework.stereotype.Service;
import travel.app.traveler.model.*;

import java.net.URL;
import java.util.List;

@Service
public class AppService {

    private List<Account> accounts;

    public Account addAccount(String name, String lastName) {
        return new Account(name, lastName);
    }

    public Account setTripToAccount(Account account, Trip trip) {
        account.setTrip(trip);
        return account;
    }

    public Trip addDayToTrip(Trip trip, Day day) {
        trip.addDay(day);
        return trip;
    }

    public Day createDay(int numberOfDay, Day day, Accommodation accommodation) {
        return new Day(numberOfDay, accommodation);
    }

    public Day addAttractionToDay(Day day, Attraction attraction) {
        day.addAttraction(attraction);
        return day;
    }

    public Attraction setAttraction(String name, String city, String street, String imageURL, String tip) {
        Attraction attraction = new Attraction(name, new Address(city, street), imageURL);
        attraction.setTip(new Tip(tip));
        return attraction;
    }

}
