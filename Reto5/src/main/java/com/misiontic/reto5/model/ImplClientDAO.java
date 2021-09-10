package com.misiontic.reto5.model;

import com.misiontic.reto5.view.FormClient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * <span>Descripción:</span>
 * <p>
 * Implementa {@link IClientDAO}. Este tipo de clase Data Access Object (DAO)
 * representa la capa de acceso a los datos de la "Entidad Cliente" realizando
 * las consultas de inserción, actualización, eliminacion o lectura a la base de
 * datos.</p>
 *
 * @author Daniel Felipe Lozada Ramirez Email: felipe_lozada04102@elpoli.edu.co
 * @author Roller Stivenson Sosa Llanes Email: stivenson.sosa@gmail.com
 * @version 1.0.0
 * @since 2021
 * @see Conexion
 * @see IClientDAO
 */
public class ImplClientDAO implements IClientDAO {

    public static FormClient formC;

    /**
     * <span>Descripción:</span>
     * <p>
     * Realiza la inserción de un nuevo registro de cliente a la base de datos
     * con sus respectivas validaciones previas.</p>
     *
     * @param formC Recibe un objeto de tipo {@link FormClient}.
     * @return Booleano - Retorna un valor verdadero o falso en caso de
     * realizarse o no la inserción en la base de datos.
     */
    @Override
    public boolean insert(FormClient formC) {
        ImplClientDAO.formC = formC;
        if (formC.txtName.getText().equals("") || formC.txtSpecie.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Los campos con asteríco son obligatorios");
            return false;
        } else {
            try {
                Connection connection;
                PreparedStatement prepared;
                connection = Conexion.getConnection();
                prepared = connection.prepareStatement("INSERT INTO cliente (c_nombre, c_especie, c_genero) VALUES (?,?,?)");

                prepared.setString(1, formC.txtName.getText());
                prepared.setString(2, formC.txtSpecie.getText());
                prepared.setString(3, formC.txtGender.getText());
                prepared.execute();
                return true;

            } catch (SQLException ex) {
                Logger.getLogger(ImplClientDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex.toString());
                return false;
            }
        }
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Realiza la actualización en la base de datos de la información de un
     * Cliente cuyos datos estén cargados en los campos del formulario de la
     * aplicación.</p>
     *
     * @param formC Recibe un objeto de tipo {@link FormClient}.
     * @return Booleano - Retorna un valor verdadero o falso en caso de
     * realizarse o no la actualización en la base de datos.
     */
    @Override
    public boolean update(FormClient formC) {
        ImplClientDAO.formC = formC;

        if (formC.txtID.getText().equals("")
                || formC.txtName.getText().equals("")
                || formC.txtSpecie.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Los campos con asteríco son obligatorios");
            return false;
        } else {
            try {
                Connection connection;
                PreparedStatement prepared;
                connection = Conexion.getConnection();
                prepared = connection.prepareStatement("UPDATE cliente SET c_nombre=?, c_especie=?, c_genero=? WHERE c_identidad=?");

                prepared.setString(1, formC.txtName.getText());
                prepared.setString(2, formC.txtSpecie.getText());
                prepared.setString(3, formC.txtGender.getText());
                prepared.setInt(4, Integer.parseInt(formC.txtID.getText()));
                prepared.execute();
                return true;

            } catch (SQLException ex) {
                Logger.getLogger(ImplClientDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex.toString());
                return false;
            }
        }
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece los datos del cliente buscado por su ID en el formulario de la
     * aplicación.</p>
     *
     * @param formC Recibe un objeto de tipo {@link FormClient}.
     * @return Booleano - Retorna un valor verdadero o falso en caso de
     * realizarse o no la búsqueda en la base de datos.
     */
    @Override
    public boolean select(FormClient formC) {
        ImplClientDAO.formC = formC;
        if (formC.txtID.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingresa un ID a buscar");
            return false;
        } else {
            try {
                Connection connection;
                PreparedStatement prepared;
                ResultSet result;
                Conexion conexion = new Conexion();
                conexion.connect();
                connection = Conexion.getConnection();
                prepared = connection.prepareStatement("SELECT c_identidad, c_nombre,"
                        + " c_especie, c_genero FROM cliente WHERE c_identidad=?");

                prepared.setInt(1, Integer.parseInt(formC.txtID.getText()));
                result = prepared.executeQuery();
                int count = 0;
                while (result.next()) {
                    count++;
                    formC.txtID.setText(String.valueOf(result.getInt(1)));
                    formC.txtName.setText(result.getString(2));
                    formC.txtSpecie.setText(result.getString(3));
                    formC.txtGender.setText(result.getString(4));
                }
                if (count == 0) {
                    JOptionPane.showMessageDialog(null, "No hay resultados");

                    return false;
                }

            } catch (SQLException ex) {
                Logger.getLogger(ImplClientDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex.toString());
                return false;
            }
        }
        return true;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Permite eliminar el registro de un cliente a partir del ID de este.</p>
     *
     * @param formC Recibe un objeto de tipo {@link FormClient}.
     * @return Booleano - Retorna un valor verdadero o falso en caso de
     * realizarse o no la búsqueda en la base de datos.
     */
    @Override
    public boolean delete(FormClient formC) {
        ImplClientDAO.formC = formC;

        if (formC.txtID.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Debes ingresar el ID del registro a borrar");
            return false;
        } else {
            try {
                Connection connection;
                PreparedStatement prepared;
                connection = Conexion.getConnection();
                prepared = connection.prepareStatement("DELETE FROM cliente WHERE c_identidad=?");

                prepared.setInt(1, Integer.parseInt(formC.txtID.getText()));

                return prepared.execute();

            } catch (SQLException ex) {
                Logger.getLogger(ImplClientDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Este registro posee integridad referencial");
                return false;
            }
        }

    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Permite retornar una lista con los clientes que se encuentran en la
     * Entidad CLiente de la base de datos.</p>
     *
     * @return ArrayList - Retorna una lista de Clientes.
     */
    @Override
    public ArrayList<Client> listClients() {

        ArrayList<Client> clientList = new ArrayList();
        try {
            Connection connection;
            PreparedStatement prepared;
            ResultSet result;
            Conexion conexion = new Conexion();
            conexion.connect();
            connection = Conexion.getConnection();
            prepared = connection.prepareStatement("SELECT * FROM cliente");
            result = prepared.executeQuery();

            while (result.next()) {
                
                Client client = new Client();

                client.setID(result.getInt("c_identidad"));
                client.setName(result.getString("c_nombre"));
                client.setSpecie(result.getString("c_especie"));
                client.setGender(result.getString("c_genero"));

                clientList.add(client);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ImplClientDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        return clientList;
    }

}
