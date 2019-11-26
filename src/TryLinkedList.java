import static java.lang.System.out;
public class TryLinkedList {
    public static void main(String [] args) {
        LinkedIntList myList =(LinkedIntList)new LinkedIntList().cons(3).cons(2).cons(1);
        TryList.printIntList(myList);
        myList.add(0);
        TryList.printIntList(myList);
        myList.remove();
        TryList.printIntList(myList);
    }
}