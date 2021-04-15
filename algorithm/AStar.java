import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class AStar {

    private Boolean[][] closedSet;  // Set of nodes already evaluated, for those not evaluated 0, for those evaluated 1 (or any number besides 0).
                                // I think using an array like this can be very time-efficient when it comes to checking whether a node has been evaluated
                                // Even though it may not be very space-efficient
    private List<State> openSet; // Set of tentative nodes to be evaluated
    private List<State> parent;  // Map of navigated nodes
    /*
    When the A* finishes, we should send parent to Maze,
    change the content of maze with parent path, and call Maze.toString to show the results
    */

    public AStar(MazeGen maze){
        closedSet = new Boolean[60][80];
        openSet = new ArrayList<>();
        parent = new ArrayList<>();

        openSet.add(new State(maze.getInitialStateX(), maze.getInitialStateY(), maze));

        for (int i = 0; i < 60; i++){
            for (int j = 0; j < 80; j++){
                closedSet[i][j] = false;
            }
        }
    }
    
    /*
     * We will use g==0 as a conditional for checking if state is in openset and save time from iterating openset array
     */
    public int manhattanDistance(MazeGen maze, State current){
        return Math.abs(current.getX() - maze.getGoalStateX()) + Math.abs(current.getY() - maze.getGoalStateY());
    }

    // Class for States of coordinates
    public class State{
        private int x;
        private int y;
        private int g; // Cost from start to this node
        private int f; // Cost from start to this node + h(this)
        private int h; // h(this) manhattan distance

        public State(int _x, int _y, MazeGen maze){
            x = _x;
            y = _y;
            g = 0;  // Be careful for g starts with 0
            f = 0;
            h = manhattanDistance(maze, this); // h(this) is constant for the whole execution of the program, so it just needs to be calculated once;
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

}