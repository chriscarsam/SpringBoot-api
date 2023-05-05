package men.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import men.voll.api.address.AddressData;
import men.voll.api.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.print.Doc;
import java.net.URI;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private MedicalRepository medicalRepository;

    @PostMapping
    public ResponseEntity<MedicalResponseData> registerDoctor(@RequestBody @Valid MedicalRecordData medicalRecordData, UriComponentsBuilder uriComponentsBuilder){
        Doctor doctor = medicalRepository.save(new Doctor(medicalRecordData));
        MedicalResponseData medicalResponseData =  new MedicalResponseData(
                doctor.getId(), doctor.getName(), doctor.getEmail(),
                doctor.getPhone(), doctor.getSpecialty().toString(),
                new AddressData(doctor.getAddress().getStreet(), doctor.getAddress().getDistrict(),
                        doctor.getAddress().getCity(), doctor.getAddress().getNumber(),
                        doctor.getAddress().getComplement()));

        URI uri = uriComponentsBuilder.path("/doctors/{id}").buildAndExpand(doctor.getId()).toUri();
        return ResponseEntity.created(uri).body(medicalResponseData);
    }
    @GetMapping
    public ResponseEntity<Page<MedicalListData>> medicalList(@PageableDefault(size = 2) Pageable pageable){
        //return medicalRepository.findAll(pageable).map(MedicalListData::new);
        return ResponseEntity.ok(medicalRepository.findByActiveTrue(pageable).map(MedicalListData::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateDoctor(@RequestBody @Valid DataUpdateDoctor dataUpdateDoctor){
        Doctor doctor = medicalRepository.getReferenceById(dataUpdateDoctor.id());
        doctor.updateData(dataUpdateDoctor);
        return ResponseEntity.ok(
                new MedicalResponseData(
                        doctor.getId(), doctor.getName(), doctor.getEmail(),
                        doctor.getPhone(), doctor.getSpecialty().toString(),
                new AddressData(doctor.getAddress().getStreet(), doctor.getAddress().getDistrict(),
                        doctor.getAddress().getCity(), doctor.getAddress().getNumber(),
                        doctor.getAddress().getComplement())));
    }
    // DELETE LOGICO
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteDoctor(@PathVariable Long id){
        Doctor doctor = medicalRepository.getReferenceById(id);
        doctor.deactivateDoctor();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalResponseData> returnMedicalData(@PathVariable Long id){
        Doctor doctor = medicalRepository.getReferenceById(id);
        doctor.deactivateDoctor();
        var medicalData =  new MedicalResponseData(
                doctor.getId(), doctor.getName(), doctor.getEmail(),
                doctor.getPhone(), doctor.getSpecialty().toString(),
                new AddressData(doctor.getAddress().getStreet(), doctor.getAddress().getDistrict(),
                        doctor.getAddress().getCity(), doctor.getAddress().getNumber(),
                        doctor.getAddress().getComplement()));
        return ResponseEntity.ok(medicalData);
    }

}
