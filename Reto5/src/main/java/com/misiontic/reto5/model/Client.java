package com.misiontic.reto5.model;

/**
 * <span>Descripción:</span>
 * <p>
 * Clase que representa la entidad Cliente en la base de datos.</p>
 *
 * @author Daniel Felipe Lozada Ramirez Email: dflozada2@misena.edu.co
 * @author Roller Stivenson Sosa Llanes Email: stivenson.sosa@gmail.com
 * @version 1.0.0
 * @since 2021
 */
public class Client {

    private int ID;
    private String name;
    private String specie;
    private String gender;

    /**
     * <span>Descripción:</span>
     * <p>
     * Permite obtener el ID del cliente.</p>
     *
     * @return ID - Retorna el ID del cliente
     */
    public int getID() {
        return ID;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Permite establecer el ID del cliente.</p>
     *
     * @param ID Recibe como parámetro un entero con el ID del cliente
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Permite obtener el nombre del cliente.</p>
     *
     * @return name - Retorna el nombre del cliente
     */
    public String getName() {
        return name;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Permite establecer el nombre del cliente.</p>
     *
     * @param name Recibe como parámetro un String con el nombre del cliente
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Permite obtener la especie del cliente.</p>
     *
     * @return specie - Retorna la especie del cliente
     */
    public String getSpecie() {
        return specie;
    }

        /**
     * <span>Descripción:</span>
     * <p>
     * Permite establecer la especie del cliente.</p>
     *
     * @param specie Recibe como parámetro un String con la especie del cliente
     */
    public void setSpecie(String specie) {
        this.specie = specie;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Permite obtener el género del cliente.</p>
     *
     * @return gender - Retorna el género del cliente
     */
    public String getGender() {
        return gender;
    }

        /**
     * <span>Descripción:</span>
     * <p>
     * Permite establecer el género del cliente.</p>
     *
     * @param gender Recibe como parámetro un String con el génerp del cliente
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

}
