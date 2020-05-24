/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrap.randomsorteo;

import scrap.randomsorteo.observer.ObserverChan;
import scrap.randomsorteo.observer.Observer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import scrap.randomsorteo.libraries.UtilesNums;

import scrap.randomsorteo.libraries.UtilesWindows;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import scrap.randomsorteo.interfaces.IStats;
import scrap.randomsorteo.libraries.UtilesSwing;

/**
 *
 * @author nv3ob61
 *
 * aforo = RND.nextInt(AFORO_MAX - AFORO_MIN +1 ) + AFORO_MIN;
 *
 *
 */
public class RandomNum extends javax.swing.JFrame implements KeyListener {

  private static final long serialVersionUID = 1L;
  //Inicio Random
  public static final Random RND = new Random();

  public static int rondas = 0;
  public static int apuesta = 0;
  public static int acumulApuesta = 0;
  public static int lastBet = 0;

  //check cada uno
  public static boolean bet1 = false;
  public static boolean bet2 = false;
  public static boolean bet3 = false;
  public static boolean bet4 = false;
  public static boolean betTotal = false;

  //premios
  public static double acumulaPremios = 0;

  private IStats istat;

  //fillGaps();
  public static final int MAX = 9999;
  public static final int MIN = 0;

  /**
   * Creates new form Random
   */
  public RandomNum() {
    initComponents();
    // Disable keyboard edits in the spinner
    JFormattedTextField tf3 = ((JSpinner.DefaultEditor) jSpinner1.getEditor()).getTextField();
    JFormattedTextField tf = ((JSpinner.DefaultEditor) jSpinner2.getEditor()).getTextField();
    JFormattedTextField tf1 = ((JSpinner.DefaultEditor) jSpinner4.getEditor()).getTextField();
    JFormattedTextField tf2 = ((JSpinner.DefaultEditor) jSpinner3.getEditor()).getTextField();
    tf.setEditable(false);
    tf2.setEditable(false);
    tf3.setEditable(false);
    tf1.setEditable(false);
    jTextPrecio1.setVisible(false);
    jTextPrecio2.setVisible(false);
    jTextPrecio3.setVisible(false);
    jTextPrecio4.setVisible(false);
    sep2.setVisible(false);
    sep3.setVisible(false);
    sep4.setVisible(false);
    sep5.setVisible(false);

    jSpinner1.setVisible(false);
    jSpinner2.setVisible(false);
    jSpinner3.setVisible(false);
    jSpinner4.setVisible(false);

    jPanelApuestaEntero.setVisible(false);

    jButtonApostar.requestFocusInWindow();

    //centrar la ventana en la pantalla
    UtilesWindows.centreWindow(this);

  }

  static int generaRandom() {
    int rand;
    Random rnd = new Random();
    rand = rnd.nextInt(MAX - MIN + 1) + MIN;
    return rand;
  }

  public String fillGaps(int rnd) {
    String num = "";
    //convertir el random
    String conv = String.valueOf(rnd);

    //crear sb para poner los 0 delante
    StringBuilder sb = new StringBuilder();

    if (conv.length() < String.valueOf(MAX).length()) {
      for (int i = 0; i < conv.length(); i++) {
        sb.append("0");
      }
      sb.append(conv);
    } else {
      sb.append(conv);
    }

    return sb.toString();
  }

  public void displayNumbers(String numb) {
    char[] spl = numb.toCharArray();

    System.out.println(spl[0]);

    jLabelU.setText(String.valueOf(spl[0]));
    jLabelD.setText(String.valueOf(spl[1]));
    jLabelM.setText(String.valueOf(spl[2]));
    jLabelC.setText(String.valueOf(spl[3]));
  }

  public void chooseImages(char op) {
    switch (op) {
      case '0':
        break;
      default:
        throw new AssertionError();
    }
  }

  private boolean esEntero() {
    boolean isOk = false;
    if (jAp1.isSelected() && jAp2.isSelected()
            && jAp3.isSelected() && jAp4.isSelected()) {
      isOk = true;
    }
    return isOk;
  }

  private void doAp1() {
    if (jTextPrecio1.isVisible()) {
      //ponemos precios a 0
      jTextPrecio1.setText("0");
      jTextPrecioTotal.setText("0");
      //cambio estados
      jTextPrecio1.setVisible(false);
      sep2.setVisible(false);
      jPanelApuestaEntero.setVisible(false);
      jSpinner1.setVisible(false);
    } else {
      jTextPrecio1.setVisible(true);
      sep2.setVisible(true);
      jSpinner1.setVisible(true);
      if (esEntero()) {
        jPanelApuestaEntero.setVisible(true);
      }
    }
  }

  private void doAp2() {
    if (jTextPrecio2.isVisible()) {
      //ponemos precios a 0
      jTextPrecio2.setText("0");
      jTextPrecioTotal.setText("0");
      //cambio estados
      jTextPrecio2.setVisible(false);
      sep3.setVisible(false);
      jPanelApuestaEntero.setVisible(false);
      jSpinner2.setVisible(false);
    } else {
      jTextPrecio2.setVisible(true);
      sep3.setVisible(true);
      jSpinner2.setVisible(true);
      if (esEntero()) {
        jPanelApuestaEntero.setVisible(true);
      }
    }
  }

  private void doAp3() {
    if (jTextPrecio3.isVisible()) {
      //ponemos precios a 0
      jTextPrecio3.setText("0");
      jTextPrecioTotal.setText("0");
      //cambio estados
      jTextPrecio3.setVisible(false);
      sep4.setVisible(false);
      jPanelApuestaEntero.setVisible(false);
      jSpinner3.setVisible(false);
    } else {
      jTextPrecio3.setVisible(true);
      sep4.setVisible(true);
      jSpinner3.setVisible(true);
      if (esEntero()) {
        jPanelApuestaEntero.setVisible(true);
      }
    }
  }

