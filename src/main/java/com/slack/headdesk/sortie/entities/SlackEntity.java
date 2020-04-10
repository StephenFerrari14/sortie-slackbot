package com.slack.headdesk.sortie.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.slack.headdesk.sortie.entities.SlackEventEntity;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SlackEntity {
    @JsonProperty
    public String challenge;
    @JsonProperty
    public SlackEventEntity event;
}