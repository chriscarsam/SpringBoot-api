package men.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import men.voll.api.patient.Patient;
import men.voll.api.patient.PatientRegistrationData;
import men.voll.api.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
