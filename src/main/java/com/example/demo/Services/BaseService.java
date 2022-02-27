package com.example.demo.Services;

import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import com.example.demo.Model.BaseModel;
import java.util.List;

import org.json.simple.JSONObject;

@Service
public class BaseService {

    public String showOne(Object object, String msg, int status) {
        JSONObject json = new JSONObject();
        json.put("data", object);
        json.put("message", msg);
        json.put("status", status);
        JSONObject data = new JSONObject();
        data.put("data", json);
        String response = data.toString();
        if (response == null) {
            response = object.toString();
        }
        return response;
    }

    public String showAll(Object lists) {
        JSONObject data = new JSONObject();
        data.put("data", lists);
        String response = data.toString();
        if (response == null) {
            response = "NULL";
        }
        return response;
    }
}
