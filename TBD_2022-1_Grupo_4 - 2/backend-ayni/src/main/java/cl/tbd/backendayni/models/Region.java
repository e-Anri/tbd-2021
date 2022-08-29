package cl.tbd.backendayni.models;

//import org.postgis.PGgeometry;

public class Region {
    //ATRIBUTOS de REGION
    /**
     * @param id id 
     * @param id_region id de la region
     * @param nom_reg nombre de la region
     * @param geom geometria de la region
     */
    private long id;
    private long id_region;
    private String nom_reg;
    private String geom;

    // CONSTRUCTOR REGION
    public Region() {
    }

    public Region(long id, long id_region, String nom_reg, String geom) {
        this.id = id;
        this.id_region = id_region;
        this.nom_reg = nom_reg;
        this.geom = geom;
    }

    // Getters
    public long getId() {
        return id;
    }

    public long getId_region() {
        return id_region;
    }

    public String getNom_reg() {
        return nom_reg;
    }

    public String getGeom() {
        return geom;
    }

    // Setters

    public void setId(long id) {
        this.id = id;
    }

    public void setId_region(long id_region) {
        this.id_region = id_region;
    }

    public void setNom_reg(String nom_reg) {
        this.nom_reg = nom_reg;
    }

    public void setGeom(String geom) {
        this.geom = geom;
    }

    // ToString
    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", id_region=" + id_region +
                ", nom_reg='" + nom_reg + '\'' +
                ", geom=" + geom +
                '}';
    }
}
