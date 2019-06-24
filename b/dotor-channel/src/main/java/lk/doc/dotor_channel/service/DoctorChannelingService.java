package lk.doc.dotor_channel.service;


import lk.doc.dotor_channel.entity.Doctor;
import lk.doc.dotor_channel.entity.DoctorCategory;
import lk.doc.dotor_channel.entity.DoctorSession;
import lk.doc.dotor_channel.repository.DoctorCategoryRepository;
import lk.doc.dotor_channel.repository.DoctorRepository;
import lk.doc.dotor_channel.repository.DoctorSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public List<Doctor> findAllDoctolers(){
        return doctorRepository.findAll();
    }

    public List<DoctorCategory> findAllDoctorCategory(){
        return doctorCategoryRepository.findAll();
    }

    public List<DoctorSession> findByDoctorAndDate(Integer doctor,String  date){
       return doctorSessionRepository.findByDoctorAndDate(doctor,date);
    }

    public Optional<DoctorSession> findSessionDetails(Integer id) {
        Optional<DoctorSession> byId = doctorSessionRepository.findOne(id);
        Optional<DoctorSession> doctorSession = doctorRepository.findById(byId.get());
    }
}
