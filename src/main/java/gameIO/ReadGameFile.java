package gameIO;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.nio.file.Paths;

public class ReadGameFile {
    public GamePlaySetupFromFile readSetup(String setupFile) {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

        try {
            return objectMapper.readValue(Paths.get(setupFile).toFile(), GamePlaySetupFromFile.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
