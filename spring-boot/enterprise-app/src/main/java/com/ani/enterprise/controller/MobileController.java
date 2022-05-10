package com.ani.enterprise.controller;

import com.ani.enterprise.dto.AppRes;
import com.ani.enterprise.dto.MobileDto;
import com.ani.enterprise.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Component
@RequestMapping("/mobile")
@RestController // this receives and sends back data to client
public class MobileController {

    @Autowired
    private MobileService service;

    @PostMapping   // POST: http://localhost:8989/mobile/
    public ResponseEntity<AppRes> addNewMobile(@RequestBody MobileDto dto) {
        service.createMobile(dto);
        AppRes res = new AppRes("success", "added new mobile");
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PostMapping(value = "/xml", consumes = MediaType.APPLICATION_XML_VALUE)  // POST: http://localhost:8989/mobile/xml
    public ResponseEntity<AppRes> addNewMobileXml(@RequestBody MobileDto dto) {

        service.createMobile(dto);

        AppRes res = new AppRes("success", "added new mobile");

        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping // GET: http://localhost:8989/mobile/
    public ResponseEntity<List<MobileDto>> showAll() {
        return ResponseEntity.ok(service.showAllMobiles());
    }

    @DeleteMapping(value = "/{id}") // DELETE: http://localhost:8989/mobile/13
    public ResponseEntity<AppRes> deleteMobile(@PathVariable Long id) {
        service.removeMobile(id);
        return ResponseEntity.ok(new AppRes("success", "deleted mobile successfully"));
    }

    @PutMapping // PUT: http://localhost:8989/mobile/
    public ResponseEntity<Object> updateMobile(@RequestBody MobileDto dto) {
        MobileDto resDto = service.updateMobile(dto);
        return new ResponseEntity<>(resDto, HttpStatus.CREATED);
    }

    // GET: http://localhost:8989/mobile/1
    public ResponseEntity<MobileDto> mobileDetails(Long id) {
        return null;
    }
}
