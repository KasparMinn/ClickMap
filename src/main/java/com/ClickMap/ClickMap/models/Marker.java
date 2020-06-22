package com.ClickMap.ClickMap.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public class Marker {

    private final UUID id;
    private final String title;

    public Marker( @JsonProperty("id") UUID id,
                   @JsonProperty("name") String title ) {

        this.id = id;
        this.title = title;

    }

    public UUID getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

}
