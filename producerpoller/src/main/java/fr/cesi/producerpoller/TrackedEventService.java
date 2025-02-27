package fr.cesi.producerpoller;

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
    public Consumer<TrackedEvent> trackedEventConsumer(){
        return (input) -> {
            System.out.println("********************");
            System.out.println(input.toString());
            System.out.println("********************");
        };
    }

    @Bean
    public Supplier<TrackedEvent> trackedEventSupplier(){
        return () -> new TrackedEvent(null,giveMeAString() , LocalDate.now());
    }
    public String giveMeAString() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = Base64.getEncoder().encodeToString(array );
        return generatedString ;
    }
}
