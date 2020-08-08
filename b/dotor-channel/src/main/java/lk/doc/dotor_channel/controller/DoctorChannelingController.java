package lk.doc.dotor_channel.controller;

import java.util.List;
import java.util.Optional;

import lk.doc.dotor_channel.model.BookingDetailModel;
import lk.doc.dotor_channel.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.doc.dotor_channel.entity.Booking;
import lk.doc.dotor_channel.entity.Doctor;
import lk.doc.dotor_channel.entity.DoctorCategory;
import lk.doc.dotor_channel.entity.DoctorSession;
import lk.doc.dotor_channel.service.DoctorChannelingService;

@RestController
@CrossOrigin
@RequestMapping("/api/doctor-channeling")
public class DoctorChannelingController {

    @Autowired
    private DoctorChannelingService doctorChannelingService;

    @Autowired
    private BookingService bookingService;

    @GetMapping("/find-all-doctors")
    public List<Doctor> findAllDoctoler() {
        return doctorChannelingService.findAllDoctolers();
    }

    @GetMapping("/find-all-doctor-categorys")
    public List<DoctorCategory> findAllDoctorCategory() {
        return doctorChannelingService.findAllDoctorCategory();
    }

    @GetMapping("/find-session-details/{id}")
    public DoctorSession findSessionDetails(@PathVariable("id") Integer id) {
        return doctorChannelingService.findSessionDetails(id);
    }

    @PostMapping("/save-booking")
    public Booking findSessionDetails(@RequestBody Booking booking) {
        return doctorChannelingService.saveBooking(booking);
    }

    @GetMapping(value = {
            "/find-doctor-session-by-doctor-and-date",
            "/find-doctor-session-by-doctor-and-date/{doctor}",
            "/find-doctor-session-by-doctor-and-date/{doctor}/{date}"
    })
    public List<DoctorSession> findByDoctorAndDate(@PathVariable Optional<Integer> doctor, @PathVariable Optional<String> date) {

        String paramDate = "";
        Integer paramDoctor = null;

        if (date.isPresent()) {
            paramDate = date.get();
        }

        String passingDate = "\"" + paramDate + "\"";

        if (doctor.isPresent()) {
            paramDoctor = doctor.get();
        }

        return doctorChannelingService.findByDoctorAndDate(paramDoctor, passingDate);
    }

    @GetMapping("/getAllAppointments")
    public List<BookingDetailModel> getAllAppointments(){
        return bookingService.getAllBookingDetails();
    }

    @GetMapping("/getAppointmentsByDate/{startDate}/{endDate}")
    public List<BookingDetailModel> getAppointmentsByDate(@PathVariable("startDate")String startDate, @PathVariable("endDate")String endDate){
        String passingDate1 = "\"" + startDate + "\"";
        String passingDate2 = "\"" + endDate + "\"";
        return bookingService.getAppointmentsByDate(passingDate1,passingDate2);
    }

}
