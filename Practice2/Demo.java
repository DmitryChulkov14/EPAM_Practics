package ua.nure.chulkov.Practice2;

import java.util.Iterator;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException {
        MyListImpl list = new MyListImpl();
        list.add("A");
        list.add("B");
        list.add(433);
        list.add(888);
        list.add(new Object());
        list.add(null);
        list.add("C");
        System.out.println(list);
        list.remove("B");
        System.out.println(list);
        System.out.println("Contains all? - " + list.containsAll(list));

        System.out.println("Show iterator using foreach:");
        for (Object o : list) {
            System.out.println(o);
        }

        System.out.println("Show iterator using while:");
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        it.remove();
        System.out.println(list);

        System.out.println("Show listIterator using while:");
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous());

        }
        listIterator.remove();
        listIterator.next();
        listIterator.set(11111);

        System.out.println(list);
    }
}
