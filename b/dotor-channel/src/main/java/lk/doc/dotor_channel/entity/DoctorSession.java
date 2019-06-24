/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.doc.dotor_channel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author macbook
 */
@Entity
@Table(name = "doctor_session")
public class DoctorSession implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_time")
    private Time startTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_time")
    private Time endTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "max_epointments")
    private int maxEpointments;
    @Basic(optional = false)
    @NotNull
    @Column(name = "availaility")
    private short availaility;
    @JoinColumn(name = "fk_doctor", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Doctor fkDoctor;

    public DoctorSession() {
    }

    public DoctorSession(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public int getMaxEpointments() {
        return maxEpointments;
    }

    public void setMaxEpointments(int maxEpointments) {
        this.maxEpointments = maxEpointments;
    }

    public short getAvailaility() {
        return availaility;
    }

    public void setAvailaility(short availaility) {
        this.availaility = availaility;
    }

    public Doctor getFkDoctor() {
        return fkDoctor;
    }

    public void setFkDoctor(Doctor fkDoctor) {
        this.fkDoctor = fkDoctor;
    }
    
}
