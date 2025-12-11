package search;

import Types.Puzzle;
import createPieces.BinPieces;
import displays.Display;
import displays.Statistics;
import matching.FieldTypesBase;
import nextMove.Moves;
import sequence.PieceSequence;

import java.util.List;

public class Search {
//    final OldSearchSequence searchSequence = new OldSearchSequence();
    PieceSequence searchSequence;

    Statistics statistics;
    Moves moves;

    private BinPieces binPieces;
    private Display display;

    private Puzzle bestPuzzle = null;
    private List<Integer> searchSequenceList;

    public void solvePuzzle(Puzzle puzzle, BinPieces binPieces, PieceSequence pieceSequence, FieldTypesBase fieldTypes) {
        this.searchSequence = pieceSequence;
        this.binPieces = binPieces;
        display = new Display(binPieces);
        moves = new Moves(binPieces, fieldTypes);
        statistics = new Statistics(binPieces);

        bestPuzzle = puzzle.copy();

        makeSearch(puzzle, 0);
    }

    public void makeSearch(Puzzle currentPuzzle, int depth) {
        statistics.incNodeCount();

        if (currentPuzzle.getUnusedPieceLists().getSize() == 0) {
            System.out.println("!!! Puzzle solved !!!");
            display.makeUrl(currentPuzzle);
            System.exit(1);
        } else {
            if (currentPuzzle.getUnusedPieceLists().getSize() < bestPuzzle.getUnusedPieceLists().getSize()) {
                System.out.println(depth + " We have a new best but still running:");
                display.makeUrl(currentPuzzle);
                bestPuzzle = currentPuzzle.copy();
                statistics.newPieceAdded();
            }
        }

        int fieldPosition = searchSequence.getSequenceToNo(depth);

        List<Integer> piecesToPlace = moves.genPieceMoves(currentPuzzle, fieldPosition);

        for (Integer currentPiece : piecesToPlace) { // All possible moves
            Puzzle newPuzzle = currentPuzzle.copy();
            newPuzzle.getUnusedPieceLists().removePieceFromList(currentPiece, fieldPosition);
            newPuzzle.getBret().put(fieldPosition, currentPiece);

            makeSearch(newPuzzle, depth + 1);

            statistics.showStatistics(currentPuzzle, bestPuzzle);
        }
    }

    private boolean isIllegal(Puzzle currentPuzzle) {
        for (int i = 0; i < 256; i++) {
            List<Integer> pieces = moves.genPieceMoves(currentPuzzle, i);
            if (pieces.size() == 0) {
                return true;
            }
        }

        return false;
    }
}
