import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class People {

    public static void main(String[] args) throws FileNotFoundException {
        HashMap personMap = readFile();
        for (ArrayList<Person> persons : personMap.values()) {
            Collections.sort(persons);
        }
        System.out.println(personMap);
    }

    public static HashMap<String, ArrayList<Person>> readFile() {
        HashMap<String, ArrayList<Person>> personMap = new HashMap<>();
        File f = new File("people.csv");
        Scanner fileScanner = new Scanner(f);
        String line = fileScanner.nextLine();
        while (fileScanner.hasNext()) {
            line = fileScanner.nextLine();
            String[] columns = line.split(",");
            Person person = new Person(Integer.valueOf(columns[0]), columns[1], columns[2], columns[3],columns[4],columns[5]);
            if (!personMap.containsKey(person.country)) {
                personMap.put(person.country, new ArrayList<>());
            }
            personMap.get(person.country).add(person);
        }
        return personMap;
    }
}


//for (ArrayList<Person> persons : personMap.values()) {
//        Collections.sort(persons);
//        }
