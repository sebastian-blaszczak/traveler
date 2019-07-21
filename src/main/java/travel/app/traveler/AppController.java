package travel.app.traveler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import travel.app.traveler.model.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class AppController {

    private final AppService appService;

    @Autowired
    public AppController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/")
    public String welcome(@RequestParam(name = "name") String name) {
        return "Welcome to traveler Request param " + name;

    }

    @RequestMapping(value = "/hello", params = {"firstName", "lastName"})
    public @ResponseBody
    String WelcomeUser(@RequestParam(value = "firstName") String firstName,
                       @RequestParam(value = "lastName") String lastName) {
        return "Welcome " + firstName + " " + lastName;
    }


    @GetMapping("/add-account")
    public Account addAccount(Account account) {
        return appService.addAccount(account.getFirstName(), account.getLastName());
    }

    @GetMapping("/add-trip")
    public Account addTripToAccount() {
        Trip trip = new Trip();
        trip.addDay(new Day(1,
                new Accommodation("hotel", new Address("Warsaw", "Pulawska"), BigDecimal.ONE, true, "www.image.com/image")));
        return appService.setTripToAccount(appService.addAccount("Seb", "B"), trip);
    }

    @GetMapping("/accounts")
    public List<Account> getAccounts() {
        return appService.getAccounts();
    }

    @GetMapping("/accountDB")
    public List<Account> getAccountsDB() {
        return appService.getAccountsFromDB();
    }

    @RequestMapping(value = "/accountDB", params = {"firstName", "lastName"})
    public Account addAccount(@RequestParam(value = "firstName") String firstName,
                              @RequestParam(value = "lastName") String lastName) {
        return appService.addAccountToDB(firstName, lastName);
    }
}
