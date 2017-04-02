package Wator;
	
public enum Direction {       
    LEFT(-1, 0), RIGHT(1, 0), UP(0, -1), DOWN(0, 1);
    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }        
    int dx; 
    int dy;
}
