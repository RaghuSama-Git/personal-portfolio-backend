package com.portfolio.get_in_touch.controller;

import com.portfolio.get_in_touch.model.GetInTouch;
import com.portfolio.get_in_touch.service.GetInTouchServiceImpl;
import com.portfolio.get_in_touch.utility.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/getintouch")
@CrossOrigin("*")
public class GetInTouchController {
    private final GetInTouchServiceImpl service;

    public GetInTouchController(GetInTouchServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/submit-details")
    public ResponseEntity<ResponseDTO<GetInTouch>> submitDetails(@RequestBody GetInTouch getInTouch){
        ResponseDTO<GetInTouch> responseDTO;

        if(getInTouch == null){
            responseDTO = new ResponseDTO<>("FAIL", null, "Details cannot be null");
            return ResponseEntity.ok(responseDTO);
        }
        GetInTouch submittedDetails = service.submitDetails(getInTouch);
        System.out.println("Server Response : " + getInTouch);
        responseDTO = new ResponseDTO<>("Success", submittedDetails, "Details have been saved successfully");
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/all-responses")
    public List<GetInTouch> fetchAllResponses() {
        List<GetInTouch> responseList = service.getAllVisitors();

        if (responseList == null || responseList.isEmpty()){
            return Collections.emptyList();
        }
        return responseList;
    }
}
