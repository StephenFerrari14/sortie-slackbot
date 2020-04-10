package com.slack.headdesk.sortie;
import com.slack.headdesk.sortie.entities.SlackEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class SortieController {
    @RequestMapping("/")
    public String index() {
        return "Sortie online!";
    }

    @PostMapping("/slack/events")
    public ResponseEntity<String> getEvents(@RequestBody SlackEntity entity) {
        SlackMessageParser parser = new SlackMessageParser(entity);
        String parsedResult = parser.parse();
        if (!parsedResult.equals("")) {
            return new ResponseEntity<>(parsedResult, HttpStatus.OK);
        }
        return new ResponseEntity<>("Need to figure out how to return entity", HttpStatus.OK);
    }

}
