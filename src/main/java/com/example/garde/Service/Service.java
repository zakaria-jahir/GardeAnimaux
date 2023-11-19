package com.example.garde.Service;

import com.example.garde.Repository.AdminRepository;
import com.example.garde.Repository.ClientRepository;
import com.example.garde.Repository.GardienRepository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private GardienRepository gardienRepository;


}
