package travel.app.traveler.model;
import java.math.BigDecimal;
import java.util.Objects;

public final class Accommodation implements Place {

    private final String name;
    private final Address address;
    private final BigDecimal price;
    private final boolean breakfast;
    private Tip tip;

    public Accommodation(String name, Address address, BigDecimal price, boolean breakfast) {
        this.name = name;
        this.address = address;
        this.price = price;
        this.breakfast = breakfast;
    }


    public boolean isBreakfast() {
        return breakfast;
    }

    public void setTip(Tip tip) {
        this.tip = tip;
    }

    @Override
    public Tip getTip() {
        return tip;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accommodation that = (Accommodation) o;
        return breakfast == that.breakfast &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(price, that.price) &&
                Objects.equals(tip, that.tip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, price, breakfast, tip);
    }

    @Override
    public String toString() {
        return "Accommodation{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
