package lk.doc.dotor_channel.service;

import lk.doc.dotor_channel.entity.Bookings;
import lk.doc.dotor_channel.entity.Doctor;
import lk.doc.dotor_channel.entity.DoctorCategory;
import lk.doc.dotor_channel.entity.DoctorSession;
import lk.doc.dotor_channel.repository.BookingRepository;
import lk.doc.dotor_channel.repository.DoctorCategoryRepository;
import lk.doc.dotor_channel.repository.DoctorRepository;
import lk.doc.dotor_channel.repository.DoctorSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DoctorChannelingService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorCategoryRepository doctorCategoryRepository;

    @Autowired
    private DoctorSessionRepository doctorSessionRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public List<Doctor> findAllDoctolers() {
        return doctorRepository.findAll();
    }

    public List<DoctorCategory> findAllDoctorCategory() {
        return doctorCategoryRepository.findAll();
    }

    public List<DoctorSession> findByDoctorAndDate(Integer doctor, String date) {
        return doctorSessionRepository.findByDoctorAndDate(doctor, date);
    }

    public DoctorSession findSessionDetails(Integer id) {
        DoctorSession doctorSessionById = doctorSessionRepository.findDoctorSessionById(id);
        return doctorSessionById;
    }

    public Bookings saveBooking(Bookings bookings) {
        return bookingRepository.save(bookings);
    }
}
