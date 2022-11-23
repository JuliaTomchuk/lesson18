package my.home.lesson18.part3;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {

        Country country = new Country("Usa", List.of(new State("California","Sacramento"),new State("Arkansas","Little Rock"), new State("Colorado","Denver")),"Washington");
        marshal(country);
        unmarshal();



    }
    private static void marshal(Country country) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Country.class);
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(country, new File("src\\my\\home\\lesson18\\part3\\resource\\country.xml"));
    }
    private static void unmarshal() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Country.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Country result = (Country) unmarshaller.unmarshal( new FileReader("src\\my\\home\\lesson18\\part3\\resource\\country.xml"));
        System.out.println(result);
    }
}