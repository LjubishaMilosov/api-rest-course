package apiCourse.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Board {

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private String id;

    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }
}