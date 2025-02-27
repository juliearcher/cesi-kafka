package fr.cesi.event_consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Base64;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

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
