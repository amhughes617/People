import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by alexanderhughes on 2/15/16.
 */
public class PeopleTest {

    @Test
    public void testReadFile() throws Exception {
        HashMap personMap = People.readFile();
        assertTrue(personMap.keySet().size() == 127);
    }

    @Test
    public void testSortLists() throws Exception {  //checks if the sort method actually changes the hashmap
        HashMap personMap = People.readFile();
        HashMap personMap2 = People.readFile();
        People.sortLists(personMap);
        assertTrue(!personMap.toString().equals(personMap2.toString()));
    }
}