package createPieces;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PieceStrParser {

    public List<String> getPiecesAsStr(String pieceStr) {
        List<String> currentPieces = new ArrayList<>();
        return findNextPiece(currentPieces, 0, pieceStr.toUpperCase(Locale.ROOT));
    }

    private List<String> findNextPiece(List<String> currentPieces, int currentPos, String pieceStr) {
        if (currentPos + 4 <= pieceStr.length()) {
            String newPiece = pieceStr.substring(currentPos, currentPos + 4);
            System.out.println(newPiece);
            if (newPiece.chars().filter(ch -> ch == 'A').count() > 2) {
                System.out.println("! Unknown piece : " + newPiece);
            } else {
                currentPieces.add(newPiece);
            }

            currentPos = currentPos + 4;
            return findNextPiece(currentPieces, currentPos, pieceStr);
        } else {
            return currentPieces;
        }
    }
}
