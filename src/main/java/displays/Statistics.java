package displays;

import Types.Puzzle;
import createPieces.BinPieces;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Statistics {
    Display display;

    BinPieces binPieces;
    private long nodeCount = 0;
    private long lastNodeCount = 0;
    private long countSinceLastPiece = 0;
    private final LocalDateTime startDateTime = LocalDateTime.now();
    private LocalDateTime lastDateTime = LocalDateTime.now();
    private LocalDateTime timeOfLastPiece = LocalDateTime.now();

    public Statistics(BinPieces binPieces) {
        this.binPieces = binPieces;
        display = new Display(binPieces);
    }

    public void incNodeCount() {
        this.nodeCount = this.nodeCount + 1;
    }

    public void newPieceAdded() {
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        long timeSinceLastUpdate = ChronoUnit.SECONDS.between(timeOfLastPiece, localDateTimeNow);
        long temp = nodeCount - countSinceLastPiece;

        System.out.println("---------------------------------------------");
        System.out.println("Time since last piece : " + ToDisplayFormats.formatLong(timeSinceLastUpdate));
        System.out.println("Nodes since last piece : " + ToDisplayFormats.formatLong(temp));
        System.out.println("---------------------------------------------");

        timeOfLastPiece = localDateTimeNow;
        countSinceLastPiece = nodeCount;
    }

    public void showStatistics(Puzzle currentPuzzleBoard, Puzzle bestPuzzleBoard) {
        LocalDateTime localDateTimeNow = LocalDateTime.now();

        long timeSinceLastUpdate = ChronoUnit.SECONDS.between(lastDateTime, localDateTimeNow);
        if (timeSinceLastUpdate >= 30) {
            long countSinceLastUpdate = nodeCount - lastNodeCount;
            long nodesPrSecondSinceLastUpdate = countSinceLastUpdate / timeSinceLastUpdate;

            long timeSinceLastStart = ChronoUnit.SECONDS.between(startDateTime, localDateTimeNow);
            long nodesPrSecondSinceStart = nodeCount / timeSinceLastStart;

            System.out.println("---------------------------------------------");
            System.out.println("Total no of nodes                           : " + ToDisplayFormats.formatLong(nodeCount));
            System.out.println("Number of nodes since last update           : " + ToDisplayFormats.formatLong(countSinceLastUpdate));
            System.out.println("Number of nodes pr second since start       : " + ToDisplayFormats.formatLong(nodesPrSecondSinceStart));
            System.out.println("Number of nodes pr second since last update : " + ToDisplayFormats.formatLong(nodesPrSecondSinceLastUpdate));
            System.out.println("---> Currently working on puzzle " + display.findUrl(currentPuzzleBoard));
            System.out.println("---> Best puzzle is " + display.findUrl(bestPuzzleBoard));
            System.out.println("---------------------------------------------");

            lastDateTime = localDateTimeNow;
            lastNodeCount = nodeCount;
        }
    }
}