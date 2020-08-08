package lk.doc.dotor_channel.repository;

import lk.doc.dotor_channel.entity.DoctorSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorSessionRepository extends JpaRepository<DoctorSession, Integer> {

    @Query(value = "SELECT \n" +
            " * \n" +
            "FROM \n" +
            " doctor_session \n" +
            "WHERE\n" +
            "(:doctor IS NULL OR doctor_session.fk_doctor = :doctor)\n" +
            "AND\n" +
            "(:date = \"\" OR doctor_session.session_date >= :date)", nativeQuery = true)
    List<DoctorSession> findByDoctorAndDate(@Param("doctor") Integer doctor, @Param("date") String date);

    DoctorSession findDoctorSessionById(Integer id);

}
