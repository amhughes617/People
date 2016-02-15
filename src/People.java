import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class People {

    public static void main(String[] args) throws IOException {
        HashMap<String, ArrayList<Person>> personMap = readFile();

        sortLists(personMap);
        System.out.println(personMap);
        System.out.println(personMap.keySet().size());
        writeJson(personMap);
    }


    //reads csv file and saves into a HashMap, it sorts the person objects by last name in each arraylist of the hashmap
    public static HashMap<String, ArrayList<Person>> readFile() throws FileNotFoundException {

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

    //sorts ArrayLists by last name
    static void sortLists(HashMap<String, ArrayList<Person>> personMap) {
        for (ArrayList<Person> persons : personMap.values()) {
            Collections.sort(persons);
        }
    }

    //writes hashmap to a json
    static void writeJson(HashMap personMap) throws IOException { //writes a separate json file

        File f = new File("people.json");
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.include("*").serialize(personMap);
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();
    }
}