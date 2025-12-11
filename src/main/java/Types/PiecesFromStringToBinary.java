package Types;

import mask.DirectionMask;

import java.util.HashMap;
import java.util.Objects;

public class PiecesFromStringToBinary {

    HashMap<String, Integer> stringToBinMap = new HashMap<>();
    int pieceNo = 0;

    /**
     * Add a piece to the system
     *
     * @param pieceStr is a string containing a char
     * @param pieceBin is the binary representation og the pieceStr
     */
    public void addPieceStrAndPieceValue(String pieceStr, int pieceBin) {
        if (!stringToBinMap.containsKey(pieceStr)) {
            stringToBinMap.put(pieceStr, pieceBin);
        }
    }

    /**
     * Finds the binary representation of a char
     *
     * @param pieceStr A string with a char
     * @return binary
     */
    public int getBinPieceToPieceStr(String pieceStr) {
        if (stringToBinMap.containsKey(pieceStr)) {
            return stringToBinMap.get(pieceStr);
        }

        return 0;
    }

    /**
     * Get the char(String) to the matching binary value
     *
     * @param value a binary value
     * @return a char(String)
     */
    public String getPieceStrToPieceBin(int value) {
        for (String key : stringToBinMap.keySet()) {
            if (Objects.equals(stringToBinMap.get(key), value)) {
                return key; //return the first found
            }
        }
        return "";
    }

    /**
     * This will add a piece to the system
     *
     * @param pieceStr the piece "ABCD"
     * @return a binary containing all pieces
     */
    public int addPiece(String pieceStr) {
        createBin(pieceStr.substring(0, 1));
        createBin(pieceStr.substring(1, 2));
        createBin(pieceStr.substring(2, 3));
        createBin(pieceStr.substring(3, 4));

        return (getBinPieceToPieceStr(pieceStr.substring(0, 1)) << DirectionMask.SHIFT_NORTH) |
                (getBinPieceToPieceStr(pieceStr.substring(1, 2)) << DirectionMask.SHIFT_EAST) |
                (getBinPieceToPieceStr(pieceStr.substring(2, 3)) << DirectionMask.SHIFT_SOUTH) |
                (getBinPieceToPieceStr(pieceStr.substring(3, 4)));
    }

    /**
     * Finds the binary value to a piece "ABCD"
     *
     * @param pieceStr piece
     * @return binary
     */
    public int getBinValueToPiece(String pieceStr) {
        return (getBinPieceToPieceStr(pieceStr.substring(0, 1)) << DirectionMask.SHIFT_NORTH) |
                (getBinPieceToPieceStr(pieceStr.substring(1, 2)) << DirectionMask.SHIFT_EAST) |
                (getBinPieceToPieceStr(pieceStr.substring(2, 3)) << DirectionMask.SHIFT_SOUTH) |
                (getBinPieceToPieceStr(pieceStr.substring(3, 4)));
    }

    private void createBin(String pieceStr) {
        if (!stringToBinMap.containsKey(pieceStr.substring(0, 1))) {
            pieceNo = pieceNo + 1;
            this.addPieceStrAndPieceValue(pieceStr.substring(0, 1), pieceNo);
        }
    }

    /**
     * Finds the full binary value to a piece "ABCD"
     *
     * @param piece
     * @return binary value
     */
    public String getPieceToPieceStr(int piece) {
        int north = (DirectionMask.getMaskNorth() & piece) >> DirectionMask.SHIFT_NORTH;
        String northPieceStr = this.getPieceStrToPieceBin(north);

        int east = (DirectionMask.getMaskEast() & piece) >> DirectionMask.SHIFT_EAST;
        String eastPieceStr = this.getPieceStrToPieceBin(east);

        int south = (DirectionMask.getMaskSouth() & piece) >> DirectionMask.SHIFT_SOUTH;
        String southPieceStr = this.getPieceStrToPieceBin(south);

        int west = (DirectionMask.getMaskWest() & piece) >> DirectionMask.SHIFT_WEST;
        String westPieceStr = this.getPieceStrToPieceBin(west);

        return northPieceStr + eastPieceStr + southPieceStr + westPieceStr;
    }
}
