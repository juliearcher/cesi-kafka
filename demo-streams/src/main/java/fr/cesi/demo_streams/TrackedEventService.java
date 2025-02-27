package fr.cesi.demo_streams;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class TrackedEventService {
    @Bean
    public Function<KStream<String, TrackedEvent>, KStream<String, Long >> kStreamFunction(){
        return (input)-> {
            return input

                    .filter( (k,v)-> isFresh(v.getSysDate() ) )
                    .map((k,v) -> new KeyValue<>(v.getTitle() , 0L))
                    .groupBy((k,v )-> k, Grouped.with(Serdes.String(), Serdes.Long()))
                    .count()
                    .toStream();

        };
    }
    public boolean isFresh( Date date ) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime parsedDate =

                date.toInstant() .atZone(ZoneId.systemDefault()) .toLocalDateTime();
        Duration duration = Duration.between(parsedDate, now);
        long seconds = duration.getSeconds();

        if (seconds >=0L && seconds <10L)return true ;
        else return false;
    }
}