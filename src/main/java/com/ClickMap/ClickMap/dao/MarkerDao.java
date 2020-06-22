package com.ClickMap.ClickMap.dao;

import com.ClickMap.ClickMap.models.Marker;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MarkerDao {

    int insertMarker(UUID id, Marker marker);

    default int addMarker(Marker marker) {

        UUID id = UUID.randomUUID();
        return insertMarker(id, marker);

    }

    List<Marker> selectAllMarkers();

    Optional<Marker> selectMarkerByID(UUID id);

    int deleteMarkerById(UUID id);
    int updateMarkerByID(UUID id, Marker marker);

}
