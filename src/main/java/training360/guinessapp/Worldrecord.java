package training360.guinessapp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "world_record")
public class Worldrecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private double value;
    private String unitOfMeasure;
    private LocalDate dateOfRecord;
    private Long recorderId;

    public Worldrecord(String description, double value, String unitOfMeasure, LocalDate dateOfRecord, Long recorderId) {
        this.description = description;
        this.value = value;
        this.unitOfMeasure = unitOfMeasure;
        this.dateOfRecord = dateOfRecord;
        this.recorderId = recorderId;
    }
}
