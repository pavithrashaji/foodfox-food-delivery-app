package application;

import java.io.IOException;
import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Node;


public class ProfilePageController {

	String cid, fname, lname, phone, email, location, username, orderno, foodno, pswd;
	int pts;
	Connection con1;
	PreparedStatement ps1;
	ResultSet rs1;
	
	ObservableList<String> locationList = FXCollections
			.observableArrayList("Karikode","Thangassery","Chinnakada","Town Limit","Polayathode","Kadappakada");
	

	
	@FXML
    private Label mb1, mb2, ptspswd;
	@FXML
	private GridPane editgrid;
	@FXML
	private ChoiceBox locationBox;
	@FXML
	private TextField textfname,textlname,textuname,textphone,textmail,textloc,textpswd;
	
	public void getID(String id, String a,String b,String c,String d,String e,String f,int g)
	{
		cid = id;
	    fname = a;
	    lname = b;
	    phone = c;
	    email = d;
	    location = e;
	    username = f;
	    pts = g;
	    mb1.setText("  Hello, "+fname+" "+lname+"  ");
	    mb2.setText("  Hello, "+fname+" "+lname+"  ");
	    fnamelabel.setText(fname);
		lnamelabel.setText(lname);
		unamelabel.setText(username);
		conlabel.setText(phone);
		maillabel.setText(email);
		loclabel.setText(location);
		textfname.setText(fname);
	    textlname.setText(lname);
		textuname.setText(username);
		textphone.setText(phone);
		textmail.setText(email);
		locationBox.setValue(location);
		String spts = ""+pts;
		ptslabel.setText(spts);
		 
		try
	    	{
	    		 Class.forName("com.mysql.cj.jdbc.Driver");
	    		 con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodfoxdatabase","root","chimera");
	 
	    		 ps1=con1.prepareStatement("select * from OrderDetails where CID=? order by OrderID desc limit 1");
	    		 ps1.setString(1,cid);
	    		 rs1=ps1.executeQuery();
	    		 while(rs1.next())
	    		 {
	    			 rlabel.setText(rs1.getString(3));
	    			 falabel.setText("Rs. " + rs1.getString(4));
	    			 eptslabel.setText(rs1.getString(5));
	    			 dloclabel.setText(rs1.getString(6));
	    			 orderno = rs1.getString(2);
	    			 System.out.println(orderno);
	    		 }
	    		 
	    		 for(int i=1; i<=10; i++)
	    		 {
	    			 foodno = orderno + "F" + i;
	    			 //String query = "select * from Order1 where CID=? and OID=? and FoodID=?";
	    			 ps1=con1.prepareStatement("select * from Order1 where CID=? and OID=? and FoodID=?");
	    			 ps1.setString(1,cid);
	    			 ps1.setString(2,orderno);
	    			 ps1.setString(3,foodno);
	    			 rs1=ps1.executeQuery();
	    			 
	    			 if(i==1)
	    			 {
	    				 while(rs1.next())
	        			 {
	        				 fl1.setText(rs1.getString(4));
	        				 q1.setText(rs1.getString(5));
	        				 a1.setText(rs1.getString(6));
	        			 } 
	    			 }
	    			 
	    			 else if(i==2)
	    			 {
	    				 while(rs1.next())
	        			 {
	        				 fl2.setText(rs1.getString(4));
	        				 q2.setText(rs1.getString(5));
	        				 a2.setText(rs1.getString(6));
	        			 } 
	    			 }
	    			 
	    			 else if(i==3)
	    			 {
	    				 while(rs1.next())
	        			 {
	        				 fl3.setText(rs1.getString(4));
	        				 q3.setText(rs1.getString(5));
	        				 a3.setText(rs1.getString(6));
	        			 } 
	    			 }
	    			 
	    			 else if(i==4)
	    			 {
	    				 while(rs1.next())
	        			 {
	        				 fl4.setText(rs1.getString(4));
	        				 q4.setText(rs1.getString(5));
	        				 a4.setText(rs1.getString(6));
	        			 } 
	    			 }
	    			 
	    			 else if(i==5)
	    			 {
	    				 while(rs1.next())
	        			 {
	        				 fl5.setText(rs1.getString(4));
	        				 q5.setText(rs1.getString(5));
	        				 a5.setText(rs1.getString(6));
	        			 } 
	    			 }
	    			 
	    			 else if(i==6)
	    			 {
	    				 while(rs1.next())
	        			 {
	        				 fl6.setText(rs1.getString(4));
	        				 q6.setText(rs1.getString(5));
	        				 a6.setText(rs1.getString(6));
	        			 } 
	    			 }
	    			 
	    			 else if(i==7)
	    			 {
	    				 while(rs1.next())
	        			 {
	        				 fl7.setText(rs1.getString(4));
	        				 q7.setText(rs1.getString(5));
	        				 a7.setText(rs1.getString(6));
	        			 } 
	    			 }
	    			 
	    			 else if(i==8)
	    			 {
	    				 while(rs1.next())
	        			 {
	        				 fl8.setText(rs1.getString(4));
	        				 q8.setText(rs1.getString(5));
	        				 a8.setText(rs1.getString(6));
	        			 } 
	    			 }
	    			 
	    			 else if(i==9)
	    			 {
	    				 while(rs1.next())
	        			 {
	        				 fl9.setText(rs1.getString(4));
	        				 q9.setText(rs1.getString(5));
	        				 a9.setText(rs1.getString(6));
	        			 } 
	    			 }
	    			 
	    			 else if(i==10)
	    			 {
	    				 while(rs1.next())
	        			 {
	        				 fl10.setText(rs1.getString(4));
	        				 q10.setText(rs1.getString(5));
	        				 a10.setText(rs1.getString(6));
	        			 } 
	    			 }
	    			 
	    		 }
	    		 
	    	}
	    	catch(ClassNotFoundException | SQLException ex)
	        {
	    		System.out.println("Connection failed");
	    		System.out.println(ex);
	        }
		 
	}	

