package fr.cesi.event_consumer;

import lombok.*;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class TrackedEvent {
    private Long id;
    private String infoToTrack;
    private LocalDate sysDate;
}
