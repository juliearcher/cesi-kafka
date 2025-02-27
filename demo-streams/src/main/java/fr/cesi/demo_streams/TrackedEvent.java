package fr.cesi.demo_streams;

import lombok.*;

import java.util.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class TrackedEvent {
    private Long id;
    private String title;
    private Date sysDate;
    private String alias;
}
