package application;
import java.awt.Color;
import java.io.IOException;
import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SelectionPageSceneController {

	
	@FXML
	private Label qty1, qty2, qty3, qty4, qty5, qty6, qty7, qty8, qty9, qty10;
	@FXML
	private Button homebtn;
	@FXML
	private Button cartbtn;
	@FXML
	private Button bpqty1;
	@FXML
	private Button bmqty1; 
	@FXML
	private Button bpqty2; 
	@FXML
	private Button bmqty2; 
	@FXML
	private Button bpqty3; 
	@FXML
	private Button bmqty3; 
	@FXML
	private Button bpqty4; 
	@FXML
	private Button bmqty4; 
	@FXML
	private Button bpqty5; 
	@FXML
	private Button bmqty5; 
	@FXML
	private Button bpqty6; 
	@FXML
	private Button bmqty6; 
	@FXML
	private Button bpqty7; 
	@FXML
	private Button bmqty7; 
	@FXML
	private Button bpqty8; 
	@FXML
	private Button bmqty8; 
	@FXML
	private Button bpqty9; 
	@FXML
	private Button bmqty9; 
	@FXML
	private Button bpqty10; 
	@FXML
	private Button bmqty10; 
	@FXML
	private Button add1;
	@FXML
	private Button add2;
	@FXML
	private Button add3;
	@FXML
	private Button add4;
	@FXML
	private Button add5;
	@FXML
	private Button add6;
	@FXML
	private Button add7;
	@FXML
	private Button add8;
	@FXML
	private Button add9;
	@FXML
	private Button add10;
	
	
	
	int q1 = 0 ,q2 = 0 ,q3 = 0 ,q4 = 0 ,q5 = 0 ,q6 = 0 ,q7 = 0 ,q8 = 0 ,q9 = 0 ,q10 = 0 ;
	int i=0;
	Connection con, con1;
	PreparedStatement pst,ps, ps1;
	ResultSet rs,rst, rs1;

	String cid, fname, lname, phone, email, location, username, orderno, foodno;
	int pts;
	String O_ID;
        int oid;
	@FXML
        private Label mb, ptslabel;
	
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
            mb.setText("Hello, "+fname);
            ptslabel.setText("Points : "+pts);
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodfoxdatabase","root","chimera");
                ps=con.prepareStatement("select OID from Order1 order by OID desc limit 1");
                rs=ps.executeQuery();
                if(rs.next())
                {
                    oid=Integer.parseInt(rs.getString(1).substring(1));
                    oid++;     
                    O_ID="O"+oid;
                    
                }
            }
            catch(ClassNotFoundException | SQLException ex)
	        {
	    		System.out.println("Connection failed");
	    		System.out.println(ex);
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
	 arg0.setTitle("foodfoxdatabase"); //arg0 is the primary stage
         CartController controller=loader.getController();
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
        void homebtn(ActionEvent event) {
		 try
	    	{
	    		Class.forName("com.mysql.cj.jdbc.Driver");
	    		con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodfoxdatabase","root","chimera");
	    		ps1=con1.prepareStatement("delete from Order1 where OID=?");
	    		ps1.setString(1,O_ID);
	    		ps1.execute();
	    	}
	    	catch(Exception ex)
	    	{
	    		ex.printStackTrace();
	    	}
            try
         {
             FXMLLoader loader=new FXMLLoader();
             loader.setLocation(getClass().getResource("/application/HomePageScene.fxml"));
             Parent root=loader.load();
             Stage arg0=(Stage) ((Node)event.getSource()).getScene().getWindow();
             HomePageSceneController controller=loader.getController();
             controller.getID(cid, fname, lname, phone, email, location, username, pts);
             arg0.setTitle("foodfoxdatabase"); //arg0 is the primary stage
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
	public void incQty1(ActionEvent event) 
	{
		q1++;
		String st = " " + q1 + " ";
		qty1.setText(st);
	}
	
	@FXML
	public void incQty2(ActionEvent event) 
	{
		q2++;
		String st = " " + q2 + " ";
		qty2.setText(st);
	}
	
	@FXML
	public void incQty3(ActionEvent event) 
	{
		q3++;
		String st = " " + q3 + " ";
		qty3.setText(st);
	}
	
	@FXML
	public void incQty4(ActionEvent event) 
	{
		q4++;
		String st = " " + q4 + " ";
		qty4.setText(st);
	}
	
	@FXML
	public void incQty5(ActionEvent event) 
	{
		q5++;
		String st = " " + q5 + " ";
		qty5.setText(st);
	}
	
	@FXML
	public void incQty6(ActionEvent event) 
	{
		q6++;
		String st = " " + q6 + " ";
		qty6.setText(st);
	}
	
	@FXML
	public void incQty7(ActionEvent event) 
	{
		q7++;
		String st = " " + q7 + " ";
		qty7.setText(st);
	}
	
	@FXML
	public void incQty8(ActionEvent event) 
	{
		q8++;
		String st = " " + q8 + " ";
		qty8.setText(st);
	}
	
	@FXML
	public void incQty9(ActionEvent event) 
	{
		q9++;
		String st = " " + q9 + " ";
		qty9.setText(st);
	}
	
	@FXML
	public void incQty10(ActionEvent event) 
	{
		q10++;
		String st = " " + q10 + " ";
		qty10.setText(st);
	}
	
	
	@FXML
	public void decQty1(ActionEvent event) 
	{
		q1--;
		String st = " " + q1 + " ";
		qty1.setText(st);
	}
	
	@FXML
	public void decQty2(ActionEvent event) 
	{
		q2--;
		String st = " " + q2 + " ";
		qty2.setText(st);
	}
	
	@FXML
	public void decQty3(ActionEvent event) 
	{
		q3--;
		String st = " " + q3 + " ";
		qty3.setText(st);
	}
	
	@FXML
	public void decQty4(ActionEvent event) 
	{
		q4--;
		String st = " " + q4 + " ";
		qty4.setText(st);
	}
	
	@FXML
	public void decQty5(ActionEvent event) 
	{
		q5--;
		String st = " " + q5 + " ";
		qty5.setText(st);
	}
	
	@FXML
	public void decQty6(ActionEvent event) 
	{
		q6--;
		String st = " " + q6 + " ";
		qty6.setText(st);
	}
	
	@FXML
	public void decQty7(ActionEvent event) 
	{
		q7--;
		String st = " " + q7 + " ";
		qty7.setText(st);
	}
	
	@FXML
	public void decQty8(ActionEvent event) 
	{
		q8--;
		String st = " " + q8 + " ";
		qty8.setText(st);
	}
	
	@FXML
	public void decQty9(ActionEvent event) 
	{
		q9--;
		String st = " " + q9 + " ";
		qty9.setText(st);
	}
	
	@FXML
	public void decQty10(ActionEvent event) 
	{
		q10--;
		String st = " " + q10 + " ";
		qty10.setText(st);
	}
	@FXML
	public void add1(ActionEvent event)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodfoxdatabase","root","chimera");
			String query1="insert into order1 values(?,?,?,?,?,?)";
			if(q1>0)
			{
						pst=con.prepareStatement(query1);
                        pst.setString(1,cid);
                        pst.setString(2,O_ID);
                        i++;
                        pst.setString(3,O_ID+"F"+i);
                        pst.setInt(5,q1);
                        pst.setFloat(6,400*q1);
                        pst.setString(4,"Momo Mia Pizza");
                        pst.execute();
                        add1.setDisable(true);
                        add1.setText("ADDED");
			}
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
	}

	@FXML
	public void add2(ActionEvent event)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodfoxdatabase","root","chimera");
			String query1="insert into order1 values(?,?,?,?,?,?)";
			pst=con.prepareStatement(query1);
			if(q2>0)
			{
                        pst.setString(1,cid);
                        pst.setString(2,O_ID);
                        i++;
                        pst.setString(3,O_ID+"F"+i);
                        pst.setInt(5,q2);
                        pst.setFloat(6,350*q2);
                        pst.setString(4,"Tandoori Paneer Pizza");
                        pst.execute();
                        add2.setDisable(true);
                        add2.setText("ADDED"); 
             }
		}
        catch(Exception e)
        {
             e.printStackTrace();
        }
	}
	@FXML
	public void add3(ActionEvent event)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodfoxdatabase","root","chimera");
			String query1="insert into order1 values(?,?,?,?,?,?)";
			pst=con.prepareStatement(query1);
			if(q3>0)
			{
                        pst.setString(1,cid);
                        pst.setString(2,O_ID);
                        i++;
                        pst.setString(3,O_ID+"F"+i);
                        pst.setInt(5,q3);
                        pst.setFloat(6,250*q3);
                        pst.setString(4,"Veggie Supreme");
                        pst.execute();
                        add3.setDisable(true);
                        add3.setText("ADDED");
		    }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@FXML
	public void add4(ActionEvent event)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodfoxdatabase","root","chimera");
			String query1="insert into order1 values(?,?,?,?,?,?)";
			pst=con.prepareStatement(query1);
			if(q4>0)
			{
                        pst.setString(1,cid);
                        pst.setString(2,O_ID);
                        i++;
                        pst.setString(3,O_ID+"F"+i);
                        pst.setInt(5,q4);
                        pst.setFloat(6,280*q4);
                        pst.setString(4,"Veg Kebab");
                        pst.execute();
                        add4.setDisable(true);
                        add4.setText("ADDED");
			}
        }
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@FXML
	public void add5(ActionEvent event)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodfoxdatabase","root","chimera");
			String query1="insert into order1 values(?,?,?,?,?,?)";
			pst=con.prepareStatement(query1);
			if(q5>0)
			{
                        pst.setString(1,cid);
                        pst.setString(2,O_ID);
                        i++;
                        pst.setString(3,O_ID+"F"+i);
                        pst.setInt(5,q5);
                        pst.setFloat(6,350*q5);
                        pst.setString(4,"Chicken Supreme");
                        pst.execute();
                        add5.setDisable(true);
                        add5.setText("ADDED");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@FXML
	public void add6(ActionEvent event)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodfoxdatabase","root","chimera");
			String query1="insert into order1 values(?,?,?,?,?,?)";
			pst=con.prepareStatement(query1);
			if(q6>0)
			{
                        pst.setString(1,cid);
                        pst.setString(2,O_ID);
                        i++;
                        pst.setString(3,O_ID+"F"+i);
                        pst.setInt(5,q6);
                        pst.setFloat(6,340*q6);
                        pst.setString(4,"Chicken Tikka");
                        add6.setDisable(true);
                        add6.setText("ADDED");
                        pst.execute();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@FXML
	public void add7(ActionEvent event)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodfoxdatabase","root","chimera");
			String query1="insert into order1 values(?,?,?,?,?,?)";
			pst=con.prepareStatement(query1);
			if(q7>0)
			{
                        pst.setString(1,cid);
                        pst.setString(2,O_ID);
                        i++;
                        pst.setString(3,O_ID+"F"+i);
                        pst.setInt(5,q7);
                        pst.setFloat(6,450*q7);
                        pst.setString(4,"Chicken Triple feast");
                        pst.execute();
                        add7.setDisable(true);
                        add7.setText("ADDED");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@FXML
	public void add8(ActionEvent event)
	{
		try
		{
			String query1="insert into order1 values(?,?,?,?,?,?)";
			pst=con.prepareStatement(query1);
			if(q8>0)
			{
                        pst.setString(1,cid);
                        pst.setString(2,O_ID);
                        i++;
                        pst.setString(3,O_ID+"F"+i);
                        pst.setInt(5,q8);
                        pst.setFloat(6,220*q8);
                        pst.setString(4,"Veg Kebab Surprise");
                        pst.execute();
                        add8.setDisable(true);
                        add8.setText("ADDED");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}	
	@FXML
	public void add9(ActionEvent event)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodfoxdatabase","root","chimera");
			String query1="insert into order1 values(?,?,?,?,?,?)";
			pst=con.prepareStatement(query1);
			if(q9>0)
			{
                        pst.setString(1,cid);
                        pst.setString(2,O_ID);
                        i++;
                        pst.setString(3,O_ID+"F"+i);
                        pst.setInt(5,q9);
                        pst.setFloat(6,300*q9);
                        pst.setString(4,"Double Sausage");
                        pst.execute();
                        add9.setDisable(true);
                        add9.setText("ADDED");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@FXML
	public void add10(ActionEvent event)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodfoxdatabase","root","chimera");
			String query1="insert into order1 values(?,?,?,?,?,?)";
			pst=con.prepareStatement(query1);
			if(q10>0)
			{
                        pst.setString(1,cid);
                        pst.setString(2,O_ID);
                        i++;
                        pst.setString(3,O_ID+"F"+i);
                        pst.setInt(5,q10);
                        pst.setFloat(6,245*q10);
                        pst.setString(4,"Corn and Cheese");
                        pst.execute();
                        add10.setDisable(true);
			 			add10.setText("ADDED");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}