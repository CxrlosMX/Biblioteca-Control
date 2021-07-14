/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import biblioteca.Biblioteca;
import claseLibro.Libro;
import javax.swing.JOptionPane;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 9/07/2021
 *
 */
public class Main {

    public static void main(String[] args) {
        Biblioteca b = new Biblioteca(2, 2);
        Libro l;
        int op = 0, op2 = 0, id;
        do {
            try {
                op = Integer.parseInt(JOptionPane.showInputDialog(null, "BIBLIOTECA TECNM\n"
                        + "1.-Registrar Libro\n"
                        + "2.-Eliminar Libro\n"
                        + "3.-Buscar Libro\n"
                        + "4.-Mostrar Libros Biblioteca\n"
                        + "5.-Prestamos\n"
                        + "6.-Salir\n¿Qué desea realizar?", "MENU", 3));
                switch (op) {
                    case 1: {
                        if (b.tieneEspacios()) {
                            l = b.rellenarLibro();
                            b.registrarLibro(l);
                        } else {
                            JOptionPane.showMessageDialog(null, "La base de datos se encuentra llena", "Base de datos llena", 2);
                        }
                        break;
                    }
                    case 2: {
                        if (b.noEstaVacia()) {
                            id = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el ID del libro que deseas eliminar", "Introduce el ID", 1));
                            b.eliminarLibro(id);
                        } else {
                            JOptionPane.showMessageDialog(null, "La lista esta vacia", "Sin Ningun Libro", 1);
                        }

                        break;
                    }
                    case 3: {
                        if (b.noEstaVacia()) {
                            id = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el ID del libro que deseas buscar", "Introduce el ID", 1));
                            b.buscarLibro(id);
                        } else {
                            JOptionPane.showMessageDialog(null, "La lista esta vacia", "Sin Ningun Libro", 1);
                        }

                        break;
                    }
                    case 4: {
                        if (b.noEstaVacia()) {

                            b.mostrarLibrosBiblioteca();
                        } else {
                            JOptionPane.showMessageDialog(null, "La lista esta vacia", "Sin Ningun Libro", 1);
                        }

                        break;
                    }
                    case 5: {
                        do {
                            try {

                                op2 = Integer.parseInt(JOptionPane.showInputDialog(null, "MENU PRESTAMO\n"
                                        + "1.-Realizar Prestamo\n"
                                        + "2.-Mostrar Libros Prestados\n"
                                        + "3.-Reponer Libro Prestado\n"
                                        + "4.-Salir\n¿Qué desea realizar?", "Menu Prestamo", 1));
                                switch (op2) {
                                    case 1: {
                                        if (b.noEstaVacia()) {
                                            id = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el ID del libro que sera prestado", "Introduce el ID", 1));
                                            b.prestarLibro(id);
                                        } else {
                                            JOptionPane.showMessageDialog(null, "La lista esta vacia", "Sin Ningun Libro", 1);
                                        }
                                        break;
                                    }
                                    case 2: {
                                        if (b.noEstaVaciaPrestados()) {
                                            b.mostrarLibrosPrestados();
                                        } else {
                                            JOptionPane.showMessageDialog(null, "La lista de los libros prestados esta vacia esta vacia", "Sin Ningun Libro", 1);
                                        }

                                        break;
                                    }
                                    case 3: {
                                        if (b.noEstaVacia()) {
                                            id = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el ID del libro que sera prestado", "Introduce el ID", 1));

                                            b.reponerLibro(id);
                                        } else {
                                            JOptionPane.showMessageDialog(null, "La lista esta vacia", "Sin Ningun Libro", 1);
                                        }

                                        break;
                                    }
                                    case 4: {
                                        JOptionPane.showMessageDialog(null, "Saliendo al menu principal", "Saliendo", 1);
                                        break;
                                    }
                                    default: {
                                        JOptionPane.showMessageDialog(null, "Introduce una opcion valida", "Error de Opcion", 2);
                                        break;
                                    }
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Error " + e.getMessage(), "Error", 0);
                            }
                        } while (op2 != 4);
                        break;
                    }
                    case 6: {
                        JOptionPane.showMessageDialog(null, "Cerrando Programa", "Saliendo", 1);
                        break;
                    }
                    default: {
                        JOptionPane.showMessageDialog(null, "Introduce una opcion valida", "Error de Opcion", 2);
                        break;
                    }

                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error " + e.getMessage(), "Error", 0);
            }

        } while (op != 6);
        /*
         Biblioteca b = new Biblioteca();
         Libro l=new Libro("El pefume","Gabriel Marquez", 5);
         b.registrarLibro(l);
         b.prestarLibro(1);
         b.mostrarLibrosBiblioteca();
         b.reponerLibro(1);
         b.mostrarLibrosBiblioteca();*/
    }

}
