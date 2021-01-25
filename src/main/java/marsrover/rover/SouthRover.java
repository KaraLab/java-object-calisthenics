package marsrover.rover;

import marsrover.position.*;
import marsrover.surface.*;
import java.io.PrintStream;

public class SouthRover extends Rover {
    private final Position position;
    private final Surface surface;

    public SouthRover(Position position, Surface surface) {
        this.position = position;
        this.surface = surface;
    }

    public SouthRover moveForward() {
         return surface.moveRoverIfFreeAt(position.increaseY(), this);
    }

    public WestRover turnRight() {
        return new WestRover(position, surface);
    }

    public void print(PrintStream out) {
        out.println();
        surface.print(out, this, position);
        out.println();
    }

    public void printRepresentation(PrintStream out, Position printPosition) {
        if (printPosition.equals(this.position)) {
            out.print("v");
        }
    }
}
