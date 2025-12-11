package displays;


import Types.Puzzle;
import createPieces.BinPieces;

public class Display {
    private String BASE_URL = "https://e2.bucas.name/#puzzle=Go4Gold&board_w=16&board_h=16&board_edges=";

    BinPieces binPieces;

    public Display(BinPieces binPieces) {
        this.binPieces = binPieces;
    }

    public void makeUrl(Puzzle puzzleBoard) {
        System.out.println(createUrl(puzzleBoard).toLowerCase());
    }

    public String findUrl(Puzzle puzzleBoard) {
       return createUrl(puzzleBoard);
    }

    private String createUrl(Puzzle puzzleBoard) {
        String url = BASE_URL;

        for (int i = 0; i < puzzleBoard.getBret().size(); i++) {
            if (puzzleBoard.getBret().get(i) == 0) {
                url = url + "0000";
            } else {
                url = url + binPieces.getPieceToPieceStr(puzzleBoard.getBret().get(i));
            }
        }

        return url.toLowerCase();
    }

}
