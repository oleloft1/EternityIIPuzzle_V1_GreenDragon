package createPieces;

import Types.UnusedPieceLists;

import java.util.ArrayList;
import java.util.List;

public class PieceFormatter {

    public BinPieces binPieces;

    public BinPieces getBinPieces() {
        return binPieces;
    }

    public UnusedPieceLists createAndFormatPieces(String pieceStr) {
        binPieces = new BinPieces();
        PieceStrParser pieceStrParser = new PieceStrParser();
        List<String> pieceListStr = pieceStrParser.getPiecesAsStr(pieceStr);

        List<Integer> listOfPieces = new ArrayList<>();

        for (String current : pieceListStr) {
            listOfPieces.add(binPieces.addPiece(current));
            listOfPieces.add(binPieces.getBinValueToPiece(
                    current.substring(3, 4) +
                            current.substring(0, 1) +
                            current.substring(1, 2) +
                            current.substring(2, 3)
            ));
            listOfPieces.add(binPieces.getBinValueToPiece(
                    current.substring(2, 3) +
                            current.substring(3, 4) +
                            current.substring(0, 1) +
                            current.substring(1, 2)
            ));
            listOfPieces.add(binPieces.getBinValueToPiece(
                    current.substring(1, 2) +
                            current.substring(2, 3) +
                            current.substring(3, 4) +
                            current.substring(0, 1)
            ));
        }

        PieceAnalysis pieceAnalysis = new PieceAnalysis(binPieces);
        List<Integer> cornerNE = pieceAnalysis.getAllCornerNE(listOfPieces);
        List<Integer> cornerNW = pieceAnalysis.getAllCornerNW(listOfPieces);
        List<Integer> cornerSE = pieceAnalysis.getAllCornerSE(listOfPieces);
        List<Integer> cornerSW = pieceAnalysis.getAllCornerSW(listOfPieces);

        List<Integer> borderNorth = pieceAnalysis.getAllBorderNorth(listOfPieces);
        List<Integer> borderEast = pieceAnalysis.getAllBorderEast(listOfPieces);
        List<Integer> borderSouth = pieceAnalysis.getAllBorderSouth(listOfPieces);
        List<Integer> borderWest = pieceAnalysis.getAllBorderWest(listOfPieces);
        List<Integer> normal = pieceAnalysis.getAllNormal(listOfPieces);

        return new UnusedPieceLists(cornerNE, cornerNW, cornerSE, cornerSW, borderNorth, borderEast, borderSouth, borderWest, normal);
    }
}
