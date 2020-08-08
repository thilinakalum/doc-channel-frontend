package lk.doc.dotor_channel.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import lk.doc.dotor_channel.entity.Booking;
import lk.doc.dotor_channel.entity.Customer;
import lk.doc.dotor_channel.entity.Doctor;
import lk.doc.dotor_channel.entity.DoctorCategory;
import lk.doc.dotor_channel.entity.DoctorSession;
import lk.doc.dotor_channel.repository.BookingRepository;
import lk.doc.dotor_channel.repository.CustomerRepository;
import lk.doc.dotor_channel.repository.DoctorCategoryRepository;
import lk.doc.dotor_channel.repository.DoctorRepository;
import lk.doc.dotor_channel.repository.DoctorSessionRepository;

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

    @Autowired
    private CustomerRepository customerRepository;

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

    public Booking saveBooking(Booking booking) {
        Customer saveCustomer = customerRepository.save(booking.getFkCustomer());
        booking.setFkCustomer(saveCustomer);
        String message = "";
        message = message + " Date" + " " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "\n";
        message = message + " Time" + " " + new SimpleDateFormat("hh:mm:ss a").format(new Date()) + "\n";
        message = message + " Your OTP Number - " + " " + 2500 + "\n";
        String uri = "http://supervision-sms.supervisionglobal.com/send_sms.php?api_key=6614988023&number=94770247336&message=test";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        if ("0".equals(result)) {
            System.out.println("SENT");
        }else{
            System.out.println("ERROR");
        }
        return bookingRepository.save(booking);
    }

}
