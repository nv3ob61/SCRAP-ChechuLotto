/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrap.randomsorteo.observer;

import scrap.randomsorteo.interfaces.IStats;

/**
 *
 * @author nv3ob61
 */
public class ObserverChan implements IStats  {
  
  private int rondas;
  
  @Override
  public void update(Object o) {
    setNews(rondas);
  }

  private void setNews(int rnd) {
    this.rondas = rnd;
  }
  
  public int getNews(){
    return rondas;
  }
}
