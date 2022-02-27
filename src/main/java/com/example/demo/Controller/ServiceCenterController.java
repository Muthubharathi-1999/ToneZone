package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.demo.Model.ServiceCenter;
import com.example.demo.Services.ServiceCenterService;

@RestController
@CrossOrigin("http://localhost:4200")
public class ServiceCenterController  {

	@Autowired
	ServiceCenterService serviceCenterService;
	
	@PostMapping(value = "/service-centers/store", produces = "application/json")
    public ResponseEntity<ServiceCenter> store(@RequestBody ServiceCenter serviceCenter) {
        ServiceCenter response = serviceCenterService.store(serviceCenter);
        if (response != null) {
            return new ResponseEntity<ServiceCenter>(response, HttpStatus.OK);
        }
        return new ResponseEntity<ServiceCenter>(new ServiceCenter(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/service-centers/all")
    public ResponseEntity<List<ServiceCenter>> getAll() {
        List<ServiceCenter> response = serviceCenterService.getAll();
        return new ResponseEntity<List<ServiceCenter>>(response, HttpStatus.OK);
    }
	
}
