package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FinalPageController {
	@FXML
	private Label restnameLabel;
	@FXML
	private Label deliveryagentLabel;
	@FXML
	private Label arrivinginLabel;
	@FXML
	private Label pointsearnedLabel;
        @FXML
	private Label orderlocLabel;
	@FXML
	private Button logout;
	@FXML
	private Label mb, ptslabel;

	// Event Listener on Button[#logout].onAction
        String cid, fname, lname, phone, email, location, username;
        int pts;
        Connection con;
	PreparedStatement ps;
	ResultSet rs;
        String orderloc;
        String restname,restloc;
    public void getID(String id, String a,String b,String c,String d,String e, String f, int g)
{

    cid = id;
    fname = a;
    lname = b;
    phone = c;
    email = d;
    location = e;
    username = f;
    pts = g;
    mb.setText("Hello, "+fname);
    ptslabel.setText("Points : "+pts);
    try
	    	{
	    		 Class.forName("com.mysql.cj.jdbc.Driver");
	    		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodfoxdatabase","root","chimera");
	    		 ps=con.prepareStatement("select * from OrderDetails where CID=? order by OrderID desc limit 1");
	    		 ps.setString(1,cid);
	    		 rs=ps.executeQuery();
	    		 if(rs.next())
                         {
                             orderloc=rs.getString(6);
                             restname=rs.getString(3);
                             restnameLabel.setText(restname);
                             pointsearnedLabel.setText(rs.getString(5));
                             orderlocLabel.setText(orderloc);
                         }
                         ps=con.prepareStatement("select RLocation from Restaurant where RName=? ");
	    		 ps.setString(1,restname);
	    		 rs=ps.executeQuery();
	    		 if(rs.next())
                         {
                             restloc=(String)rs.getString(1);
                         }
                         ps=con.prepareStatement("select * from Location where CLocation=? and RLocation=?");
	    		 ps.setString(1,orderloc);
                         ps.setString(2,restloc);
	    		 rs=ps.executeQuery();
	    		 if(rs.next())
                         {
	    			 		 String arrive = rs.getString(3) + " minutes";
                             arrivinginLabel.setText(arrive);
                             deliveryagentLabel.setText(rs.getString(5));
                         }
                }
	    	catch(ClassNotFoundException | SQLException ex)
	        {
	    		System.out.println("Connection failed");
	    		System.out.println(ex);
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
}