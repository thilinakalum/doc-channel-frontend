package lk.doc.dotor_channel.dto;

import lk.doc.dotor_channel.entity.Doctor;
import lk.doc.dotor_channel.entity.DoctorSession;
import org.hibernate.Session;

public class DoctorAndSessionDetails {
    private Doctor doctor;
    private DoctorSession doctorSession;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public DoctorSession getDoctorSession() {
        return doctorSession;
    }

    public void setDoctorSession(DoctorSession doctorSession) {
        this.doctorSession = doctorSession;
    }
}
