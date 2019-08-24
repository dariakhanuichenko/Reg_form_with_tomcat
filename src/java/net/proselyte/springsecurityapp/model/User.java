package net.proselyte.springsecurityapp.model;


import lombok.*;

import javax.persistence.*;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="users", schema="public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(name="seq",sequenceName="oracle_seq")
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Transient
    private String confirmPassword;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
