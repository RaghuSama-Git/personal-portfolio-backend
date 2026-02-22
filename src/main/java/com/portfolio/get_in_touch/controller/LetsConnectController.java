package com.portfolio.get_in_touch.controller;

import com.portfolio.get_in_touch.model.LetsConnect;
import com.portfolio.get_in_touch.service.LetsConnectServiceImpl;
import com.portfolio.get_in_touch.utility.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/lets-connect")
@CrossOrigin("*")
public class LetsConnectController {
    private final LetsConnectServiceImpl service;

    public LetsConnectController(LetsConnectServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/submit-details")
    public ResponseEntity<ResponseDTO<List<LetsConnect>>> submitDetails(@RequestBody List<LetsConnect> letsConnect){
        ResponseDTO<List<LetsConnect>> responseDTO;

        if(letsConnect == null){
            responseDTO = new ResponseDTO<>("FAIL", null, "Details cannot be null");
            return ResponseEntity.ok(responseDTO);
        }
        List<LetsConnect> submittedDetails = service.submitDetails(letsConnect);
        System.out.println("Server Response : " + letsConnect);
        responseDTO = new ResponseDTO<>("Success", submittedDetails, "Details have been saved successfully");
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/all-responses")
    public List<LetsConnect> fetchAllResponses() {
        List<LetsConnect> responseList = service.getAllVisitors();

        if (responseList == null || responseList.isEmpty()){
            return Collections.emptyList();
        }
        return responseList;
    }

    @GetMapping("update-name")
    public List<LetsConnect> updateAllUserDetails(){
        return service.updateAllUserDetails();
    }
}
