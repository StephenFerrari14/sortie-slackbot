package com.slack.headdesk.sortie;

import com.slack.headdesk.sortie.entities.SlackEntity;
import com.slack.headdesk.sortie.rules.*;

class SlackMessageParser {
    private SlackEntity entity;

    SlackMessageParser(SlackEntity entity) {
        this.entity = entity;
    }

    String parse() {
        // Could do something here we put each rule into a collection in order and it iterates through each and runs them.
        ChallengeRule challenge = new ChallengeRule(this.entity);
        challenge.run();
        if (challenge.ruleCaught) {
            return challenge.result;
        }

        SelfRule selfRule = new SelfRule(this.entity);
        selfRule.run();
        if (selfRule.ruleCaught) {
            return selfRule.result;
        }

        PingRule ping = new PingRule(this.entity);
        ping.run();
        if (ping.ruleCaught) {
            return ping.result;
        }

        HelpRule help = new HelpRule(this.entity);
        help.run();
        if (help.ruleCaught) {
            return help.result;
        }

        SortRule sort = new SortRule(this.entity);
        sort.run();
        if (sort.ruleCaught) {
            return sort.result;
        }

        return "I do not know how to do that. Please try again.";
    }
}
