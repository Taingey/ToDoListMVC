package co.istad.sbdemo.model;

import lombok.*;
import java.time.LocalDate;
@AllArgsConstructor
@Data
@Setter
@NoArgsConstructor
public class Todo {
    private Long id = 0L;
    private String task;
    private String description;
    private Boolean isDone;
    private LocalDate createAt;
}