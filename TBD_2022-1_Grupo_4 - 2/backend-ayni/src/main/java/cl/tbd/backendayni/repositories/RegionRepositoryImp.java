package cl.tbd.backendayni.repositories;

import cl.tbd.backendayni.models.Region;
import org.sql2o.Sql2o;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;

@Repository
public class RegionRepositoryImp implements RegionRepository {
    @Autowired
    private Sql2o sql2o;

    /**
     * @return Cantidad de regiones
     * @throws Exception
     */
    @Override
    public int countRegiones() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM regiones";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
            return total;
        }
    }

    /**
     * @return nuevo id de region
     * @throws Exception
     */
    @Override
    public int newId() {
        int id = 0;
        String sql = "SELECT MAX(id) FROM regiones";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id;
        }
    }

    /**
     * @return Lista de regiones
     * @throws Exception
     */
    @Override
    public List<Region> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT regiones.id, regiones.id_region, regiones.nom_reg, ST_AsText(regiones.geom) AS geom FROM regiones ORDER BY regiones.id_region ASC")
                    .executeAndFetch(Region.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * @param id id de la region
     * @return region
     * @throws Exception
     */
    @Override
    public List<Region> showRegionById(long id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT regiones.id, regiones.id_region, regiones.nom_reg, ST_AsText(regiones.geom) AS geom FROM regiones WHERE id_region = :id")
                    .addParameter("id", id)
                    .executeAndFetch(Region.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * @param region region
     * @return region
     * @throws Exception
     */ 
    @Override
    public Region createRegion(Region region) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO regiones (id_region, nom_reg, geom) VALUES (:id_region2, :nombre2, ST_GeomFromText( :geom2))";
            conn.createQuery(sql)
                    .addParameter("id_region2", region.getId_region())
                    .addParameter("nombre2", region.getNom_reg())
                    .addParameter("geom2", region.getGeom())
                    .executeUpdate();
            region.setId(newId());
            return region;
        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear la region");
            return null;
        }
    }


    @Override
    public void deleteRegionById(long id) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM regiones WHERE id_region = :id";
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo eliminar la region");
        }

    }

    @Override
    public void updateRegion(Region region) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE regiones SET id_region = :id_region2, nom_reg = :nombre2, geom = ST_GeomFromText( :geom2) WHERE id = :id";
            conn.createQuery(sql)
                    .addParameter("id_region2", region.getId_region())
                    .addParameter("nombre2", region.getNom_reg())
                    .addParameter("geom2", region.getGeom())
                    .addParameter("id", region.getId())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar la region");
        }

    }

}
