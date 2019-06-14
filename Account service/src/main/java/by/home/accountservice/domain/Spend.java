package by.home.accountservice.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "spend")
@ToString(of = {"id", "costs", "name", "user"})
@EqualsAndHashCode(of = {"id"})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Spend {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer costs;
    private String name;
    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateEvent;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Usr user;

    public Spend() {
    }

    public Spend(Integer costs, Date dateEvent, String name, Usr user) {
        this.costs = costs;
        this.dateEvent = dateEvent;
        this.name = name;
        this.user = user;
    }

    public Integer getCosts() {
        return costs;
    }

    public void setCosts(Integer costs) {
        this.costs = costs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(Date dateEvent) {
        this.dateEvent = dateEvent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usr getUser() {
        return user;
    }

    public void setUser(Usr user) {
        this.user = user;
    }
}
