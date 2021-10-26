import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import javax.swing.JToolBar;
import javax.swing.JButton;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import store.Frosting;
import store.Filling;
import store.Darkness;
import store.Shot;
import store.Store;
import store.Donut;
import store.Java;
import store.Product;

package gui;

public class MainWin extends JFrame
{
 private Store store;
 private File filename;
 private JLabel data;
 private JMenuItem mJava;
 private JButton bJava;
 private JMenuItem mDonut;
 private JButton bDonut;
 private JmenuItem mNew;
 private JButton bNew;
 private JmenuItem mOpen;
 private JButton bOpen;
 private JmenuItem mSave;
 private JButton bSave;
 private JmenuItem mSaveAs;
 private JButton bSaveAs;
 
 public Mainwin(String mainWindowTitle)
 {
  super(mainWindowTitle);
  store = new Store("JADE EXPRESS");
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setSize(400,200);
  
  JMenuBar menubar = new JmenuBar();
  JMenu file = new Jmenu("file");
  JmenuItem about = new JMenuItem("about");
  JMenuItem quit = new JmenuItem("quit");
  JmenuItem help = new JmenuItem("help");
  JmenuItem create = JMenu("create");
  mDonut = new JMenuItem("Donut");
  mJava = new JMenuItem("Java");
  JmenuItem aNew = new JmenuItem("new");
  JmenuItem save = new JmenuItem("save");
  JmenuItem open = new JmenuItem("open");
  JmenuItem saveAs = new JmenuItem("save as");
  
  
  about.addActionListener(event -> onAboutClick());
  quit.addActionListener(event -> onQuitClick());
  mDonut.addActionListener(event -> onCreateDonutClick());
  mJava.addActionListener(event -> onCreateJavaClick());
  aNew.addActionListener(event -> onANewClick());
  save.addActionListener(event -> onSaveClick());
  open.addActionListener(event -> onOpenClick());
  saveAs.addActionListener(event -> onSaveAsClick());
  
  help.add(about);
  file.add(quit);
  create.add(mDonut);
  create.add(mJava);
  file.add(mNew);
  file.add(mSave);
  file.add(mOpen);
  file.add(mSaveAs);
  
  menubar.add(file);
  menubar.add(create);
  menubar.add(help);
  setJMenuBar(menubar);
  
        bJava = new JButton(new ImageIcon("gui/resources/new_java.png"));
          bJava.setActionCommand("Create new Java");
          bJava.setToolTipText("Create a new coffee selection");
          toolbar.add(bJava);
          bJava.addActionListener(event -> onCreateJavaClick());

        bDonut = new JButton(new ImageIcon("gui/resources/new_donut.png"));
          bDonut.setActionCommand("Create new donut");
          bDonut.setToolTipText("Create a new donut selection");
          toolbar.add(bDonut);
          bDonut.addActionListener(event -> onCreateDonutClick());

        JButton bAbout = new JButton(new ImageIcon("gui/resources/about.png"));
          bAbout.setActionCommand("About JADE Manager");
          bAbout.setToolTipText("About JADE Manager");
          toolbar.add(bAbout);
          bAbout.addActionListener(event -> onAboutClick());
          
        bNew = new JButton(new ImageIcon("gui/resources/New.png"));
          bNew.setActionCommand("Create new store");
          bNew.setToolTipText("Create a new store with new orders");
          toolbar.add(bNew);
          bNew.addActionListener(event -> onANewClick());
        
        bOpen = new JButton(new ImageIcon("gui/resources/Open.png"));
          bOpen.setActionCommand("Open store file");
          bOpen.setToolTipText("Opens a store file");
          toolbar.add(bOpen);
          bOpen.addActionListener(event -> onOpenClick());
        
        bSave = new JButton(new ImageIcon("gui/resources/Save.png"));
          bSave.setActionCommand("Save file");
          bSave.setToolTipText("saves current store file");
          toolbar.add(bSave);
          bSave.addActionListener(event -> onSaveClick());
        
        bSaveAs = new JButton(new ImageIcon("gui/resources/saveas.png"));
          bSaveAs.setActionCommand("Open store file");
          bSaveAs.setToolTipText("Opens a store file");
          toolbar.add(bSaveAs);
          bSaveAs.addActionListener(event -> onSaveAsClick());
          

        getContentPane().add(toolbar, BorderLayout.PAGE_START);
        
        data = new JLabel();
        data.setFont(new Font("SansSerif", Font.BOLD, 12));
        add(data, BorderLayout.CENTER);
        msg = new JLabel();
        add(msg, BorderLayout.PAGE_END);
        updateDisplay();
        setVisible(true);
 }
 
