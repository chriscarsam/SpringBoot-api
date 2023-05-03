package men.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import men.voll.api.doctor.MedicalListData;
import men.voll.api.patient.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("patients")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid PatientRegistrationData data){
        repository.save(new Patient(data));
    }

    @GetMapping
    public Page<PatientListData> medicalList(@PageableDefault(size = 2) Pageable pageable){
       //return repository.findAll(pageable).map(PatientListData::new);
        return repository.findByActiveTrue(pageable).map(PatientListData::new);
    }
    @PutMapping
    @Transactional
    public void updatePatient(@RequestBody @Valid DataUpdatePatient dataUpdatePatient){
        Patient patient = repository.getReferenceById(dataUpdatePatient.id());
        patient.updatePatient(dataUpdatePatient);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletePatient(@PathVariable Long id){
        Patient patient = repository.getReferenceById(id);
        patient.deactivatePatient();
    }
}
