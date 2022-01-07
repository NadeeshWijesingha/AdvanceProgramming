
public class Location extends SpacePlace {
  public int column;
  public int row;
  public DIRECTION direction;
  
  public enum DIRECTION {VERTICAL, HORIZONTAL};
  
  public Location(int r, int column) {
    this.row = r;
    this.column = column;
  }

  public Location(int r, int column, DIRECTION direction) {
    this(r, column);
    this.direction = direction;
  }
  
  public String toString() {
    if(direction ==null){
      return "(" + (column +1) + "," + (row +1) + ")";
    } else {
      return "(" + (column +1) + "," + (row +1) + "," + direction + ")";
    }
  }
}
