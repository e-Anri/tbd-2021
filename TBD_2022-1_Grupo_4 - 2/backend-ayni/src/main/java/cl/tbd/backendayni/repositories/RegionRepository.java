package cl.tbd.backendayni.repositories;

import cl.tbd.backendayni.models.Region;
import java.util.List;

/**
 * Interface para RegionRepository
 */
public interface RegionRepository {
    public int countRegiones();

    public int newId();

    public List<Region> getAll();

    public List<Region> showRegionById(long id);

    public Region createRegion(Region region);

    public void deleteRegionById(long id);

    public void updateRegion(Region region);

}
