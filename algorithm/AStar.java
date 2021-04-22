
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.plaf.nimbus.State;

public class AStar {

    private Boolean[][] closedSet;  // Set of nodes already evaluated, for those not evaluated 0, for those evaluated 1 (or any number besides 0).
                                    // I think using an array like this can be very time-efficient when it comes to checking whether a node has been evaluated
                                    // Even though it may not be very space-efficient
    private List<MyState> openSet;    // Set of tentative nodes to be evaluated

    public AStar(MazeGen maze){
        closedSet = new Boolean[60][80];
        openSet = new LinkedList<>();
        openSet.add(maze.getInitial());

        for (int i = 0; i < 60; i++){
            for (int j = 0; j < 80; j++){
                closedSet[i][j] = false;
            }
        }
    }

    public void solveMaze(MazeGen maze){
        MyState current = null;
        boolean success = false;

        while (!openSet.isEmpty()){

            current = getBestOpenState();
            if(current.getX() == maze.getGoal().getX() && current.getY() == maze.getGoal().getY()){
                success = true;
                break;
            }
            openSet.remove(current);
            closeState(current);

            for (MyState neighbor : neighbors(current, maze)) {
                if(isClosed(neighbor))
                    continue;
                int tentative_g = current.getG() + 1;
                if (neighbor.getG() == 0 || tentative_g < neighbor.getG()){
                    boolean unopened = (neighbor.getG() == 0) ? true : false; // if g(neighbor) = 0 -> neighbor is not in openSet
                    neighbor.setParent(current);
                    neighbor.setG(tentative_g);
                    if(unopened){
                        openSet.add(neighbor);
                    }

                }
            }
        }

        if(!success) {
            System.out.println("No path found.");
        }
        else
            reconstructPath(maze, current);
        
       
    }

    private boolean isClosed(MyState state) {
        return (closedSet[state.getX()][state.getY()]);
    }

    private ArrayList<MyState> neighbors(MyState current, MazeGen maze) {
        ArrayList<MyState> result = new ArrayList<>();

        int[][] possibleNeighbors = {
                {current.getX(), current.getY() + 1},
                {current.getX() + 1, current.getY()},
                {current.getX(), current.getY() - 1},
                {current.getX() - 1, current.getY()}
        };

        for (int[] pn : possibleNeighbors) {
            if(pn[0] > 0 && pn[0] < 60 && pn[1] > 0 && pn[1] < 80 && maze.getNode(pn[0], pn[1]) != '█'){
                result.add(new MyState(pn[0], pn[1], maze));
            }
        }

        return result;
    }

    private void closeState(MyState state) {
        closedSet[state.getX()][state.getY()] = true;
    }

    private MyState getBestOpenState(){
        MyState aux = openSet.get(0);
        for(MyState s : openSet){
            if(s.getF() <= aux.getF()){
                aux = s;
            }
        }
        return aux;
    }
    
    private void reconstructPath(MazeGen maze, MyState current){
        current = current.getParent();

        while(current.getParent() != null){
            maze.addToPath(current.getX(),current.getY());
            current = current.getParent();
        }
    }
    /*
     * We will use g==0 as a conditional for checking if state is in openset and save time from iterating openset array
     * And has to be changed in the execution of the program
     */

     /* Doubts about the return of the main function, within the current method (gether)
     *  And transforming parent into a copy of maze, which is going to be changed and 
     *  returned has the final maze, If Java uses pointers, this one would be more efficient
     */

}