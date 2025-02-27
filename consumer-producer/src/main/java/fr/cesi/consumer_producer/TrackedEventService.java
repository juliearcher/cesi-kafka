package fr.cesi.consumer_producer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TrackedEventService {
    @Bean
    public Function <TrackedEvent , TrackedEvent> trackedEventFunction(){
        return (in) -> {
            Long id=in.getId();
            in.setId(99L);
//in.setInfoToTrack("message modifie par Function "+id);
            return in;
        };
    }
}
