package mainn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainn.images.Resources;
/**
 * Αποθηκευονται ολες οι αλλαγες, προσθεσεις, τροποποιησεις που μπορει να κανει ο διαχειριστης ή ο απλος χρηστης
 * @author Μητσοπούλου Ειρήνη
 * @author Παπαδοπούλου Κωνσταντίνα
 * @version 8.0.1 Nov 22, 2014
 */
public class User extends javax.swing.JFrame{
    private JFrame f;
    private int i;
    private int rownumber;
    private int price;
    ArrayList<Cinema> cinema;
    ArrayList<Theatre> theatre;
    ArrayList<Movies> movie;
    ArrayList<TheatricalShow> theatricalShow;
    ArrayList<String> ai8ouses;
    HashMap<String,HashSet<String>> hash;
    HashMap<String,ArrayList<String>> book;
    private JFrame frame1;
    private JFrame frame2;
    private JFrame frame3;
    private JFrame frame4;
    private JFrame frame5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton button;
    private final JToggleButton b[] = new JToggleButton[200];
    private javax.swing.JComboBox items;
    private javax.swing.JComboBox itemss;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton button1;
    private javax.swing.JButton button2;
    private javax.swing.JComboBox choice;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner date;
    private String item;
    File file;
    private Catalog catalog;
    private String hall;
    private ShowList showList;
    private String sh;
    
    public User(){
        file = new File("checks.txt");
        i=0;
        ai8ouses = new ArrayList<>();
        cinema = new ArrayList<>();
        theatre = new ArrayList<>();
        movie = new ArrayList<>();
        theatricalShow = new ArrayList<>();
        book = new HashMap<>();
        hash = new HashMap<>();
        catalog = new Catalog();
        showList = new ShowList();
    }
    
    /**
     *Ο διαχειριστης μπορει να προσθεσει μια αιθουσα cinema
     * @param c
     * @throws java.io.IOException
     **/
    public void addcHall(Cinema c) throws IOException{
        try(ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("cinema.dat"))){
          catalog.addCinHall(c);
          oos1.writeObject(catalog);
      }
      
