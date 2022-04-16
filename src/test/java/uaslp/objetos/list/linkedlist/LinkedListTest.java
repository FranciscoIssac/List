package uaslp.objetos.list.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.exception.NotNullValuesAllowedException;
import uaslp.objetos.list.exception.NotValidIndexException;

public class LinkedListTest {

    // INICIALIZACIÓN / PREPARACIÓN
    // EJECUCIÓN -> llamar al método probado
    // VALIDACIÓN

    // TDD -> Test Driven Development

    @Test
    public void givenANewList_whenGetSize_thenResultIsZero() {
        // Given:
        LinkedList<String> list = new LinkedList<>();

        // When:
        int sizeOfList = list.getSize();

        // Then:
        Assertions.assertEquals(0, sizeOfList);
    }

    @Test
    public void givenANewList_whenGetAt_thenNotValidIndexExceptionIsThrown() {
        // Given:
        LinkedList<String> list = new LinkedList<>();

        // When:
        // Then:
        Assertions.assertThrows(NotValidIndexException.class,()->list.getAt(0));

    }

    @Test
    public void givenANewList_whenAddAtFrontAnElement_thenSizeIsOne() throws NotNullValuesAllowedException, NotValidIndexException {
        // Given:
        LinkedList<String> list = new LinkedList<>();

        //When:
        list.addAtFront("Hola");

        // Then:
        int size = list.getSize();

        Assertions.assertEquals(1, size);
        Assertions.assertEquals("Hola", list.getAt(0));
    }

    @Test
    public void givenAListWith1Element_whenAddAtFrontAnElement_thenSizeIsTwo() throws NotNullValuesAllowedException, NotValidIndexException {
        // Given:
        LinkedList<String> list = new LinkedList<>();

        list.addAtFront("Hola");

        //When:
        list.addAtFront("Mundo");

        // Then:
        int size = list.getSize();

        Assertions.assertEquals(2, size);
        Assertions.assertEquals("Mundo", list.getAt(0));
        Assertions.assertEquals("Hola", list.getAt(1));
    }

    @Test
    public void givenANewList_whenAddAtTailAnElement_thenSizeIsOne() throws NotNullValuesAllowedException, NotValidIndexException {
        // Given:
        LinkedList<String> list = new LinkedList<>();

        //When:
        list.addAtTail("Hola");

        // Then:
        int size = list.getSize();

        Assertions.assertEquals(1, size);
        Assertions.assertEquals("Hola", list.getAt(0));
    }

    @Test
    public void givenAListWith1Element_whenAddAtTailAnElement_thenSizeIsTwo() throws NotNullValuesAllowedException, NotValidIndexException {
        // Given:
        LinkedList<String> list = new LinkedList<>();

        list.addAtTail("Hola");

        //When:
        list.addAtTail("Mundo");

        // Then:
        int size = list.getSize();

        Assertions.assertEquals(2, size);
        Assertions.assertEquals("Hola", list.getAt(0));
        Assertions.assertEquals("Mundo", list.getAt(1));
    }

    @Test
    public void givenAListWithOneElement_whenRemove_thenSizeIsZero() throws NotValidIndexException, NotNullValuesAllowedException {
        // Given:
        LinkedList<String> list = new LinkedList<>();

        list.addAtFront("Hola");

        // When:
        list.remove(0);

        // Then:
        int size = list.getSize();

        Assertions.assertEquals(0, size);
    }

    @Test
    public void givenAListWithTwoElements_whenRemove_thenSizeIsOne() throws NotValidIndexException, NotNullValuesAllowedException {
        // Given:
        LinkedList<String> list = new LinkedList<>();

        list.addAtFront("Hola");
        list.addAtTail("Mundo");

        // When:
        list.remove(0);

        // Then:
        int size = list.getSize();

        Assertions.assertEquals(1, size);
        Assertions.assertEquals("Mundo", list.getAt(0));
    }

