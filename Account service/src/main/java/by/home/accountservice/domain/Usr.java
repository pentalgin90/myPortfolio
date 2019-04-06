package by.home.accountservice.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "usr")
@Data
public class Usr {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String lastname;
    private Integer salary;
    private String email;
}
