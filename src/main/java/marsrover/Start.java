package marsrover;

import marsrover.position.*;
import marsrover.rover.*;
import marsrover.surface.*;

class Start {
    private Rover rover;

    private Start() {
        Position position = new Position(new PositionSegment(39), new PositionSegment(9));
        SurfaceCreator surfaceCreator = new SurfaceCreator();
        Surface surface = new Surface(surfaceCreator.create(new PositionSegment(80), new PositionSegment(20), position));
        this.rover = new NorthRover(position, surface);
    }

    public static void main(String[] args) {
        Start start = new Start();
        start.moveRover();
    }

    private void moveRover() {
        printMap();
        moveForward();
        moveForward();
        turnRight();
        moveForward();
        printMap();
    }

    private void moveForward() {
        rover = rover.moveForward();
    }

    private void turnRight() {
        rover = rover.turnRight();
    }

    private void printMap() {
        rover.print(System.out);
    }
}
