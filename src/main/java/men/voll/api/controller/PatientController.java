package men.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import men.voll.api.patient.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("patients")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<PatientDetailData> register(@RequestBody @Valid PatientRegistrationData data, UriComponentsBuilder uriBuilder){
        var patient = new Patient(data);
        repository.save(patient);

        var uri = uriBuilder.path("/patients/{id}").buildAndExpand(patient.getId()).toUri();
        return ResponseEntity.created(uri).body(new PatientDetailData(patient));
    }

    @GetMapping
    public ResponseEntity<Page<PatientListData>> medicalList(@PageableDefault(size = 4, sort = {"name"}) Pageable pageable){
       var page = repository.findByActiveTrue(pageable).map(PatientListData::new);
        return ResponseEntity.ok(page);
    }
    @PutMapping
    @Transactional
    public ResponseEntity<PatientDetailData> updatePatient(@RequestBody @Valid DataUpdatePatient dataUpdatePatient){
        Patient patient = repository.getReferenceById(dataUpdatePatient.id());
        patient.updatePatient(dataUpdatePatient);

        return ResponseEntity.ok(new PatientDetailData(patient));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletePatient(@PathVariable Long id){
        Patient patient = repository.getReferenceById(id);
        patient.deactivatePatient();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDetailData> returnPatientData(@PathVariable Long id){
        Patient patient = repository.getReferenceById(id);
        return ResponseEntity.ok(new PatientDetailData(patient));
    }
}
