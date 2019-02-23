package com.service;

import com.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.database.AdminEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final
    AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public String[] returnLogin() {
        try {
            String [] n= new String[adminRepository.findByPassword("root").size()];
            for(int i=0; i<adminRepository.findByPassword("root").size(); i++ ){
               n[i] = adminRepository.findByPassword("root").get(i).getLogin();
            }
            return n;
        } catch (NullPointerException ex) {
            return null;
        }
    }


}
