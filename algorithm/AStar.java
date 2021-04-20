import java.lang.Math;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.plaf.nimbus.State;

public class AStar {

    private Boolean[][] closedSet;  // Set of nodes already evaluated, for those not evaluated 0, for those evaluated 1 (or any number besides 0).
                                    // I think using an array like this can be very time-efficient when it comes to checking whether a node has been evaluated
                                    // Even though it may not be very space-efficient
    private List<State> openSet;    // Set of tentative nodes to be evaluated
    private List<State> parent;     //Navigated (possible name)  // Map of navigated nodes
    /*
    When the A* finishes, we should send parent to Maze,
    change the content of maze with parent path, and call Maze.toString to show the results
    */

    public AStar(MazeGen maze){
        closedSet = new Boolean[60][80];
        openSet = new OrderedStates<>(new State(maze.getInitial().getX(), maze.getInitial().getY(), maze));
        parent = new ArrayList<>();

        for (int i = 0; i < 60; i++){
            for (int j = 0; j < 80; j++){
                closedSet[i][j] = false;
            }
        }
    }
    

    public void solveMaze(MazeGen maze){
        State current;
        while (!openSet.isEmpty()){
            // Beware of getFirst() implementation (might need to Override)
            current = openSet.getFirst(); // Ordered list in ascending order, first element is the most recent one
            
        }
       
    }
    
    private class OrderedStates{
        private List<State> list;

        public OrderedStates(){
            list = new LinkedList<>();
        }

        public OrderedStates(State s){
            list = new LinkedList<>();
            list.add(s);
        }
        
        @Override
        public add(State s){
            // Add in order using binary search
            // This way, no need to reorder afterwards
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