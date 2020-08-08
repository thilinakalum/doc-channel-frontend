package lk.doc.dotor_channel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.doc.dotor_channel.entity.Doctor;
import lk.doc.dotor_channel.service.DoctorService;

@RestController
@CrossOrigin
@RequestMapping("/api/doctor")
public class DoctorController {

  @Autowired
  private DoctorService doctorService;

  @PostMapping("/save")
  public Doctor save(Doctor doctor) {
    return doctorService.save(doctor);
  }

  @GetMapping("/find-all")
  public List<Doctor> findAll() {
    return doctorService.findAll();
  }

  @DeleteMapping("/delete/{id}")
  public Doctor delete(@PathVariable Integer id) {
    return doctorService.delete(id);
  }

}
