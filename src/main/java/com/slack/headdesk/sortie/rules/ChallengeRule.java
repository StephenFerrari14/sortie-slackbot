package com.slack.headdesk.sortie.rules;

import com.slack.headdesk.sortie.entities.SlackEntity;

public class ChallengeRule extends BaseRule {
    public ChallengeRule(SlackEntity entity) {
        super(entity);
    }

    @Override
    public void run() {
        if (this.entity.challenge != null) {
            this.ruleCaught = true;
            this.result = "{\"challenge\": \"" + this.entity.challenge + "\"}";
        }
    }
}
