package fr.cesi.producerpoller;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
@Service
public class TrackedEventService {
    @Bean
    public Supplier<TrackedEvent> trackedEventSupplier() {
        return () -> new TrackedEvent(null, giveMeTitle(), new Date(), giveMeOneUserName());
    }

    public String giveMeTitle() {
        String[] users = {"Capitaine abandoné", "Viens danser", "Au bal masqué", "J'ai encore révé d'elle", "La danse des canards"," Les démons de minuit"," Partenaire particulier"," La Salsa du démon"};
        int indexAleatoire = new Random().nextInt(users.length);
        return users[indexAleatoire];
    }
    public String giveMeOneUserName () {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }
}