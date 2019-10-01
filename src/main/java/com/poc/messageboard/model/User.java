package com.poc.messageboard.model;

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
@Table(name = "user")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

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
    @Column(name = "id")
    private UUID id;

    private String email;

    private String username;

    private ZonedDateTime zonedDateTime;

//    public User() {
//    }
}
