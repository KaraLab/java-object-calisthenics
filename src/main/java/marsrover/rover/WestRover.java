package marsrover.rover;

import marsrover.position.*;
import marsrover.surface.*;
import java.io.PrintStream;

public class WestRover extends Rover {
    private final Position position;
    private final Surface surface;

    public WestRover(Position position, Surface surface) {
        this.position = position;
        this.surface = surface;
    }

    public WestRover moveForward() {
        Position positionNew = position.decreaseX();
        if(surface.isFree(positionNew)) {
            return new WestRover(positionNew, this.surface);
        }
        return this;
    }

    public NorthRover turnRight() {
        return new NorthRover(position, surface);
    }

    public void print(PrintStream out) {
        out.println();
        surface.print(out, this, position);
        out.println();
    }

    public void printRepresentation(PrintStream out, Position printPosition) {
        if (printPosition.equals(this.position)) {
            out.print("<");
        }
    }
}
