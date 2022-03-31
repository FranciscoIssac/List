import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.arraylist.ArrayList;
import uaslp.objetos.list.exception.NotNullValuesAllowedException;
import uaslp.objetos.list.linkedlist.LinkedList;
import uaslp.objetos.list.exception.NotValidIndexException;

public class Main {

    public static void main(String[] args) {
        System.out.println("Aquí se prueba con el ArrayList");

        List<String> team1 = new ArrayList<>();
        List<String> team2 = new ArrayList<>();
        List<String> team3 = new ArrayList<>();

        try {
            pruebaListas(team1, team2, team3);
        } catch (NotValidIndexException | NotNullValuesAllowedException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println();
        System.out.println("Aquí se prueba con el LinkedList");

        team1 = new LinkedList<>();
        team2 = new LinkedList<>();
        team3 = new LinkedList<>();

        try {
            pruebaListas(team1, team2, team3);
        } catch (NotValidIndexException | NotNullValuesAllowedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void pruebaListas(List<String> team1, List<String> team2, List<String> team3) throws NotValidIndexException, NotNullValuesAllowedException {

        //team1.remove(7);

        team1.setAt(7,null);

        team1.addAtTail("Jesús");
        team1.addAtTail("Salomón");
        team1.addAtTail("Yael");

        team2.addAtFront("Cristian");
        team2.addAtFront("Daniel");
        team2.addAtFront("Diego");

        team3.addAtFront("Imelda");

        Iterator<String> iterator;

        iterator = team1.getIterator();

        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }

        // Debió haber impreso
        // Jesús
        // Salomón
        // Yael

        iterator = team2.getIterator();

        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }

        // Debió haber impreso
        // Diego
        // Daniel
        // Cristian

        team1.remove(0);
        team1.addAtFront("Rebeca");
        System.out.println("Team 1 tiene: " + team1.getSize() + " integrantes"); // debe imprimir "Team 1 tiene 3 integrantes"

        iterator = team1.getIterator();

        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }

        // Debió haber impreso
        // Rebeca
        // Salomón
        // Yael

        team2.remove(2);
        team2.addAtTail("Rita");
        System.out.println("Team 2 tiene: " + team2.getSize() + " integrantes"); // debe imprimir "Team 2 tiene 3 integrantes"

        iterator = team2.getIterator();

        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }

        // Debió haber impreso
        // Diego
        // Daniel
        // Rita

        team3.remove(0);
        team3.remove(0); // El elemento no existe pero el programa no debe cerrarse por algún error

        team3.addAtTail("Tadeo");
        team3.addAtFront("Isai");

        System.out.println("Team 3 tiene: " + team3.getSize() + " integrantes"); // debe imprimir "Team 3 tiene 2 integrantes"

        iterator = team3.getIterator();

        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }

        // Debió haber impreso
        // Tadeo
        // Isai
        // - Al revés?

        if(team1.getAt(1).equals("Salomón")){
            team1.setAt(1, "Luis");
        }

        System.out.println("Team 1 tiene: " + team1.getSize() + " integrantes"); // debe imprimir "Team 1 tiene 3 integrantes"

        iterator = team1.getIterator();

        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }

        // Debió haber impreso
        // Rebeca
        // Luis
        // Yael
    }
}
