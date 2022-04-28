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

        // genera 100 strings aleatorios y los almacena en el HashSet
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

}