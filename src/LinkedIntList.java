import java.util.NoSuchElementException;

public class LinkedIntList implements IntList{
    // variables d’instance
    private Cell first;
    // /** Constructeur d’objets de classe LinkedIntList*/

    public LinkedIntList(){
        // initialisation des variables d’instance
        first = null;
    }

    public LinkedIntList(Cell first) {
        this.first = first;
    }

    public Cell getFirst() {
        return first;
    }

    @Override
    public int getHead() {
        return this.first.getDataCell();
    }

    @Override
    public IntList getTail() {
        return new LinkedIntList(first.getNextCell());
    }

    @Override
    public boolean isEmpty() {
        return first==null;
    }

    @Override
    public IntList cons(int n) {
        Cell cell = new Cell(this.first,n);
        return new LinkedIntList(cell) ;
    }

    @Override
    public int length() {
        if(this.isEmpty())return 0;
        if(this.getTail().isEmpty())return 1;
        return this.getTail().length()+1;
    }

    @Override
    public boolean equals(IntList i) {
        if (isOnlyOneEmpty(i))return false;
        if(this.getTail().isEmpty() && i.getTail().isEmpty())return true;
        return this.getHead() == i.getHead()
                && this.getTail().equals(i.getTail());
    }
    public boolean isOnlyOneEmpty(IntList i){
        return (i.getTail().isEmpty() && !this.getTail().isEmpty()) || (!i.getTail().isEmpty() && this.getTail().isEmpty());
    }
    @Override
    public int sum() {
        if (this.first==null)return 0;
        if (this.getTail().isEmpty())return this.first.getDataCell();
        return this.getTail().sum() + this.first.getDataCell();
    }

    public IntIterator iterator(){
        return new IntListIterator(this);
    }

    public void add(int n){
        this.first = new Cell(this.first,n);
    }

    public void remove(){
        this.first = this.first.getNextCell();
    }

    public void add(int n, int pos){
        if(pos <= 1){
            add(n);
        }else if(pos > length()){
            Cell newCell = this.first;
            for (int i = 1; i < length(); i++) {
                newCell = newCell.getNextCell();
            }
            newCell.setNextCell(new Cell(null,n));
        }else{
            Cell newCell = getCellAtPosition(pos - 1);
            newCell.setNextCell(new Cell(newCell.getNextCell(),n));
        }
    }

    public void remove(int pos) throws NoSuchElementException {
        if(pos < 1 || pos > length()){
            throw new NoSuchElementException("You can't remove something that isn't there.");
        }
        if(pos == 1){
            remove();
        }else{
            Cell newCell = getCellAtPosition(pos-1);
            newCell.setNextCell(newCell.getNextCell().getNextCell());
        }
    }

    private Cell getCellAtPosition(int pos) {
        Cell newCell = first;
        for (int i = 1; i < pos; i++) {
            newCell = newCell.getNextCell();
        }
        return newCell;
    }

}