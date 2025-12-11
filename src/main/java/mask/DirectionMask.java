package mask;

public class DirectionMask {
    public final static int SHIFT_NORTH = 24;
    public final static int SHIFT_EAST = 16;
    public final static int SHIFT_SOUTH = 8;
    public final static int SHIFT_WEST = 0;

    private final static int MASK_NORTH = (255 << SHIFT_NORTH);
    private final static int MASK_EAST = (255 << SHIFT_EAST);
    private final static int MASK_SOUTH = (255 << SHIFT_SOUTH);
    private final static int MASK_WEST = (255 << SHIFT_WEST);

    public static int getMaskNorth() {
        return MASK_NORTH;
    }

    public static int getMaskEast() {
        return MASK_EAST;
    }

    public static int getMaskSouth() {
        return MASK_SOUTH;
    }

    public static int getMaskWest() {
        return MASK_WEST;
    }

}
