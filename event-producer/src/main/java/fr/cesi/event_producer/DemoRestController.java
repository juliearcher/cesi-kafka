package fr.cesi.event_producer;

import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@AllArgsConstructor
@RestController
public class DemoRestController {
    private StreamBridge streamBridge;

    @GetMapping("bookmark/{topic}/{infoToTrack}")
    public TrackedEvent bookmark(@PathVariable String topic, @PathVariable String infoToTrack) {
        TrackedEvent logContent = new TrackedEvent(null, infoToTrack, LocalDate.now());
        streamBridge.send(topic, logContent);

        return logContent;
    }
}
