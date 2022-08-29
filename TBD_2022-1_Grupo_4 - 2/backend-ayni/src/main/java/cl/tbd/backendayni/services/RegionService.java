package cl.tbd.backendayni.services;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import cl.tbd.backendayni.models.Region;
import cl.tbd.backendayni.repositories.RegionRepository;

@RestController
@RequestMapping("/region")
public class RegionService {

    private final RegionRepository regionRepository;

    /**
     * @param regionRepository
     */
    RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    /**
     * @return {@value} List<Region> lista de regiones
     */
    @GetMapping
    public List<Region> getAll() {
        return regionRepository.getAll();
    }

    /**
     * @param region
     * @return {@value} Region region
     */
    @PostMapping("/create")
    @ResponseBody
    public Region createRegion(@RequestBody Region region) {
        Region newRegion = regionRepository.createRegion(region);
        return newRegion;
    }

    /**
     * @param id
     * @return {@value} lista de regiones por id
     */
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Region> showRegionById(@PathVariable long id) {
        return regionRepository.showRegionById(id);
    }

    /**
     * @param region
     * @return void
     */
    @RequestMapping(value = "/updateById/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateById(@RequestBody Region region) {
        regionRepository.updateRegion(region);
    }

    /**
     * @param id
     * @return void
     */
    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteById(@PathVariable long id) {
        regionRepository.deleteRegionById(id);
    }

    /**
     * @return String cantidad de regiones
     */
    @GetMapping("/count")
    public String countRegion() {
        int total = regionRepository.countRegiones();
        return String.format("Se tienen %s regiones.", total);
    }

}
