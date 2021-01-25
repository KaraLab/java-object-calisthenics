package marsrover.position;

import java.util.Objects;

public class Position {
    private final PositionSegment xPosition;
    private final PositionSegment yPosition;

    public Position(PositionSegment xPosition, PositionSegment yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public Position increaseX() {
        return new Position(xPosition.increase(), yPosition);
    }

    public Position increaseY() {
        return new Position(xPosition, yPosition.increase());
    }

    public Position decreaseX() {
        return new Position(xPosition.decrease(), yPosition);
    }

    public Position decreaseY() {
        return new Position(xPosition, yPosition.decrease());
    }

    @Override
    public int hashCode() {
        return Objects.hash(xPosition.hashCode(), yPosition.hashCode());
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) return true;
        if (!(object instanceof Position)) {
            return false;
        }

        Position positionObject = (Position) object;
        return xPosition.equals(positionObject.xPosition) &&
                yPosition.equals(positionObject.yPosition);
    }
}
