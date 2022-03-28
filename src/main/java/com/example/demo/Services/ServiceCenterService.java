package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.example.demo.Model.ServiceCenter;
import com.example.demo.Repository.ServiceCenterRepository;
import java.util.List;
@Service
public class ServiceCenterService {
	
	@Autowired
	ServiceCenterRepository serviceCenterRepository;

    @Autowired
    BaseService baseService;
	
	public ServiceCenter store(ServiceCenter serviceCenter) {
        ServiceCenter obj = serviceCenterRepository.save(serviceCenter);
        return obj;
    }

    public List<ServiceCenter> getAll() {
        List<ServiceCenter> serviceCenters = serviceCenterRepository.findAll();
        return serviceCenters;
    }
}