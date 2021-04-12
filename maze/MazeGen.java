
import java.util.Random;

public class MazeGen {
    private char[][] maze;
    private int initialStatex;
    private int initialStatey;
    private int goalStatex;
    private int goalStatey;

    public MazeGen() {
        this.maze = new char[60][80];
        int i = 0, j;
        while(i < 60) {
            j = 0;
            while(j < 80) {
                maze[i][j] = ' ';
                ++j;
            }
            ++i;
        }
        generateObstacles();
        generateIG();
    }

    private void generateObstacles() {
        Random ran = new Random();
        int i = 0, j;
        while(i < 60) {
            j = 0;
            while(j < 80) {
                int random = ran.nextInt(10);
                if(random < 3) {
                    maze[i][j] = '*';
                }
                ++j;
            }
            ++i;
        }
    }

    private void generateIG() {
        Random ran = new Random();
        int randi = ran.nextInt(60);
        int randj = ran.nextInt(80);
        while(maze[randi][randj] != ' ') {
            randi = ran.nextInt(60);
            randj = ran.nextInt(80);
        }
        maze[randi][randj] = 'I';
        this.initialStatex = randi;
        this.initialStatey = randj;
        while(maze[randi][randj] != ' ') {
            randi = ran.nextInt(60);
            randj = ran.nextInt(80);
        }
        maze[randi][randj] = 'G';
        this.goalStatex = randi;
        this.goalStatey = randj;
    }

    public int getInitialStateX() {
        return this.initialStatex;
    }

    public int getInitialStateY() {
        return this.initialStatey;
    }

    public int getGoalStateX() {
        return this.goalStatex;
    }

    public int getGoalStateY() {
        return this.goalStatey;
    }

    public String toString() {
        String res = "";
        for(int x = 0; x < 82; ++x) {
            res += "*";
        }
        res += "\n";
        int i = 0, j;
        while(i < 60) {
            res += "*";
            j = 0;
            while(j < 80) {
                res += maze[i][j];
                ++j;
            }
            res += "*\n";
            ++i;
        }
        for(int x = 0; x < 82; ++x) {
            res += "*";
        }
        return res;
    }
}

