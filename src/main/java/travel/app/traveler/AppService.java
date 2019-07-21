package travel.app.traveler;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Service;
import travel.app.traveler.model.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppService {

    private List<Account> accounts = new ArrayList<>();

    public Account addAccount(String name, String lastName) {
        Account account = new Account();
        account.setFirstName(name);
        account.setLastName(lastName);
        accounts.add(account);
        return account;
    }

    public Account setTripToAccount(Account account, Trip trip) {
        //account.setTrip(trip);
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

    public List<Account> getAccounts() {
        return accounts;
    }

    public Account addAccountToDB(String firstName, String lastName) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Account account = new Account();
        account.setFirstName(firstName);
        account.setLastName(lastName);

        session.save(account);


        Account accountAdded = session.get(Account.class, account.getId());
        session.getTransaction().commit();
        session.close();

        return accountAdded;
    }

    public List<Account> getAccountsFromDB() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Account> from_account = session.createQuery("from Account").getResultList();
        session.getTransaction().commit();
        session.close();
        return from_account;
    }
}
