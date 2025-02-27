package fr.cesi.event_consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class TrackedEventService {
    @Bean
    public Consumer<TrackedEvent> trackedEventConsumer() {
        return (input) -> {
            System.out.println("******************");
            System.out.println(input.toString());
            System.out.println("******************");
        };
    }
}
