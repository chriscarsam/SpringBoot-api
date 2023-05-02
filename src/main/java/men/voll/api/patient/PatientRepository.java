package men.voll.api.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
