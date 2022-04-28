package uaslp.objetos.list.hashset;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.exception.NotNullValuesAllowedException;
import uaslp.objetos.list.exception.NotSuchElementException;

public class HashSetTest {

    @Test
    public void givenANewHashSet_whenAddAnElement_thenItIsExistsInTheHashSet() {
        // Given:
        HashSet<String> hashSet = new HashSet<>();

        // When:
        hashSet.add("Hola");

        // Then:
        boolean exist = hashSet.contains("Hola");

        Assertions.assertTrue(exist);
    }

    @Test
    public void givenANewHashSet_whenSearchAnElement_thenItIsNotExistsInTheHashSet() {
        // Given:
        HashSet<String> hashSet = new HashSet<>();

        // When:
        boolean exist = hashSet.contains("Hola");

        // Then:
        Assertions.assertFalse(exist);
    }

    @Test
    public void givenAHashSetWithFiveElements_whenAddAnotherElement_thenSizeIsSix() {
        // Given:
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Adios");
        hashSet.add("Mundo");
        hashSet.add("Cruel");
        hashSet.add("Hola");
        hashSet.add("Hello");

        // When:
        hashSet.add("World");


        // Then:
        int size = hashSet.size();

        Assertions.assertEquals(6, size);
    }

    @Test
    public void givenAHashSetWithOneElement_whenRemove_thenSizeIsZero() {
        // Given:
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Hola");

        // When:
        hashSet.remove("Hola");

        // Then:
        int size = hashSet.size();

        Assertions.assertEquals(0,size);
    }

    @Test
    public void givenAHashSetWithOneElement_whenHasNext_thenItIsTrue() {
        // Given:
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Hola");

        // When:
        Iterator<String> iterator = hashSet.iterator();
        boolean exist = iterator.hasNext();

        // Then:
        Assertions.assertTrue(exist);
    }

    @Test
    public void givenAHashSetWithTwoElements_whenGenerateAIterator_thenGoToTheSecondElement() {
        // Given:
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Hola");
        hashSet.add("Mundo");

        // When:
        Iterator<String> iterator = hashSet.iterator();

        // Then:
        String str = iterator.next();

        Assertions.assertEquals("Mundo",str);
    }

    @Test
    public void givenANewHashSet_whenNext_thenNotSuchElementException() throws NotSuchElementException {
        // Given:
        HashSet<String> hashSet = new HashSet<>();
        Iterator<String> iterator = hashSet.iterator();

        // When:
        // Then:
        Assertions.assertThrows(NotSuchElementException.class, iterator::next);
    }

    @Test
    public void givenANewHashSetWithOneHundredElements_whenAddAnotherElement_thenSizeIsOneHundredOne() {
        // Given:
        HashSet<String> hashSet = new HashSet<>();
        String theAlphaNumericS;
        StringBuilder builder;
        int i = 5;

        for(int s = 0; s < 100; s++) {
            theAlphaNumericS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";
            builder = new StringBuilder(i);
            for (int m = 0; m < i; m++) {
                int myIndex = (int) (theAlphaNumericS.length() * Math.random());
                builder.append(theAlphaNumericS.charAt(myIndex));
            }
            hashSet.add(builder.toString());
        }

        // When:
        hashSet.add("Hello");


        // Then:
        int size = hashSet.size();

        Assertions.assertEquals(101, size);
    }

    /*
    @Test
    public void givenANewHashSetWith_whenAddAnotherElement_thenSizeIsSix() {
        // Given:
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Adios");
        hashSet.add("Mundo");
        hashSet.add("Cruel");
        hashSet.add("Hola");
        hashSet.add("Hello");
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("3");
        hashSet.add("4");
        hashSet.add("5");
        hashSet.add("6");
        hashSet.add("7");
        hashSet.add("8");
        hashSet.add("9");
        hashSet.add("10");
        hashSet.add("11");
        hashSet.add("12");
        hashSet.add("13");
        hashSet.add("14");
        hashSet.add("15");
        hashSet.add("16");
        hashSet.add("17");
        hashSet.add("18");
        hashSet.add("19");
        hashSet.add("20");
        hashSet.add("21");
        hashSet.add("22");
        hashSet.add("23");
        hashSet.add("24");
        hashSet.add("25");
        hashSet.add("26");
        hashSet.add("27");
        hashSet.add("28");
        hashSet.add("29");
        hashSet.add("30");
        hashSet.add("31");
        hashSet.add("32");
        hashSet.add("33");
        hashSet.add("34");
        hashSet.add("35");
        hashSet.add("36");
        hashSet.add("37");
        hashSet.add("38");
        hashSet.add("39");

        // When:
        hashSet.add("World");


        // Then:
        int size = hashSet.size();

        Assertions.assertEquals(45, size);
    }
*/
}