package nextMove;

import Types.Puzzle;
import createPieces.BinPieces;
import mask.DirectionMask;
import matching.FieldType;
import matching.FieldTypesBase;
import matching.Match;

import java.util.ArrayList;
import java.util.List;

public class Moves {
    BinPieces binPieces;
    FieldTypesBase fieldTypes;

    public Moves(BinPieces binPieces, FieldTypesBase fieldTypes) {
        this.binPieces = binPieces;
        this.fieldTypes = fieldTypes;
    }

    public List<Integer> genPieceMoves(Puzzle puzzle, int position) {
        List<Integer> piecesToUse = new ArrayList<>();
        int matchAgainstNorthMask = (binPieces.getBinPieceToPieceStr("A") << DirectionMask.SHIFT_NORTH);
        int matchAgainstEastMask = (binPieces.getBinPieceToPieceStr("A") << DirectionMask.SHIFT_EAST);
        int matchAgainstSouthMask = (binPieces.getBinPieceToPieceStr("A") << DirectionMask.SHIFT_SOUTH);
        int matchAgainstWestMask = (binPieces.getBinPieceToPieceStr("A") << DirectionMask.SHIFT_WEST);

        int piece = 0;

        FieldType fieldType = fieldTypes.fieldList.get(position);

        switch (fieldType) {
            case NW:
                matchAgainstEastMask = puzzle.getBret().get(position + 1);
                matchAgainstSouthMask = puzzle.getBret().get(position + 16);

                for (int i = 0; i < puzzle.getUnusedPieceLists().getCornersNW().size(); i++) {
                    if (Match.isMatching(puzzle.getUnusedPieceLists().getCornersNW().get(i),
                            matchAgainstNorthMask, matchAgainstEastMask, matchAgainstSouthMask, matchAgainstWestMask)) {
                        piecesToUse.add(puzzle.getUnusedPieceLists().getCornersNW().get(i));
                    }
                }
                return piecesToUse;
            case N:
                matchAgainstSouthMask = puzzle.getBret().get(position + 16);
                matchAgainstEastMask = puzzle.getBret().get(position + 1);
                matchAgainstWestMask = puzzle.getBret().get(position - 1);

                for (int i = 0; i < puzzle.getUnusedPieceLists().getBorderNorth().size(); i++) {
                    if (Match.isMatching(puzzle.getUnusedPieceLists().getBorderNorth().get(i),
                            matchAgainstNorthMask, matchAgainstEastMask, matchAgainstSouthMask, matchAgainstWestMask)) {
                        piecesToUse.add(puzzle.getUnusedPieceLists().getBorderNorth().get(i));
                    }
                }
                return piecesToUse;
            case NE:
                matchAgainstSouthMask = puzzle.getBret().get(position + 16);
                matchAgainstWestMask = puzzle.getBret().get(position - 1);

                for (int i = 0; i < puzzle.getUnusedPieceLists().getCornersNE().size(); i++) {
                    if (Match.isMatching(puzzle.getUnusedPieceLists().getCornersNE().get(i),
                            matchAgainstNorthMask, matchAgainstEastMask, matchAgainstSouthMask, matchAgainstWestMask)) {
                        piecesToUse.add(puzzle.getUnusedPieceLists().getCornersNE().get(i));
                    }
                }
                return piecesToUse;
            case W:
                matchAgainstSouthMask = puzzle.getBret().get(position + 16);
                matchAgainstEastMask = puzzle.getBret().get(position + 1);
                matchAgainstNorthMask = puzzle.getBret().get(position - 16);

                for (int i = 0; i < puzzle.getUnusedPieceLists().getBorderWest().size(); i++) {
                    if (Match.isMatching(puzzle.getUnusedPieceLists().getBorderWest().get(i),
                            matchAgainstNorthMask, matchAgainstEastMask, matchAgainstSouthMask, matchAgainstWestMask)) {
                        piecesToUse.add(puzzle.getUnusedPieceLists().getBorderWest().get(i));
                    }
                }
                return piecesToUse;
            case C:
                matchAgainstSouthMask = puzzle.getBret().get(position + 16);
                matchAgainstEastMask = puzzle.getBret().get(position + 1);
                matchAgainstWestMask = puzzle.getBret().get(position - 1);
                matchAgainstNorthMask = puzzle.getBret().get(position - 16);

                for (int i = 0; i < puzzle.getUnusedPieceLists().getNormal().size(); i++) {
                    if (Match.isMatching(puzzle.getUnusedPieceLists().getNormal().get(i),
                            matchAgainstNorthMask, matchAgainstEastMask, matchAgainstSouthMask, matchAgainstWestMask)) {
                        piecesToUse.add(puzzle.getUnusedPieceLists().getNormal().get(i));
                    }
                }
                return piecesToUse;
            case E:
                matchAgainstSouthMask = puzzle.getBret().get(position + 16);
                matchAgainstWestMask = puzzle.getBret().get(position - 1);
                matchAgainstNorthMask = puzzle.getBret().get(position - 16);

                for (int i = 0; i < puzzle.getUnusedPieceLists().getBorderEast().size(); i++) {
                    if (Match.isMatching(puzzle.getUnusedPieceLists().getBorderEast().get(i),
                            matchAgainstNorthMask, matchAgainstEastMask, matchAgainstSouthMask, matchAgainstWestMask)) {
                        piecesToUse.add(puzzle.getUnusedPieceLists().getBorderEast().get(i));
                    }
                }
                return piecesToUse;
            case SW:
                matchAgainstNorthMask = puzzle.getBret().get(position - 16);
                matchAgainstEastMask = puzzle.getBret().get(position + 1);

                for (int i = 0; i < puzzle.getUnusedPieceLists().getCornersSW().size(); i++) {
                    if (Match.isMatching(puzzle.getUnusedPieceLists().getCornersSW().get(i),
                            matchAgainstNorthMask, matchAgainstEastMask, matchAgainstSouthMask, matchAgainstWestMask)) {
                        piecesToUse.add(puzzle.getUnusedPieceLists().getCornersSW().get(i));
                    }
                }
                return piecesToUse;
            case S:
                matchAgainstEastMask = puzzle.getBret().get(position + 1);
                matchAgainstWestMask = puzzle.getBret().get(position - 1);
                matchAgainstNorthMask = puzzle.getBret().get(position - 16);

                for (int i = 0; i < puzzle.getUnusedPieceLists().getBorderSouth().size(); i++) {
                    if (Match.isMatching(puzzle.getUnusedPieceLists().getBorderSouth().get(i),
                            matchAgainstNorthMask, matchAgainstEastMask, matchAgainstSouthMask, matchAgainstWestMask)) {
                        piecesToUse.add(puzzle.getUnusedPieceLists().getBorderSouth().get(i));
                    }
                }
                return piecesToUse;
            case SE:
                matchAgainstNorthMask = puzzle.getBret().get(position - 16);
                matchAgainstWestMask = puzzle.getBret().get(position - 1);

                for (int i = 0; i < puzzle.getUnusedPieceLists().getCornersSE().size(); i++) {
                    if (Match.isMatching(puzzle.getUnusedPieceLists().getCornersSE().get(i),
                            matchAgainstNorthMask, matchAgainstEastMask, matchAgainstSouthMask, matchAgainstWestMask)) {
                        piecesToUse.add(puzzle.getUnusedPieceLists().getCornersSE().get(i));
                    }
                }
                return piecesToUse;
            case FIX_NW:
                piece = (binPieces.getBinPieceToPieceStr("L") << DirectionMask.SHIFT_NORTH)
                        | (binPieces.getBinPieceToPieceStr("W") << DirectionMask.SHIFT_EAST)
                        | (binPieces.getBinPieceToPieceStr("N") << DirectionMask.SHIFT_SOUTH)
                        | (binPieces.getBinPieceToPieceStr("M") << DirectionMask.SHIFT_WEST);
                piecesToUse.add(piece);
                return piecesToUse;
            case FIX_NE:
                piece = (binPieces.getBinPieceToPieceStr("W") << DirectionMask.SHIFT_NORTH) | (binPieces.getBinPieceToPieceStr("S") << DirectionMask.SHIFT_EAST)
                        | (binPieces.getBinPieceToPieceStr("W") << DirectionMask.SHIFT_SOUTH) | binPieces.getBinPieceToPieceStr("U");
                piecesToUse.add(piece);
                return piecesToUse;
            case FIX_C:
                piece = (binPieces.getBinPieceToPieceStr("I") << DirectionMask.SHIFT_NORTH) | (binPieces.getBinPieceToPieceStr("J") << DirectionMask.SHIFT_EAST)
                        | (binPieces.getBinPieceToPieceStr("J") << DirectionMask.SHIFT_SOUTH) | binPieces.getBinPieceToPieceStr("M");
                piecesToUse.add(piece);
                return piecesToUse;
            case FIX_SW:
                piece = (binPieces.getBinPieceToPieceStr("V") << DirectionMask.SHIFT_NORTH) | (binPieces.getBinPieceToPieceStr("M") << DirectionMask.SHIFT_EAST)
                        | (binPieces.getBinPieceToPieceStr("U") << DirectionMask.SHIFT_SOUTH) | binPieces.getBinPieceToPieceStr("J");
                piecesToUse.add(piece);
                return piecesToUse;
            case FIX_SE:
                piece = (binPieces.getBinPieceToPieceStr("Q") << DirectionMask.SHIFT_NORTH) | (binPieces.getBinPieceToPieceStr("V") << DirectionMask.SHIFT_EAST)
                        | (binPieces.getBinPieceToPieceStr("P") << DirectionMask.SHIFT_SOUTH) | binPieces.getBinPieceToPieceStr("R");
                piecesToUse.add(piece);
                return piecesToUse;
        }

        return piecesToUse;
    }

}
