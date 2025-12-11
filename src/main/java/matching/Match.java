package matching;

import mask.DirectionMask;

public class Match {

    public static boolean isMatching(int piece, int pieceMatchNorth, int pieceMatchEast, int pieceMatchSouth, int pieceMatchWest) {
        int pieceNorth = ((piece & DirectionMask.getMaskNorth()) >> DirectionMask.SHIFT_NORTH);
        int pieceEast =  ((piece & DirectionMask.getMaskEast()) >> DirectionMask.SHIFT_EAST);
        int pieceSouth = ((piece & DirectionMask.getMaskSouth()) >> DirectionMask.SHIFT_SOUTH);
        int pieceWest =  ((piece & DirectionMask.getMaskWest()) >> DirectionMask.SHIFT_WEST);

        int matchNorth = ((pieceMatchNorth & DirectionMask.getMaskSouth()) >> DirectionMask.SHIFT_SOUTH);
        int matchEast = ((pieceMatchEast & DirectionMask.getMaskWest()) >> DirectionMask.SHIFT_WEST);
        int matchSouth = ((pieceMatchSouth & DirectionMask.getMaskNorth()) >> DirectionMask.SHIFT_NORTH);
        int matchWest = ((pieceMatchWest & DirectionMask.getMaskEast()) >> DirectionMask.SHIFT_EAST);

        if (matchNorth != 0) {
            if (pieceNorth != matchNorth) {
               return false;
            }
        }
        if (matchEast != 0) {
            if (pieceEast != matchEast) {
                return false;
            }
        }
        if (matchSouth != 0) {
            if (pieceSouth != matchSouth) {
                return false;
            }
        }
        if (matchWest != 0) {
            if (pieceWest != matchWest) {
                return false;
            }
        }

        return true;
    }
}
