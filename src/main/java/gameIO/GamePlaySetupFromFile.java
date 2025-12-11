package gameIO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GamePlaySetupFromFile {
    //    GameId
    @JsonProperty("gameId")
    private String gameId;

    // This is save no
    @JsonProperty("saveNo")
    private String saveNo;

    // No of pieces/nodes played
    @JsonProperty("saveAfterNoNodes")
    private String saveAfterNoNodes;

    // Make new save after a new best have been found
    @JsonProperty("SaveAfterNewBest")
    private String SaveAfterNewBest;

    // Use fix pieces
    @JsonProperty("useFixPieces")
    private String useFixPieces;

    // The pieces to use
    @JsonProperty("piecesToUse")
    private String piecesToUse;

    @JsonProperty("sequenceToUse")
    private String sequenceToUse;
    // Current best solution
    @JsonProperty("bestSolution")
    private String bestSolution;

    // Current solution
    @JsonProperty("currentSolution")
    private String currentSolution;

    // No of pieces/nodes played
    @JsonProperty("noOfNodes")
    private String noOfNodes;

    public GamePlaySetupFromFile() {
    }

    public GamePlaySetupFromFile(String gameId, String saveNo, String saveAfterNoNodes, String saveAfterNewBest, String useFixPieces, String piecesToUse, String sequenceToUse, String bestSolution, String currentSolution, String noOfNodes) {
        this.gameId = gameId;
        this.saveNo = saveNo;
        this.saveAfterNoNodes = saveAfterNoNodes;
        SaveAfterNewBest = saveAfterNewBest;
        this.useFixPieces = useFixPieces;
        this.piecesToUse = piecesToUse;
        this.sequenceToUse = sequenceToUse;
        this.bestSolution = bestSolution;
        this.currentSolution = currentSolution;
        this.noOfNodes = noOfNodes;
    }

    public String getGameId() {
        return gameId;
    }

    public String getSaveNo() {
        return saveNo;
    }

    public String getSaveAfterNoNodes() {
        return saveAfterNoNodes;
    }

    public String getSaveAfterNewBest() {
        return SaveAfterNewBest;
    }

    public String getUseFixPieces() {
        return useFixPieces;
    }

    public String getPiecesToUse() {
        return piecesToUse;
    }

    public String getSequenceToUse() {
        return sequenceToUse;
    }

    public String getBestSolution() {
        return bestSolution;
    }

    public String getCurrentSolution() {
        return currentSolution;
    }

    public String getNoOfNodes() {
        return noOfNodes;
    }

    @Override
    public String toString() {
        return "GamePlaySetupFromFile{" +
                "gameId='" + gameId + '\'' +
                ", saveNo='" + saveNo + '\'' +
                ", saveAfterNoNodes='" + saveAfterNoNodes + '\'' +
                ", SaveAfterNewBest='" + SaveAfterNewBest + '\'' +
                ", useFixPieces='" + useFixPieces + '\'' +
                ", piecesToUse='" + piecesToUse + '\'' +
                ", sequenceToUse='" + sequenceToUse + '\'' +
                ", bestSolution='" + bestSolution + '\'' +
                ", currentSolution='" + currentSolution + '\'' +
                ", noOfNodes='" + noOfNodes + '\'' +
                '}';
    }
}
