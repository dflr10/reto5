package com.misiontic.reto5.model;

import com.misiontic.reto5.view.FormClient;
import java.util.ArrayList;

/**
 * <span>Descripción:</span>
 * <p>
 * Interfaz que se encarga de declarar los métodos que serán implementados por
 * las clase {@link ImplClientDAO}.</p>
 *
 * @author Daniel Felipe Lozada Ramirez Email: dflozada2@misena.edu.co
 * @author Roller Stivenson Sosa Llanes Email: stivenson.sosa@gmail.com
 * @version 1.0.0
 * @since 2021
 * @see Conexion
 * @see ImplClientDAO
 */
public interface IClientDAO {

    public boolean insert(FormClient formC);

    public boolean update(FormClient formC);

    public boolean select(FormClient formC);

    public boolean delete(FormClient formC);

    public ArrayList<Client> listClients();

}
