package com.example.bcp.model;
import jakarta.persistence.*;

@Entity
@Table(name =  "\"Area\"")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"Area_Id\"")
    private Integer areaId;

    @Column(name = "\"Area_Nombre\"", length = 100)
    private String areaNombre;

    @Column(name = "\"Area_Descripcion\"", length = 100)
    private String areaDescripcion;

    @Column(name = "\"Area_Direccion\"", length = 50)
    private String areaDireccion;

    // Getters and Setters

    public String getAreaNombre() {
        return areaNombre;
    }

    public void setAreaNombre(String areaNombre) {
        this.areaNombre = areaNombre;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaDescripcion() {
        return areaDescripcion;
    }

    public void setAreaDescripcion(String areaDescripcion) {
        this.areaDescripcion = areaDescripcion;
    }

    public String getAreaDireccion() {
        return areaDireccion;
    }

    public void setAreaDireccion(String areaDireccion) {
        this.areaDireccion = areaDireccion;
    }

    public Area() {

    }

    public Area(String areaDescripcion, String areaDireccion, String areaNombre) {
        this.areaDescripcion = areaDescripcion;
        this.areaDireccion = areaDireccion;
        this.areaNombre = areaNombre;
    }
}
