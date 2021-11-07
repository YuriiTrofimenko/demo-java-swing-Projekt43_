
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Я
 */
public class Calka extends javax.swing.JFrame {

    long lpunktow, sukcesów; // счетчики нарисованных точек и попаданий в заданную область
    int maxP = 1000; // liczba punktów losowanych w serii
    // абсолютно точно значение определенного интеграла рассчитали заранее
    // при помощи математического анализа
    final double W = 2.469; // stała W - wartość teoretyczna wyniku
    double wynik = 0; // oszacowanie wyniku
    Random r = new Random();
    Image obraz;
    Graphics bufor; // obraz, bufor - posłużą do ilustracji graficznej losowania punktów prostokąta

    PanelGraficzny panel = new PanelGraficzny();

    public Calka() {
        initComponents();
        add(panel);
        obraz = createImage(panel.getWidth(), panel.getHeight());
        bufor = obraz.getGraphics();
        start();
        jTable1.setValueAt(W, 0, 3);
    }

    // расширенный класс панели - с размерами и рамкой
    class PanelGraficzny extends JPanel {

        public PanelGraficzny() {
            setBounds(20, 20, 200, 200);
            setBorder(BorderFactory.createLineBorder(Color.blue));
        }

        public void paintComponent(Graphics g) {
            g.drawImage(obraz, 0, 0, this);
        }
    }

    private void losowanie() {
        double x = 2 * r.nextDouble(); //(x,y)– wylosowany punkt x0,2), y0,4)
        double y = 4 * r.nextDouble();
        // если координаты для точки лежат снизу от графика функции
        // "икс в квадрате умноженный на синус от икс",
        // то увеличиваем значение счетчика попаданий и рисовать будем красным
        if (y <= x * x * Math.sin(x)) {
            sukcesów++;
            bufor.setColor(Color.red);
        } else {
            // иначе - желтым
            bufor.setColor(Color.yellow);
        }
        // умножаем координаты точки на масштаб панели рисования
        int xp = (int) (x / 2 * panel.getWidth());//przeliczenie współrzędnych punktu na panelu
        int yp = panel.getHeight() - (int) (y / 4 * panel.getHeight());
        // геометрическая точка не имеет размеров, поэтому рисуем точку
        // как отрезок без длины
        bufor.drawLine(xp, yp, xp, yp); //rysowanie punktu
        // текущий процент попаданий, умноженный на площадь всего прямоугольника,
        // равен полощади, оказавшейся под графиком функцииы
        wynik = 8.0 * sukcesów / lpunktow;
    }

    private void start() {
        lpunktow = sukcesów = 0; // zerowanie liczników
        jTable1.setValueAt(0, 0, 0);
        jTable1.setValueAt(0, 0, 1); // wpisanie odpowiednich zer do tabeli
        jTable1.setValueAt(null, 0, 2); // usunięcie oszacowania wyniku
        bufor.setColor(Color.white);
        bufor.fillRect(0, 0, panel.getWidth(), panel.getHeight()); //białe tło obrazu
        panel.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Liczba punktów", "Liczba sukcesów", "Oszacowanie wyniku", "Wartość teoretyczna "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jButton1.setText("Losuj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Restart");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(jButton1)
                .addGap(130, 130, 130)
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(168, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(136, 136, 136))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        start();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        for (int i = 0; i < maxP; i++) { // wykonanie serii losowań
            lpunktow++;
            losowanie();
        }
        jTable1.setValueAt(lpunktow, 0, 0);
        jTable1.setValueAt(sukcesów, 0, 1);
        jTable1.setValueAt(wynik, 0, 2); // wpisanie do tabeli oszacowania wyniku
        panel.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calka().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
