package entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Gists {
    private String description;
    private String fileName;

    public String getDescription() {
        return description;
    }

    public String getFileName() {
        return fileName;
    }

    @JsonProperty("files")
    private void unmarshellNested(Map<String ,Object> files){
        Map<String,String> file= (Map<String,String>) files.get("tic-tac");
        fileName =file.get("filename");
    }
}
