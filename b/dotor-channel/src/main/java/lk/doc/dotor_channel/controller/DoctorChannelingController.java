package lk.doc.dotor_channel.controller;

import lk.doc.dotor_channel.entity.Doctor;
import lk.doc.dotor_channel.entity.DoctorCategory;
import lk.doc.dotor_channel.entity.DoctorSession;
import lk.doc.dotor_channel.service.DoctorChannelingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/doctor-channeling")
public class DoctorChannelingController {

    @Autowired
    private DoctorChannelingService doctorChannelingService;

    @GetMapping("/find-all-doctors")
    public List<Doctor> findAllDoctoler() {
        return doctorChannelingService.findAllDoctolers();
    }

    @GetMapping("/find-all-doctor-categorys")
    public List<DoctorCategory> findAllDoctorCategory() {
        return doctorChannelingService.findAllDoctorCategory();
    }

    @GetMapping(value = {
            "/find-doctor-session-by-doctor-and-date",
            "/find-doctor-session-by-doctor-and-date/{doctor}",
            "/find-doctor-session-by-doctor-and-date/{doctor}/{date}"
    })
    public List<DoctorSession> findByDoctorAndDate(@PathVariable Optional<Integer> doctor, @PathVariable Optional<String> date) {
        System.out.println("doctor - " + doctor);
        System.out.println("date - " + date);
        String paramDate = "";
        Integer paramDoctor = null;

        if (date.isPresent()) {
            paramDate = date.get();
        }


        if (doctor.isPresent()) {
            paramDoctor = doctor.get();
        }

        return doctorChannelingService.findByDoctorAndDate(paramDoctor, paramDate);
    }

}
