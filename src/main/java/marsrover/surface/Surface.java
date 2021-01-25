package marsrover.surface;

import marsrover.position.*;
import marsrover.rover.*;

import java.io.PrintStream;
import java.util.HashMap;

public class Surface {
    private final HashMap<Position, SurfaceObject> surfaceMap;

    public Surface(HashMap<Position, SurfaceObject> surfaceMap) {
        this.surfaceMap = surfaceMap;
    }

    public NorthRover moveRoverIfFreeAt(Position position, NorthRover rover) {
        if (surfaceMap.get(position) instanceof FreeSurfaceObject) {
            return new NorthRover(position, this);
        }
        return rover;
    }

    public EastRover moveRoverIfFreeAt(Position position, EastRover rover) {
        if (surfaceMap.get(position) instanceof FreeSurfaceObject) {
            return new EastRover(position, this);
        }
        return rover;
    }

    public SouthRover moveRoverIfFreeAt(Position position, SouthRover rover) {
        if (surfaceMap.get(position) instanceof FreeSurfaceObject) {
            return new SouthRover(position, this);
        }
        return rover;
    }

    public WestRover moveRoverIfFreeAt(Position position, WestRover rover) {
        if (surfaceMap.get(position) instanceof FreeSurfaceObject) {
            return new WestRover(position, this);
        }
        return rover;
    }

    public void print(PrintStream out, Rover rover, Position roverPosition) {
        int i = 0;
        while (surfaceMap.containsKey(new Position(new PositionSegment(0), new PositionSegment(i)))) {
            printRow(out, i, rover, roverPosition);
            out.println();
            i++;
        }
    }

    private void printRow(PrintStream out, int row, Rover rover, Position roverPosition) {
        int j = 0;
        while (surfaceMap.containsKey(new Position(new PositionSegment(j), new PositionSegment(row)))) {
            Position printPosition = new Position(new PositionSegment(j), new PositionSegment(row));
            printSurface(out, roverPosition, printPosition);
            rover.printRepresentation(out, printPosition);
            j++;
        }
    }

    private void printSurface(PrintStream out, Position roverPosition, Position printPosition) {
        if (!(printPosition.equals(roverPosition))) {
            SurfaceObject printObject = surfaceMap.get(printPosition);
            printObject.print(out);
        }
    }
}
