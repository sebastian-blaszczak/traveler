package travel.app.traveler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import travel.app.traveler.model.*;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;

@RestController
public class AppController {

    private final AppService appService;

    @Autowired
    public AppController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/")
    public String welcome(){
        return "Welcome to traveler";
    }

    @GetMapping("/add-account")
    public Account addAccount() {
        return appService.addAccount("Sebastian", "B");
    }

    @GetMapping("/add-trip")
    public Account addTripToAccount() {
        Trip trip = new Trip();
        trip.addDay(new Day(1,
                new Accommodation("hotel", new Address("Warsaw", "Pulawska"), BigDecimal.ONE, true, "www.image.com/image")));
        return appService.setTripToAccount(appService.addAccount("Seb", "B"), trip);
    }
}
