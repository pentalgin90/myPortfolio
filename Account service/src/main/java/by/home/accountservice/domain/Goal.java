package by.home.accountservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "goal")
@Data
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer cost;
    private Date dateEvent;
    private Date endEvent;
}
