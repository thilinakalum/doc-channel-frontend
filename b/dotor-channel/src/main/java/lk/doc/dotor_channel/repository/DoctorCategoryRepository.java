package lk.doc.dotor_channel.repository;

import lk.doc.dotor_channel.entity.DoctorCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorCategoryRepository extends JpaRepository<DoctorCategory,Integer> {
}
