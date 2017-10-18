package mainn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainn.images.Resources;
/**
 * Παρουσιαζονται ολες οι δυνατοτητες του διαχειριστη δηλαδη να προσθέτει, να τροποποιεί και να διαγράφει αίθουσες, θεατρικές παραστάσεις/ταινίες αλλα και του απλου χρηστη
 * δηλαδη να κάνει κρατήσεις συγκεκριμένων θέσεων για συγκεκριμένες προβολές θεατρικών παραστάσεων ή ταινιών
 * @author Μητσοπούλου Ειρήνη
 * @author Παπαδοπούλου Κωνσταντίνα
 * @version 8.0.1 Nov 22, 2014
 */
public class AdministratorSimpleUser extends javax.swing.JFrame  {
    private Cinema c;
    private Theatre t;
    private Movies m;
    private TheatricalShow s;
    private final User u;
    private JFrame frame;
    private JFrame frame1;
    private JFrame frame2;
    private JFrame frame3;
    private JButton addH;
    private JButton hall;
    private JButton show;
    private JButton change;
    private Icon icon;
    private JLabel label;
    private JPanel topPanel;
    private javax.swing.JSpinner balcony;
    private javax.swing.JButton button;
    private javax.swing.JButton button2;
    private javax.swing.JTextField capacity;
    private javax.swing.JTextField capacity2;
    private javax.swing.JSpinner dressingRoom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField name;
    private javax.swing.JTextField name2;
    private javax.swing.JTextField namee;
    private javax.swing.JTextField number;
    private javax.swing.JSpinner rowNumber;
    private javax.swing.JSpinner rowNumber2;
    private javax.swing.JTextField screenSize;
    private javax.swing.JComboBox screenType;
    private javax.swing.JComboBox seatType;
    private javax.swing.JComboBox seatType2;
    private javax.swing.JComboBox soundSystem;
    private javax.swing.JTextArea actorList;
    private javax.swing.JTextArea actorList2;
    private javax.swing.JTextArea description;
    private javax.swing.JTextArea descrition2;
    private javax.swing.JTextField director;
    private javax.swing.JTextField director2;
    private javax.swing.JSpinner duration;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JSpinner date;
    private final String[] date2;
    private int i;
    private int price;
    private final int[] bool = new int[200];
    
