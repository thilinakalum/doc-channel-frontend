/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.doc.dotor_channel.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author macbook
 */
@Entity
@Table(name = "bookings")
public class Bookings implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fk_doctor")
    private Integer fkDoctor;
    @Column(name = "fk_session")
    private Integer fkSession;

    public Bookings() {
    }

    public Bookings(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFkDoctor() {
        return fkDoctor;
    }

    public void setFkDoctor(Integer fkDoctor) {
        this.fkDoctor = fkDoctor;
    }

    public Integer getFkSession() {
        return fkSession;
    }

    public void setFkSession(Integer fkSession) {
        this.fkSession = fkSession;
    }
    
}
