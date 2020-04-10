package com.slack.headdesk.sortie.rules;

import com.slack.headdesk.sortie.entities.SlackEntity;
import java.util.Arrays;

public class SortRule extends BaseRule {

    public SortRule(SlackEntity entity) {
        super(entity);
    }

    @Override
    public void run() {
        try {
            String[] items = this.entity.event.text.split(",");
            String[] trimmedItems = new String[items.length];
            for (int i = 0; i < items.length; i++) {
                trimmedItems[i] = items[i].trim();
            }
            Arrays.sort(trimmedItems);
            String sortedString = Arrays.toString(trimmedItems);
            this.messenger.sendMessage(sortedString.substring(1, sortedString.length() - 1), this.entity.event.user);
            this.ruleCaught = true;
        } catch (Exception ignored) {
            this.messenger.sendMessage("Failed to sort.", this.entity.event.user);
            this.ruleCaught = true;
        }
    }
}