 protected void onANewClick()
 {
  int input = JOptionPane.showConfirmDialog(null, "THIS WILL DELETE ALL YOUR CURRENT DATA, DO YOU WISH TO CONTINUE?",    JOptionPane.YES_NO_OPTION);
  if (input == JOptionPane.YES_OPTION)
  {
   store = new Store("JADE EXPRESS");
   updateDisplay();
  }
 }
 
 protected void onOpenClick()
 {        
  JFileChooser fc = new JFileChooser(filename); 
  FileFilter storeFiles = new FileNameExtensionFilter("JADE EXPRESS files", "JADE");
  fc.addChoosableFileFilter(storeFiles);           
  fc.setFileFilter(storeFiles);                   
        
  int result = fc.showOpenDialog(this);         
  if (result == JFileChooser.APPROVE_OPTION)
  {   
   filename = fc.getSelectedFile(); 
  }
 }
            
 protected void onSaveAsClick()
 {                      
  final JFileChooser fc = new JFileChooser(filename);   
  FileFilter storeFiles = new FileNameExtensionFilter("JADE EXPRESS files", "JADE");
  fc.addChoosableFileFilter(storeFiles);                  
  fc.setFileFilter(storeFiles);                           
        
  int result = fc.showSaveDialog(this);                
  if (result == JFileChooser.APPROVE_OPTION)
  {          
   filename = fc.getSelectedFile();                  
   if(!filename.getAbsolutePath().endsWith(".jade"))  
   filename = new File(filename.getAbsolutePath() + ".nim");
   onSaveGameClick();                                
  }
 }
 
 
 
