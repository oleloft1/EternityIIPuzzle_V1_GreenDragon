package createPieces;

import mask.DirectionMask;

import java.util.ArrayList;
import java.util.List;

public class PieceAnalysis {

    BinPieces binPieces;

    public PieceAnalysis(BinPieces binPieces) {
        this.binPieces = binPieces;
    }

    /**
     * From a list of pieces this method will find all pieces matching corner NorthWest
     * @param piecesList
     * @return
     */
    public List<Integer> getAllCornerNW(List<Integer> piecesList) {
        int mask = (this.binPieces.getBinPieceToPieceStr("A") << DirectionMask.SHIFT_NORTH) | (this.binPieces.getBinPieceToPieceStr("A") << DirectionMask.SHIFT_WEST);
        int deleteMask = ~(DirectionMask.getMaskSouth() | DirectionMask.getMaskEast());

        return getAllMatchingPiecesToMask(deleteMask, mask, piecesList);
    }

    /**
     * From a list of pieces this method will find all pieces matching corner NorthEast
     * @param piecesList
     * @return
     */
    public List<Integer> getAllCornerNE(List<Integer> piecesList) {
        int mask = (this.binPieces.getBinPieceToPieceStr("A") << DirectionMask.SHIFT_NORTH) | (this.binPieces.getBinPieceToPieceStr("A") << DirectionMask.SHIFT_EAST);
        int deleteMask = ~(DirectionMask.getMaskWest() | DirectionMask.getMaskSouth());

        return getAllMatchingPiecesToMask(deleteMask, mask, piecesList);
    }

    /**
     * From a list of pieces this method will find all pieces matching corner SouthEast
     * @param piecesList
     * @return
     */
    public List<Integer> getAllCornerSE(List<Integer> piecesList) {
        int mask = (this.binPieces.getBinPieceToPieceStr("A") << DirectionMask.SHIFT_SOUTH) | (this.binPieces.getBinPieceToPieceStr("A") << DirectionMask.SHIFT_EAST);
        int deleteMask = ~(DirectionMask.getMaskNorth() | DirectionMask.getMaskWest());

        return getAllMatchingPiecesToMask(deleteMask, mask, piecesList);
    }

    /**
     * From a list of pieces this method will find all pieces matching corner SouthWest
     * @param piecesList
     * @return
     */
    public List<Integer> getAllCornerSW(List<Integer> piecesList) {
        int mask = (this.binPieces.getBinPieceToPieceStr("A") << DirectionMask.SHIFT_SOUTH) | (this.binPieces.getBinPieceToPieceStr("A") << DirectionMask.SHIFT_WEST);
        int deleteMask = ~(DirectionMask.getMaskNorth() | DirectionMask.getMaskEast());

        return getAllMatchingPiecesToMask(deleteMask, mask, piecesList);
    }

    /**
     * From a list of pieces this method will find all pieces matching North
     * @param piecesList
     * @return
     */
    public List<Integer> getAllBorderNorth(List<Integer> piecesList) {
        int mask = (this.binPieces.getBinPieceToPieceStr("A") << DirectionMask.SHIFT_NORTH);
        int deleteMask = ~(DirectionMask.getMaskWest() | DirectionMask.getMaskSouth() | DirectionMask.getMaskEast());

        List<Integer> allMatching = getAllMatchingPiecesToMask(deleteMask, mask, piecesList);

        List<Integer> cornerNE = getAllCornerNE(piecesList);
        List<Integer> cornerNW = getAllCornerNW(piecesList);

        List<Integer> removedUsedPiece1 = removeUsedPieces(allMatching, cornerNE);
        return removeUsedPieces(removedUsedPiece1, cornerNW);
    }

    /**
     * From a list of pieces this method will find all pieces matching East
     * @param piecesList
     * @return
     */
    public List<Integer> getAllBorderEast(List<Integer> piecesList) {
        int mask = (this.binPieces.getBinPieceToPieceStr("A") << DirectionMask.SHIFT_EAST);
        int deleteMask = ~(DirectionMask.getMaskWest() | DirectionMask.getMaskSouth() | DirectionMask.getMaskNorth());

        List<Integer> allMatching = getAllMatchingPiecesToMask(deleteMask, mask, piecesList);

        List<Integer> cornerNE = getAllCornerNE(piecesList);
        List<Integer> cornerSE = getAllCornerSE(piecesList);

        List<Integer> removedUsedPiece1 = removeUsedPieces(allMatching, cornerNE);
        return removeUsedPieces(removedUsedPiece1, cornerSE);
    }

