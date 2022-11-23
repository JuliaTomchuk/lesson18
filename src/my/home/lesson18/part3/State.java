package my.home.lesson18.part3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name ="State")
@XmlAccessorType(XmlAccessType.FIELD)
public class State {
    @XmlElement
    private String name;
    @XmlElement
    private String capital;
    public State(){}
    public State(String name, String capital){
        this.name=name;
        this.capital=capital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State state)) return false;
        return getName().equals(state.getName()) && getCapital().equals(state.getCapital());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCapital());
    }

    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                '}';
    }
}
