package lk.doc.dotor_channel.repository;

import lk.doc.dotor_channel.entity.DoctorSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorSessionRepository extends JpaRepository<DoctorSession,Integer> {

    /*
    SELECT
 *
FROM
 doctor_session
WHERE
doctor_session.fk_doctor = 1
AND
IF("" = "", doctor_session.DATE >= "2019-06-23", doctor_session.DATE = "2019-06-23")
     */

    @Query(value = "SELECT * FROM doctor_session WHERE DATE(doctor_session.session_date) >= DATE(NOW())",nativeQuery = true)
    List<DoctorSession> findDoctorSessions();

    @Query(value = "SELECT * FROM doctor_session WHERE DATE(doctor_session.session_date) = :sessionDate",nativeQuery = true)
    public List<DoctorSession> findByDate(@Param("sessionDate") String  sessionDate);
//
    @Query(value = "SELECT * FROM doctor_session WHERE doctor_session.fk_doctor = :doctor AND DATE(doctor_session.session_date) >= DATE(NOW())",nativeQuery = true)
    public List<DoctorSession> findByDoctor(@Param("doctor") Integer  doctor);

    @Query(value = "SELECT * FROM doctor_session WHERE (doctor_session.fk_doctor = :doctor) AND (DATE(doctor_session.session_date) = :sessionDate)",nativeQuery = true)
    public List<DoctorSession> findByDoctorAndDate(@Param("doctor") Integer doctor,@Param("sessionDate") String  sessionDate);

//    @Query(value = "SELECT * FROM doctor_session WHERE id = :id",nativeQuery = true)
//    public DoctorSession findDoctorSessionById(@Param("id") Integer id);
    public DoctorSession findDoctorSessionById(Integer id);

}
