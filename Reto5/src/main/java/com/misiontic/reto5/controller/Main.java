package com.misiontic.reto5.controller;

import com.misiontic.reto5.view.FormClient;

/**
 * <span>Descripción:</span>
 * <p>
 * Aplicación que permite realizar la CRUD en la "Entidad CLiente" de la base de
 * datos del reto 4 y permite visualizar los datos de dicha entidad en una
 * tabla.</p>
 *
 * @author Daniel Felipe Lozada Ramirez Email: felipe_lozada04102@elpoli.edu.co
 * @author Roller Stivenson Sosa Llanes Email: stivenson.sosa@gmail.com
 * @version 1.0.0
 * @since 2021
 */
public class Main {

    /**
     * <span>Descripción:</span>
     * <p>
     * Inicia la aplicación según las instrucciones que se le dan en el cuerpo
     * del método.</p>
     *
     * @param args Agumentos
     */
    public static void main(String[] args) {
        FormClient formClient = new FormClient();
        formClient.setVisible(true);

    }
}