      cinema.add(c);
      f = new JFrame();
      JOptionPane.showMessageDialog(f, "H αιθουσα προστέθηκε με επιτυχία");
    }
    /**
     *Ο διαχειριστης μπορει να προσθεσει μια αιθουσα theatre
     * @param t
     * @throws java.io.IOException
     **/
    public void addtHall(Theatre t) throws IOException{
        try(ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("theatre.dat"))){
          catalog.addThHall(t);
          oos1.writeObject(catalog);
      }
        theatre.add(t);
        f = new JFrame();
        JOptionPane.showMessageDialog(f, "H αιθουσα προστέθηκε με επιτυχία");
    }
    
    
    /**
     *Ο διαχειριστης μπορει να αφαιρεσει μια αιθουσα
     * @param hall
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     **/
    public void removeHall(String hall) throws IOException, ClassNotFoundException{
        
        if(hall.equals("Cinema")){
                    String name = (String) items.getSelectedItem();
                    f = new JFrame();
                
                    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("cinema.dat"))) {
                        Catalog cat;
                        cat = (Catalog) in.readObject();
                        ArrayList<Cinema> arrayc = cat.getCinemaHalls();
                        Iterator<Cinema> its = arrayc.iterator();
                        int j = 0;
                        while (its.hasNext()) {
                            Cinema c = its.next();
                            if (c.gethallName().equals(name)) {
                                catalog.removeCinHall(j);
                                items.removeItem(c.gethallName());
                                its.remove();
                                cinema.remove(j);
                                f = new JFrame();
                                JOptionPane.showMessageDialog(f, "Η αιθουσα αφαιρέθηκε με επιτυχία");
                                f.dispose();
                                break;
                                
                            }
                            i++;
                        }
                    }
                    try(ObjectOutputStream oos3 = new ObjectOutputStream(new FileOutputStream("cinema.dat"))){
                        oos3.writeObject(catalog);
                    }
                    
                    
                }
                else if(hall.equals("Theatre")){
                    String name = (String) items.getSelectedItem();
                    f = new JFrame();
                
                    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("theatre.dat"))) {
                        Catalog cat;
                        cat = (Catalog) in.readObject();
                        ArrayList<Theatre> arrayt = cat.getThHalls();
                        Iterator<Theatre> its = arrayt.iterator();
                        int k = 0;
                        while (its.hasNext()) {
                            Theatre t = its.next();
                            if (t.gethallName().equals(name)) {
                                catalog.removeThHall(k);
                                items.removeItem(t.gethallName());
                                its.remove();
                                theatre.remove(k);
                                f = new JFrame();
                                JOptionPane.showMessageDialog(f, "Η αιθουσα αφαιρέθηκε με επιτυχία");
                                f.dispose();
                                break;
                               
                            }
                            k++;
                        }
                    }
                    
                    try(ObjectOutputStream oos3 = new ObjectOutputStream(new FileOutputStream("theatre.dat"))){
                        oos3.writeObject(catalog);
                    }
                    
                    
                }
    }
    
    /**
     *Ο διαχειριστης μπορει να τροποποιήσει μια αιθουσα
     * @param hall
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     **/
    public void changeHall(String hall) throws IOException, ClassNotFoundException{
        if(hall.equals("Cinema")){
                    String name = (String) items.getSelectedItem();
                    f = new JFrame();
                    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("cinema.dat"))) {
                        Catalog cat;
                        cat = (Catalog) in.readObject();
                        ArrayList<Cinema> arrayc = cat.getCinemaHalls();
                        Iterator<Cinema> its = arrayc.iterator();
                        i=0;      
                        while (its.hasNext()) {
                            Cinema c = its.next();
                            if (c.gethallName().equals(name)) {
                                JOptionPane.showMessageDialog(f,"Ονομα:  " + c.gethallName() + "\n" + "Xωρητικοτητα:  " +c.getcapacity() + "\n" + "Eιδος θέσεων:  " + c.getseatType()+ "\n" + "Μεγεθος οθόνης:  " + c.getscreenSize() + "\n" + "Τυπος οθόνης:  " + c.getscreenType() + "\n" + "Συστημα ηχου:  " + c.getsoundSystem());
                                Object[] selectionValues4 = {"Ονομα","Xωρητικοτητα","Eιδος θέσεων","Μεγεθος οθόνης","Τυπος οθόνης","Συστημα ηχου"};
                                Object ch = JOptionPane.showInputDialog(null, "Επελεξε το χαρακτηρηστικο που θέλεις να αλλαξεις",
                                   "Τροποποιηση Αιθουσας", JOptionPane.QUESTION_MESSAGE, null, selectionValues4, null);
                                if(ch == "Ονομα"){
                                    
                                    catalog.removeCinHall(i);
                                    items.removeItem(c.gethallName()) ;  
                                    String name1 = JOptionPane.showInputDialog("Δωσε το νεο ονομα της αιθουσας");
                                    c.changehallName(name1);
                                    
                                    for(Cinema h : cinema){
                                        if(h.gethallName().equals(name)){
                                            h.changehallName(name1);
                                        }
                                    }
                                    its.remove();
                                }
                                else if(ch == "Xωρητικοτητα"){
                                    catalog.removeCinHall(i);
                                    items.removeItem(c.gethallName()) ;  
                                    boolean right1=false;
                                            while(right1==false){
                                                try{
                                                    int capacity1 = Integer.parseInt(JOptionPane.showInputDialog("Δωσε τη νεα χωτητικοτητα της αιθουσας"));
                                                    c.changecapacity(capacity1);
                                                    its.remove();
                                    
                                                    for(Cinema h : cinema){
                                                        if(h.gethallName().equals(name)){
                                                             h.changecapacity(capacity1); 
                                                        }
                                                    }
                                                   
                                                    right1=true;
                                                }catch(NumberFormatException n1){

                                                    System.out.println("Δώσε αριθμό κι όχι συμβολοσειρά!");
                                                }
                                            }
                                           
                                }
                                else if(ch == "Eιδος θέσεων"){
                                    catalog.removeCinHall(i);
                                    items.removeItem(c.gethallName()) ;  
                                   Object[] selectionValues3 = { "Απλες", "Πολυτελειας"};
                                   Object seatType = JOptionPane.showInputDialog(null, "Επιλεξε τον τυπο των θεσεων",
                                     "Τυπος Θεσεων", JOptionPane.QUESTION_MESSAGE, null, selectionValues3, null);
                                   String seatType1=seatType.toString();
                                   c.changeseatType(seatType1);
                                   its.remove();
                                   for(Cinema h : cinema){
                                        if(h.gethallName().equals(name)){
                                            h.changeseatType(seatType1);
                                        }
                                    }
                                }
                                else if(ch == "Μεγεθος οθόνης"){
                                   catalog.removeCinHall(i);
                                    items.removeItem(c.gethallName()) ;  
                                    boolean right2=false;
                                            while(right2==false){
                                            try{
                                                int screenSize1 = Integer.parseInt(JOptionPane.showInputDialog("Δωσε τo μεγεθος της οθόνης"));
                                                c.changescreenSize(screenSize1);
                                                its.remove();
                                                for(Cinema h : cinema){
                                                    if(h.gethallName().equals(name)){
                                                        h.changescreenSize(screenSize1);
                                                    }

                                                }
                                                
                                                right2=true;
                                            }catch(NumberFormatException nfe2){

                                                System.out.println("Δώσε αριθμό κι όχι συμβολοσειρά!");
                                            }
                                            
                                    }
                                }
                                else if(ch == "Τυπος οθόνης"){
                                    catalog.removeCinHall(i);
                                    items.removeItem(c.gethallName()) ;  
                                     Object[] selectionValues5 = { "Κανονικη", "3D"};
                                     Object screenType = JOptionPane.showInputDialog(null, "Κανονικη ή 3D?",
                                        "Screen Type", JOptionPane.QUESTION_MESSAGE, null, selectionValues5, null);
                                     String screenType1 = screenType.toString();
                                     c.changescreenType(screenType1);
                                     its.remove();
                                     for(Cinema h : cinema){
                                        if(h.gethallName().equals(name)){
                                            h.changescreenType(screenType1);
                                        }
                                    }
                                }
                                else{
                                    catalog.removeCinHall(i);
                                    items.removeItem(c.gethallName()) ;  
                                   Object[] selectionValues6 = {"Dolby Digital", "Dolby Digital Surround", "Dolby Digital Live", "Dolby Digital Plus", "Dolby TrueHD"};
                                   Object soundSystem = JOptionPane.showInputDialog(null, "Επιλεξε σύστημα ήχου",
                                       "Sound System", JOptionPane.QUESTION_MESSAGE, null, selectionValues6, null);
                                   String soundSystem1 = soundSystem.toString();
                                   c.changesoundSystem(soundSystem1);
                                   its.remove();
                                   for(Cinema h : cinema){
                                        if(h.gethallName().equals(name)){
                                            h.changesoundSystem(soundSystem1);
                                        }
                                    }
                                } 
                                catalog.addCinHall(c);
                                items.addItem(c.gethallName());
                                f=new JFrame();
                                JOptionPane.showMessageDialog(f,"H αλλαγη έγινε με επιτυχία");
                                f.dispose();
                               break;
                                
                            }
                            i++;
                        }
                    }
                    
                    try(ObjectOutputStream oos3 = new ObjectOutputStream(new FileOutputStream("cinema.dat"))){
                        oos3.writeObject(catalog);
                    }
                    
                    
        }
        else if (hall.equals("Theatre")){
            String name = (String) items.getSelectedItem();
                    f = new JFrame();
                
                    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("theatre.dat"))) {
                        Catalog cat;
                        cat = (Catalog) in.readObject();
                        ArrayList<Theatre> arrayt = cat.getThHalls();
                        Iterator<Theatre> its = arrayt.iterator();
                        i=0;     
                        while (its.hasNext()) {
                            Theatre t = its.next();
                            if (t.gethallName().equals(name)) {
                                JOptionPane.showMessageDialog(f,"Ονομα:  " + t.gethallName() + "\n" + "Xωρητικοτητα:  " +t.getcapacity() + "\n" + "Eιδος θέσεων:  " + t.getseatType()+ "\n" + "Aριθμος εξώστεων:  " + t.getdressingRoom()+ "\n" + "Aριθμος καμαρινιών:  " + t.getdressingRoom());
                                Object[] selectionValues4 = {"Ονομα", "Xωρητικοτητα","Eιδος θέσεων","Aριθμος εξώστεων","Aριθμος καμαρινιών"};
                                Object cho = JOptionPane.showInputDialog(null, "Επελεξε το χαρακτηρηστικο που θέλεις να αλλαξεις",
                                   "Τροποποιηση Αιθουσας", JOptionPane.QUESTION_MESSAGE, null, selectionValues4, null);
                                if(cho == "Ονομα"){
                                    
                                    catalog.removeThHall(i);
                                    items.removeItem(t.gethallName()) ;  
                                    String name1 = JOptionPane.showInputDialog("Δωσε το νεο ονομα της αιθουσας");
                                    t.changehallName(name1);
                                    its.remove();
                                    for(Theatre th : theatre){
                                        if(th.gethallName().equals(name)){
                                            th.changehallName(name1);
                                        }
                                    }
                                }
                                else if(cho == "Xωρητικοτητα"){
                                    catalog.removeThHall(i);
                                    items.removeItem(t.gethallName()) ;
                                    boolean right1=false;
                                            while(right1==false){
                                            try{
                                                int capacity1 = Integer.parseInt(JOptionPane.showInputDialog("Δωσε τη νεα χωτητικοτητα της αιθουσας"));
                                                t.changecapacity(capacity1);
                                                its.remove();
                                                for(Theatre th : theatre){
                                                    if(th.gethallName().equals(name)){
                                                        th.changecapacity(capacity1);

                                                    }
                                                }
                                                
                                             right1=true;
                                            }catch(NumberFormatException nfe1){

                                                System.out.println("Δώσε αριθμό κι όχι συμβολοσειρά!");
                                            }
                                            }
                                     
                                }
                                else if(cho == "Eιδος θέσεων"){
                                    catalog.removeThHall(i);
                                    items.removeItem(t.gethallName()) ;
                                    Object[] selectionValues3 = { "Απλες", "Πολυτελειας"};
                                    Object seatType = JOptionPane.showInputDialog(null, "Επιλεξε τον τυπο των θεσεων",
                                    "Τυπος Θεσεων", JOptionPane.QUESTION_MESSAGE, null, selectionValues3, null);
                                    String seatType1=seatType.toString();
                                    t.changeseatType(seatType1);
                                    its.remove();
                                    for(Theatre th : theatre){
                                        if(th.gethallName().equals(name)){
                                            th.changeseatType(seatType1);
                                        }
                                    }
                                }
                                else if(cho == "Aριθμος εξώστεων" ){
                                    catalog.removeThHall(i);
                                    items.removeItem(t.gethallName()) ;
                                    boolean right2=false;
                                            while(right2==false){
                                            try{
                                                int balcony1 = Integer.parseInt(JOptionPane.showInputDialog("Δωσε τον νεο αριθμο των εξώστεων"));
                                                t.changebalcony(balcony1);
                                                its.remove();
                                                for(Theatre th : theatre){
                                                    if(th.gethallName().equals(name)){
                                                        th.changebalcony(balcony1);
                                                    }
                                             }
                                                
                                                right2=true;
                                            }catch(NumberFormatException nfe2){

                                                System.out.println("Δώσε αριθμό κι όχι συμβολοσειρά!");
                                            }
                                            }
                                            
                                }
                                else{
                                    catalog.removeThHall(i);
                                    items.removeItem(t.gethallName()) ;
                                    boolean right3=false;
                                            while(right3==false){
                                            try{
                                                int dressingRoom1 = Integer.parseInt(JOptionPane.showInputDialog("Δωσε τον νεο αριθμο των καμαρινιών"));
                                                t.changedressingRoom(dressingRoom1);
                                                its.remove();
                                                for(Theatre th : theatre){
                                                    if(th.gethallName().equals(name)){
                                                        th.changedressingRoom(dressingRoom1);
                                                    }
                                                }
                                                
                                                right3=true;
                                            }catch(NumberFormatException nfe3){

                                                System.out.println("Δώσε αριθμό κι όχι συμβολοσειρά!");
                                            }
                                        }
                                   
                                }
                                catalog.addThHall(t);
                                items.addItem(t.gethallName());
                                f=new JFrame();
                                JOptionPane.showMessageDialog(f,"H αλλαγη έγινε με επιτυχία");
                                f.dispose();
                                break;
                                
                                }
                            i++;
                        }
                        
                    }
                    
                    try(ObjectOutputStream oos3 = new ObjectOutputStream(new FileOutputStream("theatre.dat"))){
                        oos3.writeObject(catalog);
                    }
        }
        
    }
    /**
     *Ο διαχειριστης επιλέγει ποια αίθουσα θέλει να αφαιρέσει, τροποποιήσει
     * @param choice
     * @param choice2
     **/
    public void chooseRoom(String choice,String choice2) throws FileNotFoundException, IOException, ClassNotFoundException{
        frame1 = new JFrame();
        frame1.setSize(500,800);
        frame1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        items = new javax.swing.JComboBox();
        button = new javax.swing.JButton();
        
        jLabel1.setText("Επέλεξε Αίθουσα");
        
        items.setModel(new javax.swing.DefaultComboBoxModel());
        
        if(choice2.equals("Cinema")){
                
                hall = "Cinema";
                try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("cinema.dat"))) {
                    
                    Catalog cat;
                    cat = (Catalog) in.readObject();
                    catalog = cat;
                    ArrayList<Cinema> arrayc = cat.getCinemaHalls();
                    for(Cinema cin:arrayc){
                        
                        items.addItem(cin.gethallName());
                    }
            
                }
            }
            else if (choice2.equals("Theatre")){
                
                hall = "Theatre";
                try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("theatre.dat"))) {
            
                    Catalog cat;
                    cat = (Catalog) in.readObject();
                    catalog = cat;
                    ArrayList<Theatre> arrayt = cat.getThHalls();
                    for(Theatre th:arrayt){
                        items.addItem(th.gethallName());
                    }
            
                }
            }
        
        button.setText("OK");
        if(choice.equals("Afairw")){
            button.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    try {
                        removeHall(hall);
                    } catch (IOException ex) {
                        Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    frame1.dispose();
                }
            });}
        if(choice.equals("Tropopoiw")){
            button.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    try {
                        changeHall(hall);
                    } catch (IOException ex) {
                        Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    frame1.dispose();
                }
            });}
        if(choice.equals("tainies")){
            button.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    item = (String) items.getSelectedItem();
                    frame1.dispose();
                }
            });}
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                                         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                         .addGroup(jPanel1Layout.createSequentialGroup()
                                                   .addGap(100, 100, 100)
                                                   .addComponent(jLabel1)
                                                   .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                   .addContainerGap(74, Short.MAX_VALUE)
                                                   .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                       .addComponent(button)
                                                                       .addGap(112, 112, 112))
                                                             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                       .addComponent(items, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                       .addGap(71, 71, 71))))
                                         );
        jPanel1Layout.setVerticalGroup(
                                       jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                       .addGroup(jPanel1Layout.createSequentialGroup()
                                                 .addGap(33, 33, 33)
                                                 .addComponent(jLabel1)
                                                 .addGap(26, 26, 26)
                                                 .addComponent(items, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                                 .addComponent(button)
                                                 .addGap(22, 22, 22))
                                       );
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                  .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                  );
        layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                          .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addGap(0, 10, Short.MAX_VALUE))
                                );
        
        frame1.add(jPanel1);
        frame1.pack();
        frame1.setVisible(true);
    }
    
    /**
     *Ο διαχειριστης προσθετει ταινίες
     * @param  m
     * @throws java.io.IOException
     **/
    public void addmShow(Movies m) throws IOException{
        try(ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("movies.dat"))){
          showList.addMShow(m);
          oos1.writeObject(showList);
        }
        movie.add(m);
        f = new JFrame();
        if(hash.containsKey(m.getshowName()))
        {
            HashSet<String> set =hash.get(m.getshowName());
            set.add(item);
            hash.put(m.getshowName(),set);
        }
        else{
            HashSet<String> set = new HashSet<>();
            set.add(item);
            hash.put(m.getshowName(), set);
        }
        JOptionPane.showMessageDialog(f, "H ταινια προστέθηκε στην επιλεγόμενη αίθουσα");
    }
    /**
     *Ο διαχειριστης προσθετει θεατρικές παραστάσεις/ταινίες
     * @param m
     * @throws java.io.IOException
     **/
    public void addtShow(TheatricalShow m) throws IOException{
        try(ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("theatricalShows.dat"))){
          showList.addTShow(m);
          oos1.writeObject(showList);
        }
        theatricalShow.add(m);
        f = new JFrame();
        if(hash.containsKey(m.getshowName()))
        {
            HashSet<String> set =hash.get(m.getshowName());
            set.add(item);
            hash.put(m.getshowName(),set);
        }
        else{
            HashSet<String> set = new HashSet<>();
            set.add(item);
            hash.put(m.getshowName(), set);
        }
        JOptionPane.showMessageDialog(f, "H θεατρική παράσταση προστέθηκε στην επιλεγόμενη αίθουσα");
    }
    
    /**
     *Ο διαχειριστης επιλέγει ποια θεατρικά παραστάση/ταινία θέλει να αφαιρέσει, τροποποιήσει
     * @param choice
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     **/
    public void chooseShow(String choice) throws IOException, ClassNotFoundException{
        frame1 = new JFrame();
        frame1.setSize(500,800);
        frame1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        itemss = new javax.swing.JComboBox();
        button = new javax.swing.JButton();
        
         
        Object[] it = { "Movie", "Theatrical Show"};
        Object ch = JOptionPane.showInputDialog(null, "Movie or Theatrical Show?",
                "Τύπος Show", JOptionPane.QUESTION_MESSAGE, null, it, null);
        String item2 = ch.toString();
            
        
        jLabel1.setText("Επέλεξε Show");
        
        itemss.setModel(new javax.swing.DefaultComboBoxModel());
        String showName ="";
        if((item2).equals("Movie")){
               
            sh = "Movie";
    
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("movies.dat"))) {
                    
                ShowList sl;
                sl = (ShowList) in.readObject();
                showList = sl;
                ArrayList<Movies> arraym = sl.getMShows();
                for(Movies m:arraym){
                    if(!m.getshowName().equals(showName)){
                        
                    itemss.addItem(m.getshowName());
                    showName= m.getshowName();
                    }
                }
            
            }
        }
        else if (item2.equals("Theatrical Show")){
                
                sh= "TheatricalShow";
                try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("theatricalShows.dat"))) {
            
                    ShowList sl;
                    sl = (ShowList) in.readObject();
                    showList = sl;
                    ArrayList<TheatricalShow> arrayt = sl.getTShows();
                    for(TheatricalShow th:arrayt){
                        if(!th.getshowName().equals(showName)){
                        itemss.addItem(th.getshowName());
                        showName= th.getshowName();
                        }
                    }
            
                }
            }
        button.setText("OK");
        if(choice.equals("Afairw")){
            button.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                     try {  
                    removeShow(sh);
                } catch (IOException ex) {
                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                }
                    frame1.dispose();
                }
            });}
        if(choice.equals("Tropopoiw")){
            button.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                   try { 
                    changeShow(sh);
                } catch (IOException ex) {
                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                }
                    frame1.dispose();
                }
            });}
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                                         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                         .addGroup(jPanel1Layout.createSequentialGroup()
                                                   .addGap(100, 100, 100)
                                                   .addComponent(jLabel1)
                                                   .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                   .addContainerGap(74, Short.MAX_VALUE)
                                                   .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                       .addComponent(button)
                                                                       .addGap(112, 112, 112))
                                                             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                       .addComponent(itemss, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                       .addGap(71, 71, 71))))
                                         );
        jPanel1Layout.setVerticalGroup(
                                       jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                       .addGroup(jPanel1Layout.createSequentialGroup()
                                                 .addGap(33, 33, 33)
                                                 .addComponent(jLabel1)
                                                 .addGap(26, 26, 26)
                                                 .addComponent(itemss, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                                 .addComponent(button)
                                                 .addGap(22, 22, 22))
                                       );
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                  .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                  );
        layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                          .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addGap(0, 10, Short.MAX_VALUE))
                                );
        
        frame1.add(jPanel1);
        frame1.pack();
        frame1.setVisible(true);
    }
    /**
     *Ο διαχειριστης αφαιρεί θεατρικές παραστάσεις/ταινίες
     * @param sh
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     **/
    public void removeShow(String sh) throws IOException, ClassNotFoundException{
        
        String name = (String) itemss.getSelectedItem();
                if("Movie".equals(sh)){
                    
                    f = new JFrame();
                
                    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("movies.dat"))) {
                        ShowList sl;
                        sl = (ShowList) in.readObject();
                        ArrayList<Movies> arraym = sl.getMShows();
                        Iterator<Movies> its = arraym.iterator();
                        int k = 0;
                        while (its.hasNext()) {
                            Movies m = its.next();
                            if (m.getshowName().equals(name)) {
                                showList.removeMShow(k);
                                itemss.removeItem(m.getshowName());
                                its.remove();
                                movie.remove(k);
                                f = new JFrame();
                                JOptionPane.showMessageDialog(f, "Η ταινία αφαιρέθηκε με επιτυχία");
                                f.dispose();
                                break;
                                
                            }
                            k++;
                        }
                    }
                    try(ObjectOutputStream oos3 = new ObjectOutputStream(new FileOutputStream("movies.dat"))){
                        oos3.writeObject(showList);
                    }
                   
                    
                }
                else if(sh.equals("TheatricalShow")){

                    f = new JFrame();
                
                    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("theatricalShows.dat"))) {
                        ShowList sl;
                        sl = (ShowList) in.readObject();
                        ArrayList<TheatricalShow> arrayt = sl.getTShows();
                        Iterator<TheatricalShow> its = arrayt.iterator();
                        //Iterator<Cinema> it = cinema.iterator();
                        int l = 0;
                        while (its.hasNext()) {
                            TheatricalShow ts = its.next();
                            if (ts.getshowName().equals(name)) {
                                showList.removeTShow(l);
                                itemss.removeItem(ts.getshowName());
                                its.remove();
                                theatricalShow.remove(l);
                                f = new JFrame();
                                JOptionPane.showMessageDialog(f, "Η θεατρική παράσταση αφαιρέθηκε με επιτυχία");
                                f.dispose();
                                break;
                                
                            } 
                            l++;
                        }
                    }
                    
                    try(ObjectOutputStream oos3 = new ObjectOutputStream(new FileOutputStream("theatricalShows.dat"))){
                        oos3.writeObject(showList);
                    }
                    
                   }
                    
                
                    for(String namee : hash.keySet()){
                       if(namee.equals(name))
                           hash.remove(name);
                     }
    }
    
    /**
     *Ο διαχειριστης τροποποιεί θεατρικές παραστάσεις/ταινίες
     * @param sh
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     **/
    public void changeShow(String sh) throws IOException, ClassNotFoundException{  
        
        
        if(sh.equals("Movie")){
                    
                    String name = (String) itemss.getSelectedItem();
                    f = new JFrame();
                
                    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("movies.dat"))) {
                        ShowList sl;
                        sl = (ShowList) in.readObject();
                        ArrayList<Movies> arraym = sl.getMShows();
                        Iterator<Movies> its = arraym.iterator();   
                        i=0;
                        while (its.hasNext()) {
                            Movies m = its.next();
                            if (m.getshowName().equals(name)) {
                                JOptionPane.showMessageDialog(f,"Ονομα ταινίας:  " + m.getshowName() + "\n" + "Περιγραφή:  " +m.getshowDescription() + "\n" + "Σκηνοθέτης:  " + m.getDirector()+ "\n" + "Λίστα Ηθοποιών:  " + m.getactorList() + "\n" + "Διάρκεια:  " + m.getDuration()+ "minutes");
                                Object[] selectionValues4 = {"Ονομα ταινίας","Περιγραφή","Σκηνοθέτης","Λίστα Ηθοποιών","Διάρκεια"};
                                Object ch = JOptionPane.showInputDialog(null, "Επελεξε το χαρακτηρηστικο που θέλεις να αλλαξεις",
                                   "Τροποποιηση Show", JOptionPane.QUESTION_MESSAGE, null, selectionValues4, null);
                                if(ch == "Ονομα ταινίας"){
                                    showList.removeMShow(i);
                                    itemss.removeItem(m.getshowName()) ;                             
                                    String name1 = JOptionPane.showInputDialog("Δωσε το νεο όνομα της ταινίας");                                   
                                    m.changeshowName(name1);
                                    its.remove();
                                    for(Movies h : movie){
                                        if(h.getshowName().equals(name)){
                                            h.changeshowName(name1);
                                        }
                                    }
                                }
                                else if(ch == "Περιγραφή"){
                                    showList.removeMShow(i);
                                    itemss.removeItem(m.getshowName());                                   
                                    String description1 = JOptionPane.showInputDialog("Δωσε τη νέα περιγραφή της ταινίας");                               
                                    m.changeshowDescription(description1);
                                    its.remove();
                                    for(Movies h : movie){
                                        if(h.getshowName().equals(name)){
                                            h.changeshowDescription(description1);
                                        }
                                    }
                                }
                                else if(ch == "Σκηνοθέτης"){
                                    showList.removeMShow(i);
                                    itemss.removeItem(m.getshowName());
                                   String description1 = JOptionPane.showInputDialog("Δωσε τον νέο σκηνοθέτη της ταινίας");                           
                                    m.changeDirector(description1);
                                    its.remove();
                                    for(Movies h : movie){
                                        if(h.getshowName().equals(name)){
                                            h.changeDirector(description1);
                                        }
                                    }
                                }
                                else if(ch == "Λίστα Ηθοποιών"){
                                    showList.removeMShow(i);
                                    itemss.removeItem(m.getshowName());                                 
                                   String description1 = JOptionPane.showInputDialog("Δωσε τη νέα λίστα ηθοποιών της ταινίας");                              
                                   m.changeactorList(description1);
                                   its.remove();
                                   for(Movies h : movie){
                                        if(h.getshowName().equals(name)){
                                            h.changeactorList(description1);
                                        }
                                    }
                                }

                                else{
                                    showList.removeMShow(i);
                                    itemss.removeItem(m.getshowName());
                                    boolean right=false;
                                            while(right==false){
                                            try{
                                               int duration1 = Integer.parseInt(JOptionPane.showInputDialog("Δωσε τη νέα διάρκεια της ταινίας"));                    
                                                 m.changeDuration(duration1);
                                                 right=true;
                                                 its.remove();
                                                 for(Movies h : movie){
                                                       if(h.getshowName().equals(name)){
                                                           h.changeDuration(duration1);
                                                       }
                                                 }
                                            
                                            }catch(NumberFormatException nfe){

                                                System.out.println("Δώσε αριθμό κι όχι συμβολοσειρά!");
                                            }
                                        }
                                }
                                            
                                                             
                                   
                                    
                                showList.addMShow(m);
                                itemss.addItem(m.getshowName());
                                f=new JFrame();
                                JOptionPane.showMessageDialog(f,"H αλλαγη έγινε με επιτυχία");
                                f.dispose();
                               break;
                                
                                
                            }
                            i++;
                            
                        }
                    }
                            
                            try(ObjectOutputStream oos3 = new ObjectOutputStream(new FileOutputStream("movies.dat"))){
                        oos3.writeObject(showList);
                    }
                    
        }
        else if(sh.equals("TheatricalShow")){
                    
                    String name = (String) itemss.getSelectedItem();
                    f = new JFrame();
                
                    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("theatricalShows.dat"))) {
                        ShowList sl;
                        sl = (ShowList) in.readObject();
                        ArrayList<TheatricalShow> arrayt = sl.getTShows();
                        Iterator<TheatricalShow> its = arrayt.iterator();   
                        i=0;
                        while (its.hasNext()) {
                            TheatricalShow t = its.next();
                            if (t.getshowName().equals(name)) {
                            JOptionPane.showMessageDialog(f,"Ονομα θεατρικής παράστασης:  " + t.getshowName() + "\n" + "Περιγραφή:  " +t.getshowDescription() + "\n" + "Σκηνοθέτης:  " + t.getDirector()+ "\n" + "Λίστα Ηθοποιών:  " + t.getactorList());
                            Object[] selectionValues4 = {"Ονομα θεατρικής παράστασης","Περιγραφή","Σκηνοθέτης","Λίστα Ηθοποιών"};
                            Object ch = JOptionPane.showInputDialog(null, "Επελεξε το χαρακτηρηστικο που θέλεις να αλλαξεις",
                               "Τροποποιηση Show", JOptionPane.QUESTION_MESSAGE, null, selectionValues4, null);
                            if(ch == "Ονομα θεατρικής παράστασης"){
                                showList.removeTShow(i);
                                itemss.removeItem(t.getshowName()) ;                             
                                String name1 = JOptionPane.showInputDialog("Δωσε το νεο όνομα της θεατρικής παράστασης");                                  
                                t.changeshowName(name1);
                                its.remove();
                                for(TheatricalShow th : theatricalShow){
                                        if(th.getshowName().equals(name)){
                                            th.changeshowName(name1);
                                        }
                                }
                            }
                            else if(ch == "Περιγραφή"){
                                showList.removeTShow(i);
                                itemss.removeItem(t.getshowName()) ;
                                String description1 = JOptionPane.showInputDialog("Δωσε τη νέα περιγραφή της θεατρικής παράστασης");
                                t.changeshowDescription(description1);
                                its.remove();
                                for(TheatricalShow th : theatricalShow){
                                        if(th.getshowName().equals(name)){
                                            th.changeshowDescription(description1);
                                        }
                                }
                            }
                            else if(ch == "Σκηνοθέτης"){
                                showList.removeTShow(i);
                                itemss.removeItem(t.getshowName()) ;
                                String director1 = JOptionPane.showInputDialog("Δωσε τον νέο σκηνοθέτη της θεατρικής παράστασης");
                                t.changeDirector(director1);
                                its.remove();
                                for(TheatricalShow th : theatricalShow){
                                        if(th.getshowName().equals(name)){
                                            th.changeDirector(director1);
                                        }
                                }
                            }
                            else{
                                showList.removeTShow(i);
                                itemss.removeItem(t.getshowName()) ;
                                String actorList1 = JOptionPane.showInputDialog("Δωσε τη νέα λίστα ηθοποιών της θεατρικής παράστασης");
                                t.changeactorList(actorList1);
                                its.remove();
                                for(TheatricalShow th : theatricalShow){
                                        if(th.getshowName().equals(name)){
                                            th.changeactorList(actorList1);
                                        }
                                }
                            }
                                showList.addTShow(t);
                                itemss.addItem(t.getshowName());
                                f=new JFrame();
                                JOptionPane.showMessageDialog(f,"H αλλαγη έγινε με επιτυχία");
                                f.dispose();
                                
                                break;             
                            }
                            i++;
                        }
       
                    }
                    
                    try(ObjectOutputStream oos3 = new ObjectOutputStream(new FileOutputStream("theatricalShows.dat"))){
                        oos3.writeObject(showList);
                    }
                    
                    
        }
    }
    

    /**
     *Ο απλος χρηστης κανει κρατηση συγκεκριμένων θέσεων για συγκεκριμένες προβολές θεατρικών παραστάσεων ή ταινιών
     * @param namee
     * @param number
     **/
    public void check(final String namee,final String number){
        frame1 = new JFrame();
        frame1.setSize(500,800);
        frame1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        button1 = new javax.swing.JButton();
        button2 = new javax.swing.JButton();
        
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        
        jLabel1.setFont(new java.awt.Font("Thonburi", 0, 14)); // NOI18N
        jLabel1.setText("Eπέλεξε τι επιθυμείς να παρακολουθήσεις");
        
        button1.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 13)); // NOI18N
        button1.setText("Cinema");
        button1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frame1.dispose();
                frame2 = new JFrame();
                frame2.setSize(500,800);
                frame2.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                jPanel2 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                choice = new javax.swing.JComboBox();
                button1 = new javax.swing.JButton();
                button2 = new javax.swing.JButton();
                String showName ="";
                jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                choice.setModel(new javax.swing.DefaultComboBoxModel());
                
                /*Παρακάτω είναι μια προσπαθεια να κάνουμε την αποθήκευση στον δίσκο η οποια δεν ολοκληροθηκε λογο ελειψης χρονου                
                */
                /*
                try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("movies.dat"))) {
                    
                    ShowList sl;
                    sl = (ShowList) in.readObject();
                    showList = sl;
                    ArrayList<Movies> arraym = sl.getMShows();
                    for(Movies m:arraym){
                        if(!m.getshowName().equals(showName)){
                            choice.addItem(m.getshowName());
                            showName= m.getshowName();
                        }
                    }
                        
                }catch (IOException ex) {
                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                }*/
        
                
                
                for(Movies m: movie){
                    if(!m.getshowName().equals(showName)){
                        choice.addItem(m.getshowName());
                        showName= m.getshowName();
                    }
                }
                
                jLabel1.setFont(new java.awt.Font("Osaka", 0, 18)); // NOI18N
                jLabel1.setText("ΠΑΙΖΟΝΤΑΙ ΤΩΡΑ");
                
                button1.setFont(new java.awt.Font("Menlo", 0, 13)); // NOI18N
                button1.setText("ΠΕΡΙΣΣΟΤΕΡΑ");
                button1.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        String name = (String) choice.getSelectedItem();
                        f = new JFrame();
                        
                        /*Παρακάτω είναι μια προσπαθεια να κάνουμε την αποθήκευση στον δίσκο.Επειδη όμως στην συνεχεια δεν πέτυχε
                        το βάλαμε σε σχολια.
                        */
                        /*ArrayList<Movies> arraym = showList.getMShows();
                        for(Movies h:arraym){
                            if(h.getshowName().equals(name)){
                                JOptionPane.showMessageDialog(f,"Ονομα ταινίας:  " + h.getshowName() + "\n" + "Περιγραφή:  " +h.getshowDescription() + "\n" + "Σκηνοθέτης:  " + h.getDirector()+ "\n" + "Λίστα Ηθοποιών:  " + h.getactorList() + "\n" + "Διάρκεια:  " + h.getDuration()+ "minutes");
                            }
                        }*/
                        
                        for(Movies h : movie){
                            if(h.getshowName().equals(name)){
                                JOptionPane.showMessageDialog(f,"Ονομα ταινίας:  " + h.getshowName() + "\n" + "Περιγραφή:  " +h.getshowDescription() + "\n" + "Σκηνοθέτης:  " + h.getDirector()+ "\n" + "Λίστα Ηθοποιών:  " + h.getactorList() + "\n" + "Διάρκεια:  " + h.getDuration()+ "minutes");
                            }
                        }
                    }
                });
                
                button2.setFont(new java.awt.Font("Menlo", 0, 13)); // NOI18N
                button2.setText("ΕΙΣΗΤΗΡΙΑ");
                button2.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        final String name = (String) choice.getSelectedItem();
                        frame4 = new JFrame();
                        frame4.setSize(500,800);
                        frame4.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                        
                        jPanel1 = new javax.swing.JPanel();
                        jLabel1 = new javax.swing.JLabel();
                        items = new javax.swing.JComboBox();
                        button = new javax.swing.JButton();
                        
                        jLabel1.setText("Επέλεξε Αίθουσα");
                        
                        items.setModel(new javax.swing.DefaultComboBoxModel());
                       
                        HashSet<String> set = hash.get(name);
                        for(String ai8: set)
                              items.addItem(ai8);
                                       
                        button.setText("OK");
                        button.addActionListener(new java.awt.event.ActionListener() {
                            @Override
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                int j;
                                final String aithousa = (String) items.getSelectedItem();
                                String[] date = new String[20];
                                frame3 = new JFrame();
                                frame3.setSize(500,800);
                                frame3.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                                
                                jPanel1 = new javax.swing.JPanel();
                                jLabel1 = new javax.swing.JLabel();
                                itemss = new javax.swing.JComboBox();
                                button = new javax.swing.JButton();
                                
                                jPanel1.setBackground(new java.awt.Color(255, 255, 255));
                                jLabel1.setFont(new java.awt.Font("Muna", 0, 18)); // NOI18N
                                jLabel1.setText("Eπέλεξε Μέρα και Ωρα");
                                
                                itemss.setModel(new javax.swing.DefaultComboBoxModel());
                                
                                
                                        for(Movies m : movie){
                                            if(m.getshowName().equals(name)){
                                                    date = m.getDate();
                                                    price = m.getPrice();
                                                    for(j=0; j<20; j++){
                                                        if(date[j]!=null){
                                                            itemss.addItem(date[j]);
                                                        }
                                                    }
                                            }
                                        }
                                
                                button.setText("ΚΡΑΤΗΣΗ");
                                button.addActionListener(new java.awt.event.ActionListener() {
                                    @Override
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        String datee = (String) itemss.getSelectedItem();
                                        int[] seats = new int[20];
                                        int[] bool = new int[200];
                                        
                                        for(Cinema c: cinema){
                                            if(c.gethallName().equals(aithousa)){
                                                seats = c.getSeats();
                                                rownumber = c.getrownumber();
                                                bool =c.getcheckseats();
                                            }
                                        }
                                        for(String a: ai8ouses){
                                            if(!a.contains(aithousa)){
                                                ai8ouses.add(aithousa);
                                            }
                                        }
                                        bookSeats(aithousa,seats,rownumber,bool,price,namee,number,name,aithousa,datee);
                                        frame2.dispose();
                                        frame4.dispose();
                                        frame3.dispose();
                                    }
                                });
                                
                                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                                jPanel1.setLayout(jPanel1Layout);
                                jPanel1Layout.setHorizontalGroup(
                                                                 jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                 .addGroup(jPanel1Layout.createSequentialGroup()
                                                                           .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                     .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                               .addGap(109, 109, 109)
                                                                                               .addComponent(jLabel1))
                                                                                     .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                               .addGap(75, 75, 75)
                                                                                               .addComponent(itemss, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                           .addContainerGap(69, Short.MAX_VALUE))
                                                                 .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                           .addGap(0, 0, Short.MAX_VALUE)
                                                                           .addComponent(button)
                                                                           .addGap(146, 146, 146))
                                                                 );
                                jPanel1Layout.setVerticalGroup(
                                                               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                               .addGroup(jPanel1Layout.createSequentialGroup()
                                                                         .addGap(29, 29, 29)
                                                                         .addComponent(jLabel1)
                                                                         .addGap(44, 44, 44)
                                                                         .addComponent(itemss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                                                         .addComponent(button)
                                                                         .addGap(41, 41, 41))
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
                                
                                frame3.add(jPanel1);
                                frame3.pack();
                                frame3.setVisible(true);
                            }
                        });
                        
                        
                        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                        jPanel1.setLayout(jPanel1Layout);
                        jPanel1Layout.setHorizontalGroup(
                                                         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                         .addGroup(jPanel1Layout.createSequentialGroup()
                                                                   .addGap(100, 100, 100)
                                                                   .addComponent(jLabel1)
                                                                   .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                   .addContainerGap(74, Short.MAX_VALUE)
                                                                   .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                                       .addComponent(button)
                                                                                       .addGap(112, 112, 112))
                                                                             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                                       .addComponent(items, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                       .addGap(71, 71, 71))))
                                                         );
                        jPanel1Layout.setVerticalGroup(
                                                       jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                       .addGroup(jPanel1Layout.createSequentialGroup()
                                                                 .addGap(33, 33, 33)
                                                                 .addComponent(jLabel1)
                                                                 .addGap(26, 26, 26)
                                                                 .addComponent(items, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                                                 .addComponent(button)
                                                                 .addGap(22, 22, 22))
                                                       );
                        
                        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                        getContentPane().setLayout(layout);
                        layout.setHorizontalGroup(
                                                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                  .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                  );
                        layout.setVerticalGroup(
                                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                          .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                          .addGap(0, 10, Short.MAX_VALUE))
                                                );
                        
                        frame4.add(jPanel1);
                        frame4.pack();
                        frame4.setVisible(true);
                        
                    }
                });
                
                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                                 jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                 .addGroup(jPanel2Layout.createSequentialGroup()
                                                           .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                           .addComponent(jLabel1)
                                                           .addGap(75, 75, 75))
                                                 .addGroup(jPanel2Layout.createSequentialGroup()
                                                           .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                     .addGroup(jPanel2Layout.createSequentialGroup()
                                                                               .addGap(33, 33, 33)
                                                                               .addComponent(choice, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                               .addGap(18, 18, 18)
                                                                               .addComponent(button1))
                                                                     .addGroup(jPanel2Layout.createSequentialGroup()
                                                                               .addGap(149, 149, 149)
                                                                               .addComponent(button2)))
                                                           .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                 );
                jPanel2Layout.setVerticalGroup(
                                               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                               .addGroup(jPanel2Layout.createSequentialGroup()
                                                         .addGap(26, 26, 26)
                                                         .addComponent(jLabel1)
                                                         .addGap(39, 39, 39)
                                                         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                   .addComponent(choice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                   .addComponent(button1))
                                                         .addGap(49, 49, 49)
                                                         .addComponent(button2)
                                                         .addContainerGap(41, Short.MAX_VALUE))
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
        
        button2.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 13)); // NOI18N
        button2.setText("Θεατρική παράσταση");
        button2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frame1.dispose();
                frame2 = new JFrame();
                frame2.setSize(500,800);
                frame2.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                jPanel2 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                choice = new javax.swing.JComboBox();
                button1 = new javax.swing.JButton();
                button2 = new javax.swing.JButton();
                String showName= "";
                jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                choice.setModel(new javax.swing.DefaultComboBoxModel());
                
                /*Παρακάτω είναι μια προσπαθεια να κάνουμε την αποθήκευση στον δίσκο.Επειδη όμως στην συνεχεια δεν πέτυχε
                    το βάλαμε σε σχολια.
                */
                /*try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("theatricalShows.dat"))) {
                    
                    ShowList sl;
                    sl = (ShowList) in.readObject();
                    showList = sl;
                    ArrayList<TheatricalShow> arrayt = sl.getTShows();
                    for(TheatricalShow t:arrayt){
                        if(!t.getshowName().equals(showName)){
                            choice.addItem(t.getshowName());
                            showName= t.getshowName();
                        }
                    }
                        
                }catch (IOException ex) {
                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                
                
                
                for(TheatricalShow itemm: theatricalShow){
                    if(!itemm.getshowName().equals(showName)){
                        choice.addItem(itemm.getshowName());
                        showName= itemm.getshowName();
                    }
                }
                
                jLabel1.setFont(new java.awt.Font("Osaka", 0, 18)); // NOI18N
                jLabel1.setText("ΠΑΙΖΟΝΤΑΙ ΤΩΡΑ");
                
                button1.setFont(new java.awt.Font("Menlo", 0, 13)); // NOI18N
                button1.setText("ΠΕΡΙΣΣΟΤΕΡΑ");
                button1.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        String name = (String) choice.getSelectedItem();
                        f = new JFrame();
                        
                        /*Παρακάτω είναι μια προσπαθεια να κάνουμε την αποθήκευση στον δίσκο.Επειδη όμως στην συνεχεια δεν πέτυχε
                           το βάλαμε σε σχολια.
                         */
                        /*ArrayList<TheatricalShow> arrayt = showList.getTShows();
                        for(TheatricalShow t:arrayt){
                            if(t.getshowName().equals(name)){
                                JOptionPane.showMessageDialog(f,"Ονομα θεατρικής παράστασης:  " + t.getshowName() + "\n" + "Περιγραφή:  " +t.getshowDescription() + "\n" + "Σκηνοθέτης:  " + t.getDirector()+ "\n" + "Λίστα Ηθοποιών:  " + t.getactorList());
                            }
                        }*/
                        
                        for(TheatricalShow t : theatricalShow){
                            if(t.getshowName().equals(name)){
                                JOptionPane.showMessageDialog(f,"Ονομα θεατρικής παράστασης:  " + t.getshowName() + "\n" + "Περιγραφή:  " +t.getshowDescription() + "\n" + "Σκηνοθέτης:  " + t.getDirector()+ "\n" + "Λίστα Ηθοποιών:  " + t.getactorList());
                                
                            }
                        }
                    }
                });
                
                button2.setFont(new java.awt.Font("Menlo", 0, 13)); // NOI18N
                button2.setText("ΕΙΣΗΤΗΡΙΑ");
                button2.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        final String name = (String) choice.getSelectedItem();
                        frame4 = new JFrame();
                        frame4.setSize(500,800);
                        frame4.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                        
                        jPanel1 = new javax.swing.JPanel();
                        jLabel1 = new javax.swing.JLabel();
                        items = new javax.swing.JComboBox();
                        button = new javax.swing.JButton();
                        
                        jLabel1.setText("Επέλεξε Αίθουσα");
                        
                        items.setModel(new javax.swing.DefaultComboBoxModel());
                        HashSet<String> set = hash.get(name);
                        for(String ai8: set)
                              items.addItem(ai8);
                        
                        button.setText("OK");
                        button.addActionListener(new java.awt.event.ActionListener() {
                            @Override
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                int j;
                                final String aithousa = (String) items.getSelectedItem();
                                String[] datee = new String[20];
                                frame3 = new JFrame();
                                frame3.setSize(500,800);
                                frame3.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                                
                                jPanel1 = new javax.swing.JPanel();
                                jLabel1 = new javax.swing.JLabel();
                                itemss = new javax.swing.JComboBox();
                                button = new javax.swing.JButton();
                                
                                jPanel1.setBackground(new java.awt.Color(255, 255, 255));
                                jLabel1.setFont(new java.awt.Font("Muna", 0, 18)); // NOI18N
                                jLabel1.setText("Eπέλεξε Μέρα και Ωρα");
                                
                                itemss.setModel(new javax.swing.DefaultComboBoxModel());
                                for(TheatricalShow m: theatricalShow){
                                            if(m.getshowName().equals(name)){
                                                    datee = m.getDate();
                                                    price = m.getPrice();
                                                    for(j=0; j<20; j++){
                                                        if(datee[j]!=null){
                                                            itemss.addItem(datee[j]);
                                                        }
                                                    }
                                            }
                                        }
                                
                                button.setText("ΚΡΑΤΗΣΗ");
                                button.addActionListener(new java.awt.event.ActionListener() {
                                    @Override
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        int[] bool = new int[200];
                                        int[] seats = new int[20];
                                        String datee = (String) itemss.getSelectedItem();
                                        for(String a: ai8ouses){
                                            if(!a.contains(aithousa)){
                                                ai8ouses.add(aithousa);
                                            }
                                        }
                                        for(Theatre c: theatre){
                                            if(c.gethallName().equals(aithousa)){
                                                seats = c.getSeats();
                                                rownumber = c.getrownumber();
                                                bool = c.checkseats;
                                            }
                                        }
                                        
                                        bookSeats(aithousa,seats,rownumber,bool,price,namee,number,name,aithousa,datee);
                                        frame2.dispose();
                                        frame4.dispose();
                                        frame3.dispose();
                                    }
                                });
                                
                                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                                jPanel1.setLayout(jPanel1Layout);
                                jPanel1Layout.setHorizontalGroup(
                                                                 jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                 .addGroup(jPanel1Layout.createSequentialGroup()
                                                                           .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                     .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                               .addGap(109, 109, 109)
                                                                                               .addComponent(jLabel1))
                                                                                     .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                               .addGap(75, 75, 75)
                                                                                               .addComponent(itemss, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                           .addContainerGap(69, Short.MAX_VALUE))
                                                                 .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                           .addGap(0, 0, Short.MAX_VALUE)
                                                                           .addComponent(button)
                                                                           .addGap(146, 146, 146))
                                                                 );
                                jPanel1Layout.setVerticalGroup(
                                                               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                               .addGroup(jPanel1Layout.createSequentialGroup()
                                                                         .addGap(29, 29, 29)
                                                                         .addComponent(jLabel1)
                                                                         .addGap(44, 44, 44)
                                                                         .addComponent(itemss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                                                         .addComponent(button)
                                                                         .addGap(41, 41, 41))
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
                                
                                frame3.add(jPanel1);
                                frame3.pack();
                                frame3.setVisible(true);
                            }
                        });
                        
                        
                        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                        jPanel1.setLayout(jPanel1Layout);
                        jPanel1Layout.setHorizontalGroup(
                                                         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                         .addGroup(jPanel1Layout.createSequentialGroup()
                                                                   .addGap(100, 100, 100)
                                                                   .addComponent(jLabel1)
                                                                   .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                   .addContainerGap(74, Short.MAX_VALUE)
                                                                   .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                                       .addComponent(button)
                                                                                       .addGap(112, 112, 112))
                                                                             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                                       .addComponent(items, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                       .addGap(71, 71, 71))))
                                                         );
                        jPanel1Layout.setVerticalGroup(
                                                       jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                       .addGroup(jPanel1Layout.createSequentialGroup()
                                                                 .addGap(33, 33, 33)
                                                                 .addComponent(jLabel1)
                                                                 .addGap(26, 26, 26)
                                                                 .addComponent(items, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                                                 .addComponent(button)
                                                                 .addGap(22, 22, 22))
                                                       );
                        
                        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                        getContentPane().setLayout(layout);
                        layout.setHorizontalGroup(
                                                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                  .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                  );
                        layout.setVerticalGroup(
                                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                          .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                          .addGap(0, 10, Short.MAX_VALUE))
                                                );
                        
                        frame4.add(jPanel1);
                        frame4.pack();
                        frame4.setVisible(true);
                    }
                });
                
                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                                 jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                 .addGroup(jPanel2Layout.createSequentialGroup()
                                                           .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                           .addComponent(jLabel1)
                                                           .addGap(75, 75, 75))
                                                 .addGroup(jPanel2Layout.createSequentialGroup()
                                                           .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                     .addGroup(jPanel2Layout.createSequentialGroup()
                                                                               .addGap(33, 33, 33)
                                                                               .addComponent(choice, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                               .addGap(18, 18, 18)
                                                                               .addComponent(button1))
                                                                     .addGroup(jPanel2Layout.createSequentialGroup()
                                                                               .addGap(149, 149, 149)
                                                                               .addComponent(button2)))
                                                           .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                 );
                jPanel2Layout.setVerticalGroup(
                                               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                               .addGroup(jPanel2Layout.createSequentialGroup()
                                                         .addGap(26, 26, 26)
                                                         .addComponent(jLabel1)
                                                         .addGap(39, 39, 39)
                                                         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                   .addComponent(choice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                   .addComponent(button1))
                                                         .addGap(49, 49, 49)
                                                         .addComponent(button2)
                                                         .addContainerGap(41, Short.MAX_VALUE))
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
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                                         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                         .addGroup(jPanel1Layout.createSequentialGroup()
                                                   .addGap(83, 83, 83)
                                                   .addComponent(jLabel1)
                                                   .addContainerGap(98, Short.MAX_VALUE))
                                         .addGroup(jPanel1Layout.createSequentialGroup()
                                                   .addGap(50, 50, 50)
                                                   .addComponent(button1)
                                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                   .addComponent(button2)
                                                   .addGap(36, 36, 36))
                                         );
        jPanel1Layout.setVerticalGroup(
                                       jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                       .addGroup(jPanel1Layout.createSequentialGroup()
                                                 .addGap(38, 38, 38)
                                                 .addComponent(jLabel1)
                                                 .addGap(56, 56, 56)
                                                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                           .addComponent(button1)
                                                           .addComponent(button2))
                                                 .addContainerGap(50, Short.MAX_VALUE))
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
    /**
     *Γινεται η κράτηση θέσεων στην αίθουσα cinema/theatre
     * @param aithousa
     * @param seats
     * @param rownumber
     * @param bool
     * @param price
     * @param clientname
     * @param number
     * @param show
     * @param hall
     * @param datee
     **/
    public void bookSeats(final String aithousa,int[] seats, int rownumber,final int[] bool, final int price, final String clientname, final String number, final String show, final String hall, final String datee){
        frame5 = new JFrame();
        frame5.setSize(550,500);            
        frame5.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        button = new javax.swing.JButton();
        final ImageIcon icon1 = new ImageIcon(Resources.getURL("red.png"));
        ImageIcon icon2 = new ImageIcon(Resources.getURL("white.png"));
        final ImageIcon icon3 = new ImageIcon(Resources.getURL("blue.png"));
        
        jPanel1.setBackground(Color.WHITE);
        frame5.add(jPanel1, BorderLayout.PAGE_START);
        
        
        jLabel1.setText("Booked         ");
        
        
        jLabel2.setText("Available         ");
        
        
        jLabel3.setText("My Options");
        
        jLabel4.setIcon(icon1);
        
        jLabel5.setIcon(icon2);
        
        jLabel6.setIcon(icon3);
        jPanel1.add(jLabel4);
        jPanel1.add(jLabel1);
        jPanel1.add(jLabel5);
        jPanel1.add(jLabel2);
        jPanel1.add(jLabel6);
        jPanel1.add(jLabel3);
        
        jPanel2.setBackground(Color.BLACK);
        jPanel2.setLayout(new GridLayout(rownumber,10));
        frame5.add(jPanel2, BorderLayout.CENTER);
        int k=0,j;
        for(i=0;i<rownumber;i++){
            int l = seats[i];
            for(j=0;j<l;j++){
                if(bool[k]==1){
                    b[k] = new JToggleButton(icon1);
                    b[k].setIcon(icon1);
                    b[k].setSelectedIcon(icon1);
                    jPanel2.add(b[k]);
                }
                else{
                    b[k] = new JToggleButton(icon2);
                    b[k].setIcon(icon2);
                    b[k].setSelectedIcon(icon3);
                    jPanel2.add(b[k]);
                }
                k++;
            }     
        }
        final int d = k;
        jPanel4.setBackground(Color.WHITE);
        frame5.add(jPanel4, BorderLayout.EAST);
        jPanel5.setBackground(Color.WHITE);
        frame5.add(jPanel5, BorderLayout.WEST);
        
        jPanel3.setBackground(Color.WHITE);
        frame5.add(jPanel3, BorderLayout.PAGE_END);
        
        button.setText("ΠΛΗΡΩΜΗ");
        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frame5.dispose();
                int l=0;
                int[] seatnumber = new int[200];
                for(i=0;i<d;i++){
                    if(b[i].isSelected()){
                        bool[i]= 1; // apothikeuei poies theseis einai kokkines
                        seatnumber[l] = i; //apothikeuei to noumero ths theshs pou egine h krathsh
                        l++; // upologizei posa atoma ekanan krathsh
                    }
                }
                for(Cinema c: cinema){
                          if(c.gethallName().equals(aithousa)){
                                       c.changecheckseats(bool);
                           }
                }
                for(Theatre c: theatre){
                          if(c.gethallName().equals(aithousa)){
                                       c.changecheckseats(bool);
                           }
                }
                JOptionPane.showMessageDialog(f,"To Συνολικό ποσό που πρέπει να πληρώσεις ειναι: "+l*price + "$");
                JOptionPane.showMessageDialog(f,"Η κράτηση έγινε επιτυχώς! Ευχαριστούμε που χρησιμοποιήσατε τις υπηρησίες μας.");
                FileWriter fStream;
                try {
                    fStream = new FileWriter(file, true);
                    fStream.append(clientname);
                    fStream.append(System.getProperty("line.separator"));
                    fStream.append(number);
                    fStream.append(System.getProperty("line.separator"));
                    fStream.append(show);
                    fStream.append(System.getProperty("line.separator"));
                    fStream.append(hall);
                    fStream.append(System.getProperty("line.separator"));
                    for(i=0;i<l;i++){
                             fStream.append("Seat Number:" +seatnumber[i]);
                             fStream.append("  ");
                    }
                    fStream.append(System.getProperty("line.separator"));
                    fStream.append(datee);
                    fStream.append(System.getProperty("line.separator"));
                    fStream.flush();
                    fStream.close();
                } catch (IOException ex) {
                    System.out.println("Δεν δημιουργειται το αρχειο");
                }
            }
        });
        jPanel3.add(button);
        
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                                         jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                   .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                   .addComponent(button)
                                                   .addGap(16, 16, 16))
                                         );
        jPanel3Layout.setVerticalGroup(
                                       jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                       .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                 .addContainerGap(13, Short.MAX_VALUE)
                                                 .addComponent(button)
                                                 .addContainerGap())
                                       );
        frame5.pack();
        frame5.setVisible(true);
        
    }
    
    
    /**
     *Ο απλος χρηστης ακυρωνει την κρατηση
     * @param name
     * @param number
     **/
    public void cancelCheck(String name, String number){
       File filee = new File("test2.txt");
       FileWriter fStreamm;
       i=0;
       String a=" ";
       int[] p = new int[200];
       for(int k=0;k<200;k++){
                   p[k] =0;
       }
       try{
			FileInputStream fis = new FileInputStream(file);
                        BufferedReader in = new BufferedReader(new InputStreamReader(fis));
                        BufferedWriter out = new BufferedWriter(new FileWriter(filee));
			String line;
			while ((line = in.readLine()) != null) {
                            
                            try {
                                if(line.equals(name) || (i >0 && i<6)){
                                    i++;
                                    if(i==4){
                                        a = line;
                                        for(Cinema c: cinema){
                                                if(c.gethallName().equals(a))
                                                    p =c.getcheckseats();
                                                                           
                                        }
                                        for(Theatre c: theatre){
                                                 if(c.gethallName().equals(a))
                                                    p =c.getcheckseats();
                                        }
                                    }
                                    if(i==5){
                                       
                                        String[] parts = line.split("  ");
                                        int token = parts.length;
                                        for(int j=0; j<token; j++){
                                          
                                            String[] parts2 = parts[j].split(":");
                                                
                                               System.out.println(parts2[1]);
                                               int t = Integer.parseInt(parts2[1]);
                                               p[t] = 0;           
                                            }
                                    }
                                }
                                
                                else{
                                    System.out.println(line);
                                    out.write(line);
                                    out.newLine();
                                }
                            
                            } catch (IOException ex) {
                             System.out.println("Δεν δημιουργειται το αρχειο");
                            }
                    }
                    for(Cinema c: cinema){
                        if(c.gethallName().equals(a))
                            c.changecheckseats(p);                      
                        
                    }
                    for(Theatre c: theatre){
                        if(c.gethallName().equals(a))
                            c.changecheckseats(p);
                    }
              in.close();
              out.close();
        } catch (IOException e) {
                        System.out.println("Δεν ανοιγει το αρχειο");
        }
        try{
			FileInputStream fis = new FileInputStream(filee);
                        BufferedReader in = new BufferedReader(new InputStreamReader(fis));
                        BufferedWriter out = new BufferedWriter(new FileWriter(file));
			String line;
			while ((line = in.readLine()) != null) {
                            
                            try {
                                
                                    System.out.println(line);
                                    out.write(line);
                                    out.newLine();
                                
                            
                            } catch (IOException ex) {
                                System.out.println("Δεν ανοιγει το αρχειο");
                            }
                        }
                    
                    
            
              in.close();
              out.close();
              filee.deleteOnExit();
        } catch (IOException e) {
                       System.out.println("Δεν ανοιγει το αρχειο");
        }
       
    }
    
    /**
     *Ο απλος χρηστης αλλαζει την κρατηση
     **/
    public void changeCheck(){
        // TODO code application logic here
    }
    
}

