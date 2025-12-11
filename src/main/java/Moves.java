import Types.Puzzle;
import createPieces.BinPieces;
import mask.DirectionMask;
import matching.Match;

import java.util.ArrayList;
import java.util.List;

public class Moves {
    BinPieces binPieces;

    public Moves(BinPieces binPieces) {
        this.binPieces = binPieces;
    }

    public List<Integer> genPieceMoves(Puzzle puzzle, int position) {
        List<Integer> piecesToUse = new ArrayList<>();
        int matchAgainstNorthMask = (binPieces.getBinPieceToPieceStr("A") << DirectionMask.SHIFT_NORTH);
        int matchAgainstEastMask = (binPieces.getBinPieceToPieceStr("A") << DirectionMask.SHIFT_EAST);
        int matchAgainstSouthMask = (binPieces.getBinPieceToPieceStr("A") << DirectionMask.SHIFT_SOUTH);
        int matchAgainstWestMask = (binPieces.getBinPieceToPieceStr("A") << DirectionMask.SHIFT_WEST);

//        if (position == 34) {
//            int piece = (binPieces.getBinPieceToPieceStr("L") << DirectionMask.SHIFT_NORTH)
//                      | (binPieces.getBinPieceToPieceStr("W") << DirectionMask.SHIFT_EAST)
//                      | (binPieces.getBinPieceToPieceStr("N") <<  DirectionMask.SHIFT_SOUTH)
//                      | (binPieces.getBinPieceToPieceStr("M") <<  DirectionMask.SHIFT_WEST);
//            piecesToUse.add(piece);
//            return piecesToUse;
//
////            int piece = (binPieces.getBinPieceToPieceStr("M") << DirectionMask.SHIFT_NORTH) | (binPieces.getBinPieceToPieceStr("N") << DirectionMask.SHIFT_EAST)
////                    | (binPieces.getBinPieceToPieceStr("W") <<  DirectionMask.SHIFT_SOUTH) | binPieces.getBinPieceToPieceStr("L");
////            piecesToUse.add(piece);
////            return piecesToUse;
//        }
//        if (position == 210) {
//            int piece = (binPieces.getBinPieceToPieceStr("V") << DirectionMask.SHIFT_NORTH) | (binPieces.getBinPieceToPieceStr("M") << DirectionMask.SHIFT_EAST)
//                    | (binPieces.getBinPieceToPieceStr("U") <<  DirectionMask.SHIFT_SOUTH) | binPieces.getBinPieceToPieceStr("J");
//            piecesToUse.add(piece);
//            return piecesToUse;
//        }
//        if (position == 45) {
//            int piece = (binPieces.getBinPieceToPieceStr("W") << DirectionMask.SHIFT_NORTH) | (binPieces.getBinPieceToPieceStr("S") << DirectionMask.SHIFT_EAST)
//                    | (binPieces.getBinPieceToPieceStr("W") <<  DirectionMask.SHIFT_SOUTH) | binPieces.getBinPieceToPieceStr("U");
//            piecesToUse.add(piece);
//            return piecesToUse;
//        }
//        if (position == 221) {
//            int piece = (binPieces.getBinPieceToPieceStr("Q") << DirectionMask.SHIFT_NORTH) | (binPieces.getBinPieceToPieceStr("V") << DirectionMask.SHIFT_EAST)
//                    | (binPieces.getBinPieceToPieceStr("P") <<  DirectionMask.SHIFT_SOUTH) | binPieces.getBinPieceToPieceStr("R");
//            piecesToUse.add(piece);
//            return piecesToUse;
//        }
//        if (position == 135) {
//            int piece = (binPieces.getBinPieceToPieceStr("I") << DirectionMask.SHIFT_NORTH) | (binPieces.getBinPieceToPieceStr("J") << DirectionMask.SHIFT_EAST)
//                    | (binPieces.getBinPieceToPieceStr("J") <<  DirectionMask.SHIFT_SOUTH) | binPieces.getBinPieceToPieceStr("M");
//            piecesToUse.add(piece);
//            return piecesToUse;
//        }

        // Corner Pieces
        if (position == 0) {
            matchAgainstEastMask = puzzle.getBret().get(position+1);
            matchAgainstSouthMask = puzzle.getBret().get(position+16);

            for (int i = 0; i < puzzle.getUnusedPieceLists().getCornersNW().size(); i++) {
                if (Match.isMatching(puzzle.getUnusedPieceLists().getCornersNW().get(i),
                        matchAgainstNorthMask, matchAgainstEastMask, matchAgainstSouthMask, matchAgainstWestMask)) {
                    piecesToUse.add(puzzle.getUnusedPieceLists().getCornersNW().get(i));
                }
            }
            return piecesToUse;
        }

        if (position == 15) {
            matchAgainstSouthMask = puzzle.getBret().get(position+16);
            matchAgainstWestMask = puzzle.getBret().get(position-1);

            for (int i = 0; i < puzzle.getUnusedPieceLists().getCornersNE().size(); i++) {
                if (Match.isMatching(puzzle.getUnusedPieceLists().getCornersNE().get(i),
                        matchAgainstNorthMask, matchAgainstEastMask, matchAgainstSouthMask, matchAgainstWestMask)) {
                    piecesToUse.add(puzzle.getUnusedPieceLists().getCornersNE().get(i));
                }
            }
            return piecesToUse;
        }

        if (position == 240) {
            matchAgainstNorthMask = puzzle.getBret().get(position-16);
            matchAgainstEastMask = puzzle.getBret().get(position+1);

            for (int i = 0; i < puzzle.getUnusedPieceLists().getCornersSW().size(); i++) {
                if (Match.isMatching(puzzle.getUnusedPieceLists().getCornersSW().get(i),
                        matchAgainstNorthMask, matchAgainstEastMask, matchAgainstSouthMask, matchAgainstWestMask)) {
                    piecesToUse.add(puzzle.getUnusedPieceLists().getCornersSW().get(i));
                }
            }
            return piecesToUse;
        }

        if (position == 255) {
            matchAgainstNorthMask = puzzle.getBret().get(position-16);
            matchAgainstWestMask = puzzle.getBret().get(position-1);

            for (int i = 0; i < puzzle.getUnusedPieceLists().getCornersSE().size(); i++) {
                if (Match.isMatching(puzzle.getUnusedPieceLists().getCornersSE().get(i),
                        matchAgainstNorthMask, matchAgainstEastMask, matchAgainstSouthMask, matchAgainstWestMask)) {
                    piecesToUse.add(puzzle.getUnusedPieceLists().getCornersSE().get(i));
                }
            }
            return piecesToUse;
        }

        if ((position > 0) && (position < 16)) {
            matchAgainstSouthMask = puzzle.getBret().get(position+16);
            matchAgainstEastMask = puzzle.getBret().get(position+1);
            matchAgainstWestMask = puzzle.getBret().get(position-1);

            for (int i = 0; i < puzzle.getUnusedPieceLists().getBorderNorth().size(); i++) {
                if (Match.isMatching(puzzle.getUnusedPieceLists().getBorderNorth().get(i),
                        matchAgainstNorthMask, matchAgainstEastMask, matchAgainstSouthMask, matchAgainstWestMask)) {
                    piecesToUse.add(puzzle.getUnusedPieceLists().getBorderNorth().get(i));
                }
            }
            return piecesToUse;
        }

        if ((position == 16) ||
                (position == 32) ||
                (position == 48) ||
                (position == 64) ||
                (position == 80) ||
                (position == 96) ||
                (position == 112) ||
                (position == 128) ||
                (position == 144) ||
                (position == 160) ||
                (position == 176) ||
                (position == 192) ||
                (position == 208) ||
                (position == 224)) {
            matchAgainstSouthMask = puzzle.getBret().get(position+16);
            matchAgainstEastMask = puzzle.getBret().get(position+1);
            matchAgainstNorthMask = puzzle.getBret().get(position-16);

            for (int i = 0; i < puzzle.getUnusedPieceLists().getBorderWest().size(); i++) {
                if (Match.isMatching(puzzle.getUnusedPieceLists().getBorderWest().get(i),
                        matchAgainstNorthMask, matchAgainstEastMask, matchAgainstSouthMask, matchAgainstWestMask)) {
                    piecesToUse.add(puzzle.getUnusedPieceLists().getBorderWest().get(i));
                }
            }
            return piecesToUse;
        }

        if ((position == 31) ||
                (position == 47) ||
                (position == 63) ||
                (position == 79) ||
                (position == 95) ||
                (position == 111) ||
                (position == 127) ||
                (position == 143) ||
                (position == 159) ||
                (position == 175) ||
                (position == 191) ||
                (position == 207) ||
                (position == 223) ||
                (position == 239)) {
            matchAgainstSouthMask = puzzle.getBret().get(position+16);
            matchAgainstWestMask = puzzle.getBret().get(position-1);
            matchAgainstNorthMask = puzzle.getBret().get(position-16);

            for (int i = 0; i < puzzle.getUnusedPieceLists().getBorderEast().size(); i++) {
                if (Match.isMatching(puzzle.getUnusedPieceLists().getBorderEast().get(i),
                        matchAgainstNorthMask, matchAgainstEastMask, matchAgainstSouthMask, matchAgainstWestMask)) {
                    piecesToUse.add(puzzle.getUnusedPieceLists().getBorderEast().get(i));
                }
            }
            return piecesToUse;
        }

        if ((position > 240) && (position < 255)) {
            matchAgainstEastMask = puzzle.getBret().get(position+1);
            matchAgainstWestMask = puzzle.getBret().get(position-1);
            matchAgainstNorthMask = puzzle.getBret().get(position-16);

            for (int i = 0; i < puzzle.getUnusedPieceLists().getBorderSouth().size(); i++) {
                if (Match.isMatching(puzzle.getUnusedPieceLists().getBorderSouth().get(i),
                        matchAgainstNorthMask, matchAgainstEastMask, matchAgainstSouthMask, matchAgainstWestMask)) {
                    piecesToUse.add(puzzle.getUnusedPieceLists().getBorderSouth().get(i));
                }
            }
            return piecesToUse;
        }

        matchAgainstSouthMask = puzzle.getBret().get(position+16);
        matchAgainstEastMask = puzzle.getBret().get(position+1);
        matchAgainstWestMask = puzzle.getBret().get(position-1);
        matchAgainstNorthMask = puzzle.getBret().get(position-16);

        for (int i = 0; i < puzzle.getUnusedPieceLists().getNormal().size(); i++) {
            if (Match.isMatching(puzzle.getUnusedPieceLists().getNormal().get(i),
                    matchAgainstNorthMask, matchAgainstEastMask, matchAgainstSouthMask, matchAgainstWestMask)) {
                piecesToUse.add(puzzle.getUnusedPieceLists().getNormal().get(i));
            }
        }


        return piecesToUse;
    }

//    private String getBinAsStr(int piece) {
//        int position = 1;
//        String pieceStr = "";
//
//        for (int i = 0; i < 32; i++) {
//           if ((piece & position) == position) {
//               pieceStr ="1" + pieceStr;
//           } else {
//               pieceStr ="0" + pieceStr;
//           }
//           position = position << 1;
//
//            if (i == 7) {
//                pieceStr =" " + pieceStr;
//            }
//            if (i == 15) {
//                pieceStr =" " + pieceStr;
//            }
//            if (i == 23) {
//                pieceStr =" " + pieceStr;
//            }
//        }
//
//        return pieceStr;
//    }
}
