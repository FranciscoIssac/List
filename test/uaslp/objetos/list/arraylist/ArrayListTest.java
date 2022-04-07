package uaslp.objetos.list.arraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.exception.NotNullValuesAllowedException;
import uaslp.objetos.list.exception.NotValidIndexException;

public class ArrayListTest {

    @Test
    public void givenAListWithAlmostFull_whenAddAtFrontAnElement_thenArrayListIncreaseHisSize() throws NotNullValuesAllowedException {
        // Given:
        ArrayList<String> list = new ArrayList<>(2);

        list.addAtTail("Cruel");
        list.addAtFront("Mundo");

        // When:
        list.addAtFront("Adios");

        // Then:
        Assertions.assertEquals(3, list.getSize());

    }

    @Test
    public void givenAListWithAlmostFull_whenAddAtTailAnElement_thenArrayListIncreaseHisSize() throws NotNullValuesAllowedException {
        // Given:
        ArrayList<String> list = new ArrayList<>(2);

        list.addAtTail("Mundo");
        list.addAtFront("Adios");

        // When:
        list.addAtTail("Cruel");

        // Then:
        Assertions.assertEquals(3, list.getSize());

    }

    @Test
    public void givenANewList_whenGetAt_thenNotValidIndexExceptionIsThrown() {
        // Given:
        ArrayList<String> list = new ArrayList<>();

        // When:
        // Then:
        Assertions.assertThrows(NotValidIndexException.class,()->list.getAt(0));

    }

    @Test
    public void givenANewList_whenAddAtTailAnElement_thenSizeIsOne() throws NotNullValuesAllowedException, NotValidIndexException {
        // Given:
        ArrayList<String> list = new ArrayList<>();

        //When:
        list.addAtTail("Hola");

        // Then:
        int size = list.getSize();

        Assertions.assertEquals(1, size);
        Assertions.assertEquals("Hola", list.getAt(0));
    }

    @Test
    public void givenAListWithOneElement_whenRemove_thenSizeIsZero() throws NotValidIndexException, NotNullValuesAllowedException {
        // Given:
        ArrayList<String> list = new ArrayList<>();

        list.addAtFront("Hola");

        // When:
        list.remove(0);

        // Then:
        int size = list.getSize();

        Assertions.assertEquals(0, size);
    }

    @Test
    public void givenAListWithTwoElements_whenRemoveIndex3_thenNotValidIndexExceptionIsThrown() throws NotNullValuesAllowedException {
        // Given:
        ArrayList<String> list = new ArrayList<>();

        list.addAtFront("Hola");
        list.addAtTail("Mundo");

        // When:
        // Then:
        Assertions.assertThrows(NotValidIndexException.class,()->list.remove(3));
    }

    @Test
    public void givenAListWithTwoElements_whenSetAtIndex3_thenNotValidIndexExceptionIsThrown() throws NotNullValuesAllowedException {
        // Given:
        ArrayList<String> list = new ArrayList<>();

        list.addAtFront("Hola");
        list.addAtTail("Mundo");

        // When:
        // Then:
        Assertions.assertThrows(NotValidIndexException.class,()->list.setAt(3,"valor"));
    }

    @Test
    public void givenAListWithTwoElements_whenAddAtFrontNullValue_thenNotNotNullValuesAllowedExceptionIsThrown() throws NotNullValuesAllowedException {
        // Given:
        ArrayList<String> list = new ArrayList<>();

        list.addAtFront("Hola");
        list.addAtTail("Mundo");

        // When:
        // Then:
        Assertions.assertThrows(NotNullValuesAllowedException.class,()->list.addAtFront(null));
    }

    @Test
    public void givenAListWithTwoElements_whenAddAtTailNullValue_thenNotNotNullValuesAllowedExceptionIsThrown() throws NotNullValuesAllowedException {
        // Given:
        ArrayList<String> list = new ArrayList<>();

        list.addAtFront("Hola");
        list.addAtTail("Mundo");

        // When:
        // Then:
        Assertions.assertThrows(NotNullValuesAllowedException.class,()->list.addAtTail(null));
    }

    @Test
    public void givenAListWithTwoElements_whenAddSetAtNullValue_thenNotNotNullValuesAllowedExceptionIsThrown() throws NotNullValuesAllowedException {
        // Given:
        ArrayList<String> list = new ArrayList<>();

        list.addAtFront("Hola");
        list.addAtTail("Mundo");

        // When:
        // Then:
        Assertions.assertThrows(NotNullValuesAllowedException.class,()->list.setAt(0,null));
    }

    @Test
    public void givenAListWithThreeElements_whenRemoveAll_thenSizeIsZero() throws NotNullValuesAllowedException {
        // Given:
        ArrayList<String> list = new ArrayList<>();

        list.addAtTail("Mundo");
        list.addAtTail("Cruel");
        list.addAtFront("Adios");

        // When:
        list.removeAll();

        // Then:
        int size = list.getSize();

        Assertions.assertEquals(0, size);
    }

    @Test
    public void givenAListWithTwoElements_whenSetAt_thenElementIsModified() throws NotValidIndexException, NotNullValuesAllowedException {
        // Given:
        ArrayList<String> list = new ArrayList<>();

        list.addAtTail("Mundo");
        list.addAtFront("Adios");

        // When:
        list.setAt(0, "Hola");

        // Then:
        int size = list.getSize();

        Assertions.assertEquals(2, size);
        Assertions.assertEquals("Hola", list.getAt(0));
        Assertions.assertEquals("Mundo", list.getAt(1));
    }

    @Test
    public void givenAListWithThreeElements_whenGetIterator_thenIteratorWorksOverAllThreeElements() throws NotNullValuesAllowedException, NotValidIndexException {
        // Given:
        ArrayList<String> list = new ArrayList<>();

        list.addAtTail("Mundo");
        list.addAtTail("Cruel");
        list.addAtFront("Adios");

        // When:
        Iterator<String> Iterator = list.getIterator();

        // Then:
        int size = list.getSize();

        Assertions.assertEquals(3, size);
        Assertions.assertNotNull(Iterator);
        Assertions.assertTrue(Iterator.hasNext());
        Assertions.assertEquals("Adios", Iterator.next());
        Assertions.assertTrue(Iterator.hasNext());
        Assertions.assertEquals("Mundo", Iterator.next());
        Assertions.assertTrue(Iterator.hasNext());
        Assertions.assertEquals("Cruel", Iterator.next());
        Assertions.assertFalse(Iterator.hasNext());
    }
}