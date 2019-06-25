package lk.doc.dotor_channel.repository;

import lk.doc.dotor_channel.entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Bookings, Integer> {

}
