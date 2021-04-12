import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class AStar {

    private int[][] closedSet;  // Set of nodes already evaluated, for those not evaluated 0, for those evaluated 1 (or any number besides 0).
                                // I think using an array like this can be very time-efficient when it comes to checking whether a node has been evaluated
                                // Even though it may not be very space-efficient
    private List<Pair> openSet; // Set of tentative nodes to be evaluated
    private List<Pair> parent;  // Map of navigated nodes


    public AStar(MazeGen maze){
        closedSet = new int[60][80];
        openSet = new ArrayList<>();
        parent = new ArrayList<>();

        openSet.add(new Pair(maze.getInitialStateX(), maze.getInitialStateY()));

        for (int i = 0; i < 60; i++){
            for (int j = 0; j < 80; j++){
                closedSet[i][j] = 0;
            }
        }
    }

    public int manhattanDistance(MazeGen maze){
        return Math.abs(maze.getInitialStateX() - maze.getGoalStateX()) + Math.abs(maze.getInitialStateY()) - maze.getGoalStateY();
    }

    // Class for pairs of coordinates
    public class Pair{
        private int x;
        private int y;

        public Pair(int _x, int _y){
            x = _x;
            y = _y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

}
