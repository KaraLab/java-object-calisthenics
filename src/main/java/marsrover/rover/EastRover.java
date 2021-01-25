package marsrover.rover;

import marsrover.position.*;
import marsrover.surface.*;
import java.io.PrintStream;

public class EastRover extends Rover {
    private final Position position;
    private final Surface surface;

    public EastRover(Position position, Surface surface) {
        this.position = position;
        this.surface = surface;
    }

    public EastRover moveForward() {
        return surface.moveRoverIfFreeAt(position.increaseX(), this);
    }

    public SouthRover turnRight() {
        return new SouthRover(position, surface);
    }

    public void print(PrintStream out) {
        out.println();
        surface.print(out, this, position);
        out.println();
    }

    public void printRepresentation(PrintStream out, Position printPosition) {
        if (printPosition.equals(this.position)) {
            out.print(">");
        }
    }
}
