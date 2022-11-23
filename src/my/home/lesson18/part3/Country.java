package my.home.lesson18.part3;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "Country")
@XmlAccessorType( XmlAccessType.NONE)
public class Country {
    @XmlElement
    private String name;
    @XmlElement
    private String capital;

@XmlElement
    private List<State> states;

    public Country(String name, List <State> states, String capital) {
        this.name = name;
        this.states = states;
        this.capital= capital;
    }
    public Country() {

    }

    public String getName() {
        return name;
    }


    public List<State> getStates() {
        return states;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country country)) return false;
        return getName().equals(country.getName()) && capital.equals(country.capital) && getStates().equals(country.getStates());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), capital, getStates());
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", states=" + states +
                '}';
    }
}

