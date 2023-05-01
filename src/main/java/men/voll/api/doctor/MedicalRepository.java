package men.voll.api.doctor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRepository extends JpaRepository<Doctor, Long> {
}
