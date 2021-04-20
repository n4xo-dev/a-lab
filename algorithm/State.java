// Class for States of coordinates
public class State{
    private int x;
    private int y;
    private int g; // Cost from start to this node
    private int f; // Cost from start to this node + h(this)
    private int h; // h(this) manhattan distance

    // Constructor meant for Goal State
    public State(int _x, int _y){
        x = _x;
        y = _y;
        g = 0;  // Be careful for g starts with 0
        f = 0;
        h = 0;
    }

    public State(int _x, int _y, MazeGen maze){
        x = _x;
        y = _y;
        g = 0;  // Be careful for g starts with 0
        f = 0;
        h = manhattanDistance(maze, this); // h(this) is constant for the whole execution of the program, so it just needs to be calculated once;
    }

    public int manhattanDistance(MazeGen maze, State current){
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
}