    @Test
    public void givenAListWithTwoElements_whenRemoveIndex3_thenNotValidIndexExceptionIsThrown() throws NotNullValuesAllowedException {
        // Given:
        LinkedList<String> list = new LinkedList<>();

        list.addAtFront("Hola");
        list.addAtTail("Mundo");

        // When:
        // Then:
        Assertions.assertThrows(NotValidIndexException.class,()->list.remove(3));
    }

    @Test
    public void givenAListWithTwoElements_whenSetAtIndex3_thenNotValidIndexExceptionIsThrown() throws NotNullValuesAllowedException {
        // Given:
        LinkedList<String> list = new LinkedList<>();

        list.addAtFront("Hola");
        list.addAtTail("Mundo");

        // When:
        // Then:
        Assertions.assertThrows(NotValidIndexException.class,()->list.setAt(3,"valor"));
    }

    @Test
    public void givenAListWithTwoElements_whenAddAtFrontNullValue_thenNotNotNullValuesAllowedExceptionIsThrown() throws NotNullValuesAllowedException {
        // Given:
        LinkedList<String> list = new LinkedList<>();

        list.addAtFront("Hola");
        list.addAtTail("Mundo");

        // When:
        // Then:
        Assertions.assertThrows(NotNullValuesAllowedException.class,()->list.addAtFront(null));
    }

    @Test
    public void givenAListWithTwoElements_whenAddAtTailNullValue_thenNotNotNullValuesAllowedExceptionIsThrown() throws NotNullValuesAllowedException {
        // Given:
        LinkedList<String> list = new LinkedList<>();

        list.addAtFront("Hola");
        list.addAtTail("Mundo");

        // When:
        // Then:
        Assertions.assertThrows(NotNullValuesAllowedException.class,()->list.addAtTail(null));
    }

    @Test
    public void givenAListWithTwoElements_whenAddSetAtNullValue_thenNotNotNullValuesAllowedExceptionIsThrown() throws NotNullValuesAllowedException {
        // Given:
        LinkedList<String> list = new LinkedList<>();

        list.addAtFront("Hola");
        list.addAtTail("Mundo");

        // When:
        // Then:
        Assertions.assertThrows(NotNullValuesAllowedException.class,()->list.setAt(0,null));
    }

    @Test
    public void givenAListWithTwoElements_whenRemoveIndex1_thenSizeIsOne() throws NotValidIndexException, NotNullValuesAllowedException {
        // Given:
        LinkedList<String> list = new LinkedList<>();

        list.addAtFront("Hola");
        list.addAtTail("Mundo");

        // When:
        list.remove(1);

        // Then:
        int size = list.getSize();

        Assertions.assertEquals(1, size);
        Assertions.assertEquals("Hola", list.getAt(0));
    }

    @Test
    public void givenAListWithThreeElements_whenRemoveIndex1_thenSizeIsTwo() throws NotValidIndexException, NotNullValuesAllowedException {
        // Given:
        LinkedList<String> list = new LinkedList<>();

        list.addAtTail("Mundo");
        list.addAtTail("Cruel");
        list.addAtFront("Adios");

        // When:
        list.remove(1);

        // Then:
        int size = list.getSize();

        Assertions.assertEquals(2, size);
        Assertions.assertEquals("Adios", list.getAt(0));
        Assertions.assertEquals("Cruel", list.getAt(1));
    }

    @Test
    public void givenAListWithThreeElements_whenRemoveElementAtTail_thenSizeIsTwo() throws NotValidIndexException, NotNullValuesAllowedException {
        // Given:
        LinkedList<String> list = new LinkedList<>();

        list.addAtTail("Mundo");
        list.addAtTail("Cruel");
        list.addAtFront("Adios");

        // When:
        list.remove(2);

        // Then:
        int size = list.getSize();

        Assertions.assertEquals(2, size);
        Assertions.assertEquals("Adios", list.getAt(0));
        Assertions.assertEquals("Mundo", list.getAt(1));
    }

    @Test
    public void givenAListWithThreeElements_whenRemoveAll_thenSizeIsZero() throws NotNullValuesAllowedException {
        // Given:
        LinkedList<String> list = new LinkedList<>();

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
        LinkedList<String> list = new LinkedList<>();

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
        LinkedList<String> list = new LinkedList<>();

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
