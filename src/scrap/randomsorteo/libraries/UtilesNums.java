/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrap.randomsorteo.libraries;

/**
 *
 * @author nv3ob61
 */
public class UtilesNums {

  public static boolean isInteger(String s) {
    try {
      Integer.parseInt(s);
    } catch (NumberFormatException | NullPointerException e) {
      return false;
    }
    // only got here if we didn't return false
    return true;
  }
  
  
  public static final  String warningBetNames(int i) {
    String name = "";
    switch (i) {
      case 0:
        name = "Apuesta 1";
        break;
      case 1:
        name = "Apuesta 2";
        break;
      case 2:
        name = "Apuesta 3";
        break;
      case 3:
        name = "Apuesta 4";
        break;
      case 4:
        name = "Apuesta Entero";
        break;
    }
    return name;
  }
}
