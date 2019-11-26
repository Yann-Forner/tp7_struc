import java.util.ListIterator;

public class IntListIterator implements IntIterator {

    private Cell myCell;

    public IntListIterator(LinkedIntList l) {
        this.myCell = l.getFirst();
    }
    @Override
    public int next() {
        int temp = this.myCell.getDataCell();
        this.myCell = this.myCell.getNextCell();
        return temp;
    }
    @Override
    public boolean hasNext() {
        return this.myCell != null;
    }


}
