package marsrover.surface;

import marsrover.position.Position;
import marsrover.position.PositionSegment;

import java.util.AbstractMap;
import java.util.HashMap;

public class SurfaceCreator {
    public HashMap<Position, SurfaceObject> create(PositionSegment maxXValue, PositionSegment maxYValue, Position roverPosition) {
        HashMap<Position, SurfaceObject> surface = new HashMap<>();
        int i = 0;
        while (!(new PositionSegment(i).equals(maxXValue))) {
            putObstaclesInRow(surface, i, maxYValue, roverPosition);
            i++;
        }
        return surface;
    }

    private void putObstaclesInRow(HashMap<Position, SurfaceObject> surface, int i, PositionSegment maxYValue, Position roverPosition) {
        int j = 0;
        while (!(new PositionSegment(j).equals(maxYValue))) {
            HashMap.Entry<Position, SurfaceObject> entry =
                    randomObstacleTo(new Position(new PositionSegment(i), new PositionSegment(j)), roverPosition);
            surface.put(entry.getKey(), entry.getValue());
            j++;
        }
    }

    private HashMap.Entry<Position, SurfaceObject> randomObstacleTo(Position position, Position roverPosition) {
        SurfaceObjectCreator creator = new SurfaceObjectCreator();
        if ((position.equals(roverPosition))) {
            return new AbstractMap.SimpleEntry<>(position, creator.createFreeSpace());
        }
        return new AbstractMap.SimpleEntry<>(position, creator.create());
    }
}