    @FXML
    private Button homebtn;

    @FXML
    private Label save, editlabel;
    
    @FXML
    private Button editbtn;
    
    @FXML
    private Button bsave;
    
    @FXML
    private Button searchbtn;

    @FXML
    private Button accountbtn;

    @FXML
    private Button cartbtn;

    @FXML
    private Button logout;
    
    @FXML
    private Label fnamelabel;
    
    @FXML
    private Label lnamelabel, unamelabel, conlabel, maillabel, loclabel, ptslabel;
    
    @FXML
    private Label rlabel, falabel, eptslabel, dloclabel;
    
    @FXML
    private Label fl1, fl2, fl3, fl4, fl5, fl6, fl7, fl8, fl9, fl10;
    
    @FXML
    private Label q1, q2, q3, q4, q5, q6, q7, q8, q9, q10;
    
    @FXML
    private Label a1, a2, a3, a4, a5, a6, a7, a8, a9, a10;
    
    

    @FXML
    void editprofile(ActionEvent event) {
    	editgrid.setVisible(true);
    	save.setVisible(true);
    	bsave.setDisable(false);
    	editbtn.setDisable(true);
    	bsave.setVisible(true);
    	editbtn.setVisible(false);
    	editlabel.setVisible(false);
    	ptspswd.setText("Password :    ");
    }
    
