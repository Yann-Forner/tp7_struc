public class TryList {
    static int sum(IntList l) {
        if (l.isEmpty()) return 0;
        return l.getHead() + sum(l.getTail());
    }

    public static void main(String[] args) {
        IntList myList = new LinkedIntList().cons(3).cons(2).cons(1).cons(5);
        IntList myList2 = new LinkedIntList().cons(3).cons(2).cons(1);
        LinkedIntList myList3 = new LinkedIntList();
        myList3.add(5);
        myList3.add(4);
        myList3.add(3);
        myList3.remove();
        int result = sum(myList);
        System.out.println(result);
        IntList myLongerList = myList.cons(8);
        result = sum(myLongerList);
        System.out.println(result);
        result = myList.sum();

        System.out.println(result);
        System.out.println(myLongerList.sum());
        System.out.println(myList.equals(myList2));

        printIntList(myList3);
        myList3.add(7,4);
        printIntList(myList3);
        System.out.println(myList3.length());
    }

    public static void printIntList(LinkedIntList l) {
        IntIterator intIterator = l.iterator();
        System.out.print("[");
        while (intIterator.hasNext()){
            System.out.print(" "+intIterator.next()+" ");
        }
        System.out.print("]");
    }
}
