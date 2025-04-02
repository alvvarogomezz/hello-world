/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alvgommat2
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {

    public static Scanner tec = new Scanner(System.in);

    public static void main(String[] args) {
        /* Creamos un ArrayList */
        ArrayList<Contacto> misContactos = new ArrayList<Contacto>();
        int op = 0, i;
        Contacto contacto;
        do {//Mientras no seleccionen SALIR
            op = menu();
            switch (op) {
                case 1:
                    misContactos.add(pedirContacto());
                    //añade el contacto introducido
                    break;
                case 2:

                    misContactos.remove(pedirContactoAModificar());
                    //El remove funciona si implementamos el equals
                    break;
                case 3:
                    contacto = pedirContactoAModificar();
                    i = misContactos.indexOf(contacto);
                    //Busca el índice
                    if (i != -1) { //Si lo encuentra, lo muestra
                        System.out.println("Contacto: "
                                + misContactos.get(i));
                    } else {
                        System.out.println("No existe");
                    }
                    break;
                case 4:
                    //REcorre los contactos y los muestra
                    for (i = 0; i < misContactos.size(); i++) {
                        System.out.println("Contacto " + i + ":"
                                + misContactos.get(i));
                    }
            }
        } while (op != 5);
    }

    public static int menu() {
        int op;

        System.out.println("1.Añadir\n2.borrar\n3.Buscar\n4.Listar\n5.Salir");
        do {
            op = tec.nextInt();
        } while (op < 1 || op > 5);
        return op;
    }

    public static Contacto pedirContacto() {
        String nom, tfno;
        tec.nextLine();
        System.out.println("Introduce el nombre: ");
        nom = tec.nextLine();
        System.out.println("Introduce el teléfono: ");
        tfno = tec.nextLine();
        return new Contacto(nom, tfno);
    }

    public static Contacto pedirContactoAModificar() {
        //Para modificar un contacto, basta con el nombre
        
        tec.nextLine();
        System.out.println("Introduce el nombre: ");
        nom = tec.nextLine();
        return new Contacto(nom);
    }
}