  private void doAp4() {
    if (jTextPrecio4.isVisible()) {
      //ponemos precios a 0
      jTextPrecio4.setText("0");
      jTextPrecioTotal.setText("0");
      //cambio estados
      jTextPrecio4.setVisible(false);
      sep5.setVisible(false);
      jPanelApuestaEntero.setVisible(false);
      jSpinner4.setVisible(false);
    } else {
      jTextPrecio4.setVisible(true);
      sep5.setVisible(true);
      jSpinner4.setVisible(true);
      if (esEntero()) {
        jPanelApuestaEntero.setVisible(true);
      }
    }
  }

  private void nuevoJuego() {
    jLabelSaldo.setText("2000");
    rondas = 0;
    apuesta = 0;
    lastBet = 0;
    jTextPrecio1.setText("0");
    jTextPrecio2.setText("0");
    jTextPrecio3.setText("0");
    jTextPrecio4.setText("0");
    jTextPrecioTotal.setText("0");
    jLabelTotalApuesta.setText("0");

    jMenu2.setFocusable(false);
    jMenu2.setFocusPainted(false);

    jButtonApostar.requestFocusInWindow();
  }

  private void settleBet() {

    apuesta = 0;

    //suma todos los campos de apuestas
    //comprobamos la apuesta por todo el núm.
    if (jTextPrecioTotal.isVisible() && !jTextPrecioTotal.getText().equals("0")) {
      apuesta += Integer.parseInt(jTextPrecioTotal.getText());
    }

    //comprobamos las apuestas individuales
    if (!jTextPrecio1.getText().equals("0")) {
      apuesta += Integer.parseInt(jTextPrecio1.getText());
    }
    if (!jTextPrecio2.getText().equals("0")) {
      apuesta += Integer.parseInt(jTextPrecio2.getText());
    }
    if (!jTextPrecio3.getText().equals("0")) {
      apuesta += Integer.parseInt(jTextPrecio3.getText());
    }
    if (!jTextPrecio4.getText().equals("0")) {
      apuesta += Integer.parseInt(jTextPrecio4.getText());
    }

    //una vez sumado el importe lo muestra en jLabelTotalApuesta
    jLabelTotalApuesta.setText(String.valueOf(apuesta));
  }

  private void checkWins() {
    double premio = 0;

    //comprobamos cada número
    if (jAp1.isSelected()) {
      try {
        //Si el marcador corresponde con el seleccioado en spinner
        //Nota: You should also call spinner.commitEdit() prior to calling getValue() to ensure manually typed values with the editor are propagated to the model, otherwise you will only get the old value.
        jSpinner1.commitEdit();
      } catch (ParseException ex) {
        Logger.getLogger(RandomNum.class.getName()).log(Level.SEVERE, null, ex);
      }
      System.out.println(jLabelM.getText());
      if (Integer.parseInt(jLabelM.getText()) == Integer.parseInt(jSpinner1.getValue().toString())) {
        premio += Double.parseDouble(jLabelTotalApuesta.getText()) * 1.63;
      }
    }

    if (jAp2.isSelected()) {
      try {
        //Si el marcador corresponde con el seleccioado en spinner
        //Nota: You should also call spinner.commitEdit() prior to calling getValue() to ensure manually typed values with the editor are propagated to the model, otherwise you will only get the old value.
        jSpinner2.commitEdit();
      } catch (ParseException ex) {
        Logger.getLogger(RandomNum.class.getName()).log(Level.SEVERE, null, ex);
      }
      System.out.println(jLabelC.getText());
      if (Integer.parseInt(jLabelC.getText()) == Integer.parseInt(jSpinner2.getValue().toString())) {
        premio += Double.parseDouble(jLabelTotalApuesta.getText()) * 1.63;
      }
    }

    if (jAp3.isSelected()) {
      try {
        //Si el marcador corresponde con el seleccioado en spinner
        //Nota: You should also call spinner.commitEdit() prior to calling getValue() to ensure manually typed values with the editor are propagated to the model, otherwise you will only get the old value.
        jSpinner3.commitEdit();
      } catch (ParseException ex) {
        Logger.getLogger(RandomNum.class.getName()).log(Level.SEVERE, null, ex);
      }
      System.out.println(jLabelD.getText());
      if (Integer.parseInt(jLabelD.getText()) == Integer.parseInt(jSpinner3.getValue().toString())) {
        premio += Double.parseDouble(jLabelTotalApuesta.getText()) * 1.63;
      }
    }

    if (jAp4.isSelected()) {
      try {
        //Si el marcador corresponde con el seleccioado en spinner
        //Nota: You should also call spinner.commitEdit() prior to calling getValue() to ensure manually typed values with the editor are propagated to the model, otherwise you will only get the old value.
        jSpinner4.commitEdit();
      } catch (ParseException ex) {
        Logger.getLogger(RandomNum.class.getName()).log(Level.SEVERE, null, ex);
      }
      System.out.println(jLabelC.getText());
      if (Integer.parseInt(jLabelU.getText()) == Integer.parseInt(jSpinner4.getValue().toString())) {
        premio += Double.parseDouble(jLabelTotalApuesta.getText()) * 1.63;
      }
    }

    if (esEntero()) {
      if (premioTotal()) {
        premio += Double.parseDouble(jLabelTotalApuesta.getText()) * 2.54;
      }
    }

    //total de premio...
    jLabelPremio.setText(String.format("%.2f", premio));
  }

  private boolean premioTotal() {
    return Integer.parseInt(jLabelM.getText()) == Integer.parseInt(jSpinner1.getValue().toString())
            && Integer.parseInt(jLabelC.getText()) == Integer.parseInt(jSpinner2.getValue().toString())
            && Integer.parseInt(jLabelD.getText()) == Integer.parseInt(jSpinner3.getValue().toString())
            && Integer.parseInt(jLabelU.getText()) == Integer.parseInt(jSpinner4.getValue().toString());
  }

