package com.univbuc.eventreservation.admin.controllers;

import com.univbuc.eventreservation.admin.model.Event;
import com.univbuc.eventreservation.admin.services.AdminService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/events")
    public ResponseEntity<Event> addEvent(@Valid @RequestBody Event event){
        return ResponseEntity.ok(adminService.addEvent(event));
    }

    @PutMapping("/events/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable int id, @RequestBody Event event){
        return ResponseEntity.ok(adminService.updateEvent(event, id));
    }

    @DeleteMapping("/events/{id}")
    public ResponseEntity<Event> cancelEvent(@PathVariable int id){
        return ResponseEntity.ok(adminService.cancelEvent(id));
    }
}
