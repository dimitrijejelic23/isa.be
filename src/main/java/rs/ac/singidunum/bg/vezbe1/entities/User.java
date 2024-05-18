package rs.ac.singidunum.bg.vezbe1.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name", columnDefinition = "VARCHAR(255) NOT NULL")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "VARCHAR(255) NOT NULL")
    private String lastName;

    @Column(name = "email", columnDefinition = "VARCHAR(255) NOT NULL")
    private String email;

}
