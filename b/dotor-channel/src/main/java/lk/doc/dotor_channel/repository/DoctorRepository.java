package lk.doc.dotor_channel.repository;

import lk.doc.dotor_channel.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    Doctor findDoctorById(Integer fkDoctor);
}