 protected void onCreateJavaClick()
 {
  try {
            String name = getString("Java name?");
            double price = getDouble("Price?");
            double cost = getDouble("Cost?");
            Darkness darkness = (Darkness) selectFromArray("Darkness?", Darkness.values());
            Java java = new Java(name, price, cost, darkness);
            while(true) {
                Shot shot = (Shot) selectFromArray("Shot?", Shot.values());
                if(shot.equals(Shot.None)) break;
                java.addShot(shot);
            }
            store.addProduct(java);
            updateDisplay();
        } catch (CancelDialogException e) { // ignore a Cancel
        } catch(Exception e) {
            msg.setText("Failed to create new Java: " + e.getMessage());
        }
    }
 
 
 protected void onCreateDonutClick()
 {
  try {
            String name = getString("Donut name?");
            double price = getDouble("Price?");
            double cost = getDouble("Cost?");
            Frosting frosting = (Frosting) selectFromArray("Select a Frosting", Frosting.values());
            Filling filling = (Filling) selectFromArray("Select a Filling", Filling.values());
            String[] options = {"No Sprinkles", "Sprinkles"};
            boolean sprinkles = (JOptionPane.showOptionDialog(this, "Sprinkles?", "", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]) == 1);
            store.addProduct(new Donut(name, price, cost, frosting, filling, sprinkles));
            updateDisplay();
        } catch (CancelDialogException e) { // ignore a Cancel
        } catch(Exception e) {
            msg.setText("Failed to create new Donut: " + e);
        }
    }
 
 protected void onAboutClick()
 {
  JDialog about = new JDialog();
  about.setLayout(new FlowLayout());
  about.setTitle("JADE EXPRESS");
  BufferedImage myPicture = ImageIO.read(new File("Logo.png"));
  JLabel logo = new JLabel(new ImageIcon(myPicture));
  about.add(logo);
  
  JLabel title = newJLabel("<html>" + "<p><font size=+4>Java and Donut Express</font></p>" + "</html>");
  about.add(title);
  JLabel artist = new JLabel("<html>" + "<p>Version 1.3J</p>" + "<p>Copyright 2017-2020 by Chau-Phuc Nguyen</p>" + "<p>Licensed under Gnu GPL 3.0</p>" + "<p>Logo by Chau-Phuc Nguyen, for personal use</p>" + "<p>Coffee Cup Icon by Chau-Phuc Nguyen, for personal use</p>" + "<p>Donut Icon by Chau-Phuc Nguyen, for personal use</p>" + "<p>About Icon by Chau-Phuc Nguyen, for personal use</p>" + "<p>New Icon by Chau-Phuc Nguyen, for personal use</p>" + "<p>Open Icon by Chau-Phuc Nguyen, for personal use</p>" + "<p>Save Icon by Chau-Phuc Nguyen, for personal use</p>" + "<p>Save As Icon by Chau-Phuc Nguyen, for personal use</p>" + "</html>");
  about.add(artist);
  JButton ok = new JButton("OK");
  ok.addActionListener(new ActionListener()
  {
   public void actionPerformed(Action Event e)
   {
    about.setVisible(false);
   }
  });
  about.add(ok);
  aboutInfo.setSize(450,200);
  about.setVisible(true);
 }
 
 protected void onQuitClick()
 {
  dispose();
 }
 
 public static void main(String[] args)
 {
  MainWin jadeEXPRESS = new Mainwin("JADE EXPRESS");
  jadeEXPRESS.setVisible(true);
 }
 
 private void updateDisplay() {
        data.setText("<html>" + store.toString()
                                     .replaceAll("<","&lt;")
                                     .replaceAll(">", "&gt;")
                                     .replaceAll("\n", "<br/>")
                              + "</html>");
    }
    
 protected class CancelDialogException extends Exception {
        public CancelDialogException() {
            super("Dialog canceled");
        }
    }
    private String getString(String prompt) throws CancelDialogException {
        String newPrompt = prompt;
        while(true) {
            try {
                newPrompt = JOptionPane.showInputDialog(this, newPrompt);
                if(newPrompt == null || newPrompt.length() == 0) 
                    throw new CancelDialogException();
                break;
            } catch (CancelDialogException e) {
                throw e;  // Rethrow to signal Cancel was clicked
            } catch (Exception e) {
                newPrompt = "ERROR: Invalid string '" + newPrompt + "\n" + prompt;
            }
        }
        return newPrompt;
    }
    
    private double getDouble(String prompt) throws CancelDialogException {
        String newPrompt = prompt;
        double result = 0.0;
        while(true) {
            try {
                newPrompt = JOptionPane.showInputDialog(this, newPrompt);
                if(newPrompt == null) throw new CancelDialogException();
                result = Double.parseDouble(newPrompt);
                break;
            } catch (CancelDialogException e) {
                throw e;  // Rethrow to signal Cancel was clicked
            } catch (Exception e) {
                newPrompt = "ERROR: Invalid double '" + newPrompt + "\n" + prompt;
            }
        }
        return result;
    }
    
    private Object selectFromArray(String prompt, Object[] options) throws CancelDialogException {
        JComboBox<Object> comboEnum = new JComboBox<>();
        comboEnum.setModel(new DefaultComboBoxModel<Object>(options));
        int button = JOptionPane.showConfirmDialog(this, comboEnum, prompt, 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(button == JOptionPane.CANCEL_OPTION) throw new CancelDialogException();
        return comboEnum.getSelectedItem();
    }
