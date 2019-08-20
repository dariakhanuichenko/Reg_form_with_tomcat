package net.proselyte.springsecurityapp.model;

import lombok.*;


import javax.persistence.*;
import java.util.Set;
@Data
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString

@Entity
@Table(name="roles",schema="public")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String name;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
    private Set<User> users;
}