    //AdministratorSimpleUser Interface Window
    public AdministratorSimpleUser(){
        u = new User();
        i=0;
        date2 = new String[20];
        for(int j=0; j<20; j++){
            date2[j]= null;
        }
        for(int j=0; j<200; j++){
                   bool[j]=0;
        }
        JFrame framem = new JFrame("Διαχειριστής ή Απλος Χρηστης?");
        framem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framem.setResizable(false);
        framem.setSize(300, 300);
        
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        panel.setBackground(Color.WHITE);
        framem.add(panel, BorderLayout.CENTER);
        
        JButton a = new JButton("Διαχειριστης");
        a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                admin();
            }
        });
        panel.add(a);
        
        JButton j = new JButton("Απλος Χρηστης");
        j.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simpleuser();
            }
        });
        panel.add(j);
        framem.setLocationRelativeTo(null);
        framem.setVisible(true);
    }
    
    /**
     *Administrator Interface Window
     **/
    private void admin(){
        frame = new JFrame("Διαχειριστής");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(600, 400);
        
        topPanel = new JPanel();
        topPanel.setBackground(Color.BLACK);
        frame.add(topPanel, BorderLayout.PAGE_START);
        
        hall = new JButton("Αιθουσες");
        hall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ai8ouses();
                } catch (IOException ex) {
                    Logger.getLogger(AdministratorSimpleUser.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AdministratorSimpleUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        topPanel.add(hall);
        
        show = new JButton("Ταινιες");
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tainies();
                } catch (IOException ex) {
                    Logger.getLogger(AdministratorSimpleUser.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AdministratorSimpleUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        topPanel.add(show);
        
        label = new JLabel();
        label.setIcon(new ImageIcon(Resources.getURL("1.jpg")));
        frame.add(label, BorderLayout.CENTER);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    /**
     *Προσθέτει, τροποποιεί και διαγράφει αίθουσες
     **/
    private void ai8ouses() throws IOException, ClassNotFoundException{
        Object[] selectionValues2 = { "Θελω Να Προσθεσω Αιθουσα", "Θελω Να Αφαιρεσω Αιθουσα", "Θελω Να Αλλαξω Μια Αιθουσα" };
        Object selection2 = JOptionPane.showInputDialog(null, "Δωσε την επιλογη σου",
                                                        "Διαχειριση Αιθουσων", JOptionPane.QUESTION_MESSAGE, null, selectionValues2, null);
        
        if(selection2 == "Θελω Να Προσθεσω Αιθουσα"){
            Object[] item = { "Cinema", "Theatre"};
            Object choice = JOptionPane.showInputDialog(null, "Cinema ή Theatre;",
                                                        "Τυπος Aίθουσας", JOptionPane.QUESTION_MESSAGE, null, item, null);
            String item1 = choice.toString();
            if(item1.equals("Cinema")){
                frame1 = new JFrame();
                frame1.setSize(500,800);
                frame1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                
                jPanel1 = new javax.swing.JPanel();
                jLabel8 = new javax.swing.JLabel();
                jLabel9 = new javax.swing.JLabel();
                jLabel10 = new javax.swing.JLabel();
                jLabel11 = new javax.swing.JLabel();
                jLabel12 = new javax.swing.JLabel();
                jLabel13 = new javax.swing.JLabel();
                jLabel14 = new javax.swing.JLabel();
                name = new javax.swing.JTextField();
                capacity = new javax.swing.JTextField();
                seatType = new javax.swing.JComboBox();
                screenSize = new javax.swing.JTextField();
                rowNumber = new javax.swing.JSpinner();
                screenType = new javax.swing.JComboBox();
                soundSystem = new javax.swing.JComboBox();
                button = new javax.swing.JButton();
                
                jLabel8.setText("Ονομα αίθουσας");
                
                jLabel9.setText("Χωριτηκότητα");
                
                jLabel10.setText("Τύπος θέσεων");
                
                jLabel11.setText("Αριθμός σειρών");
                
                jLabel12.setText("Μέγεθος οθόνης");
                
                jLabel13.setText("Τύπος οθονης");
                
                jLabel14.setText("Σύστημα ήχου");
                
                seatType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Απλες", "Πολυτελειας" }));
                
                rowNumber.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
                
                screenType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Κανονικη", "3D" }));
                
                soundSystem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dolby Digital", "Dolby Digital Surround", "Dolby Digital Live", "Dolby Digital Plus", "Dolby TrueHD" }));
                
                button.setText("OK");
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String name1 = name.getText();
                        int capacity1 = Integer.parseInt(capacity.getText());
                        String seatType1 = (String) seatType.getSelectedItem();
                        Object sp= rowNumber.getValue();
                        int rowNumber1 =Integer.parseInt(sp.toString() );
                        int[] seats = new int[rowNumber1+1];
                        for(int i=1; i<=rowNumber1; i++ ){
                            boolean right=false;
                                   while(right==false){   
                                        try{
                                                int seatNumber = Integer.parseInt(JOptionPane.showInputDialog("Δωσε τον αριθμο των θέσεων της σειρας νούμερο " + i));
                                                seats[i]= seatNumber;
                                                right=true;
                                            }catch(NumberFormatException nfe1){

                                                System.out.println("Δώσε αριθμό κι όχι συμβολοσειρά!");
                                            }
                                   }
                        }
                        String screenSize1 = screenSize.getText();
                        int screenSize2 = Integer.parseInt(screenSize1);
                        String screenType1 = (String) screenType.getSelectedItem();
                        String soundSystem1 = (String) soundSystem.getSelectedItem();
                        c= new Cinema(name1,capacity1,seatType1,rowNumber1,seats,bool,screenSize2,screenType1,soundSystem1);
                        try {
                            u.addcHall(c);
                        } catch (IOException ex) {
                            Logger.getLogger(AdministratorSimpleUser.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        frame1.dispose();
                    }
                });
                
                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                                 jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                 .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                           .addGap(60, 60, 60)
                                                           .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                     .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                         .addComponent(jLabel8)
                                                                                         .addComponent(jLabel11)
                                                                                         .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                                   .addGap(1, 1, 1)
                                                                                                   .addComponent(jLabel10))
                                                                                         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                   .addComponent(jLabel13)
                                                                                                   .addComponent(jLabel14)))
                                                                               .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                     .addGroup(jPanel1Layout.createSequentialGroup()
                                                                               .addGap(1, 1, 1)
                                                                               .addComponent(jLabel12)))
                                                           .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                                                           .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                     .addComponent(name)
                                                                     .addComponent(capacity, javax.swing.GroupLayout.Alignment.LEADING)
                                                                     .addComponent(soundSystem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                     .addComponent(screenType, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                     .addComponent(screenSize)
                                                                     .addComponent(rowNumber)
                                                                     .addComponent(seatType, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                           .addGap(107, 107, 107))
                                                 .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                           .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                           .addComponent(button)
                                                           .addGap(34, 34, 34))
                                                 );
                jPanel1Layout.setVerticalGroup(
                                               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                               .addGroup(jPanel1Layout.createSequentialGroup()
                                                         .addContainerGap()
                                                         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                   .addComponent(jLabel8)
                                                                   .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                         .addGap(22, 22, 22)
                                                         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                   .addComponent(capacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                   .addComponent(jLabel9))
                                                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                   .addComponent(seatType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                   .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                         .addGap(18, 18, 18)
                                                         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                   .addComponent(rowNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                   .addComponent(jLabel11))
                                                         .addGap(16, 16, 16)
                                                         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                   .addComponent(screenSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                   .addComponent(jLabel12))
                                                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                   .addComponent(screenType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                   .addComponent(jLabel13))
                                                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                   .addComponent(soundSystem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                   .addComponent(jLabel14))
                                                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                                         .addComponent(button)
                                                         .addGap(30, 30, 30))
                                               );
                frame1.add(jPanel1);
                frame1.pack();
                frame1.setVisible(true);
            }
            else{
                frame2 = new JFrame();
                frame2.setSize(500,800);
                frame2.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                
                jPanel2 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                name2 = new javax.swing.JTextField();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                jLabel6 = new javax.swing.JLabel();
                capacity2 = new javax.swing.JTextField();
                button2 = new javax.swing.JButton();
                seatType2 = new javax.swing.JComboBox();
                rowNumber2 = new javax.swing.JSpinner();
                balcony = new javax.swing.JSpinner();
                dressingRoom = new javax.swing.JSpinner();
                
                jLabel1.setText("Ονομα αίθουσας");
                
                jLabel2.setText("Χωριτηκότητα");
                
                jLabel3.setText("Τύπος θέσεων");
                
                jLabel4.setText("Αριθμός σειρών");
                
                jLabel5.setText("Αριθμός καμαρινίων");
                
                jLabel6.setText("Αριθμός εξώστεων");
                
                button2.setText("OK");
                button2.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        String name1 = name2.getText();
                        int capacity1 = Integer.parseInt(capacity2.getText());
                        String seatType1 = (String) seatType2.getSelectedItem();
                        Object sp= rowNumber2.getValue();
                        int rowNumber1 =Integer.parseInt(sp.toString() );
                        int[] seats = new int[rowNumber1+1];
                        for(int i=1; i<=rowNumber1; i++ ){
                           boolean right=false;
                                   while(right==false){   
                                            try{
                                                int seatNumber = Integer.parseInt(JOptionPane.showInputDialog("Δωσε τον αριθμο των θέσεων της σειρας νούμερο " + i));
                                                seats[i]= seatNumber;
                                                right=true;
                                            }catch(NumberFormatException nfe2){

                                                System.out.println("Δώσε αριθμό κι όχι συμβολοσειρά!");
                                            }
                                   }
                        }
                        Object sps= balcony.getValue();
                        int balcony1 =Integer.parseInt(sps.toString() );
                        Object spss = dressingRoom.getValue();
                        int dressingRoom1 = Integer.parseInt(spss.toString() );
                        t= new Theatre(name1,capacity1,seatType1,rowNumber1,seats,bool,balcony1,dressingRoom1);
                        try {
                            u.addtHall(t);
                        } catch (IOException ex) {
                            Logger.getLogger(AdministratorSimpleUser.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        frame2.dispose();
                    }
                });
                
                seatType2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Απλες", "Πολυτελειας" }));
                
                rowNumber2.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
                
                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                                 jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                 .addGroup(jPanel2Layout.createSequentialGroup()
                                                           .addGap(67, 67, 67)
                                                           .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                     .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                               .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                                                               .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                                                               .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                                                         .addComponent(jLabel4)
                                                                                         .addGap(18, 18, 18))
                                                                               .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                                                               .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                         .addComponent(jLabel1)
                                                                                         .addGap(180, 180, 180)))
                                                                     .addComponent(jLabel3))
                                                           .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
                                                           .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                     .addComponent(balcony)
                                                                     .addComponent(capacity2)
                                                                     .addComponent(rowNumber2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                                                     .addComponent(seatType2, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                                                                     .addComponent(name2)
                                                                     .addComponent(dressingRoom))
                                                           .addGap(136, 136, 136))
                                                 .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                           .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                           .addComponent(button2)
                                                           .addGap(37, 37, 37))
                                                 );
                jPanel2Layout.setVerticalGroup(
                                               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                               .addGroup(jPanel2Layout.createSequentialGroup()
                                                         .addContainerGap()
                                                         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                   .addComponent(jLabel1)
                                                                   .addComponent(name2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                         .addGap(18, 18, 18)
                                                         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                   .addComponent(jLabel2)
                                                                   .addComponent(capacity2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                         .addGap(18, 18, 18)
                                                         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                   .addComponent(jLabel3)
                                                                   .addComponent(seatType2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                         .addGap(23, 23, 23)
                                                         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                   .addComponent(jLabel4)
                                                                   .addComponent(rowNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                         .addGap(28, 28, 28)
                                                         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                   .addComponent(jLabel6)
                                                                   .addComponent(balcony, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                         .addGap(18, 18, 18)
                                                         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                   .addComponent(jLabel5)
                                                                   .addComponent(dressingRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                                         .addComponent(button2)
                                                         .addGap(33, 33, 33))
                                               );
                
                frame2.add(jPanel2);
                frame2.pack();
                frame2.setVisible(true);
            }
        }
        else if(selection2 == "Θελω Να Αφαιρεσω Αιθουσα"){
           Object[] it = { "Cinema", "Theatre"};
            Object ch = JOptionPane.showInputDialog(null, "Cinema ή Theatre;",
                "Τυπος Aίθουσας", JOptionPane.QUESTION_MESSAGE, null, it, null);
            String item1 = ch.toString();
                 u.chooseRoom("Afairw",item1);
        }
        else{
            Object[] it = { "Cinema", "Theatre"};
            Object ch = JOptionPane.showInputDialog(null, "Cinema ή Theatre;",
                "Τυπος Aίθουσας", JOptionPane.QUESTION_MESSAGE, null, it, null);
            String item1 = ch.toString();
                 u.chooseRoom("Tropopoiw",item1);
        }
        }
    
    /**
     *Προσθέτει, τροποποιεί και διαγράφει show
     **/
    private void tainies() throws IOException, ClassNotFoundException{
        Object[] selectionValues2 = { "Θελω Να Προσθεσω Show", "Θελω Να Αφαιρεσω Show", "Θελω Να Αλλαξω Ενα Show"};
        Object selection2 = JOptionPane.showInputDialog(null, "Δωσε την επιλογη σου",
                                                        "Διαχειριση Ταινιων", JOptionPane.QUESTION_MESSAGE, null, selectionValues2, null);
        if(selection2 == "Θελω Να Προσθεσω Show"){
            Object[] item = { "Tαινία", "Θεατρική Παρασταση"};
            Object choice = JOptionPane.showInputDialog(null, "Tαινία ή Θεατρική Παρασταση;",
                                                        "Eίδος Show", JOptionPane.QUESTION_MESSAGE, null, item, null);
            String item1 = choice.toString();
            if(item1.equals("Tαινία")){
                
                frame1 = new JFrame();
                frame1.setSize(500,800);
                frame1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                
                jScrollPane1 = new javax.swing.JScrollPane();
                jTextArea1 = new javax.swing.JTextArea();
                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                name = new javax.swing.JTextField();
                director = new javax.swing.JTextField();
                button = new javax.swing.JButton();
                duration = new javax.swing.JSpinner();
                jLabel6 = new javax.swing.JLabel();
                jScrollPane4 = new javax.swing.JScrollPane();
                description = new javax.swing.JTextArea();
                jScrollPane5 = new javax.swing.JScrollPane();
                actorList = new javax.swing.JTextArea();
                
                jTextArea1.setColumns(20);
                jTextArea1.setRows(5);
                jScrollPane1.setViewportView(jTextArea1);
                
                jLabel1.setText("Ονομα Ταινίας");
                
                jLabel2.setText("Περιγραφή");
                
                jLabel3.setText("Σκηνοθέτης");
                
                jLabel4.setText("Λίστα ηθοποιών");
                
                jLabel5.setText("Διάρκεια Ταινίας");
                
                button.setText("Eπέλεξε Αιθουσα");
                button.setToolTipText("");
                button.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        frame2 = new JFrame();
                        frame2.setSize(500,800);
                        frame2.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                        jPanel2 = new javax.swing.JPanel();
                        jLabel1 = new javax.swing.JLabel();
                        jButton1 = new javax.swing.JButton();
                        jButton2 = new javax.swing.JButton();
                        jButton3 = new javax.swing.JButton();
                        button = new javax.swing.JButton();
                        jLabel2 = new javax.swing.JLabel();
                        
                        jLabel1.setText("Eπέλεξε πρώτα την αίθουσα που θέλεις να παιχτεί,");
                        jLabel2.setText("έπειτα ημερομηνίες και ώρες και τέλος την τίμη του Show");
                        
                        jButton1.setText("Αιθουσα");
                        jButton1.addActionListener(new java.awt.event.ActionListener() {
                            @Override
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                try {
                                    u.chooseRoom("tainies","Cinema");
                                } catch (IOException ex) {
                                    Logger.getLogger(AdministratorSimpleUser.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (ClassNotFoundException ex) {
                                    Logger.getLogger(AdministratorSimpleUser.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        });
                        
                        jButton2.setText("Ημερομηνίες και Ωρες");
                        jButton2.addActionListener(new java.awt.event.ActionListener() {
                            @Override
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                frame1 = new JFrame();
                                frame1.setSize(500,800);
                                frame1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                                
                                jPanel1 = new javax.swing.JPanel();
                                date = new javax.swing.JSpinner();
                                button = new javax.swing.JButton();
                                jLabel1 = new javax.swing.JLabel();
                                
                                date.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1419162233103L), null, null, java.util.Calendar.DAY_OF_WEEK_IN_MONTH));
                                
                                button.setText("ΟΚ");
                                button.addActionListener(new java.awt.event.ActionListener() {
                                    @Override
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        Object sp= date.getValue();
                                        String date1 = sp.toString();
                                        date2[i]= date1;
                                        i=i+1;
                                        frame1.dispose();
                                        
                                    }
                                });
                                
                                jLabel1.setText("Βάλε ημερομηνία και ώρα που θέλεις να παιχνεί");
                                
                                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                                jPanel1.setLayout(jPanel1Layout);
                                jPanel1Layout.setHorizontalGroup(
                                                                 jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                 .addGroup(jPanel1Layout.createSequentialGroup()
                                                                           .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                     .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                               .addGap(145, 145, 145)
                                                                                               .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                     .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                               .addGap(175, 175, 175)
                                                                                               .addComponent(button))
                                                                                     .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                               .addGap(68, 68, 68)
                                                                                               .addComponent(jLabel1)))
                                                                           .addContainerGap(32, Short.MAX_VALUE))
                                                                 );
                                jPanel1Layout.setVerticalGroup(
                                                               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                               .addGroup(jPanel1Layout.createSequentialGroup()
                                                                         .addGap(24, 24, 24)
                                                                         .addComponent(jLabel1)
                                                                         .addGap(27, 27, 27)
                                                                         .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                                                         .addComponent(button)
                                                                         .addGap(20, 20, 20))
                                                               );
                                
                                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                                getContentPane().setLayout(layout);
                                layout.setHorizontalGroup(
                                                          layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                          .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                          );
                                layout.setVerticalGroup(
                                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        );
                                frame1.add(jPanel1);
                                frame1.pack();
                                frame1.setVisible(true);
                                
                            }
                        });
                        
                        jButton3.setText("Τιμή $");
                        jButton3.addActionListener(new java.awt.event.ActionListener() {
                            @Override
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                               boolean right2=false;
                                            while(right2==false){
                                            try{
                                                price = Integer.parseInt(JOptionPane.showInputDialog("Δώσε την τιμή $ του Show"));
                                                right2=true;
                                            }catch(NumberFormatException nfe2){

                                                System.out.println("Δώσε αριθμό κι όχι συμβολοσειρά!");
                                            }
                                            }
                            }
                        });
                        
                        button.setText("ΟΚ");
                        button.addActionListener(new java.awt.event.ActionListener() {
                            @Override
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                String name1 = name.getText();
                                String description1 = description.getText();
                                String director1 = director.getText();
                                String actorList1 = actorList.getText();
                                Object sp= duration.getValue();
                                int duration1 =Integer.parseInt(sp.toString() );
                                m = new Movies(duration1,name1,description1,director1,actorList1,date2,price);
                                try {
                                    u.addmShow(m);
                                } catch (IOException ex) {
                                    Logger.getLogger(AdministratorSimpleUser.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                i=0;
                                for(int j=0; j<20; j++){
                                    date2[j]= null;
                                }
                                frame2.dispose();
                            }
                        });
                        
                        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel2);
                        jPanel2.setLayout(jPanel1Layout);
                        jPanel1Layout.setHorizontalGroup(
                                                         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                         .addGroup(jPanel1Layout.createSequentialGroup()
                                                                   .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                             .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                       .addGap(30, 30, 30)
                                                                                       .addComponent(jButton1)
                                                                                       .addGap(26, 26, 26)
                                                                                       .addComponent(jButton2)
                                                                                       .addGap(31, 31, 31)
                                                                                       .addComponent(jButton3))
                                                                             .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                       .addGap(47, 47, 47)
                                                                                       .addComponent(jLabel2))
                                                                             .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                       .addGap(67, 67, 67)
                                                                                       .addComponent(jLabel1)))
                                                                   .addContainerGap(20, Short.MAX_VALUE))
                                                         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                   .addGap(0, 0, Short.MAX_VALUE)
                                                                   .addComponent(button)
                                                                   .addGap(194, 194, 194))
                                                         );
                        jPanel1Layout.setVerticalGroup(
                                                       jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                       .addGroup(jPanel1Layout.createSequentialGroup()
                                                                 .addGap(20, 20, 20)
                                                                 .addComponent(jLabel1)
                                                                 .addGap(18, 18, 18)
                                                                 .addComponent(jLabel2)
                                                                 .addGap(42, 42, 42)
                                                                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                           .addComponent(jButton1)
                                                                           .addComponent(jButton2)
                                                                           .addComponent(jButton3))
                                                                 .addGap(58, 58, 58)
                                                                 .addComponent(button)
                                                                 .addContainerGap(15, Short.MAX_VALUE))
                                                       );
                        
                        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                        getContentPane().setLayout(layout);
                        layout.setHorizontalGroup(
                                                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                  .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                  );
                        layout.setVerticalGroup(
                                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                );
                        frame2.add(jPanel2);
                        frame2.pack();
                        frame2.setVisible(true);
                    }
                });
                
                duration.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(60), Integer.valueOf(60), null, Integer.valueOf(1)));
                
                jLabel6.setText("minutes");
                jLabel6.setToolTipText("");
                
                description.setColumns(20);
                description.setRows(5);
                jScrollPane4.setViewportView(description);
                
                actorList.setColumns(20);
                actorList.setRows(5);
                jScrollPane5.setViewportView(actorList);
                
                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                                 jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                 .addGroup(jPanel1Layout.createSequentialGroup()
                                                           .addGap(52, 52, 52)
                                                           .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                     .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                     .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                               .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                                                               .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                     .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                     .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                           .addGap(179, 179, 179)
                                                           .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                               .addComponent(duration, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                               .addGap(18, 18, 18)
                                                                               .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                     .addComponent(director)
                                                                     .addComponent(name)
                                                                     .addComponent(jScrollPane4)
                                                                     .addComponent(jScrollPane5))
                                                           .addContainerGap(10, Short.MAX_VALUE))
                                                 .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                           .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                           .addComponent(button)
                                                           .addContainerGap())
                                                 );
                jPanel1Layout.setVerticalGroup(
                                               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                               .addGroup(jPanel1Layout.createSequentialGroup()
                                                         .addGap(9, 9, 9)
                                                         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                   .addComponent(jLabel1)
                                                                   .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                         .addGap(23, 23, 23)
                                                         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                   .addComponent(jLabel2)
                                                                   .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                         .addGap(27, 27, 27)
                                                         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                   .addComponent(jLabel3)
                                                                   .addComponent(director, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                   .addComponent(jLabel4)
                                                                   .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                   .addComponent(jLabel5)
                                                                   .addComponent(duration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                   .addComponent(jLabel6))
                                                         .addGap(10, 10, 10)
                                                         .addComponent(button))
                                               );
                frame1.add(jPanel1);
                frame1.pack();
                frame1.setVisible(true);
            }
            else{
                frame2 = new JFrame();
                frame2.setSize(500,800);
                frame2.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                
                jScrollPane1 = new javax.swing.JScrollPane();
                jTextArea1 = new javax.swing.JTextArea();
                jPanel2 = new javax.swing.JPanel();
                jLabel7 = new javax.swing.JLabel();
                jLabel8 = new javax.swing.JLabel();
                jLabel9 = new javax.swing.JLabel();
                jLabel10 = new javax.swing.JLabel();
                name2 = new javax.swing.JTextField();
                director2 = new javax.swing.JTextField();
                button2 = new javax.swing.JButton();
                jScrollPane2 = new javax.swing.JScrollPane();
                descrition2 = new javax.swing.JTextArea();
                jScrollPane3 = new javax.swing.JScrollPane();
                actorList2 = new javax.swing.JTextArea();
                
                jTextArea1.setColumns(20);
                jTextArea1.setRows(5);
                jScrollPane1.setViewportView(jTextArea1);
                
                jLabel7.setText("Ονομα Θεατρικής Παράστασης");
                
                jLabel8.setText("Περιγραφή");
                
                jLabel9.setText("Σκηνοθέτης");
                
                jLabel10.setText("Λίστα ηθοποιών");
                
                button2.setText("Eπέλεξε Αιθουσα");
                button2.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        frame1 = new JFrame();
                        frame1.setSize(500,800);
                        frame1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                        jPanel1 = new javax.swing.JPanel();
                        jLabel1 = new javax.swing.JLabel();
                        jButton1 = new javax.swing.JButton();
                        jButton2 = new javax.swing.JButton();
                        jButton3 = new javax.swing.JButton();
                        button = new javax.swing.JButton();
                        jLabel2 = new javax.swing.JLabel();
                        
                        jLabel1.setText("Eπέλεξε πρώτα την αίθουσα που θέλεις να παιχτεί,");
                        jLabel2.setText("έπειτα ημερομηνίες και ώρες και τέλος την τίμη του Show");
                        
                        jButton1.setText("Αιθουσα");
                        jButton1.addActionListener(new java.awt.event.ActionListener() {
                            @Override
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                try {
                                    u.chooseRoom("tainies","Cinema");
                                } catch (IOException ex) {
                                    Logger.getLogger(AdministratorSimpleUser.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (ClassNotFoundException ex) {
                                    Logger.getLogger(AdministratorSimpleUser.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        });
                        
                        jButton2.setText("Ημερομηνίες και Ωρες");
                        jButton2.addActionListener(new java.awt.event.ActionListener() {
                            @Override
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                frame2 = new JFrame();
                                frame2.setSize(500,800);
                                frame2.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                                
                                jPanel1 = new javax.swing.JPanel();
                                date = new javax.swing.JSpinner();
                                button = new javax.swing.JButton();
                                jLabel1 = new javax.swing.JLabel();
                                
                                date.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1419162233103L), null, null, java.util.Calendar.DAY_OF_WEEK_IN_MONTH));
                                
                                button.setText("ΟΚ");
                                button.addActionListener(new java.awt.event.ActionListener() {
                                    @Override
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        Object sp= date.getValue();
                                        String date1 = sp.toString();
                                        date2[i]= date1;
                                        i=i+1;
                                        frame2.dispose();
                                        
                                    }
                                });
                                
                                jLabel1.setText("Βάλε ημερομηνία και ώρα που θέλεις να παιχτεί");
                                
                                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                                jPanel1.setLayout(jPanel1Layout);
                                jPanel1Layout.setHorizontalGroup(
                                                                 jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                 .addGroup(jPanel1Layout.createSequentialGroup()
                                                                           .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                     .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                               .addGap(145, 145, 145)
                                                                                               .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                     .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                               .addGap(175, 175, 175)
                                                                                               .addComponent(button))
                                                                                     .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                               .addGap(68, 68, 68)
                                                                                               .addComponent(jLabel1)))
                                                                           .addContainerGap(32, Short.MAX_VALUE))
                                                                 );
                                jPanel1Layout.setVerticalGroup(
                                                               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                               .addGroup(jPanel1Layout.createSequentialGroup()
                                                                         .addGap(24, 24, 24)
                                                                         .addComponent(jLabel1)
                                                                         .addGap(27, 27, 27)
                                                                         .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                                                         .addComponent(button)
                                                                         .addGap(20, 20, 20))
                                                               );
                                
                                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                                getContentPane().setLayout(layout);
                                layout.setHorizontalGroup(
                                                          layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                          .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                          );
                                layout.setVerticalGroup(
                                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        );
                                frame2.add(jPanel1);
                                frame2.pack();
                                frame2.setVisible(true);
                                
                            }
                        });
                        
                        jButton3.setText("Τιμή $");
                        jButton3.addActionListener(new java.awt.event.ActionListener() {
                            @Override
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                boolean right2=false;
                                            while(right2==false){
                                            try{
                                                price = Integer.parseInt(JOptionPane.showInputDialog("Δώσε την τιμή $ του Show"));
                                                right2=true;
                                            }catch(NumberFormatException nfe2){

                                                System.out.println("Δώσε αριθμό κι όχι συμβολοσειρά!");
                                            }
                                            }
                            }
                        });
                        
                        button.setText("ΟΚ");
                        button.addActionListener(new java.awt.event.ActionListener() {
                            @Override
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                String name1 = name2.getText();
                                String description1 = descrition2.getText();
                                String director1 = director2.getText();
                                String actorList1 = actorList2.getText();
                                s = new TheatricalShow(name1,description1,director1,actorList1,date2,price);
                                try {
                                    u.addtShow(s);
                                } catch (IOException ex) {
                                    Logger.getLogger(AdministratorSimpleUser.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                i=0;
                                for(int j=0; j<20; j++){
                                    date2[j]= null;
                                }
                                frame1.dispose();
                            }
                        });
                        
                        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                        jPanel1.setLayout(jPanel1Layout);
                        jPanel1Layout.setHorizontalGroup(
                                                         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                         .addGroup(jPanel1Layout.createSequentialGroup()
                                                                   .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                             .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                       .addGap(30, 30, 30)
                                                                                       .addComponent(jButton1)
                                                                                       .addGap(26, 26, 26)
                                                                                       .addComponent(jButton2)
                                                                                       .addGap(31, 31, 31)
                                                                                       .addComponent(jButton3))
                                                                             .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                       .addGap(47, 47, 47)
                                                                                       .addComponent(jLabel2))
                                                                             .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                       .addGap(67, 67, 67)
                                                                                       .addComponent(jLabel1)))
                                                                   .addContainerGap(20, Short.MAX_VALUE))
                                                         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                   .addGap(0, 0, Short.MAX_VALUE)
                                                                   .addComponent(button)
                                                                   .addGap(194, 194, 194))
                                                         );
                        jPanel1Layout.setVerticalGroup(
                                                       jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                       .addGroup(jPanel1Layout.createSequentialGroup()
                                                                 .addGap(20, 20, 20)
                                                                 .addComponent(jLabel1)
                                                                 .addGap(18, 18, 18)
                                                                 .addComponent(jLabel2)
                                                                 .addGap(42, 42, 42)
                                                                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                           .addComponent(jButton1)
                                                                           .addComponent(jButton2)
                                                                           .addComponent(jButton3))
                                                                 .addGap(58, 58, 58)
                                                                 .addComponent(button)
                                                                 .addContainerGap(15, Short.MAX_VALUE))
                                                       );
                        
                        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                        getContentPane().setLayout(layout);
                        layout.setHorizontalGroup(
                                                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                  .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                  );
                        layout.setVerticalGroup(
                                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                );
                        frame1.add(jPanel1);
                        frame1.pack();
                        frame1.setVisible(true);
                    }
                });
                
                descrition2.setColumns(20);
                descrition2.setRows(5);
                jScrollPane2.setViewportView(descrition2);
                
                actorList2.setColumns(20);
                actorList2.setRows(5);
                jScrollPane3.setViewportView(actorList2);
                
                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                                 jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                 .addGroup(jPanel2Layout.createSequentialGroup()
                                                           .addGap(31, 31, 31)
                                                           .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                     .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                     .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                     .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                     .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                           .addGap(112, 112, 112)
                                                           .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                     .addComponent(director2)
                                                                     .addComponent(jScrollPane2)
                                                                     .addComponent(jScrollPane3)
                                                                     .addComponent(name2))
                                                           .addContainerGap(18, Short.MAX_VALUE))
                                                 .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                           .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                           .addComponent(button2)
                                                           .addContainerGap())
                                                 );
                jPanel2Layout.setVerticalGroup(
                                               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                               .addGroup(jPanel2Layout.createSequentialGroup()
                                                         .addGap(20, 20, 20)
                                                         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                   .addComponent(jLabel7)
                                                                   .addComponent(name2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                   .addGroup(jPanel2Layout.createSequentialGroup()
                                                                             .addGap(22, 22, 22)
                                                                             .addComponent(jLabel8))
                                                                   .addGroup(jPanel2Layout.createSequentialGroup()
                                                                             .addGap(18, 18, 18)
                                                                             .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                         .addGap(33, 33, 33)
                                                         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                   .addComponent(director2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                   .addComponent(jLabel9))
                                                         .addGap(22, 22, 22)
                                                         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                   .addComponent(jLabel10)
                                                                   .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                         .addGap(22, 22, 22)
                                                         .addComponent(button2)
                                                         .addContainerGap(12, Short.MAX_VALUE))
                                               );
                frame2.add(jPanel2);
                frame2.pack();
                frame2.setVisible(true);
            }
        }
        else if(selection2 == "Θελω Να Αφαιρεσω Show"){
            u.chooseShow("Afairw");
        }
        else if(selection2 == "Θελω Να Αλλαξω Ενα Show"){
            u.chooseShow("Tropopoiw");
        }
    }
    /**
     *SimpleUser Interface Window
     **/
    public void simpleuser(){
        frame = new JFrame("Welcome! - Eπέλεξε τι απο τα παρακάτω επιθυμείς να κάνεις");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(600, 400);
        
        topPanel = new JPanel();
        topPanel.setBackground(Color.DARK_GRAY);
        frame.add(topPanel, BorderLayout.PAGE_START);
        
        hall = new JButton("KΡΑΤΗΣΗ");
        hall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                krathsh("krathsh");
            }
        });
        topPanel.add(hall);
        
        show = new JButton("ΑΚΥΡΩΣΗ ΚΡΑΤΗΣΗΣ");
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                krathsh("akurwsh");
            }
        });
        topPanel.add(show);
        
        change = new JButton("ΑΛΛΑΓΗ ΚΡΑΤΗΣΗΣ");
        change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        topPanel.add(change);
        
        label = new JLabel();
        label.setIcon(new ImageIcon(Resources.getURL("2.png")));
        frame.add(label, BorderLayout.CENTER);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    /**
     *Kάνει κρατήσεις συγκεκριμένων θέσεων για συγκεκριμένες προβολές θεατρικών παραστάσεων ή ταινιών
     * @param choice
     **/
    public void krathsh(String choice){
        frame1 = new JFrame();
        frame1.setSize(500,800);
        frame1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        namee = new javax.swing.JTextField();
        number = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        button = new javax.swing.JButton();
        
        
        jLabel1.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel1.setText("Στοιχεία Πελάτη");
        
        jLabel2.setText("Ονοματεπώνυμο");
        
        jLabel3.setText("Τηλέφωνο");
        
        button.setText("ΟΚ");
        if(choice.equals("krathsh")){
            button.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    frame1.dispose();
                    String name1 = namee.getText();
                    String number1 = number.getText();
                    u.check(name1,number1);
                }
            });}
        else if(choice.equals("akurwsh")){
            button.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    frame1.dispose();
                    String name1 = namee.getText();
                    String number1 = number.getText();
                    u.cancelCheck(name1,number1);
                }
            });}
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                                         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                         .addGroup(jPanel1Layout.createSequentialGroup()
                                                   .addGap(32, 32, 32)
                                                   .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                             .addComponent(jLabel1)
                                                             .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                                             .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                   .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                             .addComponent(namee, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                                             .addComponent(number))
                                                   .addContainerGap(32, Short.MAX_VALUE))
                                         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                   .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                   .addComponent(button)
                                                   .addGap(93, 93, 93))
                                         );
        jPanel1Layout.setVerticalGroup(
                                       jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                       .addGroup(jPanel1Layout.createSequentialGroup()
                                                 .addGap(14, 14, 14)
                                                 .addComponent(jLabel1)
                                                 .addGap(24, 24, 24)
                                                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                           .addComponent(namee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                           .addComponent(jLabel2))
                                                 .addGap(21, 21, 21)
                                                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                           .addComponent(number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                           .addComponent(jLabel3))
                                                 .addGap(39, 39, 39)
                                                 .addComponent(button)
                                                 .addContainerGap(35, Short.MAX_VALUE))
                                       );
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                  .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                  );
        layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                );
        frame1.add(jPanel1);
        frame1.pack();
        frame1.setVisible(true);
    }
}
