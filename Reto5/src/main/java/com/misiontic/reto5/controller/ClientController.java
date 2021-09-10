package com.misiontic.reto5.controller;

import com.misiontic.reto5.model.Client;
import com.misiontic.reto5.model.ImplClientDAO;
import com.misiontic.reto5.view.FormClient;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * <span>Descripción:</span>
 * <p>
 * Implementa {@link ActionListener}. Se encarga de implementar la lógica de los
 * eventos del click desencadenados por el usuario en la vista
 * {@link FormClient}.</p>
 *
 * @author Daniel Felipe Lozada Ramirez Email: felipe_lozada04102@elpoli.edu.co
 * @author Roller Stivenson Sosa Llanes Email: stivenson.sosa@gmail.com
 * @version 1.0.0
 * @since 2021
 * @see ActionListener
 */
public class ClientController implements ActionListener {

    /**
     * Variables y constantes de la clase {@link  ClientController}.
     *
     */
    private final FormClient formC;
    private final ImplClientDAO clientDAO;
    DefaultTableModel tableModel = new DefaultTableModel();

    /**
     * <p>
     * Constructor de la clase ClientController</p>
     *
     * @param formC Recibe un objeto de la clase {@link FormClient}.
     * @param clientDAO Recibe un objeto de la clase {@link ImplClientDAO}.
     */
    public ClientController(FormClient formC, ImplClientDAO clientDAO) {
        this.formC = formC;
        this.clientDAO = clientDAO;
        addListeneres();
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Realiza la asignación de los actionListeners desde fuera del constructor
     * para evitar la advertencia que indica 'Leaking this in constructor'
     * debido a que se estápasandocomo parámetro un objeto que no ha sido
     * terminado de construir.</p>
     *
     */
    private void addListeneres() {
        this.formC.buttonInsert.addActionListener(this);
        this.formC.buttonUpdate.addActionListener(this);
        this.formC.buttonSelect.addActionListener(this);
        this.formC.buttonDelete.addActionListener(this);
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Sobreescribe el método {@code actionPerformed(ActionEvent e)} para
     * dotarlo del comportamiento necesario, a fin de desencadenar los eventos
     * del click del botón en la vista de {@link FormClient}.</p>
     *
     * @see ActionEvent
     * @param e Recibe un objeto de tipo ActionEvent.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == formC.buttonInsert) {
            if (clientDAO.insert(formC)) {
                clearTable();
                renderClients();
                clearlFields();
            }
        }
        if (e.getSource() == formC.buttonUpdate) {
            if (clientDAO.update(formC)) {
                clearTable();
                renderClients();
                clearlFields();
            }
        }
        if (e.getSource() == formC.buttonSelect) {
            if (clientDAO.select(formC)) {
            } else {
                clearlFields();
            }
        }
        if (e.getSource() == formC.buttonDelete) {
            clientDAO.delete(formC);
            clearTable();
            renderClients();
            clearlFields();

        }
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Permite redibujar las filas de la tabla del {@link FormClient} para
     * actualizar los datos de esta.
     * </p>
     */
    public void renderClients() {
        ArrayList<Client> list = clientDAO.listClients();
        tableModel = (DefaultTableModel) formC.clientTable.getModel();
        Object[] object = new Object[4];

        for (int i = 0; i < list.size(); i++) {
            object[0] = list.get(i).getID();
            object[1] = list.get(i).getName();
            object[2] = list.get(i).getSpecie();
            object[3] = list.get(i).getGender();
            tableModel.addRow(object);
        }
        formC.clientTable.setModel(tableModel);
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Limpia todos los campos del formulario {@link FormClient} y lo reinicia.
     * </p>
     */
    public void clearlFields() {
        formC.txtID.setText("");
        formC.txtName.setText("");
        formC.txtSpecie.setText("");
        formC.txtGender.setText("");
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Limpia los campos de la tabla del formulario {@link FormClient}.
     * </p>
     */
    public void clearTable() {
        int rows = formC.clientTable.getRowCount();
        for (int i = 0; i < rows; i++) {
            formC.modelClient.removeRow(0);
        }
    }

}
