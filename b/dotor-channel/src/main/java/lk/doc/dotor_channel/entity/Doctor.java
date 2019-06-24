/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.doc.dotor_channel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author macbook
 */
@Entity
@Table(name = "doctor")

public class Doctor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    
    @Size(max = 1000)
    @Column(name = "description")
    private String description;
    
    @Size(max = 100)
    @Column(name = "qualification")
    private String qualification;
    
    @JoinColumn(name = "fk_doctor_category", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private DoctorCategory fkDoctorCategory;
    
    @OneToMany(mappedBy = "fkDoctor", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<DoctorSession> doctorSessionList;

    public Doctor() {
    }

    public Doctor(Integer id) {
        this.id = id;
    }

    public Doctor(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public DoctorCategory getFkDoctorCategory() {
        return fkDoctorCategory;
    }

    public void setFkDoctorCategory(DoctorCategory fkDoctorCategory) {
        this.fkDoctorCategory = fkDoctorCategory;
    }

    @XmlTransient
    public List<DoctorSession> getDoctorSessionList() {
        return doctorSessionList;
    }

    public void setDoctorSessionList(List<DoctorSession> doctorSessionList) {
        this.doctorSessionList = doctorSessionList;
    }

}
