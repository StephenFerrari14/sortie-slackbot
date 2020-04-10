package com.slack.headdesk.sortie.rules;

import com.slack.headdesk.sortie.entities.SlackEntity;

public class HelpRule extends BaseRule {
    public HelpRule(SlackEntity entity) {
        super(entity);
    }

    @Override
    public void run() {
        if (this.entity.event.text.toLowerCase().equals("help")) {
            this.messenger.sendMessage("Hey user, I only sort things.\nJust send me a message of what you want to sort separated by commas and I'll sort it for you!", entity.event.user);
            this.ruleCaught = true;
        }
    }
}