  //si todos los núms de apuestas son dígitos, ya sean 0 o lo que sea
  private boolean areBetsDigits() {
    boolean areOk = false;

    if (UtilesNums.isInteger(jTextPrecioTotal.getText())) {
      betTotal = true;
    }

    if (UtilesNums.isInteger(jTextPrecio1.getText())) {
      bet1 = true;
    }
    if (UtilesNums.isInteger(jTextPrecio2.getText())) {
      bet2 = true;
    }
    if (UtilesNums.isInteger(jTextPrecio3.getText())) {
      bet3 = true;
    }
    if (UtilesNums.isInteger(jTextPrecio4.getText())) {
      bet4 = true;
    }

    //cond si todos son true
    if (bet1 == true && bet2 == true && bet3 == true
            && bet4 == true && betTotal == true) {
      areOk = true;
    }

    return areOk;
  }

  private void showApuestaWarning() {
    int count = 0;
    boolean[] bets = {bet1, bet2, bet3, bet4, betTotal};
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < bets.length; i++) {
      if (i == bets.length - 1 && bets[i] == false) {
        sb.append(" y ").append(UtilesNums.warningBetNames(i)).append(".");
        count++;
      } else if (bets[i] == false) {
        sb.append(UtilesNums.warningBetNames(i)).append(", ");
        count++;
      }
    }

    if (count > 0) {
      sb.insert(0, "Fallan los siguientes campos de apuestas: ");
      JOptionPane.showMessageDialog(jPanel13, sb.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
    }
  }

  private void resetBets() {
    bet1 = false;
    bet2 = false;
    bet3 = false;
    bet4 = false;
    betTotal = false;
  }

  private void openStats() {

    Stats status = new Stats(this, true, rondas);
    status.addWindowListener(new java.awt.event.WindowAdapter() {
      @Override
      public void windowClosing(java.awt.event.WindowEvent e) {
        System.exit(0);
      }
    });
    status.setBounds(status.getX(), 0, status.getWidth(), status.getHeight());
    status.setVisible(true);
  }

  //no comprobamos si son los campos enteros porque esto está dentro del método ya
  //en el botón APUESTA
  private int sumBets() {
    int sum;

    sum = (int) (Double.parseDouble(jTextPrecio1.getText())
            + Double.parseDouble(jTextPrecio2.getText())
            + Double.parseDouble(jTextPrecio3.getText())
            + Double.parseDouble(jTextPrecio4.getText())
            + Double.parseDouble(jTextPrecioTotal.getText()));

    return sum;
  }

  private void deleteBets() {
    jTextPrecio1.setText("0");
    jTextPrecio2.setText("0");
    jTextPrecio3.setText("0");
    jTextPrecio4.setText("0");
    jTextPrecioTotal.setText("0");
  }

  private void preSettleBet() {
    //comprueba que todos los campos de apuesta son dígitos
    if (areBetsDigits()) {
      //Si el saldo es > 0
      if (Double.parseDouble(jLabelSaldo.getText()) > 0) {
        //si la cantidad apostada es igual o menor que el saldo
        if (sumBets()
                <= Double.parseDouble(jLabelSaldo.getText())) {
          settleBet();
          lastBet = sumBets();
        } else {
          jLabelTotalApuesta.setText("0");
          JOptionPane.showMessageDialog(this, "ERROR: Apuesta supera al saldo", "MEEEC", JOptionPane.ERROR_MESSAGE);
        }
      } else {
        // si el saldo es 0
        jLabelTotalApuesta.setText("0");
        JOptionPane.showMessageDialog(this, "Estás más pelao que el tío de los caballitos", "MEEEC", JOptionPane.ERROR_MESSAGE);
      }
    } else {
      //¿QUé pasa si algún campo no es válido
      showApuestaWarning();
    }
  }

  private void rollGame() {
    //borrado del campo del premio anterior
    jLabelPremio.setText("0");

    //comprobar al tirar que se ha elegido número
    if (!jSpinner1.getValue().toString().equals("-")) {

      //si el total apostado es mayor que 0  (si el texto no es cero)
      if (!jLabelTotalApuesta.getText().equals("0")) {
        //si el saldo total menos lo apostado es > que 0
        if (Double.parseDouble(jLabelSaldo.getText()) - Double.parseDouble(jLabelTotalApuesta.getText()) >= 0) {

          //restar del total
          jLabelSaldo.setText(String.format("%.2f", Double.parseDouble(jLabelSaldo.getText()) - apuesta));

          //hace el random y lo muestra
          displayNumbers(fillGaps(generaRandom()));

          //comprueba premio
          checkWins();

          //Actualiza el saldo si hay premio.
          jLabelSaldo.setText(String.valueOf(
                  Double.parseDouble(jLabelSaldo.getText())
                  + Double.parseDouble(jLabelPremio.getText())));

          //añadimos ronda
          rondas++;
          System.out.println("RONDAS" + rondas);

//        //actualizar estadísticas
          Observer obs = new Observer();
          ObserverChan chan = new ObserverChan();

          obs.addObs(chan);
          System.out.println("ENVIO PRIMER RONDAS: " + rondas);
          obs.setNews(rondas);

          //borrar total apostado
          jLabelTotalApuesta.setText("0");

          //reset check campos apuestas
          resetBets();
        } else {

          JOptionPane.showMessageDialog(jPanelApuestaEntero, "UOPS!");
          //mostramos estadísticas fin de partida

          System.out.println("FIN DE PARTIDA");
        }
      }
    } else {
      JOptionPane.showMessageDialog(null, "ERR: Te falta elegir algún número",
              "MEEEEEC", JOptionPane.INFORMATION_MESSAGE);
    }
  }

  private void mouseClicked(JTextField hop) {
    hop.setText("");
  }

