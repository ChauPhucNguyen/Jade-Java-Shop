package gui;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import store.Store;
import store.Order;
import store.Product;
import store.Donut;
import store.Frosting;
import store.Filling;
import store.Java;
import store.Darkness;
import store.Shot;
import store.Person;
import store.Customer;
import store.Server;

public class MainWin extends JFrame
{

 private final int WIDTH = 800;
 private final int HEIGHT = 600;
    
 protected enum Display {PRODUCTS, PEOPLE, ORDERS};
    
 public MainWin(String title)
 {
  super(title);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setSize(WIDTH, HEIGHT);
        
  JMenuBar menubar = new JMenuBar();
        
  JMenu mFile = new JMenu("File");
  JMenuItem mNew = new JMenuItem("New");
  JMenuItem mOpen = new JMenuItem("Open");
  JMenuItem mSave = new JMenuItem("Save");
  JMenuItem mSaveAs = new JMenuItem("Save As");
  JMenuItem mQuit = new JMenuItem("Quit");
  JMenu mCreate = new JMenu("Create");
  JMenuItem mOrder = new JMenuItem("Order");
  JMenuItem mJava = new JMenuItem("Java");
  JMenuItem mDonut = new JMenuItem("Donut");
  JMenuItem mCustomer = new JMenuItem("Customer");
  JMenuItem mServer = new JMenuItem("Server");
  JMenu mView = new JMenu("View");
  JMenuItem mOrders = new JMenuItem("Orders");
  JMenuItem mProducts = new JMenuItem("Products");
  JMenuItem mPeople = new JMenuItem("People");
  JMenu mHelp = new JMenu("Help");
  JMenuItem mAbout = new JMenuItem("About");
  Jmenu mEdit = new JMenu("Edit");
        
  mNew.addActionListener(event -> onNewClick());
  mOpen.addActionListener(event -> onOpenClick());
  mSave.addActionListener(event -> onSaveClick());
  mSaveAs.addActionListener(event -> onSaveAsClick());
  mQuit.addActionListener(event -> onQuitClick());
  mOrder.addActionListener(event -> onCreateOrderClick());
  mJava.addActionListener(event -> onCreateJavaClick());
  mDonut.addActionListener(event -> onCreateDonutClick());
  mCustomer.addActionListener(event -> onCreateCustomerClick());
  mServer.addActionListener(event -> onCreateServerClick());
  mProducts.addActionListener(event -> updateDisplay(Display.PRODUCTS));
  mPeople.addActionListener(event -> updateDisplay(Display.PEOPLE));
  mOrders.addActionListener(event -> updateDisplay(Display.ORDERS));
  mAbout.addActionListener(event -> onAboutClick());
  mEdit.addActionListen(event -> onEditClick());
  
  
  mFile.add(mNew);
  mFile.add(mOpen);
  mFile.add(mSave);
  mFile.add(mSaveAs);
  mFile.add(mQuit);
  mCreate.add(mJava);
  mCreate.add(mDonut);
  mCreate.add(mCustomer);
  mCreate.add(mServer);
  mView.add(mProducts);
  mView.add(mPeople);
  mHelp.add(mAbout);
        
  menubar.add(mFile);
  menubar.add(mCreate);
  menubar.add(mView);
  menubar.add(mHelp);
  menubar.add(mEdit);
        
  setJMenuBar(menubar);
        
  JToolBar toolbar = new JToolBar("JADE Controls");
  
   private Store store;
   private File filename;
    
    private JLabel data;                   
    private JLabel msg;                     
    private JButton bOrder;                
    private JButton bJava;                
    private JButton bDonut;                
    private JButton bCustomer;            
    private JButton bServer;               
    private JButton bListOrders;           
    private JButton bListProducts;         
    private JButton bListPeople;           

       JButton bNew = new JButton(new ImageIcon("gui/resources/New.png"));
          bNew.setActionCommand("Create new JADE store");
          bNew.setToolTipText("Create new JADE store");
          toolbar.add(bNew);
          bNew.addActionListener(event -> onNewClick());

        JButton bOpen = new JButton(new ImageIcon("gui/resources/Open.png"));
          bOpen.setActionCommand("Open JADE file");
          bOpen.setToolTipText("Open JADE file");
          toolbar.add(bOpen);
          bOpen.addActionListener(event -> onOpenClick());

        JButton bSave = new JButton(new ImageIcon("gui/resources/Save.png"));
          bSave.setActionCommand("Save JADE file");
          bSave.setToolTipText("Save JADE file");
          toolbar.add(bSave);
          bSave.addActionListener(event -> onSaveClick());

        JButton bSaveAs = new JButton(new ImageIcon("gui/resources/saveas.png"));
          bSaveAs.setActionCommand("Save JADE as new file");
          bSaveAs.setToolTipText("Save JADE as new file");
          toolbar.add(bSaveAs);
          bSaveAs.addActionListener(event -> onSaveAsClick());

        toolbar.add(Box.createHorizontalStrut(25));
        
        
        bOrder  = new JButton(new ImageIcon("gui/resources/newOrder.png"));
          bOrder.setActionCommand("Create new Order");
          bOrder.setToolTipText("Place an Order");
          toolbar.add(bOrder);
          bOrder.addActionListener(event -> onCreateOrderClick());

        bJava  = new JButton(new ImageIcon("gui/resources/newjava.png"));
          bJava.setActionCommand("Create new Java");
          bJava.setToolTipText("Create a new coffee selection");
          toolbar.add(bJava);
          bJava.addActionListener(event -> onCreateJavaClick());

        bDonut = new JButton(new ImageIcon("gui/resources/newdonut.png"));
          bDonut.setActionCommand("Create new donut");
          bDonut.setToolTipText("Create a new donut selection");
          toolbar.add(bDonut);
          bDonut.addActionListener(event -> onCreateDonutClick());

        bCustomer = new JButton(new ImageIcon("gui/resources/NewCustomer.png"));
          bCustomer.setActionCommand("Create new customer");
          bCustomer.setToolTipText("Create a new customer");
          toolbar.add(bCustomer);
          bCustomer.addActionListener(event -> onCreateCustomerClick());

        bServer = new JButton(new ImageIcon("gui/resources/NewServer.png"));
          bServer.setActionCommand("Create new server");
          bServer.setToolTipText("Create a new server");
          toolbar.add(bServer);
          bServer.addActionListener(event -> onCreateServerClick());

        toolbar.add(Box.createHorizontalStrut(25));
        
        bListOrders = new JButton(new ImageIcon("gui/resources/Orders.png"));
          bListOrders.setActionCommand("List all orders");
          bListOrders.setToolTipText("List all orders");
          toolbar.add(bListOrders);
          bListOrders.addActionListener(event -> updateDisplay(Display.ORDERS));

        bListProducts = new JButton(new ImageIcon("gui/resources/Products.png"));
          bListProducts.setActionCommand("List all products");
          bListProducts.setToolTipText("List all products");
          toolbar.add(bListProducts);
          bListProducts.addActionListener(event -> updateDisplay(Display.PRODUCTS));

        bListPeople = new JButton(new ImageIcon("gui/resources/Customers.png"));
          bListPeople.setActionCommand("List people");
          bListPeople.setToolTipText("List people");
          toolbar.add(bListPeople);
          bListPeople.addActionListener(event -> updateDisplay(Display.PEOPLE));

        toolbar.add(Box.createHorizontalStrut(25));
        
        JButton bAbout = new JButton(new ImageIcon("gui/resources/About.png"));
          bAbout.setActionCommand("About JADE Manager");
          bAbout.setToolTipText("About JADE Manager");
          toolbar.add(bAbout);
          bAbout.addActionListener(event -> onAboutClick());

        getContentPane().add(toolbar, BorderLayout.PAGE_START);
        
        
        data = new JLabel();
        data.setFont(new Font("SansSerif", Font.BOLD, 12));
        data.setVerticalAlignment(JLabel.TOP);
        add(data, BorderLayout.CENTER);

        
        msg = new JLabel();
        add(msg, BorderLayout.PAGE_END);
        
        
        onNewClick();
        
        
        setVisible(true);        
    }
    
    
    
