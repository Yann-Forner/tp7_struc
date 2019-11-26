import static java.lang.System.out;
public class TryLinkedList {
    public static void main(String [] args) {
        LinkedIntList myList =(LinkedIntList)new LinkedIntList().cons(3).cons(2).cons(1);
        LinkedIntList myList2 =(LinkedIntList)new LinkedIntList().cons(3).cons(2).cons(1);
        out.println(myList.equals(myList2));


    }
}