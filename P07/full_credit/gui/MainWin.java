import store.Donut;
import store.Java;
import store.Product;
import store.Store;
import java.awt.*;
import javax.swing.*;

public class MainWin extends JFrame
{
 private Store store;
 private JLabel data;
 private JMenu mJava;
 private JButton bJava;
 private JMenuItem mDonut;
 private JButton bDonut;
 
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
  
  about.addActionListener(event -> onAboutClick());
  quit.addActionListener(event -> onQuitClick());
  mDonut.addActionListener(event -> onCreateDonutClick());
  mJava.addActionListener(event -> onCreateJavaClick());
  
  help.add(about);
  file.add(quit);
  create.add(mDonut);
  create.add(mJava);
  
  menubar.add(file);
  menubar.add(create);
  menubar.add(help);
  setJMenuBar(menubar);
  
  JToolBar toolbar = new JToolBar("Navigation");
  bDonut = new JButton(new ImageIcon("newdonut.png");
  bDonut.setActionCommand("Create a new donut order");
  bDonut.setToolTipText("Click to create a new order for donuts");
  toolbar.add(bDonut);
  bDonut.addActionListener(event -> onCreateDonutClick());
  bJava = new JButton(new ImageIcon("newjava.png");
  bJava.setActionCommand("Create a new java order");
  bJava.setToolTipText("Click to create a new order for coffee");
  toolbar.add(bJava);
  bJava.addActionListener(event -> onCreateJavaClick());
  JButton bAbout = new JButton(new ImageIcon("About.png");
  bAbout.setActionCommand("Click for additional info");
  bAbout.setToolTipText("Click to show useful information about JADE EXPRESS");
  toolbar.add(bAbout);
  bAbout.addActionListener(event -> onAboutClick());
  toolbar.add(Box.createHorizontalGlue());
  JButton quitB = new JButton("X");
  quitB.setActionCommand("Quit");
  quitB.setToolTipText("Exit Store");
  quitB.setBorder(null);
  toolbar.add(quitB);
  quitB.addActionListener(event -> onQuitClick());
  toolbar.addSeparator();
  getContentPane().add(toolbar, BorderLayout.PAGE_START);
  status = new JLabel();
  add(status, BorderLayout.PAGE_END);
  setVisible(true);
 }
  
 protected void onCreateJavaClick();
 String name = JOption
 
 protected void onCreateDonutClick();
 
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
  JLabel artist = new JLabel("<html>" + "<p>Version 1.3J</p>" + "<p>Copyright 2017-2020 by Chau-Phuc Nguyen</p>" + "<p>Licensed under Gnu GPL 3.0</p>" + "<p>Logo by Chau-Phuc Nguyen, for personal use</p>" + "<p>Coffee Cup Icon by Chau-Phuc Nguyen, for personal use</p>" + "<p>Donut Icon by Chau-Phuc Nguyen, for personal use</p>" + "<p>About Icon by Chau-Phuc Nguyen, for personal use</p>" + "</html>");
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
  System.exit(0);
 }
 
 public static void main(String[] args)
 {
  MainWin jadeEXPRESS = new Mainwin("JADE EXPRESS");
  jadeEXPRESS.setVisible(true);
 }