  private void focusLost(JTextField hop) {
    if (hop.getText().isBlank() || hop.getText().isEmpty()) {
      hop.setText("0");
    }
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanelMarcador = new javax.swing.JPanel();
    jLabelM = new javax.swing.JLabel();
    jLabelC = new javax.swing.JLabel();
    jLabelD = new javax.swing.JLabel();
    jLabelU = new javax.swing.JLabel();
    jPanelSelect = new javax.swing.JPanel();
    jPanel11 = new javax.swing.JPanel();
    jAp1 = new javax.swing.JCheckBox();
    jPanel12 = new javax.swing.JPanel();
    jAp2 = new javax.swing.JCheckBox();
    jPanel13 = new javax.swing.JPanel();
    jAp3 = new javax.swing.JCheckBox();
    jPanel14 = new javax.swing.JPanel();
    jAp4 = new javax.swing.JCheckBox();
    jPanel15 = new javax.swing.JPanel();
    jPanelSpin = new javax.swing.JPanel();
    jPanel6 = new javax.swing.JPanel();
    jSpinner1 = new javax.swing.JSpinner();
    jPanel7 = new javax.swing.JPanel();
    jSpinner2 = new javax.swing.JSpinner();
    jPanel8 = new javax.swing.JPanel();
    jSpinner3 = new javax.swing.JSpinner();
    jPanel9 = new javax.swing.JPanel();
    jSpinner4 = new javax.swing.JSpinner();
    jPanel10 = new javax.swing.JPanel();
    jPanelPrecioAp = new javax.swing.JPanel();
    sep1 = new javax.swing.JLabel();
    jTextPrecio1 = new javax.swing.JTextField();
    sep2 = new javax.swing.JLabel();
    jTextPrecio2 = new javax.swing.JTextField();
    sep3 = new javax.swing.JLabel();
    jTextPrecio3 = new javax.swing.JTextField();
    sep4 = new javax.swing.JLabel();
    jTextPrecio4 = new javax.swing.JTextField();
    sep5 = new javax.swing.JLabel();
    jPanelApuestaEntero = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jTextPrecioTotal = new javax.swing.JTextField();
    sep6 = new javax.swing.JLabel();
    jPanel2 = new javax.swing.JPanel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabelTotalApuesta = new javax.swing.JLabel();
    sep7 = new javax.swing.JLabel();
    jLabelPremio = new javax.swing.JLabel();
    sep8 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabelSaldo = new javax.swing.JLabel();
    sep9 = new javax.swing.JLabel();
    jButtonApostar = new javax.swing.JButton();
    jButtonRandom = new javax.swing.JButton();
    jButtonRandom1 = new javax.swing.JButton();
    jButton1 = new javax.swing.JButton();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu2 = new javax.swing.JMenu();
    jMenuItem3 = new javax.swing.JMenuItem();
    jMenuItem4 = new javax.swing.JMenuItem();
    jMenu1 = new javax.swing.JMenu();
    jMenuItem1 = new javax.swing.JMenuItem();
    jMenuItem2 = new javax.swing.JMenuItem();
    jMenu3 = new javax.swing.JMenu();
    jMenuItem6 = new javax.swing.JMenuItem();
    jMenuItem5 = new javax.swing.JMenuItem();
    jMenu4 = new javax.swing.JMenu();
    jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
    jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
    jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
    jCheckBoxMenuItem4 = new javax.swing.JCheckBoxMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setBackground(new java.awt.Color(51, 51, 51));

    jPanelMarcador.setBackground(new java.awt.Color(0, 0, 0));
    jPanelMarcador.setForeground(new java.awt.Color(255, 255, 255));
    jPanelMarcador.setLayout(new java.awt.GridLayout(1, 0));

    jLabelM.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
    jLabelM.setForeground(new java.awt.Color(255, 255, 255));
    jLabelM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabelM.setText("0");
    jPanelMarcador.add(jLabelM);

    jLabelC.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
    jLabelC.setForeground(new java.awt.Color(255, 255, 255));
    jLabelC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabelC.setText("0");
    jPanelMarcador.add(jLabelC);

    jLabelD.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
    jLabelD.setForeground(new java.awt.Color(255, 255, 255));
    jLabelD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabelD.setText("0");
    jPanelMarcador.add(jLabelD);

    jLabelU.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
    jLabelU.setForeground(new java.awt.Color(255, 255, 255));
    jLabelU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabelU.setText("0");
    jPanelMarcador.add(jLabelU);

    jPanelSelect.setBackground(new java.awt.Color(204, 204, 204));
    jPanelSelect.setLayout(new java.awt.GridLayout(1, 0));

    jPanel11.setBackground(new java.awt.Color(204, 204, 204));

    javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
    jPanel11.setLayout(jPanel11Layout);
    jPanel11Layout.setHorizontalGroup(
      jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 66, Short.MAX_VALUE)
    );
    jPanel11Layout.setVerticalGroup(
      jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 40, Short.MAX_VALUE)
    );

    jPanelSelect.add(jPanel11);

    jAp1.setBackground(new java.awt.Color(204, 204, 204));
    jAp1.setForeground(new java.awt.Color(0, 0, 0));
    jAp1.setText("   1");
    jAp1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jAp1ActionPerformed(evt);
      }
    });
    jPanelSelect.add(jAp1);

    jPanel12.setBackground(new java.awt.Color(204, 204, 204));

    javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
    jPanel12.setLayout(jPanel12Layout);
    jPanel12Layout.setHorizontalGroup(
      jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 66, Short.MAX_VALUE)
    );
    jPanel12Layout.setVerticalGroup(
      jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 40, Short.MAX_VALUE)
    );

    jPanelSelect.add(jPanel12);

    jAp2.setBackground(new java.awt.Color(204, 204, 204));
    jAp2.setForeground(new java.awt.Color(0, 0, 0));
    jAp2.setText("   2");
    jAp2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jAp2ActionPerformed(evt);
      }
    });
    jPanelSelect.add(jAp2);

    jPanel13.setBackground(new java.awt.Color(204, 204, 204));

    javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
    jPanel13.setLayout(jPanel13Layout);
    jPanel13Layout.setHorizontalGroup(
      jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 66, Short.MAX_VALUE)
    );
    jPanel13Layout.setVerticalGroup(
      jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 40, Short.MAX_VALUE)
    );

    jPanelSelect.add(jPanel13);

    jAp3.setBackground(new java.awt.Color(204, 204, 204));
    jAp3.setForeground(new java.awt.Color(0, 0, 0));
    jAp3.setText("   3");
    jAp3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jAp3ActionPerformed(evt);
      }
    });
    jPanelSelect.add(jAp3);

    jPanel14.setBackground(new java.awt.Color(204, 204, 204));

    javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
    jPanel14.setLayout(jPanel14Layout);
    jPanel14Layout.setHorizontalGroup(
      jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 66, Short.MAX_VALUE)
    );
    jPanel14Layout.setVerticalGroup(
      jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 40, Short.MAX_VALUE)
    );

    jPanelSelect.add(jPanel14);

    jAp4.setBackground(new java.awt.Color(204, 204, 204));
    jAp4.setForeground(new java.awt.Color(0, 0, 0));
    jAp4.setText("   4");
    jAp4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jAp4ActionPerformed(evt);
      }
    });
    jPanelSelect.add(jAp4);

    jPanel15.setBackground(new java.awt.Color(204, 204, 204));

    javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
    jPanel15.setLayout(jPanel15Layout);
    jPanel15Layout.setHorizontalGroup(
      jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 66, Short.MAX_VALUE)
    );
    jPanel15Layout.setVerticalGroup(
      jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 40, Short.MAX_VALUE)
    );

    jPanelSelect.add(jPanel15);

    jPanelSpin.setBackground(new java.awt.Color(51, 51, 51));
    jPanelSpin.setLayout(new java.awt.GridLayout(1, 0));

    jPanel6.setBackground(new java.awt.Color(102, 102, 102));

    javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
    jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(
      jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 66, Short.MAX_VALUE)
    );
    jPanel6Layout.setVerticalGroup(
      jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 40, Short.MAX_VALUE)
    );

    jPanelSpin.add(jPanel6);

    jSpinner1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
    jSpinner1.setModel(new javax.swing.SpinnerListModel(new String[] {"-", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
    jSpinner1.setBorder(null);
    jPanelSpin.add(jSpinner1);

    jPanel7.setBackground(new java.awt.Color(102, 102, 102));

    javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
    jPanel7.setLayout(jPanel7Layout);
    jPanel7Layout.setHorizontalGroup(
      jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 66, Short.MAX_VALUE)
    );
    jPanel7Layout.setVerticalGroup(
      jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 0, Short.MAX_VALUE)
    );

    jPanelSpin.add(jPanel7);

    jSpinner2.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
    jSpinner2.setModel(new javax.swing.SpinnerListModel(new String[] {"-", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
    jSpinner2.setBorder(null);
    jPanelSpin.add(jSpinner2);

    jPanel8.setBackground(new java.awt.Color(102, 102, 102));

    javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
    jPanel8.setLayout(jPanel8Layout);
    jPanel8Layout.setHorizontalGroup(
      jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 66, Short.MAX_VALUE)
    );
    jPanel8Layout.setVerticalGroup(
      jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 0, Short.MAX_VALUE)
    );

    jPanelSpin.add(jPanel8);

    jSpinner3.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
    jSpinner3.setModel(new javax.swing.SpinnerListModel(new String[] {"-", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
    jSpinner3.setBorder(null);
    jPanelSpin.add(jSpinner3);

    jPanel9.setBackground(new java.awt.Color(102, 102, 102));

    javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
    jPanel9.setLayout(jPanel9Layout);
    jPanel9Layout.setHorizontalGroup(
      jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 66, Short.MAX_VALUE)
    );
    jPanel9Layout.setVerticalGroup(
      jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 0, Short.MAX_VALUE)
    );

    jPanelSpin.add(jPanel9);

    jSpinner4.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
    jSpinner4.setModel(new javax.swing.SpinnerListModel(new String[] {"-", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
    jSpinner4.setBorder(null);
    jPanelSpin.add(jSpinner4);

    jPanel10.setBackground(new java.awt.Color(102, 102, 102));

    javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
    jPanel10.setLayout(jPanel10Layout);
    jPanel10Layout.setHorizontalGroup(
      jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 66, Short.MAX_VALUE)
    );
    jPanel10Layout.setVerticalGroup(
      jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 40, Short.MAX_VALUE)
    );

    jPanelSpin.add(jPanel10);

    jPanelPrecioAp.setLayout(new java.awt.GridLayout(1, 0));
    jPanelPrecioAp.add(sep1);

    jTextPrecio1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    jTextPrecio1.setText("0");
    jTextPrecio1.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusLost(java.awt.event.FocusEvent evt) {
        jTextPrecio1FocusLost(evt);
      }
    });
    jTextPrecio1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTextPrecio1MouseClicked(evt);
      }
    });
    jTextPrecio1.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        jTextPrecio1KeyPressed(evt);
      }
      public void keyReleased(java.awt.event.KeyEvent evt) {
        jTextPrecio1KeyReleased(evt);
      }
    });
    jPanelPrecioAp.add(jTextPrecio1);

    sep2.setText(" €");
    jPanelPrecioAp.add(sep2);

    jTextPrecio2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    jTextPrecio2.setText("0");
    jTextPrecio2.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusLost(java.awt.event.FocusEvent evt) {
        jTextPrecio2FocusLost(evt);
      }
    });
    jTextPrecio2.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTextPrecio2MouseClicked(evt);
      }
    });
    jTextPrecio2.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        jTextPrecio2KeyPressed(evt);
      }
      public void keyReleased(java.awt.event.KeyEvent evt) {
        jTextPrecio2KeyReleased(evt);
      }
    });
    jPanelPrecioAp.add(jTextPrecio2);

    sep3.setText(" €");
    jPanelPrecioAp.add(sep3);

    jTextPrecio3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    jTextPrecio3.setText("0");
    jTextPrecio3.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusLost(java.awt.event.FocusEvent evt) {
        jTextPrecio3FocusLost(evt);
      }
    });
    jTextPrecio3.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTextPrecio3MouseClicked(evt);
      }
    });
    jTextPrecio3.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        jTextPrecio3KeyReleased(evt);
      }
    });
    jPanelPrecioAp.add(jTextPrecio3);

    sep4.setText(" €");
    jPanelPrecioAp.add(sep4);

    jTextPrecio4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    jTextPrecio4.setText("0");
    jTextPrecio4.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusLost(java.awt.event.FocusEvent evt) {
        jTextPrecio4FocusLost(evt);
      }
    });
    jTextPrecio4.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTextPrecio4MouseClicked(evt);
      }
    });
    jTextPrecio4.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        jTextPrecio4KeyReleased(evt);
      }
    });
    jPanelPrecioAp.add(jTextPrecio4);

    sep5.setText(" €");
    jPanelPrecioAp.add(sep5);

    jPanelApuestaEntero.setBackground(new java.awt.Color(153, 153, 153));

    jLabel1.setText("APUESTA AL NÚMERO ENTERO: ");

    jTextPrecioTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    jTextPrecioTotal.setText("0");
    jTextPrecioTotal.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusLost(java.awt.event.FocusEvent evt) {
        jTextPrecioTotalFocusLost(evt);
      }
    });
    jTextPrecioTotal.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTextPrecioTotalMouseClicked(evt);
      }
    });
    jTextPrecioTotal.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        jTextPrecioTotalKeyReleased(evt);
      }
    });

    sep6.setText(" €");

    javax.swing.GroupLayout jPanelApuestaEnteroLayout = new javax.swing.GroupLayout(jPanelApuestaEntero);
    jPanelApuestaEntero.setLayout(jPanelApuestaEnteroLayout);
    jPanelApuestaEnteroLayout.setHorizontalGroup(
      jPanelApuestaEnteroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelApuestaEnteroLayout.createSequentialGroup()
        .addGap(93, 93, 93)
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jTextPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(sep6, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(15, 15, 15))
    );
    jPanelApuestaEnteroLayout.setVerticalGroup(
      jPanelApuestaEnteroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelApuestaEnteroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jTextPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
      .addComponent(sep6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    jLabel2.setText("TOTAL APOSTADO   :");

    jLabel3.setText("PREMIO                    :");

    jLabelTotalApuesta.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabelTotalApuesta.setText("0");

    sep7.setText(" €");

    jLabelPremio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabelPremio.setText("0");

    sep8.setText(" €");

    jLabel4.setText("SALDO                     :");

    jLabelSaldo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabelSaldo.setText("0");

    sep9.setText(" €");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(40, 40, 40)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabelSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(sep9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelPremio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
              .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelTotalApuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel2Layout.createSequentialGroup()
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sep7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(sep8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        .addContainerGap(10, Short.MAX_VALUE)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(jLabelSaldo)
          .addComponent(sep9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(jLabelTotalApuesta)
          .addComponent(sep7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(jLabelPremio)
          .addComponent(sep8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap())
    );

    jButtonApostar.setText("APOSTAR");
    jButtonApostar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonApostarActionPerformed(evt);
      }
    });

    jButtonRandom.setText("TIRAR");
    jButtonRandom.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonRandomActionPerformed(evt);
      }
    });

    jButtonRandom1.setText("APOS/TIRAR");
    jButtonRandom1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonRandom1ActionPerformed(evt);
      }
    });

    jButton1.setText("Roll 100");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jMenu2.setText("Inicio");

    jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
    jMenuItem3.setText("Nuevo Juego");
    jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem3ActionPerformed(evt);
      }
    });
    jMenu2.add(jMenuItem3);

    jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
    jMenuItem4.setText("Salir");
    jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem4ActionPerformed(evt);
      }
    });
    jMenu2.add(jMenuItem4);

    jMenuBar1.add(jMenu2);

    jMenu1.setText("Opciones");

    jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
    jMenuItem1.setText("Estadísticas");
    jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jMenuItem1MouseClicked(evt);
      }
    });
    jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem1ActionPerformed(evt);
      }
    });
    jMenu1.add(jMenuItem1);

    jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
    jMenuItem2.setText("Una Alludita");
    jMenu1.add(jMenuItem2);

    jMenuBar1.add(jMenu1);

    jMenu3.setText("Apuesta");

    jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
    jMenuItem6.setText("Hacer Apuesta");
    jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem6ActionPerformed(evt);
      }
    });
    jMenu3.add(jMenuItem6);

    jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
    jMenuItem5.setText("Borrar Apuestas");
    jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem5ActionPerformed(evt);
      }
    });
    jMenu3.add(jMenuItem5);

    jMenu4.setText("Selección");

    jCheckBoxMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
    jCheckBoxMenuItem1.setText("Activa Apuesta #1");
    jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jCheckBoxMenuItem1ActionPerformed(evt);
      }
    });
    jMenu4.add(jCheckBoxMenuItem1);

    jCheckBoxMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
    jCheckBoxMenuItem2.setText("Activa Apuesta #2");
    jCheckBoxMenuItem2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jCheckBoxMenuItem2ActionPerformed(evt);
      }
    });
    jMenu4.add(jCheckBoxMenuItem2);

    jCheckBoxMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
    jCheckBoxMenuItem3.setText("Activa Apuesta #3");
    jCheckBoxMenuItem3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jCheckBoxMenuItem3ActionPerformed(evt);
      }
    });
    jMenu4.add(jCheckBoxMenuItem3);

    jCheckBoxMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_MASK));
    jCheckBoxMenuItem4.setText("Activa Apuesta #4");
    jCheckBoxMenuItem4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jCheckBoxMenuItem4ActionPerformed(evt);
      }
    });
    jMenu4.add(jCheckBoxMenuItem4);

    jMenu3.add(jMenu4);

    jMenuBar1.add(jMenu3);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanelPrecioAp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(jButtonApostar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(jButtonRandom, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButtonRandom1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
              .addComponent(jPanelMarcador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jPanelSpin, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
              .addComponent(jPanelSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jPanelApuestaEntero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(17, 17, 17)
        .addComponent(jPanelMarcador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(32, 32, 32)
        .addComponent(jPanelApuestaEntero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
        .addComponent(jPanelSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanelSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jPanelPrecioAp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jButtonApostar)
              .addComponent(jButton1))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jButtonRandom)
              .addComponent(jButtonRandom1))
            .addGap(8, 8, 8)))
        .addGap(7, 7, 7))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jButtonRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRandomActionPerformed
    rollGame();
  }//GEN-LAST:event_jButtonRandomActionPerformed

  private void jAp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAp1ActionPerformed
    if (jAp1.isSelected()) {
      jCheckBoxMenuItem1.setSelected(true);
    } else {
      jCheckBoxMenuItem1.setSelected(false);
    }
    doAp1();
  }//GEN-LAST:event_jAp1ActionPerformed

  private void jAp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAp2ActionPerformed
    if (jAp2.isSelected()) {
      jCheckBoxMenuItem2.setSelected(true);
    } else {
      jCheckBoxMenuItem2.setSelected(false);
    }
    doAp2();
  }//GEN-LAST:event_jAp2ActionPerformed

  private void jAp3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAp3ActionPerformed
    if (jAp3.isSelected()) {
      jCheckBoxMenuItem3.setSelected(true);
    } else {
      jCheckBoxMenuItem3.setSelected(false);
    }
    doAp3();
  }//GEN-LAST:event_jAp3ActionPerformed

  private void jAp4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAp4ActionPerformed
    if (jAp4.isSelected()) {
      jCheckBoxMenuItem4.setSelected(true);
    } else {
      jCheckBoxMenuItem4.setSelected(false);
    }
    doAp4();
  }//GEN-LAST:event_jAp4ActionPerformed

  private void jButtonApostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApostarActionPerformed
    preSettleBet();
  }//GEN-LAST:event_jButtonApostarActionPerformed

  private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
    nuevoJuego();
  }//GEN-LAST:event_jMenuItem3ActionPerformed

  private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
    openStats();
  }//GEN-LAST:event_jMenuItem1MouseClicked

  private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    openStats();
  }//GEN-LAST:event_jMenuItem1ActionPerformed

  private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
    System.exit(0);
  }//GEN-LAST:event_jMenuItem4ActionPerformed

  private void jButtonRandom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRandom1ActionPerformed
    System.out.println("ACC botón APOS / TIRAR, Cantidad: " + jLabelTotalApuesta.getText());
    System.out.println("lastBet: " + lastBet);
    if (lastBet != 0) {
      jLabelTotalApuesta.setText(String.valueOf(lastBet));
      preSettleBet();
      rollGame();
    }
  }//GEN-LAST:event_jButtonRandom1ActionPerformed

  private void jTextPrecio1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPrecio1KeyPressed
    // TODO add your handling code here:
  }//GEN-LAST:event_jTextPrecio1KeyPressed

  private void jTextPrecio1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPrecio1KeyReleased
    if (isNumber1(evt)) {
      jTextPrecio1.setText(jTextPrecio1.getText() + "");
    }
  }//GEN-LAST:event_jTextPrecio1KeyReleased

  private void jTextPrecio2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPrecio2KeyPressed
    // TODO add your handling code here:
  }//GEN-LAST:event_jTextPrecio2KeyPressed

  private void jTextPrecio2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPrecio2KeyReleased
    if (isNumber2(evt)) {
      jTextPrecio2.setText(jTextPrecio2.getText() + "");
    }
  }//GEN-LAST:event_jTextPrecio2KeyReleased

  private void jTextPrecio3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPrecio3KeyReleased
    if (isNumber3(evt)) {
      jTextPrecio3.setText(jTextPrecio3.getText() + "");
    }
  }//GEN-LAST:event_jTextPrecio3KeyReleased

  private void jTextPrecio4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPrecio4KeyReleased
    if (isNumber4(evt)) {
      jTextPrecio4.setText(jTextPrecio4.getText() + "");
    }
  }//GEN-LAST:event_jTextPrecio4KeyReleased

  private void jTextPrecioTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPrecioTotalKeyReleased
    if (isNumberTot(evt)) {
      jTextPrecioTotal.setText(jTextPrecioTotal.getText() + "");
    }
  }//GEN-LAST:event_jTextPrecioTotalKeyReleased

  private void jTextPrecio1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextPrecio1MouseClicked
    mouseClicked(jTextPrecio1);
  }//GEN-LAST:event_jTextPrecio1MouseClicked

  private void jTextPrecio1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextPrecio1FocusLost
    focusLost(jTextPrecio1);
  }//GEN-LAST:event_jTextPrecio1FocusLost

  private void jTextPrecio2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextPrecio2MouseClicked
    mouseClicked(jTextPrecio2);
  }//GEN-LAST:event_jTextPrecio2MouseClicked

  private void jTextPrecio2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextPrecio2FocusLost
    focusLost(jTextPrecio2);
  }//GEN-LAST:event_jTextPrecio2FocusLost

  private void jTextPrecio3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextPrecio3MouseClicked
    mouseClicked(jTextPrecio3);
  }//GEN-LAST:event_jTextPrecio3MouseClicked

  private void jTextPrecio4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextPrecio4MouseClicked
    mouseClicked(jTextPrecio4);
  }//GEN-LAST:event_jTextPrecio4MouseClicked

  private void jTextPrecioTotalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextPrecioTotalMouseClicked
    mouseClicked(jTextPrecioTotal);
  }//GEN-LAST:event_jTextPrecioTotalMouseClicked

  private void jTextPrecio3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextPrecio3FocusLost
    focusLost(jTextPrecio3);
  }//GEN-LAST:event_jTextPrecio3FocusLost

  private void jTextPrecio4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextPrecio4FocusLost
    focusLost(jTextPrecio4);
  }//GEN-LAST:event_jTextPrecio4FocusLost

  private void jTextPrecioTotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextPrecioTotalFocusLost
    focusLost(jTextPrecioTotal);
  }//GEN-LAST:event_jTextPrecioTotalFocusLost

  private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
    deleteBets();
  }//GEN-LAST:event_jMenuItem5ActionPerformed

  private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
    if (!jLabelTotalApuesta.getText().equals("0")) {
      preSettleBet();
    }
  }//GEN-LAST:event_jMenuItem6ActionPerformed

  private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
    if (jCheckBoxMenuItem1.isSelected()) {
      jAp1.setSelected(true);
    } else {
      jAp1.setSelected(false);
    }
    doAp1();
  }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

  private void jCheckBoxMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem2ActionPerformed
    if (jCheckBoxMenuItem2.isSelected()) {
      jAp2.setSelected(true);
    } else {
      jAp2.setSelected(false);
    }
    doAp2();
  }//GEN-LAST:event_jCheckBoxMenuItem2ActionPerformed

  private void jCheckBoxMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem3ActionPerformed
    if (jCheckBoxMenuItem3.isSelected()) {
      jAp3.setSelected(true);
    } else {
      jAp3.setSelected(false);
    }
    doAp3();
  }//GEN-LAST:event_jCheckBoxMenuItem3ActionPerformed

  private void jCheckBoxMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem4ActionPerformed
    if (jCheckBoxMenuItem4.isSelected()) {
      jAp4.setSelected(true);
    } else {
      jAp4.setSelected(false);
    }
    doAp4();
  }//GEN-LAST:event_jCheckBoxMenuItem4ActionPerformed

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    for (int i = 0; i < 20; i++) {
      if (lastBet != 0) {
        jLabelTotalApuesta.setText(String.valueOf(lastBet));
        preSettleBet();
        rollGame();
      }
    }
  }//GEN-LAST:event_jButton1ActionPerformed

  private boolean isNumber1(java.awt.event.KeyEvent evt) {
    boolean isOk = false;

    if (UtilesSwing.validarCampo(jTextPrecio1, "^[1-9]\\d*$", "")) {
      isOk = true;
    }

    return isOk;
  }

  private boolean isNumber2(java.awt.event.KeyEvent evt) {
    boolean isOk = false;

    if (UtilesSwing.validarCampo(jTextPrecio2, "^[1-9]\\d*$", "")) {
      isOk = true;
    }

    return isOk;
  }

  private boolean isNumber3(java.awt.event.KeyEvent evt) {
    boolean isOk = false;

    if (UtilesSwing.validarCampo(jTextPrecio3, "^[1-9]\\d*$", "")) {
      isOk = true;
    }

    return isOk;
  }

  private boolean isNumber4(java.awt.event.KeyEvent evt) {
    boolean isOk = false;

    if (UtilesSwing.validarCampo(jTextPrecio4, "^[1-9]\\d*$", "")) {
      isOk = true;
    }

    return isOk;
  }

  private boolean isNumberTot(java.awt.event.KeyEvent evt) {
    boolean isOk = false;

    if (UtilesSwing.validarCampo(jTextPrecioTotal, "^[1-9]\\d*$", "")) {
      isOk = true;
    }

    return isOk;
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JCheckBox jAp1;
  private javax.swing.JCheckBox jAp2;
  private javax.swing.JCheckBox jAp3;
  private javax.swing.JCheckBox jAp4;
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButtonApostar;
  private javax.swing.JButton jButtonRandom;
  private javax.swing.JButton jButtonRandom1;
  private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
  private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
  private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
  private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem4;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabelC;
  private javax.swing.JLabel jLabelD;
  private javax.swing.JLabel jLabelM;
  private javax.swing.JLabel jLabelPremio;
  private javax.swing.JLabel jLabelSaldo;
  private javax.swing.JLabel jLabelTotalApuesta;
  private javax.swing.JLabel jLabelU;
  private javax.swing.JMenu jMenu1;
  private javax.swing.JMenu jMenu2;
  private javax.swing.JMenu jMenu3;
  private javax.swing.JMenu jMenu4;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JMenuItem jMenuItem1;
  private javax.swing.JMenuItem jMenuItem2;
  private javax.swing.JMenuItem jMenuItem3;
  private javax.swing.JMenuItem jMenuItem4;
  private javax.swing.JMenuItem jMenuItem5;
  private javax.swing.JMenuItem jMenuItem6;
  private javax.swing.JPanel jPanel10;
  private javax.swing.JPanel jPanel11;
  private javax.swing.JPanel jPanel12;
  private javax.swing.JPanel jPanel13;
  private javax.swing.JPanel jPanel14;
  private javax.swing.JPanel jPanel15;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel6;
  private javax.swing.JPanel jPanel7;
  private javax.swing.JPanel jPanel8;
  private javax.swing.JPanel jPanel9;
  private javax.swing.JPanel jPanelApuestaEntero;
  private javax.swing.JPanel jPanelMarcador;
  private javax.swing.JPanel jPanelPrecioAp;
  private javax.swing.JPanel jPanelSelect;
  private javax.swing.JPanel jPanelSpin;
  private javax.swing.JSpinner jSpinner1;
  private javax.swing.JSpinner jSpinner2;
  private javax.swing.JSpinner jSpinner3;
  private javax.swing.JSpinner jSpinner4;
  private javax.swing.JTextField jTextPrecio1;
  private javax.swing.JTextField jTextPrecio2;
  private javax.swing.JTextField jTextPrecio3;
  private javax.swing.JTextField jTextPrecio4;
  private javax.swing.JTextField jTextPrecioTotal;
  private javax.swing.JLabel sep1;
  private javax.swing.JLabel sep2;
  private javax.swing.JLabel sep3;
  private javax.swing.JLabel sep4;
  private javax.swing.JLabel sep5;
  private javax.swing.JLabel sep6;
  private javax.swing.JLabel sep7;
  private javax.swing.JLabel sep8;
  private javax.swing.JLabel sep9;
  // End of variables declaration//GEN-END:variables

  @Override
  public void keyTyped(KeyEvent e) {
    System.out.println("keyTyped");
  }

  @Override
  public void keyPressed(KeyEvent e) {
    System.out.println("keyPress");
  }

  @Override
  public void keyReleased(KeyEvent e) {
    System.out.println("keyReleased");
  }

}
