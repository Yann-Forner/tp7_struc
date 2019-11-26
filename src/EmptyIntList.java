import java.util.NoSuchElementException;

public class EmptyIntList extends InductiveIntList {

    @Override
    public int getHead() {
        throw new NoSuchElementException();
    }

    @Override
    public IntList getTail() {
        throw new NoSuchElementException();
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public IntList cons(int n) {
        return new NonEmptyIntList(n,this);
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public int sum() {
        return 0;
    }
    @Override
    public boolean equals(IntList i) {
        return i.isEmpty();
    }
}
