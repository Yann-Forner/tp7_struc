public class NonEmptyIntList extends InductiveIntList {
    private int head;
    private IntList queue;

    public NonEmptyIntList(int head, IntList queue) {
        this.head = head;
        this.queue = queue;
    }

    @Override
    public int getHead() {
        return this.head;
    }

    @Override
    public IntList getTail() {
        return this.queue;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public IntList cons(int n) {
        return new NonEmptyIntList(n, this);
    }

    @Override
    public int length() {
        return this.queue.length()+1;
    }

    @Override
    public int sum() {
        return this.queue.sum() + this.head;
    }

    @Override
    public boolean equals(IntList i) {
        return !i.isEmpty()
                && this.head==i.getHead()
                && this.queue.equals(i.getTail());
    }
}