    @FXML
    void savechanges(ActionEvent event) {
    	editgrid.setVisible(false);
    	save.setVisible(false);
    	bsave.setDisable(true);
    	editbtn.setDisable(false);
    	bsave.setVisible(false);
    	editbtn.setVisible(true);
    	editlabel.setVisible(true);
    	ptspswd.setText("Points :    ");
    	fname = textfname.getText();
	    lname = textlname.getText();
		username = textuname.getText();
		phone = textphone.getText();
		email = textmail.getText();
		pswd = textpswd.getText();
		location=(String)locationBox.getValue();
		fnamelabel.setText(fname);
		lnamelabel.setText(lname);
		unamelabel.setText(username);
		conlabel.setText(phone);
		maillabel.setText(email);
		loclabel.setText(location);
		mb1.setText("  Hello, "+fname+" "+lname+"  ");
	    mb2.setText("  Hello, "+fname+" "+lname+"  ");
	    try
	    {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodfoxdatabase","root","chimera");
	    	
	    	if(pswd.equals(""))
	    	{
	    		ps1=con1.prepareStatement("update Customer set CFName=?, CLName=?, CNumber=?, CMail=?, CLocation=?, CUser=? where CID = ?");
	    		ps1.setString(1,fname);
	    		ps1.setString(2,lname);
	    		ps1.setString(3,phone);
	    		ps1.setString(4,email);
	    		ps1.setString(5,location);
	    		ps1.setString(6,username);
	    		ps1.setString(7,cid);
	    		ps1.execute();
	    	}
	    	else
	    	{
	    		ps1=con1.prepareStatement("update Customer set CFName=?, CLName=?, CNumber=?, CMail=?, CLocation=?, CUser=?, CPswd=? where CID = ?");
	    		ps1.setString(1,fname);
	    		ps1.setString(2,lname);
	    		ps1.setString(3,phone);
	    		ps1.setString(4,email);
	    		ps1.setString(5,location);
	    		ps1.setString(6,username);
	    		ps1.setString(7, pswd);
	    		ps1.setString(8,cid);
	    		ps1.execute();
	    	}
	    }
	    catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    }
    	
    }
    
    
    @FXML
    void cartbtn(ActionEvent event) {
        try
        {
        	FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/application/cart.fxml"));
            Parent root=loader.load();
   	 Stage arg0=(Stage) ((Node)event.getSource()).getScene().getWindow();
   	 
   	CartController controller=loader.getController();
    controller.getID(cid, fname, lname, phone, email, location, username, pts);
    
   	 
	 arg0.setTitle("FoodFox"); //arg0 is the primary stage
	 Scene scene=new Scene(root,1300,700);
         scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
         arg0.setScene(scene);
         arg0.setResizable(false);
	 arg0.show();
        }
        catch(IOException e) 
        {
			e.printStackTrace();
	}
    }
    
    @FXML
    void homebtn(ActionEvent event) {
        try
        {
        	FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/application/HomePageScene.fxml"));
            Parent root=loader.load();
   	 Stage arg0=(Stage) ((Node)event.getSource()).getScene().getWindow();
   	 
   	HomePageSceneController controller=loader.getController();
    controller.getID(cid, fname, lname, phone, email, location, username, pts);
    
   	 
	 arg0.setTitle("FoodFox"); //arg0 is the primary stage
	 Scene scene=new Scene(root,1300,700);
         scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
         arg0.setScene(scene);
         arg0.setResizable(false);
	 arg0.show();
        }
        catch(IOException e) 
        {
			e.printStackTrace();
	}
    }
    
    @FXML
    public void initialize()
    {
    	bsave.setDisable(true);
    	bsave.setVisible(false);
    	locationBox.setItems(locationList);
    }

    @FXML
    void logout(ActionEvent event) {
        try
        {
        	FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/application/login.fxml"));
            Parent root=loader.load();
   	 Stage arg0=(Stage) ((Node)event.getSource()).getScene().getWindow();
	 arg0.setTitle("FoodFox"); //arg0 is the primary stage
	 Scene scene=new Scene(root,1300,700);
         scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
         arg0.setScene(scene);
         arg0.setResizable(false);
	 arg0.show();
        }
        catch(IOException e) 
        {
			e.printStackTrace();
	}	
    }  

}