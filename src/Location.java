
public class Location extends SpacePlace {
  public int column;
  public int row;
  public DIRECTION d;
  
  public enum DIRECTION {VERTICAL, HORIZONTAL};
  
  public Location(int r, int column) {
    this.row = r;
    this.column = column;
  }

  public Location(int r, int column, DIRECTION d) {
    this(r, column);
    this.d=d;
  }
  
  public String toString() {
    if(d==null){
      return "(" + (column +1) + "," + (row +1) + ")";
    } else {
      return "(" + (column +1) + "," + (row +1) + "," + d + ")";
    }
  }
}
