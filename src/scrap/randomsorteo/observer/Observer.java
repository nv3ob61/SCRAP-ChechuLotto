/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrap.randomsorteo.observer;

import java.util.ArrayList;
import java.util.List;
import scrap.randomsorteo.interfaces.IStats;

/**
 *
 * @author nv3ob61
 */
//
public class Observer {

  public int rondas;

  private final List<IStats> estados = new ArrayList<>();

  
  //método para actualizar los stats
  public void setNews(int rnd) {
    this.rondas = rnd;
    System.out.println("VALOR this.rondas en setNews: " + this.rondas);
    for (IStats estado : estados) {
      estado.update(rnd);
      System.out.println("SET NEWS OK" + rnd);
    }
  }

  public final void addObs(IStats stats) {
    this.estados.add(stats);
  }

  public final void removeObs(IStats stats) {
    this.estados.remove(stats);
  }
}
