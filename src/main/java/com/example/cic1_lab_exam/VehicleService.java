package com.example.cic1_lab_exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VehicleService {
    private final List<Vehicle> store = new ArrayList<>();
    public List<Vehicle> findAll() { return new ArrayList<>(store); }
    public Optional<Vehicle> findByReg(String reg) {
        for (Vehicle vehicle : store) {
            if (vehicle.getRegNumber().equals(reg)) {
                return Optional.of(vehicle);
            }
        }
        return Optional.empty();
    }

    public Vehicle create(Vehicle vehicle) {
        if (findByReg(vehicle.getRegNumber()).isPresent()) {
            throw new IllegalArgumentException(vehicle.getRegNumber() + " already exists.");
        }
        store.add(vehicle);
        return vehicle;
    }

    public boolean delete(String reg) {
        for (Vehicle vehicle : store) {
            if (vehicle.getRegNumber().equals(reg)) {
                store.remove(vehicle);
                return true;
            }
        }
        return false;
    }

    public Optional<Vehicle> update(String reg, String newName) {
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getRegNumber().equals(reg)) {
                Vehicle vehicle = store.get(i);
                vehicle.setDriverName(newName);
                return Optional.of(vehicle);
            }
        }
        throw new IllegalArgumentException(reg + " does not exist.");
    }
}
