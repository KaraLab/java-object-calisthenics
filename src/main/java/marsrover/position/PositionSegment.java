package marsrover.position;

import java.util.Objects;

public class PositionSegment {
    private final int positionSegment;

    public PositionSegment(int positionSegment) {
        this.positionSegment = positionSegment;
    }

    PositionSegment increase() {
        return new PositionSegment(positionSegment + 1);
    }

    PositionSegment decrease() {
        return new PositionSegment(positionSegment - 1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionSegment);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PositionSegment)) {
            return false;
        }
        return ((PositionSegment) object).positionSegment == positionSegment;
    }
}
