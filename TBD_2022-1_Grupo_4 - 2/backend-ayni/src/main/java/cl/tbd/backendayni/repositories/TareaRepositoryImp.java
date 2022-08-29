package cl.tbd.backendayni.repositories;

import org.springframework.stereotype.Repository;
import cl.tbd.backendayni.models.Tarea;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class TareaRepositoryImp implements TareaRepository {

    @Autowired
    private Sql2o sql2o;

    /**
     * @return {@value} int cantidad de tareas
     * @throws Exception si no se puede obtener la cantidad de tareas
     * @see cl.tbd.backendayni.repositories.TareaRepository#countTareas()
     */
    @Override
    public int countTareas() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM tarea";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
            return total;
        }
    }

    /**
     * @return {@value} int nuevo id
     * @throws Exception si no se puede obtener el id
     * @see cl.tbd.backendayni.repositories.TareaRepository#newId()
     */
    @Override
    public int newId() {
        int id = 0;
        String sql = "SELECT MAX(id) FROM tarea";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id;
        }
    }

    /**
     * @return {@value} List<Tarea> lista de tareas
     * @throws Exception si no se puede obtener la lista de tareas
     * @see cl.tbd.backendayni.repositories.TareaRepository#getAll()
     */
    @Override
    public List<Tarea> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(
                    "SELECT id, id_emergencia, nombre, descripcion, fecha, requerimientos, longitude, latitude, ST_AsText(geom) AS geom FROM tarea ORDER BY tarea.id ASC")
                    .executeAndFetch(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * @param id {@value} long id de la tarea
     * @return {@value} List<Tarea> lista de tareas
     * @throws Exception si no se puede obtener la lista de tareas
     * @see cl.tbd.backendayni.repositories.TareaRepository#showTareaById(long id)
     */
    @Override
    public List<Tarea> showTareaById(long id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM tarea WHERE tarea.id = :id")
                    .addParameter("id", id)
                    .executeAndFetch(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * @param tarea {@value} Tarea tarea a crear
     * @return {@value} Tarea tarea creada
     * @throws Exception si no se puede crear la tarea
     * @see cl.tbd.backendayni.repositories.TareaRepository#createTarea(Tarea tarea)
     */
    @Override
    public Tarea createTarea(Tarea tarea) {
        Connection conn = sql2o.open();

        String SQL_INSERT = "INSERT INTO tarea(id_emergencia, nombre, descripcion, fecha, requerimientos, longitude, latitude, geom)"
                +
                "VALUES (:id_emergencia2, :nombre2, :descripcion2, :fecha2, :requerimientos2, :longitude2, :latitude2, ST_MakePoint( :latitude2,:longitude2))";

        try {
            conn.createQuery(SQL_INSERT)
                    .addParameter("id_emergencia2", tarea.getId_emergencia())
                    .addParameter("nombre2", tarea.getNombre())
                    .addParameter("descripcion2", tarea.getDescripcion())
                    .addParameter("fecha2", tarea.getFecha())
                    .addParameter("requerimientos2", tarea.getRequerimientos())
                    .addParameter("longitude2", tarea.getLongitude())
                    .addParameter("latitude2", tarea.getLatitude())
                    .executeUpdate();
            tarea.setId(newId());

            return tarea;

        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear la emergencia\n");
            return null;
        }
    }

    /**
     * @param id {@value} long id de la tarea
     * @return {@value} Tarea tarea eliminada
     * @throws Exception si no se puede eliminar la tarea
     * @see cl.tbd.backendayni.repositories.TareaRepository#deleteTarea(long id)
     */
    @Override
    public void deleteTareaById(long id) {
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM tarea WHERE tarea.id = :id";

        try {
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar la tarea\n");
        }
    }

    /**
     * @param tarea {@value} Tarea tarea a actualizar
     * @return {@value} Tarea tarea actualizada
     * @throws Exception si no se puede actualizar la tarea
     * @see cl.tbd.backendayni.repositories.TareaRepository#updateTarea(Tarea tarea)
     */
    @Override
    public void updateTarea(Tarea tarea) {

        String SQL_UPDATE = "UPDATE tarea SET id_emergencia = :id_emergencia2, nombre = :nombre2, descripcion = :descripcion2, fecha = :fecha2, requerimientos = :requerimientos2, longitude = :longitude2, latitude = :latitude2, geom = ST_MakePoint( :latitude2,:longitude2), id = :id2 WHERE id = :id2";

        try (Connection conn = sql2o.open()) {

            conn.createQuery(SQL_UPDATE)
                    .addParameter("id_emergencia2", tarea.getId_emergencia())
                    .addParameter("nombre2", tarea.getNombre())
                    .addParameter("descripcion2", tarea.getDescripcion())
                    .addParameter("fecha2", tarea.getFecha())
                    .addParameter("requerimientos2", tarea.getRequerimientos())
                    .addParameter("longitude2", tarea.getLongitude())
                    .addParameter("latitude2", tarea.getLatitude())
                    .addParameter("id2", tarea.getId())
                    .executeUpdate();
            conn.createQuery("UPDATE tarea SET geom = ST_MakePoint(latitude, longitude) WHERE id = :id2")
                    .addParameter("id2", tarea.getId())
                    .executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar la tarea\n");
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // COMPLEMENTARIOS

    /**
     * @param id {@value} long id de la emergencia
     * @return {@value} List<Tarea> lista de tareas
     * @throws Exception si no se puede obtener la lista de tareas
     * @see cl.tbd.backendayni.repositories.TareaRepository#showTareaByIdEmergencia(long
     *      id)
     */
    @Override
    public List<Tarea> getTareaByIdEmergencia(long id) {
        String SQL_SELECT = "SELECT id, id_emergencia, nombre, descripcion, fecha, requerimientos, longitude, latitude, ST_AsText(geom) AS geom FROM tarea WHERE tarea.id_emergencia = :id";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(SQL_SELECT)
                    .addParameter("id", id)
                    .executeAndFetch(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    
    // REQUISITOS
    /**
     * @param id {@value} long id de la region
     * @return {@value} List<Tarea> lista de tareas
     * @throws Exception si no se puede obtener la lista de tareas
     * @see cl.tbd.backendayni.repositories.TareaRepository#showTareaByIdRegion(long
     *      id)
     */
    @Override
    public List<Tarea> getTareaByIdRegion(long id){
        String SQL_SELECT = "SELECT tarea.id, tarea.id_emergencia, tarea.nombre, tarea.descripcion, tarea.fecha, tarea.requerimientos, tarea.longitude, tarea.latitude, ST_AsText(tarea.geom) AS geom FROM  tarea JOIN regiones ON ST_Intersects(regiones.geom,tarea.geom) WHERE regiones.id_region = :id";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(SQL_SELECT)
                    .addParameter("id", id)
                    .executeAndFetch(Tarea.class);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
