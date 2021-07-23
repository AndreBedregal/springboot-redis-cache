package pe.javanatic.rediscache.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
public class User implements Serializable {

    @Id
    private UUID id;

    private String name;

    private String email;

    @Enumerated
    private Department department;

}
