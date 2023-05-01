package men.voll.api.controller;

import men.voll.api.doctor.Doctor;
import men.voll.api.doctor.MedicalRecordData;
import men.voll.api.doctor.MedicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class DoctorController {

    @Autowired
    private MedicalRepository medicalRepository;

    @PostMapping
    public void registerDoctor(@RequestBody MedicalRecordData medicalRecordData){
        medicalRepository.save(new Doctor(medicalRecordData));
    }

}
