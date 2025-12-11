package gamePlay;

import java.util.List;

public class GamePlaySettings {
    //    GameId
    private String gameId;

    // This is save no
    private int saveNo;

    // No of pieces/nodes played
    private int saveAfterNoNodes;

    // Make new save after a new best have been found
    private boolean SaveAfterNewBest;

    // Use fix pieces
    private boolean useFixPieces;

    // The pieces to use
    private String piecesToUse;

    private List<Integer> sequenceToUse;

    // Current best solution
    private String bestSolution;

    // Current solution
    private String CurrentSolution;

    // No of pieces/nodes played
    private int noOfNodes;

    public GamePlaySettings(String gameId, int saveNo, int saveAfterNoNodes, boolean saveAfterNewBest, boolean useFixPieces, String piecesToUse, List<Integer> sequenceToUse, String bestSolution, String currentSolution, int noOfNodes) {
        this.gameId = gameId;
        this.saveNo = saveNo;
        this.saveAfterNoNodes = saveAfterNoNodes;
        SaveAfterNewBest = saveAfterNewBest;
        this.useFixPieces = useFixPieces;
        this.piecesToUse = piecesToUse;
        this.sequenceToUse = sequenceToUse;
        this.bestSolution = bestSolution;
        CurrentSolution = currentSolution;
        this.noOfNodes = noOfNodes;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public int getSaveNo() {
        return saveNo;
    }

    public void setSaveNo(int saveNo) {
        this.saveNo = saveNo;
    }

    public int getSaveAfterNoNodes() {
        return saveAfterNoNodes;
    }

    public void setSaveAfterNoNodes(int saveAfterNoNodes) {
        this.saveAfterNoNodes = saveAfterNoNodes;
    }

    public boolean isSaveAfterNewBest() {
        return SaveAfterNewBest;
    }

    public void setSaveAfterNewBest(boolean saveAfterNewBest) {
        SaveAfterNewBest = saveAfterNewBest;
    }

    public boolean isUseFixPieces() {
        return useFixPieces;
    }

    public void setUseFixPieces(boolean useFixPieces) {
        this.useFixPieces = useFixPieces;
    }

    public String getPiecesToUse() {
        return piecesToUse;
    }

    public void setPiecesToUse(String piecesToUse) {
        this.piecesToUse = piecesToUse;
    }

    public List<Integer> getSequenceToUse() {
        return sequenceToUse;
    }

    public void setSequenceToUse(List<Integer> sequenceToUse) {
        this.sequenceToUse = sequenceToUse;
    }

    public String getBestSolution() {
        return bestSolution;
    }

    public void setBestSolution(String bestSolution) {
        this.bestSolution = bestSolution;
    }

    public String getCurrentSolution() {
        return CurrentSolution;
    }

    public void setCurrentSolution(String currentSolution) {
        CurrentSolution = currentSolution;
    }

    public int getNoOfNodes() {
        return noOfNodes;
    }

    public void setNoOfNodes(int noOfNodes) {
        this.noOfNodes = noOfNodes;
    }

    @Override
    public String toString() {
        return "GamePlaySettings{" +
                "gameId='" + gameId + '\'' +
                ", saveNo=" + saveNo +
                ", saveAfterNoNodes=" + saveAfterNoNodes +
                ", SaveAfterNewBest=" + SaveAfterNewBest +
                ", useFixPieces=" + useFixPieces +
                ", piecesToUse='" + piecesToUse + '\'' +
                ", sequenceToUse=" + sequenceToUse +
                ", bestSolution='" + bestSolution + '\'' +
                ", CurrentSolution='" + CurrentSolution + '\'' +
                ", noOfNodes=" + noOfNodes +
                '}';
    }
}
