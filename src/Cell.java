public class Cell {
    private Cell nextCell;
    private int dataCell;

    public Cell(Cell nextCell, int dataCell) {
        this.nextCell = nextCell;
        this.dataCell = dataCell;
    }


    public Cell getNextCell() {
        return nextCell;
    }

    public void setNextCell(Cell nextCell) {
        this.nextCell = nextCell;
    }

    public int getDataCell() {
        return dataCell;
    }

    public void setDataCell(int dataCell) {
        this.dataCell = dataCell;
    }
}
