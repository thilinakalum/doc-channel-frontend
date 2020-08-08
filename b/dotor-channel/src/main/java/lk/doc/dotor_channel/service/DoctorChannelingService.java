package lk.doc.dotor_channel.service;

import lk.doc.dotor_channel.entity.*;
import lk.doc.dotor_channel.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DoctorChannelingService {

  @Autowired private DoctorRepository doctorRepository;

  @Autowired private DoctorCategoryRepository doctorCategoryRepository;

  @Autowired private DoctorSessionRepository doctorSessionRepository;

  @Autowired private BookingRepository bookingRepository;

  @Autowired private CustomerRepository customerRepository;

  public List<Doctor> findAllDoctolers() {
    return doctorRepository.findAll();
  }

  public List<DoctorCategory> findAllDoctorCategory() {
    return doctorCategoryRepository.findAll();
  }

  public List<DoctorSession> findByDoctorAndDate(Integer doctor, String date) {
    if (date != null && doctor != null) {
      return doctorSessionRepository.findByDoctorAndDate(doctor, date);
    }
    if (date != null) {
      return doctorSessionRepository.findByDate(date);
    }
    if (doctor != null) {
      return doctorSessionRepository.findByDoctor(doctor);
    }
    return doctorSessionRepository.findDoctorSessions();
  }

  public DoctorSession findSessionDetails(Integer id) {
    DoctorSession doctorSessionById = doctorSessionRepository.findDoctorSessionById(id);
    return doctorSessionById;
  }

  public Booking saveBooking(Booking booking) {
    Customer saveCustomer = customerRepository.save(booking.getFkCustomer());
    booking.setFkCustomer(saveCustomer);
    return bookingRepository.save(booking);
  }
}
