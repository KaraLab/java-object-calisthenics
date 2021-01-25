package marsrover.rover;

import marsrover.position.*;

import java.io.PrintStream;

public abstract class Rover {
    public abstract Rover moveForward();
    public abstract Rover turnRight();
    public abstract void print(PrintStream out);
    public abstract void printRepresentation(PrintStream out, Position printPosition);
}
