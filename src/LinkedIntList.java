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
        if (this.getTail().isEmpty() || i.getTail().isEmpty())return this.getHead() == i.getHead();
        return this.first.getDataCell() == i.getHead()
                && this.getTail().equals(i.getTail());
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

    public void add(int n,int pos){

        if(pos < 1 ){
            this.add(n);

        } else {
            if(pos> length()){
                pos = length();
            }
            Cell cell = this.getFirst();
            for (int i = 1; i <= pos-1; i++) {
                cell = cell.getNextCell();
            }
            cell.setNextCell(new Cell(cell.getNextCell(),n));
        }
    }

    public void remove(int pos) {
        if(pos < 1 ||  pos > length()){
            throw new NoSuchElementException();
        }
        Cell cell = this.getFirst();
        for (int i = 1; i < pos-1 ; i++) {
            cell = cell.getNextCell();
        }
        cell.setNextCell(cell.getNextCell().getNextCell());
    }

}