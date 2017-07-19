package ua.nure.chulkov.Practice2;

public class Demo {
    public static void main(String[] args) {
        MyListImpl list = new MyListImpl();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
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
        ListIterator it = list.listIterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        it.remove();
        System.out.println(list);

        System.out.println("Show listIterator using while:");
        ListIterator listIterator = list.listIterator();
        while (it.hasPrevious()){
            System.out.print(it.previous() + " ");

        }
        System.out.println();
        listIterator.remove();
        listIterator.next();
        listIterator.set(11111);
        System.out.println(list);
    }
}
