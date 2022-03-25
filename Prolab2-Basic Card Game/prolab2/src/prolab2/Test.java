package prolab2;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Test extends javax.swing.JFrame {

    static ArrayList<Futbolcu> futbolcu = new ArrayList<Futbolcu>();
    static ArrayList<Basketbolcu> basketbolcu = new ArrayList<Basketbolcu>();
    static Bilgisayar bilgisayar = new Bilgisayar(2, "Bilgisayar", 0);
    static Kullanici oyuncu = new Kullanici(1);
    static int tiklanan = 4;

    static void karsilastir(Bilgisayar pc, Kullanici kul, int sira, int kartidpc, int kartidkul) {
        Random r = new Random();
        int pozisyon = r.nextInt(3);
        if (sira % 2 == 0) {
            Futbolcu fpc = pc.fList.get(kartidpc);
            Futbolcu fkul = kul.fList.get(kartidkul);
            oynanankartisimpc.setText(fpc.getSporcuIsim());
            oynanankarttakimpc.setText(fpc.getSporcuTakim());
            ucuncupuandegeripc.setText("" + fpc.getPenalti());
            dorduncupuandegeripc.setText("" + fpc.getSerbestAtis());
            besincipuandegeripc.setText("" + fpc.getKaleciKarsiKarsiya());
            ikinciucuncuyazi.setText("Penalti:");
            ikincidorduncuyazi.setText("Serbest Atis:");
            ikincibesinciyazi.setText("Kaleci ile karsi karsiya:");
            if (pozisyon == 0) {
                pozisyonText.setText("Kaleci ile karsi karsiya");
                oyPuanText.setText("" + fkul.getKaleciKarsiKarsiya());
                pcPuanText.setText("" + fpc.getKaleciKarsiKarsiya());
                if (fpc.getKaleciKarsiKarsiya() > fkul.getKaleciKarsiKarsiya()) {
                    pc.setSkor(pc.getSkor() + 10);
                    kul.fList.remove(kartidkul);
                    pc.fList.remove(kartidpc);
                    pc.futboladim--;
                } else if (fpc.getKaleciKarsiKarsiya() < fkul.getKaleciKarsiKarsiya()) {
                    kul.setSkor(kul.getSkor() + 10);
                    kul.fList.remove(kartidkul);
                    pc.fList.remove(kartidpc);
                    pc.futboladim--;
                }
            } else if (pozisyon == 1) {
                pozisyonText.setText("Penalti");
                oyPuanText.setText("" + fkul.getPenalti());
                pcPuanText.setText("" + fpc.getPenalti());
                if (fpc.getPenalti() > fkul.getPenalti()) {
                    pc.setSkor(pc.getSkor() + 10);
                    kul.fList.remove(kartidkul);
                    pc.fList.remove(kartidpc);
                    pc.futboladim--;
                } else if (fpc.getPenalti() < fkul.getPenalti()) {
                    kul.setSkor(kul.getSkor() + 10);
                    kul.fList.remove(kartidkul);
                    pc.fList.remove(kartidpc);
                    pc.futboladim--;
                }
            } else {
                pozisyonText.setText("Serbest Atis");
                oyPuanText.setText("" + fkul.getSerbestAtis());
                pcPuanText.setText("" + fpc.getSerbestAtis());
                if (fpc.getSerbestAtis() > fkul.getSerbestAtis()) {
                    pc.setSkor(pc.getSkor() + 10);
                    kul.fList.remove(kartidkul);
                    pc.fList.remove(kartidpc);
                    pc.futboladim--;
                } else if (fpc.getSerbestAtis() < fkul.getSerbestAtis()) {
                    kul.setSkor(kul.getSkor() + 10);
                    kul.fList.remove(kartidkul);
                    pc.fList.remove(kartidpc);
                    pc.futboladim--;
                }
            }
        } else {
            Basketbolcu bpc = pc.bList.get(kartidpc);
            Basketbolcu bkul = kul.bList.get(kartidkul);
            oynanankartisimpc.setText(bpc.getSporcuIsim());
            oynanankarttakimpc.setText(bpc.getSporcuTakim());
            ucuncupuandegeripc.setText("" + bpc.getIkilik());
            dorduncupuandegeripc.setText("" + bpc.getUcluk());
            besincipuandegeripc.setText("" + bpc.getSerbestAtis());
            ikinciucuncuyazi.setText("Ikilik:");
            ikincidorduncuyazi.setText("Ucluk:");
            ikincibesinciyazi.setText("Serbest Atis:");
            if (pozisyon == 0) {
                pozisyonText.setText("Ikilik");
                oyPuanText.setText("" + bkul.getIkilik());
                pcPuanText.setText("" + bpc.getIkilik());
                if (bpc.getIkilik() > bkul.getIkilik()) {
                    pc.setSkor(pc.getSkor() + 10);
                    kul.bList.remove(kartidkul);
                    pc.bList.remove(kartidpc);
                    pc.basketboladim--;
                } else if (bpc.getIkilik() < bkul.getIkilik()) {
                    kul.setSkor(kul.getSkor() + 10);
                    kul.bList.remove(kartidkul);
                    pc.bList.remove(kartidpc);
                    pc.basketboladim--;
                }
            } else if (pozisyon == 1) {
                pozisyonText.setText("Ucluk");
                oyPuanText.setText("" + bkul.getUcluk());
                pcPuanText.setText("" + bpc.getUcluk());
                if (bpc.getUcluk() > bkul.getUcluk()) {
                    pc.setSkor(pc.getSkor() + 10);
                    kul.bList.remove(kartidkul);
                    pc.bList.remove(kartidpc);
                    pc.basketboladim--;
                } else if (bpc.getUcluk() < bkul.getUcluk()) {
                    kul.setSkor(kul.getSkor() + 10);
                    kul.bList.remove(kartidkul);
                    pc.bList.remove(kartidpc);
                    pc.basketboladim--;
                }
            } else {
                pozisyonText.setText("Serbest Atis");
                oyPuanText.setText("" + bkul.getSerbestAtis());
                pcPuanText.setText("" + bpc.getSerbestAtis());
                if (bpc.getSerbestAtis() > bkul.getSerbestAtis()) {
                    pc.setSkor(pc.getSkor() + 10);
                    kul.bList.remove(kartidkul);
                    pc.bList.remove(kartidpc);
                    pc.basketboladim--;
                } else if (bpc.getSerbestAtis() < bkul.getSerbestAtis()) {
                    kul.setSkor(kul.getSkor() + 10);
                    kul.bList.remove(kartidkul);
                    pc.bList.remove(kartidpc);
                    pc.basketboladim--;
                }
            }
        }
        pcPuan.setText("Bilgisayar Puani:" + bilgisayar.getSkor());
        oyuncuPuan.setText("Oyuncu Puani:" + oyuncu.getSkor());
    }

    static void kartDagit(Bilgisayar pc, Kullanici kul, ArrayList<Futbolcu> futbolcu, ArrayList<Basketbolcu> basketbolcu) {
        int ind = 7;
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int ata = r.nextInt(ind);
            pc.fList.add(futbolcu.get(ata));
            futbolcu.remove(ata);
            ind--;
        }
        for (int i = 0; i < 4; i++) {
            kul.fList.add(futbolcu.get(ind));
            futbolcu.remove(ind);
            ind--;
        }
        ind = 7;
        for (int i = 0; i < 4; i++) {
            int ata = r.nextInt(ind);
            pc.bList.add(basketbolcu.get(ata));
            basketbolcu.remove(ata);
            ind--;
        }
        for (int i = 0; i < 4; i++) {
            kul.bList.add(basketbolcu.get(ind));
            basketbolcu.remove(ind);
            ind--;
        }
    }

    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test().setVisible(true);
                oynaButonu.setVisible(false);
                kazanantext.setVisible(false);
            }
        });

        Futbolcu F1 = new Futbolcu("Cristiano Ronaldo", "Juventus FC", 95, 85, 90);
        Futbolcu F2 = new Futbolcu("Lionel Messi", "FC Barcelona", 95, 90, 85);
        Futbolcu F3 = new Futbolcu("Antoine Griezmann", "FC Barcelona", 85, 75, 80);
        Futbolcu F4 = new Futbolcu("Sergio Ramos", "Real Madrid CF", 85, 75, 85);
        Futbolcu F5 = new Futbolcu("Paulo Dybala", "Juventus FC", 80, 80, 85);
        Futbolcu F6 = new Futbolcu("Robert Lewandowski", "FC Bayern München", 90, 90, 80);
        Futbolcu F7 = new Futbolcu("Kylian Mbappé", "Paris Saint-Germain", 80, 75, 90);
        Futbolcu F8 = new Futbolcu("Luis Suárez", "Atlético Madrid", 90, 85, 80);

        futbolcu.add(F1);
        futbolcu.add(F2);
        futbolcu.add(F3);
        futbolcu.add(F4);
        futbolcu.add(F5);
        futbolcu.add(F6);
        futbolcu.add(F7);
        futbolcu.add(F8);

        Basketbolcu B1 = new Basketbolcu("Giannis Antetokounmpo", "Milwaukee Bucks", 95, 90, 95);
        Basketbolcu B2 = new Basketbolcu("Kawhi Leonard", "Los Angeles Clippers", 90, 80, 90);
        Basketbolcu B3 = new Basketbolcu("LeBron James", "Los Angeles Lakers", 100, 95, 95);
        Basketbolcu B4 = new Basketbolcu("James Harden", "Houston Rockets", 95, 95, 95);
        Basketbolcu B5 = new Basketbolcu("Anthony Davis", "Los Angeles Lakers", 90, 85, 85);
        Basketbolcu B6 = new Basketbolcu("Nikola Jokic", "Denver Nuggets", 85, 80, 85);
        Basketbolcu B7 = new Basketbolcu("Joel Embiid", "Philadelphia 76ers", 85, 85, 90);
        Basketbolcu B8 = new Basketbolcu("Luka Doncic", "Dallas Mavericks", 90, 85, 95);

        basketbolcu.add(B1);
        basketbolcu.add(B2);
        basketbolcu.add(B3);
        basketbolcu.add(B4);
        basketbolcu.add(B5);
        basketbolcu.add(B6);
        basketbolcu.add(B7);
        basketbolcu.add(B8);

        kartDagit(bilgisayar, oyuncu, futbolcu, basketbolcu);
    }

    private int say = 0;

    /**
     * Creates new form Interface
     */
    public Test() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pcPuan = new javax.swing.JLabel();
        oyuncuPuan = new javax.swing.JLabel();
        kartDagitButonu = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        oyKart2 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        oyKart3 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        oyKart4 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        oyKart1 = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        pcKart2 = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        pcKart3 = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        pcKart4 = new javax.swing.JTextArea();
        jScrollPane19 = new javax.swing.JScrollPane();
        pcKart1 = new javax.swing.JTextArea();
        oynaButonu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ucuncuyazi = new javax.swing.JLabel();
        dorduncuyazi = new javax.swing.JLabel();
        besinciyazi = new javax.swing.JLabel();
        oynanankartisimoy = new javax.swing.JLabel();
        oynanankarttakimoy = new javax.swing.JLabel();
        ucuncupuandegerioy = new javax.swing.JLabel();
        dorduncupuandegerioy = new javax.swing.JLabel();
        besincipuandegerioy = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ikinciucuncuyazi = new javax.swing.JLabel();
        ikincidorduncuyazi = new javax.swing.JLabel();
        ikincibesinciyazi = new javax.swing.JLabel();
        oynanankartisimpc = new javax.swing.JLabel();
        oynanankarttakimpc = new javax.swing.JLabel();
        ucuncupuandegeripc = new javax.swing.JLabel();
        dorduncupuandegeripc = new javax.swing.JLabel();
        besincipuandegeripc = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pozisyonText = new javax.swing.JLabel();
        oyPuanText = new javax.swing.JLabel();
        pcPuanText = new javax.swing.JLabel();
        kazanantext = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sporcu Kart Oyunu");

        pcPuan.setText("Bilgisayar Puani:0");

        oyuncuPuan.setText("Oyuncu Puani:0");

        kartDagitButonu.setText("Kartlari dagit");
        kartDagitButonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kartDagitButonuActionPerformed(evt);
            }
        });

        oyKart2.setEditable(false);
        oyKart2.setColumns(14);
        oyKart2.setRows(5);
        oyKart2.setText("Futbolcu ismi:  ***\nFutbolcu takimi:  ***\nPenalti:  ***\nSerbest Atis:  ***\nKaleciyle karsi karsiya:  ***\n");
        oyKart2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        oyKart2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oyKart2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(oyKart2);

        oyKart3.setEditable(false);
        oyKart3.setColumns(14);
        oyKart3.setRows(5);
        oyKart3.setText("Futbolcu ismi:  ***\nFutbolcu takimi:  ***\nPenalti:  ***\nSerbest Atis:  ***\nKaleciyle karsi karsiya:  ***\n");
        oyKart3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        oyKart3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oyKart3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(oyKart3);

        oyKart4.setEditable(false);
        oyKart4.setColumns(14);
        oyKart4.setRows(5);
        oyKart4.setText("Futbolcu ismi:  ***\nFutbolcu takimi:  ***\nPenalti:  ***\nSerbest Atis:  ***\nKaleciyle karsi karsiya:  ***\n");
        oyKart4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        oyKart4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oyKart4MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(oyKart4);

        oyKart1.setEditable(false);
        oyKart1.setColumns(14);
        oyKart1.setRows(5);
        oyKart1.setText("Futbolcu ismi:  ***\nFutbolcu takimi:  ***\nPenalti:  ***\nSerbest Atis:  ***\nKaleciyle karsi karsiya:  ***\n");
        oyKart1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        oyKart1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oyKart1MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(oyKart1);

        pcKart2.setEditable(false);
        pcKart2.setColumns(14);
        pcKart2.setRows(5);
        pcKart2.setText("Futbolcu ismi:  ***\nFutbolcu takimi:  ***\nPenalti:  ***\nSerbest Atis:  ***\nKaleciyle karsi karsiya:  ***\n");
        pcKart2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane7.setViewportView(pcKart2);

        pcKart3.setEditable(false);
        pcKart3.setColumns(14);
        pcKart3.setRows(5);
        pcKart3.setText("Futbolcu ismi:  ***\nFutbolcu takimi:  ***\nPenalti:  ***\nSerbest Atis:  ***\nKaleciyle karsi karsiya:  ***\n");
        pcKart3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane8.setViewportView(pcKart3);

        pcKart4.setEditable(false);
        pcKart4.setColumns(14);
        pcKart4.setRows(5);
        pcKart4.setText("Futbolcu ismi:  ***\nFutbolcu takimi:  ***\nPenalti:  ***\nSerbest Atis:  ***\nKaleciyle karsi karsiya:  ***\n");
        pcKart4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane9.setViewportView(pcKart4);

        pcKart1.setEditable(false);
        pcKart1.setColumns(14);
        pcKart1.setRows(5);
        pcKart1.setText("Futbolcu ismi:  ***\nFutbolcu takimi:  ***\nPenalti:  ***\nSerbest Atis:  ***\nKaleciyle karsi karsiya:  ***\n");
        pcKart1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane19.setViewportView(pcKart1);

        oynaButonu.setText("Oyna");
        oynaButonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oynaButonuActionPerformed(evt);
            }
        });

        jLabel1.setText("Isim:");

        jLabel2.setText("Takim:");

        ucuncuyazi.setText("Pozisyon 1:");

        dorduncuyazi.setText("Pozisyon 2:");

        besinciyazi.setText("Pozisyon 3:");

        oynanankartisimoy.setText("***");

        oynanankarttakimoy.setText("***");

        ucuncupuandegerioy.setText("***");

        dorduncupuandegerioy.setText("***");

        besincipuandegerioy.setText("***");

        jLabel6.setText("Isim:");

        jLabel7.setText("Takim:");

        ikinciucuncuyazi.setText("Pozisyon 1:");

        ikincidorduncuyazi.setText("Pozisyon 2:");

        ikincibesinciyazi.setText("Pozisyon 3:");

        oynanankartisimpc.setText("***");

        oynanankarttakimpc.setText("***");

        ucuncupuandegeripc.setText("***");

        dorduncupuandegeripc.setText("***");

        besincipuandegeripc.setText("***");

        jLabel3.setText("Karsilastirma:");

        jLabel4.setText("Pozisyon:");

        jLabel5.setText("Oyuncu kart puani:");

        jLabel8.setText("Bilgisayar kart puani:");

        pozisyonText.setText("***");

        oyPuanText.setText("***");

        pcPuanText.setText("***");

        kazanantext.setText("KAZANAN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oyuncuPuan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pcPuan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(74, 74, 74))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(kazanantext)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kartDagitButonu)
                            .addComponent(oynaButonu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(346, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(604, 604, 604)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(260, 260, 260)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(besinciyazi)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(ucuncuyazi)
                                    .addComponent(dorduncuyazi))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ucuncupuandegerioy)
                                    .addComponent(oynanankartisimoy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(oynanankarttakimoy, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(besincipuandegerioy, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dorduncupuandegerioy)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ikincidorduncuyazi, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ikinciucuncuyazi, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ikincibesinciyazi, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(besincipuandegeripc)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(dorduncupuandegeripc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ucuncupuandegeripc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(oynanankarttakimpc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(oynanankartisimpc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(428, 428, 428)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pozisyonText))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(oyPuanText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pcPuanText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pcPuan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(oyuncuPuan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kazanantext))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(oynanankartisimoy)
                    .addComponent(jLabel6)
                    .addComponent(oynanankartisimpc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(oynanankarttakimoy)
                    .addComponent(jLabel7)
                    .addComponent(oynanankarttakimpc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ucuncuyazi)
                    .addComponent(ucuncupuandegerioy)
                    .addComponent(ikinciucuncuyazi)
                    .addComponent(ucuncupuandegeripc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dorduncuyazi)
                    .addComponent(dorduncupuandegerioy)
                    .addComponent(ikincidorduncuyazi)
                    .addComponent(dorduncupuandegeripc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(besinciyazi)
                    .addComponent(besincipuandegerioy)
                    .addComponent(ikincibesinciyazi)
                    .addComponent(besincipuandegeripc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pozisyonText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(oyPuanText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(pcPuanText))
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(kartDagitButonu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(oynaButonu)
                        .addGap(18, 18, 18))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kartDagitButonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kartDagitButonuActionPerformed

        ArrayList<String> oyfutarraylist = new ArrayList<String>();
        for (var i : oyuncu.fList) {
            String icerik = i.getSporcuIsim() + "\n" + i.getSporcuTakim() + "\nPenalti: "
                    + i.getPenalti() + "\nSerbest atis: " + i.getSerbestAtis() + "\nKaleciyle karsi karsiya:"
                    + i.getKaleciKarsiKarsiya();
            oyfutarraylist.add(icerik);
        }
        oyKart1.setText(oyfutarraylist.get(0));
        oyKart2.setText(oyfutarraylist.get(1));
        oyKart3.setText(oyfutarraylist.get(2));
        oyKart4.setText(oyfutarraylist.get(3));

        ArrayList<String> pcfutarraylist = new ArrayList<String>();
        for (var i : bilgisayar.fList) {
            String icerik = i.getSporcuIsim() + "\n" + i.getSporcuTakim() + "\nPenalti: "
                    + i.getPenalti() + "\nSerbest atis: " + i.getSerbestAtis() + "\nKaleciyle karsi karsiya:"
                    + i.getKaleciKarsiKarsiya();
            pcfutarraylist.add(icerik);
        }
        pcKart1.setText(pcfutarraylist.get(0));
        pcKart2.setText(pcfutarraylist.get(1));
        pcKart3.setText(pcfutarraylist.get(2));
        pcKart4.setText(pcfutarraylist.get(3));

        kartDagitButonu.setVisible(false);
        oynaButonu.setVisible(true);

    }//GEN-LAST:event_kartDagitButonuActionPerformed

    private void oynaButonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oynaButonuActionPerformed

        if (say % 2 == 0) {

            if (tiklanan == 0) {
                karsilastir(bilgisayar, oyuncu, say, bilgisayar.kartSec(say), 0);
            } else if (tiklanan == 1) {
                karsilastir(bilgisayar, oyuncu, say, bilgisayar.kartSec(say), 1);
            } else if (tiklanan == 2) {
                karsilastir(bilgisayar, oyuncu, say, bilgisayar.kartSec(say), 2);
            } else if (tiklanan == 3) {
                karsilastir(bilgisayar, oyuncu, say, bilgisayar.kartSec(say), 3);
            }

            if (!(oyuncu.bList.isEmpty())) {

                ArrayList<String> oybasarraylist = new ArrayList<String>();
                for (var i : oyuncu.bList) {
                    String kart1oybas = i.getSporcuIsim() + "\n" + i.getSporcuTakim() + "\nIkilik: "
                            + i.getIkilik() + "\nUcluk: " + i.getUcluk() + "\nSerbest atis: "
                            + i.getSerbestAtis();
                    oybasarraylist.add(kart1oybas);
                }
                if (oybasarraylist.size() == 4) {
                    oyKart1.setText(oybasarraylist.get(0));
                    oyKart2.setText(oybasarraylist.get(1));
                    oyKart3.setText(oybasarraylist.get(2));
                    oyKart4.setText(oybasarraylist.get(3));
                } else if (oybasarraylist.size() == 3) {
                    oyKart1.setText(oybasarraylist.get(0));
                    oyKart2.setText(oybasarraylist.get(1));
                    oyKart3.setText(oybasarraylist.get(2));
                } else if (oybasarraylist.size() == 2) {
                    oyKart1.setText(oybasarraylist.get(0));
                    oyKart2.setText(oybasarraylist.get(1));
                } else if (oybasarraylist.size() == 1) {
                    oyKart1.setText(oybasarraylist.get(0));
                }

                if (oyuncu.bList.size() == 4) {
                    oyKart1.setVisible(true);
                    oyKart2.setVisible(true);
                    oyKart3.setVisible(true);
                    oyKart4.setVisible(true);
                } else if (oyuncu.bList.size() == 3) {
                    oyKart1.setVisible(true);
                    oyKart2.setVisible(true);
                    oyKart3.setVisible(true);
                    oyKart4.setVisible(false);
                } else if (oyuncu.bList.size() == 2) {
                    oyKart1.setVisible(true);
                    oyKart2.setVisible(true);
                    oyKart3.setVisible(false);
                    oyKart4.setVisible(false);
                } else if (oyuncu.bList.size() == 1) {
                    oyKart1.setVisible(true);
                    oyKart2.setVisible(false);
                    oyKart3.setVisible(false);
                    oyKart4.setVisible(false);
                } else {
                    oyKart1.setVisible(false);
                    oyKart2.setVisible(false);
                    oyKart3.setVisible(false);
                    oyKart4.setVisible(false);
                }

                ArrayList<String> pcbasarraylist = new ArrayList<String>();
                for (var i : bilgisayar.bList) {
                    String kart1pcbas = i.getSporcuIsim() + "\n" + i.getSporcuTakim() + "\nIkilik: "
                            + i.getIkilik() + "\nUcluk: " + i.getUcluk() + "\nSerbest atis: "
                            + i.getSerbestAtis();
                    pcbasarraylist.add(kart1pcbas);
                }
                if (pcbasarraylist.size() == 4) {
                    pcKart1.setText(pcbasarraylist.get(0));
                    pcKart2.setText(pcbasarraylist.get(1));
                    pcKart3.setText(pcbasarraylist.get(2));
                    pcKart4.setText(pcbasarraylist.get(3));
                } else if (pcbasarraylist.size() == 3) {
                    pcKart1.setText(pcbasarraylist.get(0));
                    pcKart2.setText(pcbasarraylist.get(1));
                    pcKart3.setText(pcbasarraylist.get(2));
                } else if (pcbasarraylist.size() == 2) {
                    pcKart1.setText(pcbasarraylist.get(0));
                    pcKart2.setText(pcbasarraylist.get(1));
                } else if (pcbasarraylist.size() == 1) {
                    pcKart1.setText(pcbasarraylist.get(0));
                }

                if (bilgisayar.bList.size() == 4) {
                    pcKart1.setVisible(true);
                    pcKart2.setVisible(true);
                    pcKart3.setVisible(true);
                    pcKart4.setVisible(true);
                } else if (bilgisayar.bList.size() == 3) {
                    pcKart1.setVisible(true);
                    pcKart2.setVisible(true);
                    pcKart3.setVisible(true);
                    pcKart4.setVisible(false);
                } else if (bilgisayar.bList.size() == 2) {
                    pcKart1.setVisible(true);
                    pcKart2.setVisible(true);
                    pcKart3.setVisible(false);
                    pcKart4.setVisible(false);
                } else if (bilgisayar.bList.size() == 1) {
                    pcKart1.setVisible(true);
                    pcKart2.setVisible(false);
                    pcKart3.setVisible(false);
                    pcKart4.setVisible(false);
                } else {
                    pcKart1.setVisible(false);
                    pcKart2.setVisible(false);
                    pcKart3.setVisible(false);
                    pcKart4.setVisible(false);
                }

                say++;
            } else {

                ArrayList<String> oyfutarraylist = new ArrayList<String>();
                for (var i : oyuncu.fList) {
                    String kart1oyfut = i.getSporcuIsim() + "\n" + i.getSporcuTakim() + "\nPenalti: "
                            + i.getPenalti() + "\nSerbest atis: " + i.getSerbestAtis() + "\nKaleciyle karsi karsiya:"
                            + i.getKaleciKarsiKarsiya();
                    oyfutarraylist.add(kart1oyfut);
                }
                if (oyfutarraylist.size() == 4) {
                    oyKart1.setText(oyfutarraylist.get(0));
                    oyKart2.setText(oyfutarraylist.get(1));
                    oyKart3.setText(oyfutarraylist.get(2));
                    oyKart4.setText(oyfutarraylist.get(3));
                } else if (oyfutarraylist.size() == 3) {
                    oyKart1.setText(oyfutarraylist.get(0));
                    oyKart2.setText(oyfutarraylist.get(1));
                    oyKart3.setText(oyfutarraylist.get(2));
                } else if (oyfutarraylist.size() == 2) {
                    oyKart1.setText(oyfutarraylist.get(0));
                    oyKart2.setText(oyfutarraylist.get(1));
                } else if (oyfutarraylist.size() == 1) {
                    oyKart1.setText(oyfutarraylist.get(0));
                }

                if (oyuncu.fList.size() == 4) {
                    oyKart1.setVisible(true);
                    oyKart2.setVisible(true);
                    oyKart3.setVisible(true);
                    oyKart4.setVisible(true);
                } else if (oyuncu.fList.size() == 3) {
                    oyKart1.setVisible(true);
                    oyKart2.setVisible(true);
                    oyKart3.setVisible(true);
                    oyKart4.setVisible(false);
                } else if (oyuncu.fList.size() == 2) {
                    oyKart1.setVisible(true);
                    oyKart2.setVisible(true);
                    oyKart3.setVisible(false);
                    oyKart4.setVisible(false);
                } else if (oyuncu.fList.size() == 1) {
                    oyKart1.setVisible(true);
                    oyKart2.setVisible(false);
                    oyKart3.setVisible(false);
                    oyKart4.setVisible(false);
                } else {
                    oyKart1.setVisible(false);
                    oyKart2.setVisible(false);
                    oyKart3.setVisible(false);
                    oyKart4.setVisible(false);
                }
                ArrayList<String> pcfutarraylist = new ArrayList<String>();
                for (var i : bilgisayar.fList) {
                    String kart1pcfut = i.getSporcuIsim() + "\n" + i.getSporcuTakim() + "\nPenalti: "
                            + i.getPenalti() + "\nSerbest atis: " + i.getSerbestAtis() + "\nKaleciyle karsi karsiya:"
                            + i.getKaleciKarsiKarsiya();
                    pcfutarraylist.add(kart1pcfut);
                }
                if (pcfutarraylist.size() == 4) {
                    pcKart1.setText(pcfutarraylist.get(0));
                    pcKart2.setText(pcfutarraylist.get(1));
                    pcKart3.setText(pcfutarraylist.get(2));
                    pcKart4.setText(pcfutarraylist.get(3));
                } else if (pcfutarraylist.size() == 3) {
                    pcKart1.setText(pcfutarraylist.get(0));
                    pcKart2.setText(pcfutarraylist.get(1));
                    pcKart3.setText(pcfutarraylist.get(2));
                } else if (pcfutarraylist.size() == 2) {
                    pcKart1.setText(pcfutarraylist.get(0));
                    pcKart2.setText(pcfutarraylist.get(1));
                } else if (pcfutarraylist.size() == 1) {
                    pcKart1.setText(pcfutarraylist.get(0));
                }

                if (bilgisayar.fList.size() == 4) {
                    pcKart1.setVisible(true);
                    pcKart2.setVisible(true);
                    pcKart3.setVisible(true);
                    pcKart4.setVisible(true);
                } else if (bilgisayar.fList.size() == 3) {
                    pcKart1.setVisible(true);
                    pcKart2.setVisible(true);
                    pcKart3.setVisible(true);
                    pcKart4.setVisible(false);
                } else if (bilgisayar.fList.size() == 2) {
                    pcKart1.setVisible(true);
                    pcKart2.setVisible(true);
                    pcKart3.setVisible(false);
                    pcKart4.setVisible(false);
                } else if (bilgisayar.fList.size() == 1) {
                    pcKart1.setVisible(true);
                    pcKart2.setVisible(false);
                    pcKart3.setVisible(false);
                    pcKart4.setVisible(false);
                } else {
                    pcKart1.setVisible(false);
                    pcKart2.setVisible(false);
                    pcKart3.setVisible(false);
                    pcKart4.setVisible(false);
                }

            }

        } else {
            if (tiklanan == 0) {
                karsilastir(bilgisayar, oyuncu, say, bilgisayar.kartSec(say), 0);
            } else if (tiklanan == 1) {
                karsilastir(bilgisayar, oyuncu, say, bilgisayar.kartSec(say), 1);
            } else if (tiklanan == 2) {
                karsilastir(bilgisayar, oyuncu, say, bilgisayar.kartSec(say), 2);
            } else if (tiklanan == 3) {
                karsilastir(bilgisayar, oyuncu, say, bilgisayar.kartSec(say), 3);
            }

            if (!(oyuncu.fList.isEmpty())) {

                ArrayList<String> oyfutarraylist = new ArrayList<String>();
                for (var i : oyuncu.fList) {
                    String kart1oyfut = i.getSporcuIsim() + "\n" + i.getSporcuTakim() + "\nPenalti: "
                            + i.getPenalti() + "\nSerbest atis: " + i.getSerbestAtis() + "\nKaleciyle karsi karsiya:"
                            + i.getKaleciKarsiKarsiya();
                    oyfutarraylist.add(kart1oyfut);
                }
                if (oyfutarraylist.size() == 4) {
                    oyKart1.setText(oyfutarraylist.get(0));
                    oyKart2.setText(oyfutarraylist.get(1));
                    oyKart3.setText(oyfutarraylist.get(2));
                    oyKart4.setText(oyfutarraylist.get(3));
                } else if (oyfutarraylist.size() == 3) {
                    oyKart1.setText(oyfutarraylist.get(0));
                    oyKart2.setText(oyfutarraylist.get(1));
                    oyKart3.setText(oyfutarraylist.get(2));
                } else if (oyfutarraylist.size() == 2) {
                    oyKart1.setText(oyfutarraylist.get(0));
                    oyKart2.setText(oyfutarraylist.get(1));
                } else if (oyfutarraylist.size() == 1) {
                    oyKart1.setText(oyfutarraylist.get(0));
                }

                if (oyuncu.fList.size() == 4) {
                    oyKart1.setVisible(true);
                    oyKart2.setVisible(true);
                    oyKart3.setVisible(true);
                    oyKart4.setVisible(true);
                } else if (oyuncu.fList.size() == 3) {
                    oyKart1.setVisible(true);
                    oyKart2.setVisible(true);
                    oyKart3.setVisible(true);
                    oyKart4.setVisible(false);
                } else if (oyuncu.fList.size() == 2) {
                    oyKart1.setVisible(true);
                    oyKart2.setVisible(true);
                    oyKart3.setVisible(false);
                    oyKart4.setVisible(false);
                } else if (oyuncu.fList.size() == 1) {
                    oyKart1.setVisible(true);
                    oyKart2.setVisible(false);
                    oyKart3.setVisible(false);
                    oyKart4.setVisible(false);
                } else {
                    oyKart1.setVisible(false);
                    oyKart2.setVisible(false);
                    oyKart3.setVisible(false);
                    oyKart4.setVisible(false);
                }
                ArrayList<String> pcfutarraylist = new ArrayList<String>();
                for (var i : bilgisayar.fList) {
                    String kart1pcfut = i.getSporcuIsim() + "\n" + i.getSporcuTakim() + "\nPenalti: "
                            + i.getPenalti() + "\nSerbest atis: " + i.getSerbestAtis() + "\nKaleciyle karsi karsiya:"
                            + i.getKaleciKarsiKarsiya();
                    pcfutarraylist.add(kart1pcfut);
                }
                if (pcfutarraylist.size() == 4) {
                    pcKart1.setText(pcfutarraylist.get(0));
                    pcKart2.setText(pcfutarraylist.get(1));
                    pcKart3.setText(pcfutarraylist.get(2));
                    pcKart4.setText(pcfutarraylist.get(3));
                } else if (pcfutarraylist.size() == 3) {
                    pcKart1.setText(pcfutarraylist.get(0));
                    pcKart2.setText(pcfutarraylist.get(1));
                    pcKart3.setText(pcfutarraylist.get(2));
                } else if (pcfutarraylist.size() == 2) {
                    pcKart1.setText(pcfutarraylist.get(0));
                    pcKart2.setText(pcfutarraylist.get(1));
                } else if (pcfutarraylist.size() == 1) {
                    pcKart1.setText(pcfutarraylist.get(0));
                }

                if (bilgisayar.fList.size() == 4) {
                    pcKart1.setVisible(true);
                    pcKart2.setVisible(true);
                    pcKart3.setVisible(true);
                    pcKart4.setVisible(true);
                } else if (bilgisayar.fList.size() == 3) {
                    pcKart1.setVisible(true);
                    pcKart2.setVisible(true);
                    pcKart3.setVisible(true);
                    pcKart4.setVisible(false);
                } else if (bilgisayar.fList.size() == 2) {
                    pcKart1.setVisible(true);
                    pcKart2.setVisible(true);
                    pcKart3.setVisible(false);
                    pcKart4.setVisible(false);
                } else if (bilgisayar.fList.size() == 1) {
                    pcKart1.setVisible(true);
                    pcKart2.setVisible(false);
                    pcKart3.setVisible(false);
                    pcKart4.setVisible(false);
                } else {
                    pcKart1.setVisible(false);
                    pcKart2.setVisible(false);
                    pcKart3.setVisible(false);
                    pcKart4.setVisible(false);
                }

                say++;
            } else {
                ArrayList<String> oybasarraylist = new ArrayList<String>();
                for (var i : oyuncu.bList) {
                    String kart1oybas = i.getSporcuIsim() + "\n" + i.getSporcuTakim() + "\nIkilik: "
                            + i.getIkilik() + "\nUcluk: " + i.getUcluk() + "\nSerbest atis: "
                            + i.getSerbestAtis();
                    oybasarraylist.add(kart1oybas);
                }
                if (oybasarraylist.size() == 4) {
                    oyKart1.setText(oybasarraylist.get(0));
                    oyKart2.setText(oybasarraylist.get(1));
                    oyKart3.setText(oybasarraylist.get(2));
                    oyKart4.setText(oybasarraylist.get(3));
                } else if (oybasarraylist.size() == 3) {
                    oyKart1.setText(oybasarraylist.get(0));
                    oyKart2.setText(oybasarraylist.get(1));
                    oyKart3.setText(oybasarraylist.get(2));
                } else if (oybasarraylist.size() == 2) {
                    oyKart1.setText(oybasarraylist.get(0));
                    oyKart2.setText(oybasarraylist.get(1));
                } else if (oybasarraylist.size() == 1) {
                    oyKart1.setText(oybasarraylist.get(0));
                }

                if (oyuncu.bList.size() == 4) {
                    oyKart1.setVisible(true);
                    oyKart2.setVisible(true);
                    oyKart3.setVisible(true);
                    oyKart4.setVisible(true);
                } else if (oyuncu.bList.size() == 3) {
                    oyKart1.setVisible(true);
                    oyKart2.setVisible(true);
                    oyKart3.setVisible(true);
                    oyKart4.setVisible(false);
                } else if (oyuncu.bList.size() == 2) {
                    oyKart1.setVisible(true);
                    oyKart2.setVisible(true);
                    oyKart3.setVisible(false);
                    oyKart4.setVisible(false);
                } else if (oyuncu.bList.size() == 1) {
                    oyKart1.setVisible(true);
                    oyKart2.setVisible(false);
                    oyKart3.setVisible(false);
                    oyKart4.setVisible(false);
                } else {
                    oyKart1.setVisible(false);
                    oyKart2.setVisible(false);
                    oyKart3.setVisible(false);
                    oyKart4.setVisible(false);
                }

                ArrayList<String> pcbasarraylist = new ArrayList<String>();
                for (var i : bilgisayar.bList) {
                    String kart1pcbas = i.getSporcuIsim() + "\n" + i.getSporcuTakim() + "\nIkilik: "
                            + i.getIkilik() + "\nUcluk: " + i.getUcluk() + "\nSerbest atis: "
                            + i.getSerbestAtis();
                    pcbasarraylist.add(kart1pcbas);
                }
                if (pcbasarraylist.size() == 4) {
                    pcKart1.setText(pcbasarraylist.get(0));
                    pcKart2.setText(pcbasarraylist.get(1));
                    pcKart3.setText(pcbasarraylist.get(2));
                    pcKart4.setText(pcbasarraylist.get(3));
                } else if (pcbasarraylist.size() == 3) {
                    pcKart1.setText(pcbasarraylist.get(0));
                    pcKart2.setText(pcbasarraylist.get(1));
                    pcKart3.setText(pcbasarraylist.get(2));
                } else if (pcbasarraylist.size() == 2) {
                    pcKart1.setText(pcbasarraylist.get(0));
                    pcKart2.setText(pcbasarraylist.get(1));
                } else if (pcbasarraylist.size() == 1) {
                    pcKart1.setText(pcbasarraylist.get(0));
                }

                if (bilgisayar.bList.size() == 4) {
                    pcKart1.setVisible(true);
                    pcKart2.setVisible(true);
                    pcKart3.setVisible(true);
                    pcKart4.setVisible(true);
                } else if (bilgisayar.bList.size() == 3) {
                    pcKart1.setVisible(true);
                    pcKart2.setVisible(true);
                    pcKart3.setVisible(true);
                    pcKart4.setVisible(false);
                } else if (bilgisayar.bList.size() == 2) {
                    pcKart1.setVisible(true);
                    pcKart2.setVisible(true);
                    pcKart3.setVisible(false);
                    pcKart4.setVisible(false);
                } else if (bilgisayar.bList.size() == 1) {
                    pcKart1.setVisible(true);
                    pcKart2.setVisible(false);
                    pcKart3.setVisible(false);
                    pcKart4.setVisible(false);
                } else {
                    pcKart1.setVisible(false);
                    pcKart2.setVisible(false);
                    pcKart3.setVisible(false);
                    pcKart4.setVisible(false);
                }

            }
        }
        pcPuan.setText("Bilgisayar Puani:" + bilgisayar.getSkor());
        oyuncuPuan.setText("Oyuncu Puani:" + oyuncu.getSkor());
        if (oyuncu.bList.isEmpty() && oyuncu.fList.isEmpty()) {
            kazanantext.setVisible(true);
            if (oyuncu.getSkor() > bilgisayar.getSkor()) {
                kazanantext.setText("KAZANDINIZ!");
            } else if (oyuncu.getSkor() == bilgisayar.getSkor()) {
                kazanantext.setText("BERABERE");
            } else {
                kazanantext.setText("KAYBETTINIZ");
            }
        }
    }//GEN-LAST:event_oynaButonuActionPerformed

    private void oyKart1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oyKart1MouseClicked
        // TODO add your handling code here:
        tiklanan = 0;
        oyKart1.setVisible(false);
        oynanankartisimpc.setText("***");
        oynanankarttakimpc.setText("***");
        ucuncupuandegeripc.setText("***");
        dorduncupuandegeripc.setText("***");
        besincipuandegeripc.setText("***");
        ikinciucuncuyazi.setText("Pozisyon 1: ");
        ikincidorduncuyazi.setText("Pozisyon 2:");
        ikincibesinciyazi.setText("Pozisyon 3:");

        if (say % 2 == 0) {
            oynanankartisimoy.setText(oyuncu.fList.get(0).getSporcuIsim());
            oynanankarttakimoy.setText(oyuncu.fList.get(0).getSporcuTakim());
            ucuncupuandegerioy.setText("" + oyuncu.fList.get(0).getPenalti());
            dorduncupuandegerioy.setText("" + oyuncu.fList.get(0).getSerbestAtis());
            besincipuandegerioy.setText("" + oyuncu.fList.get(0).getKaleciKarsiKarsiya());
            ucuncuyazi.setText("Penalti:");
            dorduncuyazi.setText("Serbest Atis:");
            besinciyazi.setText("Kaleci ile karsi karsiya:");

        } else {
            oynanankartisimoy.setText(oyuncu.bList.get(0).getSporcuIsim());
            oynanankarttakimoy.setText(oyuncu.bList.get(0).getSporcuTakim());
            ucuncupuandegerioy.setText("" + oyuncu.bList.get(0).getIkilik());
            dorduncupuandegerioy.setText("" + oyuncu.bList.get(0).getUcluk());
            besincipuandegerioy.setText("" + oyuncu.bList.get(0).getSerbestAtis());
            ucuncuyazi.setText("Ikilik:");
            dorduncuyazi.setText("Ucluk:");
            besinciyazi.setText("Serbest Atis:");

        }
    }//GEN-LAST:event_oyKart1MouseClicked

    private void oyKart2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oyKart2MouseClicked
        // TODO add your handling code here:
        tiklanan = 1;
        oyKart2.setVisible(false);
        oynanankartisimpc.setText("***");
        oynanankarttakimpc.setText("***");
        ucuncupuandegeripc.setText("***");
        dorduncupuandegeripc.setText("***");
        besincipuandegeripc.setText("***");
        ikinciucuncuyazi.setText("Pozisyon 1: ");
        ikincidorduncuyazi.setText("Pozisyon 2:");
        ikincibesinciyazi.setText("Pozisyon 3:");
        if (say % 2 == 0) {
            oynanankartisimoy.setText(oyuncu.fList.get(1).getSporcuIsim());
            oynanankarttakimoy.setText(oyuncu.fList.get(1).getSporcuTakim());
            ucuncupuandegerioy.setText("" + oyuncu.fList.get(1).getPenalti());
            dorduncupuandegerioy.setText("" + oyuncu.fList.get(1).getSerbestAtis());
            besincipuandegerioy.setText("" + oyuncu.fList.get(1).getKaleciKarsiKarsiya());
            ucuncuyazi.setText("Penalti:");
            dorduncuyazi.setText("Serbest Atis:");
            besinciyazi.setText("Kaleci ile karsi karsiya:");

        } else {
            oynanankartisimoy.setText(oyuncu.bList.get(1).getSporcuIsim());
            oynanankarttakimoy.setText(oyuncu.bList.get(1).getSporcuTakim());
            ucuncupuandegerioy.setText("" + oyuncu.bList.get(1).getIkilik());
            dorduncupuandegerioy.setText("" + oyuncu.bList.get(1).getUcluk());
            besincipuandegerioy.setText("" + oyuncu.bList.get(1).getSerbestAtis());
            ucuncuyazi.setText("Ikilik:");
            dorduncuyazi.setText("Ucluk:");
            besinciyazi.setText("Serbest Atis:");
        }
    }//GEN-LAST:event_oyKart2MouseClicked

    private void oyKart3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oyKart3MouseClicked
        // TODO add your handling code here:
        tiklanan = 2;
        oyKart3.setVisible(false);
        oynanankartisimpc.setText("***");
        oynanankarttakimpc.setText("***");
        ucuncupuandegeripc.setText("***");
        dorduncupuandegeripc.setText("***");
        besincipuandegeripc.setText("***");
        ikinciucuncuyazi.setText("Pozisyon 1: ");
        ikincidorduncuyazi.setText("Pozisyon 2:");
        ikincibesinciyazi.setText("Pozisyon 3:");
        if (say % 2 == 0) {
            oynanankartisimoy.setText(oyuncu.fList.get(2).getSporcuIsim());
            oynanankarttakimoy.setText(oyuncu.fList.get(2).getSporcuTakim());
            ucuncupuandegerioy.setText("" + oyuncu.fList.get(2).getPenalti());
            dorduncupuandegerioy.setText("" + oyuncu.fList.get(2).getSerbestAtis());
            besincipuandegerioy.setText("" + oyuncu.fList.get(2).getKaleciKarsiKarsiya());
            ucuncuyazi.setText("Penalti:");
            dorduncuyazi.setText("Serbest Atis:");
            besinciyazi.setText("Kaleci ile karsi karsiya:");
        } else {
            oynanankartisimoy.setText(oyuncu.bList.get(2).getSporcuIsim());
            oynanankarttakimoy.setText(oyuncu.bList.get(2).getSporcuTakim());
            ucuncupuandegerioy.setText("" + oyuncu.bList.get(2).getIkilik());
            dorduncupuandegerioy.setText("" + oyuncu.bList.get(2).getUcluk());
            besincipuandegerioy.setText("" + oyuncu.bList.get(2).getSerbestAtis());
            ucuncuyazi.setText("Ikilik:");
            dorduncuyazi.setText("Ucluk:");
            besinciyazi.setText("Serbest Atis:");
        }
    }//GEN-LAST:event_oyKart3MouseClicked

    private void oyKart4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oyKart4MouseClicked
        // TODO add your handling code here:
        tiklanan = 3;
        oyKart4.setVisible(false);
        oynanankartisimpc.setText("***");
        oynanankarttakimpc.setText("***");
        ucuncupuandegeripc.setText("***");
        dorduncupuandegeripc.setText("***");
        besincipuandegeripc.setText("***");
        ikinciucuncuyazi.setText("Pozisyon 1: ");
        ikincidorduncuyazi.setText("Pozisyon 2:");
        ikincibesinciyazi.setText("Pozisyon 3:");
        if (say % 2 == 0) {
            oynanankartisimoy.setText(oyuncu.fList.get(3).getSporcuIsim());
            oynanankarttakimoy.setText(oyuncu.fList.get(3).getSporcuTakim());
            ucuncupuandegerioy.setText("" + oyuncu.fList.get(3).getPenalti());
            dorduncupuandegerioy.setText("" + oyuncu.fList.get(3).getSerbestAtis());
            besincipuandegerioy.setText("" + oyuncu.fList.get(3).getKaleciKarsiKarsiya());
            ucuncuyazi.setText("Penalti:");
            dorduncuyazi.setText("Serbest Atis:");
            besinciyazi.setText("Kaleci ile karsi karsiya:");
        } else {
            oynanankartisimoy.setText(oyuncu.bList.get(3).getSporcuIsim());
            oynanankarttakimoy.setText(oyuncu.bList.get(3).getSporcuTakim());
            ucuncupuandegerioy.setText("" + oyuncu.bList.get(3).getIkilik());
            dorduncupuandegerioy.setText("" + oyuncu.bList.get(3).getUcluk());
            besincipuandegerioy.setText("" + oyuncu.bList.get(3).getSerbestAtis());
            ucuncuyazi.setText("Ikilik:");
            dorduncuyazi.setText("Ucluk:");
            besinciyazi.setText("Serbest Atis:");
        }
    }//GEN-LAST:event_oyKart4MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel besincipuandegerioy;
    private static javax.swing.JLabel besincipuandegeripc;
    private javax.swing.JLabel besinciyazi;
    private javax.swing.JLabel dorduncupuandegerioy;
    private static javax.swing.JLabel dorduncupuandegeripc;
    private javax.swing.JLabel dorduncuyazi;
    private static javax.swing.JLabel ikincibesinciyazi;
    private static javax.swing.JLabel ikincidorduncuyazi;
    private static javax.swing.JLabel ikinciucuncuyazi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JButton kartDagitButonu;
    private static javax.swing.JLabel kazanantext;
    private static javax.swing.JTextArea oyKart1;
    private javax.swing.JTextArea oyKart2;
    private javax.swing.JTextArea oyKart3;
    private javax.swing.JTextArea oyKart4;
    private static javax.swing.JLabel oyPuanText;
    private static javax.swing.JButton oynaButonu;
    private javax.swing.JLabel oynanankartisimoy;
    private static javax.swing.JLabel oynanankartisimpc;
    private javax.swing.JLabel oynanankarttakimoy;
    private static javax.swing.JLabel oynanankarttakimpc;
    private static javax.swing.JLabel oyuncuPuan;
    private javax.swing.JTextArea pcKart1;
    private javax.swing.JTextArea pcKart2;
    private javax.swing.JTextArea pcKart3;
    private javax.swing.JTextArea pcKart4;
    private static javax.swing.JLabel pcPuan;
    private static javax.swing.JLabel pcPuanText;
    private static javax.swing.JLabel pozisyonText;
    private javax.swing.JLabel ucuncupuandegerioy;
    private static javax.swing.JLabel ucuncupuandegeripc;
    private javax.swing.JLabel ucuncuyazi;
    // End of variables declaration//GEN-END:variables
}