    /**
     * From a list of pieces this method will find all pieces matching South
     * @param piecesList
     * @return
     */
    public List<Integer> getAllBorderSouth(List<Integer> piecesList) {
        int mask = (this.binPieces.getBinPieceToPieceStr("A") << DirectionMask.SHIFT_SOUTH);
        int deleteMask = ~(DirectionMask.getMaskWest() | DirectionMask.getMaskEast() | DirectionMask.getMaskNorth());

        List<Integer> allMatching = getAllMatchingPiecesToMask(deleteMask, mask, piecesList);

        List<Integer> cornerSW = getAllCornerSW(piecesList);
        List<Integer> cornerSE = getAllCornerSE(piecesList);

        List<Integer> removedUsedPiece1 = removeUsedPieces(allMatching, cornerSW);
        return removeUsedPieces(removedUsedPiece1, cornerSE);
    }

    /**
     * From a list of pieces this method will find all pieces matching West
     * @param piecesList
     * @return
     */
    public List<Integer> getAllBorderWest(List<Integer> piecesList) {
        int mask = (this.binPieces.getBinPieceToPieceStr("A") << DirectionMask.SHIFT_WEST);
        int deleteMask = ~(DirectionMask.getMaskSouth() | DirectionMask.getMaskEast() | DirectionMask.getMaskNorth());

        List<Integer> allMatching = getAllMatchingPiecesToMask(deleteMask, mask, piecesList);

        List<Integer> cornerSW = getAllCornerSW(piecesList);
        List<Integer> cornerNW = getAllCornerNW(piecesList);

        List<Integer> removedUsedPiece1 = removeUsedPieces(allMatching, cornerSW);
        return removeUsedPieces(removedUsedPiece1, cornerNW);
    }

    /**
     * From a list of pieces this method will find all Normal pieces
     * @param piecesList
     * @return
     */
    public List<Integer> getAllNormal(List<Integer> piecesList) {
        List<Integer> cornerNE = getAllCornerNE(piecesList);
        List<Integer> cornerNW = getAllCornerNW(piecesList);
        List<Integer> cornerSE = getAllCornerSE(piecesList);
        List<Integer> cornerSW = getAllCornerSW(piecesList);

        List<Integer> borderNorth = getAllBorderNorth(piecesList);
        List<Integer> borderEast = getAllBorderEast(piecesList);
        List<Integer> borderSouth = getAllBorderSouth(piecesList);
        List<Integer> borderWest = getAllBorderWest(piecesList);

        List<Integer> removedUsedPiece1 = removeUsedPieces(piecesList, cornerNE);
        List<Integer> removedUsedPiece2 = removeUsedPieces(removedUsedPiece1, cornerNW);
        List<Integer> removedUsedPiece3 = removeUsedPieces(removedUsedPiece2, cornerSE);
        List<Integer> removedUsedPiece4 = removeUsedPieces(removedUsedPiece3, cornerSW);

        List<Integer> removedUsedPiece5 = removeUsedPieces(removedUsedPiece4, borderNorth);
        List<Integer> removedUsedPiece6 = removeUsedPieces(removedUsedPiece5, borderEast);
        List<Integer> removedUsedPiece7 = removeUsedPieces(removedUsedPiece6, borderSouth);

        return removeUsedPieces(removedUsedPiece7, borderWest);
    }

    private List<Integer> removeUsedPieces(List<Integer> fullList, List<Integer> removeFromList) {
        List<Integer> returnList = new ArrayList<>();

        for (int i = 0; i < fullList.size() -1; i++) {
            if (!piecesInList(fullList.get(i), removeFromList)) {
                returnList.add(fullList.get(i));
            }
        }

        return returnList;
    }

    private boolean piecesInList(int piece, List<Integer> pieceList) {
        for (int i = 0; i < pieceList.size() -1; i++) {
            if (pieceList.get(i) == piece) {
                return true;
            }
        }

        return false;
    }


//    /**
//     * From a list of pieces this method will find all special pieces
//     * @param piecesList
//     * @return
//     */
//    public List<Integer> getAllSpecial(List<Integer> piecesList) { // TODO
//        return new ArrayList<>();
//    }

    private List<Integer> getAllMatchingPiecesToMask(int deleteMask, int mask, List<Integer> piecesList) {
        List<Integer> cornerPieces = new ArrayList<>();

        for (Integer current : piecesList) {
            int pieceMask = current & deleteMask;

            if (mask == pieceMask) {
                cornerPieces.add(current);
            }
        }

        return cornerPieces;
    }

}