    protected void onNewClick()
    {
        String storeName = "JADE";
        if(store != null)
        {
            storeName = JOptionPane.showInputDialog(this, "New store name?");
        }
        if(storeName != null)
        {
            store = new Store(storeName);
            filename = new File("Untitled.jade");
        }
        updateDisplay(Display.PRODUCTS);
    }

    protected void onOpenClick()
    {
        final JFileChooser fc = new JFileChooser(filename);
        FileFilter jadeFiles = new FileNameExtensionFilter(NAME + " files", EXT);
        fc.addChoosableFileFilter(jadeFiles);
        fc.setFileFilter(jadeFiles);
        
        int result = fc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            File fname = fc.getSelectedFile();
             
            try (BufferedReader br = new BufferedReader(new FileReader(fname)))
            {
                String magicCookie = br.readLine();
                if(!magicCookie.equals(MAGIC_COOKIE)) 
                    throw new RuntimeException("Not a " + NAME + " file");
                String fileVersion = br.readLine();
                if(!fileVersion.equals(FILE_VERSION)) 
                    throw new RuntimeException(
                        "Incompatible " + NAME + " file format: " + fileVersion);
                
               
                
                Store newStore = new Store(br);
                store = newStore;
                filename = fname;
            } catch (Exception e)
            {
                JOptionPane.showMessageDialog(
                    this, 
                    "Unable to open " + filename + '\n' + e, "Failed",
                    JOptionPane.ERROR_MESSAGE); 
            }
            updateDisplay(Display.PRODUCTS);
        }
    }
    protected void onSaveClick()
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename)))
        {
            bw.write(MAGIC_COOKIE + '\n');
            bw.write(FILE_VERSION + '\n');
            store.save(bw);
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(
                this, 
                "Unable to save " + filename + '\n' + e, "Failed",
                JOptionPane.ERROR_MESSAGE); 
        }
    }

    protected void onSaveAsClick()
    {
        final JFileChooser fc = new JFileChooser(filename);
        FileFilter jadeFiles = new FileNameExtensionFilter(NAME + " files", EXT);
        fc.addChoosableFileFilter(jadeFiles);
        fc.setFileFilter(jadeFiles);
        
        int result = fc.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            File fname = fc.getSelectedFile();
            if(!fname.getAbsolutePath().endsWith("." + EXT))
                fname = new File(fname.getAbsolutePath() + "." + EXT);
            filename = fname; // Success - use new filename!
            onSaveClick();
        }
    }

    protected void onQuitClick()
    {
        dispose();
    }
    
    protected void onCreateOrderClick()
    { 
        try
        {
            ArrayList<Customer> customers = new ArrayList<>();
            ArrayList<Server>   servers = new ArrayList<>();
        
            for(Object p : store.getPeople())
            {
                if(p instanceof Customer) customers.add((Customer) p);
                if(p instanceof Server)   servers.add((Server) p);
            }

            
            JLabel lCustomer = new JLabel("<HTML>Customer</HTML>");
            JComboBox<Object> dCustomer = new JComboBox<>(customers.toArray());
   
         
            JLabel lServer = new JLabel("<HTML><BR/>Server</HTML>");
            JComboBox<Object> dServer = new JComboBox<>(servers.toArray());
        
            Object[] objects =
            {
                lCustomer, dCustomer,
                lServer, dServer
            };
        
            int button = JOptionPane.showConfirmDialog(
                this,
                objects,
                "Begin Order",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );

            if(button != JOptionPane.OK_OPTION) return;

         
            Order newOrder = new Order((Customer) dCustomer.getSelectedItem(), 
                                       (Server)   dServer  .getSelectedItem());
       
       
            JLabel lProducts = new JLabel("<HTML>" 
                                        + newOrder.toString() 
                         + "<BR/><BR/><BR/><BR/><BR/><BR/><BR/><BR/></HTML>");
        
            JSpinner sQuantity = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
            JComboBox<Object> dProducts = new JComboBox<>(store.getProducts());
            JButton bAdd = new JButton("Add");
            bAdd.addActionListener(event ->
            {
                newOrder.addProduct((Integer) sQuantity.getValue(), 
                                    (Product) dProducts.getSelectedItem());
                lProducts.setText("<HTML>" + newOrder.toString() 
                                                     .replaceAll("<",  "&lt;")
                                                     .replaceAll(">",  "&gt;")
                                                     .replaceAll("\n", "<br/>")
                               + "</HTML>");
            });
        
            JPanel productPanel = new JPanel(); 
            productPanel.add(bAdd);
            productPanel.add(sQuantity);
            productPanel.add(dProducts);

            

            Object[] orderObjects =
            {
                lProducts,
                productPanel,
            };
            
            int selection = JOptionPane.showConfirmDialog(
                this,
                orderObjects,
                "Add Products to Order",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );
            
            if(selection != JOptionPane.OK_OPTION) return;

            store.addOrder(newOrder);
            updateDisplay(Display.ORDERS);
        } catch(Exception e)
        {
            msg.setText("Failed to create new Order: " + e.getMessage());
        }
    }

    protected void onCreateJavaClick()
    {  
        try
        {
           
            JLabel lName = new JLabel("Name");
            JTextField dName = new JTextField(20);

           
            JLabel lPrice = new JLabel("<HTML><BR/>Price</HTML>");
            JSpinner dPrice = new JSpinner(new SpinnerNumberModel(4.95, 0.0, 69.69, 0.35));

          
            JLabel lCost = new JLabel("<HTML><BR/>Cost</HTML>");
            JSpinner dCost = new JSpinner(new SpinnerNumberModel(.44, 0.0, 69.69, 0.35));

        
            JLabel lDarkness = new JLabel("<HTML><BR/>Darkness</HTML>");
            JComboBox<Object> dDarkness = new JComboBox<>(Darkness.values());
            
       
            JLabel sShots = new JLabel("<HTML><BR/></HTML>");
            
           
            JPanel shotPanel = new JPanel();
            shotPanel.setLayout(new BoxLayout(shotPanel, BoxLayout.PAGE_AXIS));
            
            JScrollPane scrollingShotPanel = new JScrollPane(shotPanel);
            scrollingShotPanel.setPreferredSize(new Dimension(200,120));
            
            shotPanel.add(new JComboBox<Shot>(Shot.values()));
            shotPanel.add(new JComboBox<Shot>(Shot.values()));
            shotPanel.add(new JComboBox<Shot>(Shot.values()));
            
            JButton addShot = new JButton("Add a Shot");
            addShot.addActionListener(event ->
            {
                shotPanel.add(new JComboBox<Shot>(Shot.values()));
            });
            

            Object[] objects =
            {
                lName,     dName,
                lPrice,    dPrice,
                lCost,     dCost,
                lDarkness, dDarkness,
                sShots,    
                addShot,    scrollingShotPanel,
            };
            
            int button = JOptionPane.showConfirmDialog(
                this,
                objects,
                "New Java",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );
            
            if(button != JOptionPane.OK_OPTION) return;

            String name = dName.getText();
            double price = (double) dPrice.getValue();
            double cost = (double) dCost.getValue();
            Darkness darkness = (Darkness) dDarkness.getSelectedItem();
            Java java = new Java(name, price, cost, darkness);
            
            for(Object o : shotPanel.getComponents())
            {
                if(!(o instanceof JComboBox)) continue; // verify cast will work, then
                @SuppressWarnings("unchecked")          // skip unchecked cast warning
                    JComboBox<Object> cb = (JComboBox<Object>) o;
                Shot shot = (Shot) cb.getSelectedItem();
                if(shot != Shot.None) java.addShot(shot);
            }
            store.addProduct(java);
            updateDisplay(Display.PRODUCTS);
        } catch(Exception e)
        {
            msg.setText("Failed to create new Java: " + e.getMessage());
        }
    }
    
    protected void onCreateDonutClick()
    {  
        try
        {
            JLabel lName = new JLabel("Name");
            JTextField dName = new JTextField(20);

            JLabel lPrice = new JLabel("<HTML><BR/>Price</HTML>");
            JSpinner dPrice = new JSpinner(new SpinnerNumberModel(4.95, 0.0, 69.69, 0.35));

            JLabel lCost = new JLabel("<HTML><BR/>Cost</HTML>");
            JSpinner dCost = new JSpinner(new SpinnerNumberModel(.44, 0.0, 99.99, 0.35));

            JLabel lFrosting = new JLabel("<HTML><BR/>Frosting</HTML>");
            JComboBox<Object> dFrosting = new JComboBox<>(Frosting.values());

            JLabel lFilling = new JLabel("<HTML><BR/>Filling</HTML>");
            JComboBox<Object> dFilling = new JComboBox<>(Filling.values());

            String[] options = {"No Sprinkles", "Sprinkles"};
            JLabel lSprinkles = new JLabel("<HTML><BR/>Sprinkles</HTML>");
            JComboBox<Object> dSprinkles = new JComboBox<>(options);

            Object[] objects =
            {
                lName,      dName,
                lPrice,     dPrice,
                lCost,      dCost,
                lFrosting,  dFrosting,
                lFilling,   dFilling,
                lSprinkles, dSprinkles,
            };
            
            int button = JOptionPane.showConfirmDialog(
                this,
                objects,
                "New Donut",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );
            
            if(button == JOptionPane.OK_OPTION)
            {
                String name = dName.getText();
                double price = (double) dPrice.getValue();
                double cost = (double) dCost.getValue();
                Frosting frosting = (Frosting) dFrosting.getSelectedItem();
                Filling filling = (Filling) dFilling.getSelectedItem();
                boolean sprinkles = (dSprinkles.getSelectedItem() == "Sprinkles");
                store.addProduct(new Donut(name, price, cost, 
                                           frosting, filling, sprinkles));
            }
            updateDisplay(Display.PRODUCTS);
        } catch(Exception e)
        {
            msg.setText("Failed to create new Donut: " + e);
        }
    }
                            
    protected void onCreateCustomerClick()
    {
        JLabel lName = new JLabel("Name");
        JTextField dName = new JTextField(20);

        JLabel lPhone = new JLabel(
            "<HTML><BR/>Phone  <SMALL>(Example: 123-456-7890)</SMALL></HTML>");
        JTextField dPhone = new JTextField(20);

        Object[] objects =
        {
            lName,  dName,
            lPhone,   dPhone,
        };

        final Pattern phoneFormat = Pattern.compile("^(\\d{3})-(\\d{3})-(\\d{4})$");
 
        while(true)
        {
            try
            {
                int button = JOptionPane.showConfirmDialog(
                    this,
                    objects,
                    "New Customer",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );
            
                if(button == JOptionPane.OK_OPTION)
                {
                    String name = dName.getText();
                    String phone = dPhone.getText();
                    if(!phoneFormat.matcher(phone).find())
                        throw new IllegalArgumentException("Invalid Phone: " + phone);
                    store.addPerson(new Customer(name, phone));
                    updateDisplay(Display.PEOPLE);
                }
                break;
            } catch(Exception e)
            {
                JOptionPane.showMessageDialog(this, "Invalid input: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    protected void onCreateServerClick()
    {
        JLabel lName = new JLabel("Name");
        JTextField dName = new JTextField(20);

        JLabel lPhone = new JLabel(
            "<HTML><BR/>Phone  <SMALL>(Example: 123-456-7890)</SMALL></HTML>");
        JTextField dPhone = new JTextField(20);

        JLabel lSSN = new JLabel(
            "<HTML><BR/>SSN  <SMALL>(Example: 123-45-6789)</SMALL></HTML>");
        JTextField dSSN = new JTextField(20);

        Object[] objects =
        {
            lName,  dName,
            lPhone, dPhone,
            lSSN,   dSSN,
        };

        final Pattern phoneFormat = Pattern.compile("^(\\d{3})-(\\d{3})-(\\d{4})$");
        final Pattern ssnFormat   = Pattern.compile("^(\\d{3})-(\\d{2})-(\\d{4})$");
 
        while(true)
        {
            try
            {
                int button = JOptionPane.showConfirmDialog(
                    this,
                    objects,
                    "New Server",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );
            
                if(button == JOptionPane.OK_OPTION)
                {
                    String name = dName.getText();
                    String phone = dPhone.getText();
                    if(!phoneFormat.matcher(phone).find())
                        throw new IllegalArgumentException("Invalid Phone: " + phone);
                    String ssn = dSSN.getText();
                    if(!ssnFormat.matcher(ssn).find())
                        throw new IllegalArgumentException("Invalid SSN: " + ssn);
                    store.addPerson(new Server(name, phone, ssn));
                    updateDisplay(Display.PEOPLE);
                }
                break;
            } catch(Exception e)
            {
                JOptionPane.showMessageDialog(this, "Invalid input: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
         
    protected void onAboutClick()
    {                
        JDialog about = new JDialog();
        about.getContentPane().setLayout(
            new BoxLayout(about.getContentPane(), BoxLayout.PAGE_AXIS));
        about.setTitle("Java and Donut Express");
        about.setSize(640,600);
        
        try
        {
            BufferedImage myPicture = ImageIO.read(new File("gui/resources/About.png"));
            JLabel logo = new JLabel(new ImageIcon(myPicture));
            logo.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            about.add(logo);
        } catch(IOException e)
        {
        }
        
        JLabel title = new JLabel("<html>"
          + "<p><font size=+3>Java and Donut Express</font></p>"
          + "</html>");
        title.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        about.add(title);

        JLabel copyright = new JLabel("<html>"
          + "<p>Version 0.2</p>"
          + "<p>Copyright 2021 by Chau-Phuc Nguyen</p>"
          + "<p>Licensed under Gnu GPL 3.0</p>"
          + "<p>Adopted suggested P10 solution by George Rice</p>"
          + "<br/>"
          + "</html>");
        copyright.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        about.add(copyright);
                    
       JLabel artists = new JLabel("<html>"
          + "<p>About icon by Chau-Phuc Nguyen</p>"
          + "<p>Logo icon by Chau-Phuc Nguyen</p>"
          + "<p>New Customer icon by Chau-Phuc Nguyen</p>"
          + "<p>Orders icon by Chau-Phuc Nguyen</p>"
          + "<p>Save Icon by Chau-Phuc Nguyen</p>"
          + "<p>Donut icon by Chau-Phuc Nguyen</p>"
          + "<p>New java icon by Chau-Phuc Nguyen</p>"
          + "<p>Server icon by Chau-Phuc Nguyen</p>"
          + "<p>New donut icon by Chau-Phuc Nguyen"
          + "<p>Help icon by Vector Stall via the Flat Icon license</p>"
          + "<p>New icon by Chau-Phuc Nguyen</p>"
          + "<p>File icon by Chau-Phuc Nguyen</p>"
          + "<p>Open icon by Chau-Phuc Nguyen</p>"          
          + "<br/>"
          + "</html>");
        artists.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        about.add(artists);

        JButton ok = new JButton("OK");
        ok.setAlignmentX(JButton.CENTER_ALIGNMENT);
        ok.addActionListener(event -> about.setVisible(false));
        about.add(ok);
        
        about.pack();
        about.setVisible(true);
     }

    public static void main(String[] args)
    {
        MainWin myApp = new MainWin("JADE");
        myApp.setVisible(true);
    }
    
    private void updateDisplay(Display display)
    {
        String s = "ERROR: Invalid display request: " + display;
        if(display == Display.PRODUCTS) s = store.toString();
        if(display == Display.PEOPLE)  s = store.peopleToString();
        if(display == Display.ORDERS)  s = store.ordersToString();
        data.setText("<html>" + s.replaceAll("<","&lt;")
                                 .replaceAll(">", "&gt;")
                                 .replaceAll("\n", "<br/>")
                              + "</html>");
    }
}
