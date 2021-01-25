package marsrover.surface;

import java.util.Random;

class SurfaceObjectCreator {
    SurfaceObject create() {
        SurfaceObject surfaceObject;
        Random r = new Random();
        surfaceObject = new FreeSurfaceObject();
        if (r.nextDouble() < 0.25) {
            surfaceObject = new ObstacleSurfaceObject();
        }
        return surfaceObject;
    }

    SurfaceObject createFreeSpace() {
        return new FreeSurfaceObject();
    }
}
