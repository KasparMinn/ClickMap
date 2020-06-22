package com.ClickMap.ClickMap.service;

import com.ClickMap.ClickMap.dao.MarkerDao;
import com.ClickMap.ClickMap.models.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class MarkerService {

    private final MarkerDao markerDao;

    @Autowired
    public MarkerService(@Qualifier("fakeDao") MarkerDao markerDao) {
        this.markerDao = markerDao;
    }


    public int addMarker(Marker marker) {

        return markerDao.addMarker(marker);

    }

    public List<Marker> getAllMarkers() {

        return markerDao.selectAllMarkers();

    }

    public Optional<Marker> getMarkerById(UUID id) {

        return markerDao.selectMarkerByID(id);

    }

    public int deleteMarker(UUID id) {

        return markerDao.deleteMarkerById(id);

    }

    public int updateMarker(UUID id, Marker newMarker) {

        return markerDao.updateMarkerByID(id, newMarker);

    }
}
