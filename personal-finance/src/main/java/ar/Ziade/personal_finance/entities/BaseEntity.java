package ar.Ziade.personal_finance.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * a base entity that will it is only meant to be inherited
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseEntity {
    /**
     * the id, meant to identify the entity in the database
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * this will record when was the entity was created
     */
    @CreatedDate
    @Column(name = "DATE_CREATED")
    private LocalDateTime dateCreated;
}
