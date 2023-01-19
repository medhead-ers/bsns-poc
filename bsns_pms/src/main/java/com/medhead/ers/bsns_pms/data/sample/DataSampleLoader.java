package com.medhead.ers.bsns_pms.data.sample;

import com.medhead.ers.bsns_pms.data.repository.PatientRepository;
import com.medhead.ers.bsns_pms.domain.entity.Patient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSampleLoader {
    @Bean
    CommandLineRunner initDatabase(PatientRepository patientRepository) {
        return  args -> {
            patientRepository.save(new Patient("John", "Doe", 25));
            patientRepository.save(new Patient("Bob", "Sand", 48));
            patientRepository.save(new Patient("Duke", "Nukem", 62));
        };
    }
}
