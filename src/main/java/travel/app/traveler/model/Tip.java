package travel.app.traveler.model;

import java.util.Objects;

public final class Tip {

    private final String tipContent;

    public Tip(String tipContent) {
        this.tipContent = tipContent;
    }

    public String getTipContent() {
        return tipContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tip tip = (Tip) o;
        return Objects.equals(tipContent, tip.tipContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipContent);
    }

    @Override
    public String toString() {
        return "Tip{" +
                "tipContent='" + tipContent + '\'' +
                '}';
    }
}
