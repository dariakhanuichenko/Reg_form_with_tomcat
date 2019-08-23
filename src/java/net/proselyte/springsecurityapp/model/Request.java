package net.proselyte.springsecurityapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="request", schema="public")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @Column(name="request")
    String request;

    @Column(name="status")
    String status;

    @Column(name="price")
    Long price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User master;

}
