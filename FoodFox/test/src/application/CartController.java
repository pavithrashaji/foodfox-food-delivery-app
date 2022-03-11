package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author meemu
 */
public class CartController implements Initializable {

	String cid, fname, lname, phone, email, location, username, orderno, foodno;
	int pts;
    @FXML
    private Button accountbtn;
    @FXML
    private Button cartbtn;
    @FXML
    private Button confirm, cancel;
    @FXML
    private Button logout;
     @FXML
    private Label orderitem1;

    @FXML
    private Label orderitem2;

    @FXML
    private Label orderitem3;

    @FXML
    private Label orderitem4;
    
    @FXML
    private ChoiceBox locationBox;
    
    @FXML
    private Label fl1, fl2, fl3, fl4, fl5, fl6, fl7, fl8, fl9, fl10;
    
    @FXML
    private Label q1, q2, q3, q4, q5, q6, q7, q8, q9, q10;
    
    @FXML
    private Label a1, a2, a3, a4, a5, a6, a7, a8, a9, a10;
    
    @FXML
    private Label rlabel, falabel, eptslabel, lcancel;
    
    /**
     * Initializes the controller class.
     */
    ObservableList<String> locationList = FXCollections
			.observableArrayList("Karikode","Thangassery","Chinnakada","Town Limit","Polayathode","Kadappakada");
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        locationBox.setItems(locationList);
        
    }
    
	Connection con1, con2;
	PreparedStatement ps1, ps2;
	ResultSet rs1, rs2;
	
	@FXML
        private Label mb, ptslabel;
	float sum=0;
        int points=0;
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
	    locationBox.setValue(location);
	    mb.setText("Hello, "+fname);
	    ptslabel.setText("Points : "+pts);
	    
	    try
	    	{
	    		 Class.forName("com.mysql.cj.jdbc.Driver");
	    		 con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodfoxdatabase","root","chimera");
	    		 ps1=con1.prepareStatement("select * from Order1 where CID=? order by OID desc limit 1");
	    		 ps1.setString(1,cid);
	    		 rs1=ps1.executeQuery();
	    		 if(rs1.next())
                         {
	    			 
                                 orderno = rs1.getString(2);
                                 System.out.println(orderno);
        
                         }	
	    		 
	    		 for(int i=1; i<=10; i++)
	    		 {
	    			 foodno = orderno + "F" + i;
	    			 //String query = "select * from Order1 where CID=? and OID=? and FoodID=?";
	    			 ps1=con1.prepareStatement("select * from Order1 where CID=? and OID=? and FoodID=? order by OID desc limit 1");
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
                             sum=sum+rs1.getFloat(6);
	        			 } 
	    			 }
	    			 
	    			 else if(i==2)
	    			 {
	    				 while(rs1.next())
	        			 {
	        				 fl2.setText(rs1.getString(4));
	        				 q2.setText(rs1.getString(5));
	        				 a2.setText(rs1.getString(6));
                             sum=sum+rs1.getFloat(6);
	        			 } 
	    			 }
	    			 
	    			 else if(i==3)
	    			 {
	    				 while(rs1.next())
	        			 {
	        				 fl3.setText(rs1.getString(4));
	        				 q3.setText(rs1.getString(5));
	        				 a3.setText(rs1.getString(6));
                             sum=sum+rs1.getFloat(6);
	        			 } 
	    			 }
	    			 
	    			 else if(i==4)
	    			 {
	    				 while(rs1.next())
	        			 {
	        				 fl4.setText(rs1.getString(4));
	        				 q4.setText(rs1.getString(5));
	        				 a4.setText(rs1.getString(6));
                             sum=sum+rs1.getFloat(6);
	        			 } 
	    			 }
	    			 
	    			 else if(i==5)
	    			 {
	    				 while(rs1.next())
	        			 {
	        				 fl5.setText(rs1.getString(4));
	        				 q5.setText(rs1.getString(5));
	        				 a5.setText(rs1.getString(6));
                             sum=sum+rs1.getFloat(6);
	        			 } 
	    			 }
	    			 
	    			 else if(i==6)
	    			 {
	    				 while(rs1.next())
	        			 {
	        				 fl6.setText(rs1.getString(4));
	        				 q6.setText(rs1.getString(5));
	        				 a6.setText(rs1.getString(6));
                             sum=sum+rs1.getFloat(6);
	        			 } 
	    			 }
	    			 
	    			 else if(i==7)
	    			 {
	    				 while(rs1.next())
	        			 {
	        				 fl7.setText(rs1.getString(4));
	        				 q7.setText(rs1.getString(5));
	        				 a7.setText(rs1.getString(6));
                             sum=sum+rs1.getFloat(6);
	        			 } 
	    			 }
	    			 
	    			 else if(i==8)
	    			 {
	    				 while(rs1.next())
	        			 {
	        				 fl8.setText(rs1.getString(4));
	        				 q8.setText(rs1.getString(5));
	        				 a8.setText(rs1.getString(6));
                             sum=sum+rs1.getFloat(6);
	        			 } 
	    			 }
	    			 
	    			 else if(i==9)
	    			 {
	    				 while(rs1.next())
	        			 {
	        				 fl9.setText(rs1.getString(4));
	        				 q9.setText(rs1.getString(5));
	        				 a9.setText(rs1.getString(6));
                             sum=sum+rs1.getFloat(6);
	        			 } 
	    			 }
	    			 
	    			 else if(i==10)
	    			 {
	    				 while(rs1.next())
	        			 {
	        				 fl10.setText(rs1.getString(4));
	        				 q10.setText(rs1.getString(5));
	        				 a10.setText(rs1.getString(6));
                             sum=sum+rs1.getFloat(6);
	        			 } 
	    			 }
	    			 
	    		 }
                         falabel.setText("Rs. "+sum);
                         points=(int) Math.floor(sum/10);
                         eptslabel.setText(""+points);
                         rlabel.setText("Pizza Hut");
                         if(sum == 0)
                         {
                        	    rlabel.setText(" -- ");
                        	    falabel.setText(" -- ");
                        	    eptslabel.setText(" -- ");
                        	    confirm.setDisable(true);
               				 	confirm.setText("   N O   O R D E R S   P L A C E D   "); 
               				 	lcancel.setVisible(true);
                         }
                         
	    		 
	    	}
	    	catch(ClassNotFoundException | SQLException ex)
	        {
	    		System.out.println("Connection failed");
	    		System.out.println(ex);
	        }
	    try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodfoxdatabase","root","chimera");
    		ps1=con1.prepareStatement("select * from OrderDetails where CID=? order by OrderID desc limit 1");
    		ps1.setString(1,cid);
    		rs1 = ps1.executeQuery();
    		while(rs1.next())
    		{
    			if(orderno.equals(rs1.getString(2)))
    			{
				 confirm.setDisable(true);
				 confirm.setText("   O R D E R   C O N F I R M E D   "); 
				 lcancel.setVisible(true);
				 cancel.setDisable(true);
    			}
    		}
    	}
    	catch(Exception ex)
        {
            ex.printStackTrace();
        }
		 
	}	


    @FXML
    private void accountbtn(ActionEvent event) {
        try
     {
         FXMLLoader loader=new FXMLLoader();
         loader.setLocation(getClass().getResource("/application/ProfilePage.fxml"));
         
         Parent root=loader.load();
	 Stage arg0=(Stage) ((Node)event.getSource()).getScene().getWindow();
         
         arg0.setTitle("FoodFox");
         ProfilePageController controller=loader.getController();
         controller.getID(cid, fname, lname, phone, email, location, username, pts);
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
    private void logout(ActionEvent event) {
        try
        {
         FXMLLoader loader=new FXMLLoader();
         loader.setLocation(getClass().getResource("/application/login.fxml"));
         
         Parent root=loader.load();
	 Stage arg0=(Stage) ((Node)event.getSource()).getScene().getWindow();
         
         arg0.setTitle("FoodFox");
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
    private void homebtn(ActionEvent event) {
        try
        {
         FXMLLoader loader=new FXMLLoader();
         loader.setLocation(getClass().getResource("/application/HomePageScene.fxml"));
         
         Parent root=loader.load();
	 Stage arg0=(Stage) ((Node)event.getSource()).getScene().getWindow();
         
         HomePageSceneController controller=loader.getController();
         controller.getID(cid, fname, lname, phone, email, location, username, pts);
         arg0.setTitle("FoodFox");
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
    private void cancelorder(ActionEvent event) {
    	try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodfoxdatabase","root","chimera");
    		ps1=con1.prepareStatement("delete from Order1 where OID=?");
    		ps1.setString(1,orderno);
    		ps1.execute();
    	}
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
        try
        {
         FXMLLoader loader=new FXMLLoader();
         loader.setLocation(getClass().getResource("/application/SelectionPageScene.fxml"));
         
         Parent root=loader.load();
         Stage arg0=(Stage) ((Node)event.getSource()).getScene().getWindow();
         
         SelectionPageSceneController controller=loader.getController();
         controller.getID(cid, fname, lname, phone, email, location, username, pts);
         arg0.setTitle("FoodFox");
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
    private void gotofp(ActionEvent event) {
        try
	    	{
				 Class.forName("com.mysql.cj.jdbc.Driver");
	    		 con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodfoxdatabase","root","chimera");
				 ps2=con2.prepareStatement("insert into OrderDetails values(?,?,?,?,?,?)");
	    		 ps2.setString(1,cid);
	             ps2.setString(2,orderno);
	             ps2.setString(3,"Pizza Hut");
	             ps2.setString(4,""+sum);
	             ps2.setString(5,""+points);
	             ps2.setString(6,(String)locationBox.getValue());
	             ps2.execute();
	             
	             ps2=con2.prepareStatement("select * from Customer where CID=?");
	             ps2.setString(1,cid);     
	    		 rs2 = ps2.executeQuery();
	    		 while(rs2.next())
	    		 {
	    			 pts = points + rs2.getInt(7);	 
	    		 }
	    		 
	    		 ps2=con2.prepareStatement("update Customer set CPoints=? where CID=?");
	             ps2.setInt(1,pts);
	             ps2.setString(2,cid);
	             ps2.execute();		     
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        try
        {
         FXMLLoader loader=new FXMLLoader();
         loader.setLocation(getClass().getResource("/application/FinalPage.fxml"));
         
         Parent root=loader.load();
	 Stage arg0=(Stage) ((Node)event.getSource()).getScene().getWindow();
         
         FinalPageController controller=loader.getController();
         controller.getID(cid, fname, lname, phone, email, location, username, pts);
         arg0.setTitle("FoodFox");
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