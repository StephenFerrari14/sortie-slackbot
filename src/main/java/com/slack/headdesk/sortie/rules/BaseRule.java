package com.slack.headdesk.sortie.rules;

import com.slack.headdesk.sortie.SlackMessager;
import com.slack.headdesk.sortie.entities.SlackEntity;

public class BaseRule implements RulesInterface {
    SlackEntity entity;
    public Boolean ruleCaught = false;
    public String result = "success"; // Turn this into entity
    SlackMessager messenger;

    BaseRule(SlackEntity entity) {
        this.entity = entity;
        this.messenger = new SlackMessager();
    }

    @Override
    public void run() {
    }
}
