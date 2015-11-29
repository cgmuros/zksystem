/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgmuros.pruebazk.controller;

import com.cgmuros.pruebazk.business.CuentaImpl;
import com.cgmuros.pruebazk.business.ICuenta;
import com.cgmuros.pruebazk.model.Cuenta;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;

/**
 *
 * @author cgmuros
 */
public class CuentaController extends SelectorComposer<Component> {

    @Wire
    private Textbox usuario;

    @Wire
    private Textbox contrasena;

    @Wire
    private Textbox nombre;

    @Wire
    private Textbox apellido;

    @Wire
    private Textbox email;

    @Wire
    private Button crearCuenta;

    @Listen("onClick = #crearCuenta")
    public void crearCuenta() {
        Cuenta cuenta = new Cuenta();
        cuenta.setUsuario(usuario.getValue());
        cuenta.setPassword(contrasena.getValue());
        cuenta.setNombre(nombre.getValue());
        cuenta.setApellido(apellido.getValue());
        cuenta.setEmail(email.getValue());

        ICuenta nuevaCuenta = new CuentaImpl();
        nuevaCuenta.Crear(cuenta);
    }

    @Listen("onBlur = #usuario")
    public void validaUsuario() {
        ICuenta cuenta = new CuentaImpl();
        if (cuenta.Existe(usuario.getValue())) {
            usuario.setErrorMessage("Debe elegir otro usuario");
        } else {
            crearCuenta.setDisabled(false);
        }
    }


    @Override
    public void doBeforeComposeChildren(Component comp) throws Exception {
        Session sess = Sessions.getCurrent();
        Cuenta cre = (Cuenta) sess.getAttribute("key");
        if (cre == null) {
            Executions.sendRedirect("/index.zul");
        }
    }

}
