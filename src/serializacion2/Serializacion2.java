/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacion2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author otorradomiguez
 */
public class Serializacion2 {

    public static String[] cod = {"p1", "p2", "p3"};
    public static String[] desc = {"parafusos", "cravos", "tachas"};
    public static double[] prezo = {3.0, 4.0, 5.0};

    static String ruta = "/home/local/DANIELCASTELAO/otorradomiguez/NetBeansProjects/serializacion2/serial.otm";

    public static void main(String[] args) {
        Product p1 = new Product(cod[0], desc[0], prezo[0]);
        Product p2 = new Product(cod[1], desc[1], prezo[1]);
        Product p3 = new Product(cod[2], desc[2], prezo[2]);

        escribir(ruta, p1, p2, p3);
        leer(ruta);
    }

    public static void escribir(String ruta, Product... p) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta));
            for (Product x : p) {
                oos.writeObject(x);
            }
            oos.writeObject(null);
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Serializacion2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Serializacion2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void leer(String ruta) {
        try {           
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta));
            Product tempProduct=(Product) ois.readObject();
            while(tempProduct!=null){
                System.out.println(tempProduct.toString());
                tempProduct=(Product) ois.readObject();
            }
            ois.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Serializacion2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Serializacion2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Serializacion2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
