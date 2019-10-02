package com.poc.messageboard.model;

import com.poc.messageboard.custom.Status;
import com.poc.messageboard.custom.StatusConverter;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * Created by Swaroop Pallapothu on Oct, 2019
 */
@Entity
@Table(name = "message")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator = "uuid-v1")
    @GenericGenerator(
            name = "uuid-v1",
            strategy = "uuid2",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    @Column(name = "id", columnDefinition = "binary(16)", nullable = false)
    private UUID id;

    private String title;

    private String message;

    @Basic
    @Convert(converter = StatusConverter.class)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User createdUser;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private ZonedDateTime createdTimestamp;

    @Column(columnDefinition = "TIMESTAMP DEFAULT NULL ON update CURRENT_TIMESTAMP")
    private ZonedDateTime modifiedTimestamp;

}