

public class Main {
    public static void main(String [] args) {
        MazeGen maze = new MazeGen();
        AStar solver = new AStar(maze);
        solver.solveMaze(maze);
        System.out.println(maze.toString());
    }
}
