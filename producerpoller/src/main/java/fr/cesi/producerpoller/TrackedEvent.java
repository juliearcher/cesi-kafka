package fr.cesi.producerpoller;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class TrackedEvent {
    private Long id;
    private String title;
    private Date sysDate;
    private String alias;
}
