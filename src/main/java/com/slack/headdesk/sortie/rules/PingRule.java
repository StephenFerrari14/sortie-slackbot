package com.slack.headdesk.sortie.rules;

import com.slack.headdesk.sortie.entities.SlackEntity;

public class PingRule extends BaseRule {
    public PingRule(SlackEntity entity) {
        super(entity);
    }

    @Override
    public void run() {
        if (this.entity.event.text.toLowerCase().equals("ping")) {
            this.messenger.sendMessage("pong", this.entity.event.user);
            this.ruleCaught = true;
        }
    }
}
