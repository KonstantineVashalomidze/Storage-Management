package org.example.controllers;

import org.example.models.StorageFacility;
import org.example.services.StorageFacilityService;
import org.example.views.StorageFacilityView;

import java.util.List;

public class StorageFacilityController {
    private final StorageFacilityService storageFacilityService;
    private final StorageFacilityView storageFacilityView;

    public StorageFacilityController(StorageFacilityService storageFacilityService, StorageFacilityView storageFacilityView) {
        this.storageFacilityService = storageFacilityService;
        this.storageFacilityView = storageFacilityView;
    }

    public void displayStorageFacilities() {
        List<StorageFacility> storageFacilities = storageFacilityService.getAllStorageFacilities();
        storageFacilityView.showStorageFacilities(storageFacilities);
    }

    public void addStorageFacility(String name, String location, int capacity) {
        StorageFacility newStorageFacility = new StorageFacility(name, location, capacity);
        boolean added = storageFacilityService.addStorageFacility(newStorageFacility);
        if (added) {
            storageFacilityView.showSuccessMessage("Storage facility added successfully.");
        } else {
            storageFacilityView.showErrorMessage("Failed to add storage facility. Please try again.");
        }
    }

    public void removeStorageFacility(int facilityId) {
        boolean removed = storageFacilityService.removeStorageFacility(facilityId);
        if (removed) {
            storageFacilityView.showSuccessMessage("Storage facility removed successfully.");
        } else {
            storageFacilityView.showErrorMessage("Failed to remove storage facility. Please try again.");
        }
    }

    // Other methods related to storage facility management can be added here...
}
