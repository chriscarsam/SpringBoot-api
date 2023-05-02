package men.voll.api.controller;

import jakarta.validation.Valid;
import men.voll.api.doctor.Doctor;
import men.voll.api.doctor.MedicalListData;
import men.voll.api.doctor.MedicalRecordData;
import men.voll.api.doctor.MedicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private MedicalRepository medicalRepository;

    @PostMapping
    public void registerDoctor(@RequestBody @Valid MedicalRecordData medicalRecordData){
        medicalRepository.save(new Doctor(medicalRecordData));
    }
    @GetMapping
    public List<MedicalListData> medicalList(){
        return medicalRepository.findAll().stream().map(MedicalListData::new).toList();
    }

}
