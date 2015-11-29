/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgmuros.pruebazk.business;

import com.cgmuros.pruebazk.model.Cuenta;
import java.util.List;

/**
 *
 * @author cgmuros
 */
public interface ICuenta {

    void Crear(Cuenta cuenta);
    List<Cuenta> listarTodos ();
    Boolean Existe (String usuario);
    Boolean Login (Cuenta cuenta);

}
