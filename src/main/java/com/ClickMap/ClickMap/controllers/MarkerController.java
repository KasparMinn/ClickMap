package com.ClickMap.ClickMap.controllers;
import com.ClickMap.ClickMap.models.Marker;
import com.ClickMap.ClickMap.service.MarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping ("/api/v1/marker")
@RestController

public class MarkerController {

    private final MarkerService markerService;

    @Autowired
    public MarkerController(MarkerService markerService) {
        this.markerService = markerService;
    }

    @PostMapping
    public void addPerson(@RequestBody Marker marker) {
        markerService.addMarker(marker);
    }

    @GetMapping
    public List<Marker> getAllMarkers() {
        return markerService.getAllMarkers();
    }


    @GetMapping(path = "{id}")
    public Marker getMarkerById(@PathVariable("id") UUID id) {

        return markerService.getMarkerById(id)
                .orElse(null);

    }

    @DeleteMapping(path = "{id}")
    public void deleteMarkerByID(@PathVariable("id") UUID id) {
     markerService.deleteMarker(id);
    }

    @PutMapping(path = "{id}")
    public void updateMarker(@PathVariable("id") UUID id, @RequestBody Marker markerToUpdate) {
        markerService.updateMarker(id, markerToUpdate);
    }
}
