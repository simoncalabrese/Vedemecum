package model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by simon on 04/09/16.
 */
@Entity
@Table(
        name = "ANAG_USER"
)
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(
            name = "USER_ID"
    )
    private Integer id;

    @Column(
            name = "USER_COD",
            nullable = false
    )
    private String cod;

    @Column(
            name = "USER_PSW",
            nullable = false
    )
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
