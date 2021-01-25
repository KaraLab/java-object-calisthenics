package marsrover.rover;

import marsrover.position.*;
import marsrover.surface.*;
import java.io.PrintStream;

public class NorthRover extends Rover {
    private final Position position;
    private final Surface surface;

    public NorthRover(Position position, Surface surface) {
        this.position = position;
        this.surface = surface;
    }

    public NorthRover moveForward() {
        return surface.moveRoverIfFreeAt(position.decreaseY(), this);
    }

    public EastRover turnRight() {
        return new EastRover(position, surface);
    }

    public void print(PrintStream out) {
        out.println();
        surface.print(out, this, position);
        out.println();
    }

    public void printRepresentation(PrintStream out, Position printPosition) {
        if (printPosition.equals(this.position)) {
            out.print("^");
        }
    }
}
