package my.home.lesson18.part1;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        String pathToFolder = "src/my/home/lesson18/part1/resource";
        List<Path> path = null;
        try {
            path = checkFolder(pathToFolder);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (EmptyListException e) {
            System.err.println(e);
        }
        User user = null;
        try {
            user = unmarshall(path.get(0));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(user);

        Optional<String> str = getLines(Paths.get("F:\\tms\\lesson18\\src\\my\\home\\lesson18\\part1\\resource\\1.xml"));
        String name = getFileName(str);


        try {
            marshall(user, name);
        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }

    public static List checkFolder(String path) throws IOException, EmptyListException {

        List<Path> paths = Files.list(Paths.get(path)).filter(p -> p.toString().endsWith(".xml")).limit(1).collect(Collectors.toList());

        if (paths.isEmpty()) {
            throw new EmptyListException("There are no xml files is the folder");
        }
        return paths;
    }

    public static User unmarshall(Path path) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(User.class);
        User user = (User) context.createUnmarshaller().unmarshal(new FileReader("F:\\tms\\lesson18\\src\\my\\home\\lesson18\\part1\\resource\\1.xml"));
        return user;
    }

    public static void marshall(User user, String nameForFile) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(User.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        File file = new File("F:\\tms\\lesson18\\src\\my\\home\\lesson18\\part1\\resource\\" + nameForFile + ".txt");
        marshaller.marshal(user, file);


    }

    public static Optional<String> getLines(Path path) throws IOException {
        Optional<String> lines = null;
        lines = Files.lines(path).reduce((s1, s2) -> s1 + s2);

        return lines;
    }

    public static String getFileName(Optional<String> str) {
        String lines = str.get();

        String nameforFile = "";
        Pattern pattern = Pattern.compile("\\>\\w+\\<");
        Matcher matcher = pattern.matcher(lines);

        while (matcher.find()) {

            nameforFile = nameforFile + (matcher.group().replaceAll("\\>|\\<", ""));
        }
        return nameforFile;
    }
}
