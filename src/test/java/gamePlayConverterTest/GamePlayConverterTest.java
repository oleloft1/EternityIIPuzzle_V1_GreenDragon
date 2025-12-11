package gamePlayConverterTest;

import gameIO.GamePlaySetupFromFile;
import gamePlay.GamePlayConverter;
import gamePlay.GamePlaySettings;
import org.junit.Assert;
import org.junit.Test;

public class GamePlayConverterTest {

    @Test
    public void canConvertTrue() {
        // Arrange
        GamePlayConverter gamePlayConverter = new GamePlayConverter();
        String gameId = "";
        String saveNo = "";
        String saveAfterNoNodes = "";
        String saveAfterNewBest = "true";
        String useFixPieces = "false";
        String piecesToUse = "";
        String sequenceToUse = "";
        String bestSolution = "";
        String currentSolution = "";
        String noOfNodes = "";
        GamePlaySetupFromFile gamePlaySetupFromFile = new GamePlaySetupFromFile(gameId, saveNo, saveAfterNoNodes, saveAfterNewBest, useFixPieces, piecesToUse, sequenceToUse, bestSolution, currentSolution, noOfNodes);


        // Act
        GamePlaySettings gamePlaySettings = gamePlayConverter.convertFromSaveFile(gamePlaySetupFromFile);

        // Assert
        Assert.assertFalse(gamePlaySettings.getGameId().isEmpty());
        Assert.assertTrue(gamePlaySettings.getBestSolution().isEmpty());
        Assert.assertTrue(gamePlaySettings.getCurrentSolution().isEmpty());

        // Todo: And more
    }
}
