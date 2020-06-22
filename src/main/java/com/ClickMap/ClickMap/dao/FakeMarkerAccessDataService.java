package com.ClickMap.ClickMap.dao;

import com.ClickMap.ClickMap.models.Marker;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository("fakeDao")
public class FakeMarkerAccessDataService implements MarkerDao {

    private static List<Marker> DB = new ArrayList<>();


    @Override
    public int insertMarker(UUID id, Marker marker) {

        DB.add(new Marker(id, marker.getTitle()));
        return 0;

    }

    @Override
    public int addMarker(Marker marker) {
        return 1;
    }

    @Override
    public List<Marker> selectAllMarkers() {
        return DB;
    }

    @Override
    public Optional<Marker> selectMarkerByID(UUID id) {
        return DB.stream()
                .filter(marker -> marker.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteMarkerById(UUID id) {

        Optional<Marker> markerMaybe = selectMarkerByID(id);

        if (markerMaybe.isEmpty()) { return 0; }

        DB.remove(markerMaybe.get());
        return 1;

    }

    @Override
    public int updateMarkerByID(UUID id, Marker marker) {

        return selectMarkerByID(id)
               .map(p ->  {

                   int indexOfMarkerToDelete = DB.indexOf(marker);
                   if (indexOfMarkerToDelete >= 0) {

                       DB.set(indexOfMarkerToDelete, marker);
                       return 1;

                   }
                   return 0;
               })
                .orElse(0);
    }
}
