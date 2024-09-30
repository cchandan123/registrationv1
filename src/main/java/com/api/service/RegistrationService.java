package com.api.service;

import com.api.entity.Registration;
import com.api.payload.RegistrationDto;
import com.api.repository.RegistrationRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class RegistrationService {

    private RegistrationRepository registrationRepository;

    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public List<Registration> getRegistrations(){
        List<Registration> registrations = registrationRepository.findAll();
        return registrations;
    }

    public RegistrationDto createRegistration(RegistrationDto registrationDto) {
        Registration registration = new Registration();
        registration.setName(registrationDto.getName());
        registration.setEmail(registrationDto.getEmail());
        registration.setMobile(registrationDto.getMobile());
        Registration savedEntity = registrationRepository.save(registration);
        RegistrationDto dto = new RegistrationDto();
        dto.setName(savedEntity.getName());
        dto.setEmail(savedEntity.getEmail());
        dto.setMobile(savedEntity.getMobile());
        return dto;
    }

    public void deleteRegistration(long id) {
        registrationRepository.deleteById(id);
    }

    public Registration updateRegistration(long id, Registration registration) {
        Registration r = registrationRepository.findById(id).get();
        r.setName(registration.getName());
        r.setEmail(registration.getEmail());
        r.setMobile(registration.getMobile());
        Registration savedEntity = registrationRepository.save(r);
        return savedEntity;
    }
}
