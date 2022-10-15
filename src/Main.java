import uaslp.objetos.list.linkedlist.LinkedList;
import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;

public class Main {
    public static void main(String[] args) {
        List datos = new LinkedList();

        datos.addAtTail("Jorge");
        datos.addAtTail("Alberto");
        datos.addAtTail("Hernandez");
        datos.addAtTail("Soria");
        datos.addAtTail("UwU");

        datos.addAtFront("3");
        datos.addAtFront("0");
        datos.addAtFront("6");
        datos.addAtFront("8");
        datos.addAtFront("4");
        datos.addAtFront("3");

        Iterator iterator = datos.getIterator();

        while (iterator.hasNext()){
            String data = iterator.next();
            System.out.println(data);
        }

        datos.addAtFront("1");
        datos.addAtFront("2");
        datos.addAtFront("3");

        datos.removeAll();

        System.out.println("------------------");

        iterator = datos.getIterator();

        while (iterator.hasNext()){
            String data = iterator.next();
            System.out.println(data);
        }

    }
}