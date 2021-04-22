// Class for States of coordinates
public class MyState {
    private int x, y;
    private int g; // Cost from start to this node
    private int f; // Cost from start to this node + h(this)
    private int h; // h(this) manhattan distance
    private MyState parent; // Link to previous state on path

    // Constructor meant for Goal State
    public MyState(int _x, int _y){
        x = _x;
        y = _y;
        g = 0;  // Be careful for g starts with 0
        f = 0;
        h = 0;
        parent = null;
    }

    public MyState(int _x, int _y, MazeGen maze){
        x = _x;
        y = _y;
        g = 0;  // Be careful for g starts with 0
        h = manhattanDistance(maze, this); // h(this) is constant for the whole execution of the program, so it just needs to be calculated once;
        f = h;
        parent = null;
    }

    public int manhattanDistance(MazeGen maze, MyState current){
        return Math.abs(current.getX() - maze.getGoal().getX()) + Math.abs(current.getY() - maze.getGoal().getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getG() {
        return g;
    }
    public void setG(int _g) {
        g = _g;
        f = h + g ; //updated f
    }

    public int getF() {
        return f;
    }
    public void setF(int _f) {
        f = _f;
    }

    public int getH(){
        return h;
    }

    public MyState getParent() {
        return parent;
    }

    public void setParent(MyState parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o){
        boolean res = false;
        if(o instanceof MyState){
            MyState z = (MyState) o;
            if(this.hashCode() == z.hashCode())
                res = true;
        }
    return res;
    }

    @Override
    public int hashCode() {
        return (((this.getX() + this.getY()) * (this.getY() + this.getX() + 1)) / 2) + this.getY() ;
    }
}
