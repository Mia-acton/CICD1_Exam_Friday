package com.example.cic1_lab_exam;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RequestMapping
@RestController
@ControllerAdvice
public class VehicleController {
    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<Vehicle> create(@Valid @RequestBody Vehicle v) {
        Vehicle created = service.create(v);
        return ResponseEntity.created(URI.create("/api/vehicles/" + created.getRegNumber())).body(created);
    }

    @GetMapping("/{regNumber}")
    public ResponseEntity<Vehicle> getOne(@Valid @PathVariable String reg) {
        Optional<Vehicle> maybe = service.findByReg(reg);
        if (maybe.isPresent()) {
            return ResponseEntity.ok(maybe.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{regNumber}")
    public ResponseEntity<Vehicle> update(@Valid String reg, @Valid @PathVariable String newName) {
        Optional<Vehicle> maybe = service.update(reg, newName);
        if (maybe.isPresent()) {
            return ResponseEntity.ok(maybe.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/bookings/{regNumber}")
    public ResponseEntity<Vehicle> delete(@Valid @PathVariable String reg) {
        boolean deleted = service.delete(reg);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
