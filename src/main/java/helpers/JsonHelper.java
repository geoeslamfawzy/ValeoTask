package helpers;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.FrameworkConstants;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class JsonHelper {
    private final String fileName;

    public JsonHelper(String fileName) {
        this.fileName = FrameworkConstants.readDataFile(fileName + ".json") ;
    }

    public String extractData(String tokenName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(new File(fileName));
        JsonNode tokenNode = rootNode.get(tokenName);
        return tokenNode.asText();
    }


    public List<HashMap<String, String>> getJsonDataToMap(String tokenPath) throws IOException {
        String jsonContent = FileUtils.readFileToString(new File(fileName), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonContent);
        JsonNode userLoginsNode = rootNode.path(tokenPath);
        List<HashMap<String, String>> data = mapper.readValue(userLoginsNode.toString(), new TypeReference<List<HashMap<String, String>>>() {});
        return data;
    }
    public Object[][] getJsonArrayData(String tokenArray) throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(tokenArray);
        Object[][] testData = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            testData[i][0] = data.get(i);
        }
        return testData;
    }

    public Object[][] getJsonDataArrayFromJsonFile() throws IOException {
        String jsonContent = FileUtils.readFileToString(new File(fileName), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object>[] data = mapper.readValue(jsonContent, new TypeReference<HashMap<String, Object>[]>() {});
        Object[][] dataArray = new Object[data.length][1];
        for (int i = 0; i < data.length; i++) {
            dataArray[i][0] = data[i];
        }
        return dataArray;
    }
}
