package com.medhead.ers.bsns_pms.data.sample;

import com.medhead.ers.bsns_pms.data.repository.PatientRepository;
import com.medhead.ers.bsns_pms.domain.entity.Patient;
import com.medhead.ers.bsns_pms.domain.valueObject.Gender;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSampleLoader {
    @Bean
    CommandLineRunner initDatabase(PatientRepository patientRepository) {
        return  args -> {
            patientRepository.save(new Patient("John", "Doe", 25, Gender.MALE));
            patientRepository.save(new Patient("Julia", "Sanderson", 48, Gender.FEMALE));
            patientRepository.save(new Patient("Duke", "Nukem", 62, Gender.UNKNOWN));
        };
    }
}
