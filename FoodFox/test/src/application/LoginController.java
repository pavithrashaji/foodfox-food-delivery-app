package application;

import java.sql.*;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
/////////////////////////////////////////

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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.UUID;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
public class LoginController implements Initializable{
			
        ObservableList<String> locationList = FXCollections
			.observableArrayList("Karikode","Thangassery","Chinnakada","Town Limit","Polayathode","Kadappakada");
	
	@FXML //like a via, connects fxml to maincontroller
	private Button signup,login;
	@FXML
	private Pane change1,change2;
	@FXML
	private ChoiceBox locationBox;
        
        @FXML
        private Button submit1;
        @FXML
        private Button submit2;
	
	
	public void signupPage() throws IOException{
		//Stage stage1=(Stage)signup.getScene().getWindow();
		
		change1.setVisible(false);
		change2.setVisible(true);
	}
	public void loginPage() throws IOException{
		//Stage stage2=(Stage)login.getScene().getWindow();
		
		change2.setVisible(false);
		change1.setVisible(true);
	}


 @FXML
 private TextField login_username;
 @FXML
 private TextField login_password;
 
     @FXML
    private TextField signupuname;

    @FXML
    private PasswordField signuppass;

    @FXML
    private PasswordField signupconfirmpass;

    @FXML
    private TextField signupmobile;

    @FXML
    private TextField signupemail;

    @FXML
    private TextField signuplname;

    @FXML
    private TextField signupfname;
    
    public String C_ID;
    public String count=null;
    public String lcount="";
    int ccount=0;
 /**
 * Initializes the controller class.
 * @param url
 * @param rb
 */
 Connection con;
 PreparedStatement pst,ps;
 ResultSet rs,rst;
 @FXML
 private void SignInbtn(ActionEvent event) throws SQLException,ClassNotFoundException {
 String username=login_username.getText();
 String password=login_password.getText();
 if(username.equals("")&&password.equals(""))
 JOptionPane.showMessageDialog(null,"Enter Username and password");
 else
 {
 try
 {
 Class.forName("com.mysql.cj.jdbc.Driver");

con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodfoxdatabase","root","chimera");
 pst=con.prepareStatement("select * from Customer where CUser=? and CPswd=?");
 pst.setString(1, username);
 pst.setString(2, password);
 
 rs=pst.executeQuery();
 if(rs.next())
 {
     //System.out.println("Login Success");
	 String cid = (String)rs.getString(1);
     String fname= (String)rs.getString(2);
     String lname = (String)rs.getString(3);
     String phone =(String)rs.getString(4); 
     String email =  (String)rs.getString(5);
     String location = (String)rs.getString(6);
     String user =  (String)rs.getString(8);
     int pts = rs.getInt(7);
     try
     {
         FXMLLoader loader=new FXMLLoader();
         loader.setLocation(getClass().getResource("/application/HomePageScene.fxml"));
         
         Parent root=loader.load();
	 Stage arg0=(Stage) ((Node)event.getSource()).getScene().getWindow();
         
         arg0.setTitle("FoodFox");
         Scene scene=new Scene(root,1300,700);
         HomePageSceneController controller=loader.getController();
         controller.getID(cid, fname, lname, phone, email, location, user, pts);
         scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
         arg0.setScene(scene);
         arg0.setResizable(false);
	 arg0.show();
     }
     catch(Exception e) 
                {
			e.printStackTrace();
		}
 }
 else {
 JOptionPane.showMessageDialog(null,"Login Failed");
 login_username.setText("");
 login_password.setText("");
 login_username.requestFocus();
 login_password.requestFocus();
 }
 }catch(ClassNotFoundException | SQLException e)
 {
 System.out.println("Connection failed");
 System.out.println(e);
 }
 } }
 
 @FXML
 void signupbtn(ActionEvent event) throws IOException,SQLException,ClassNotFoundException {
        
        String fname=signupfname.getText();
        String lname=signuplname.getText();
       String email=signupemail.getText();
       String phone=signupmobile.getText();
       String username=signupuname.getText();
      String password=signuppass.getText();
      String confirmpassword=signupconfirmpass.getText();
      String location=(String)locationBox.getValue();
      
       if(fname.equals("")||lname.equals("")||email.equals("")||phone.equals("")||password.equals("")||confirmpassword.equals("")||location.equals(""))
         JOptionPane.showMessageDialog(null,"Blank fields found!!");
       else if(!password.equals(confirmpassword))
            JOptionPane.showMessageDialog(null,"Passwords do not match");
      else
      {
         try
         {
             //C_ID=UUID.randomUUID().toString();
//             System.out.println(C_ID);
           Class.forName("com.mysql.cj.jdbc.Driver");
          con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodfoxdatabase","root","chimera");
          
          String query3="select * from Customer where cmail=?";
          
          pst=con.prepareStatement(query3);
          pst.setString(1, email);
          rs=pst.executeQuery();
          if(rs.next())
          {
              JOptionPane.showMessageDialog(null,"Email already exists!!!Try logging in");
          }else{
            String query1="insert into Customer values(?,?,?,?,?,?,?,?,?)";
            
            pst=con.prepareStatement(query1);
            
            
            pst.setString(2, fname);
            pst.setString(3, lname);
            pst.setString(4, phone);
            pst.setString(5, email);
            pst.setString(6, location);
            pst.setInt(7, 50);
            pst.setString(8, username);
            pst.setString(9, password);
            String query4=("select @count:=cid from customer order by cid desc limit 1");
            ps=con.prepareStatement(query4);
            rst=ps.executeQuery();
            
            if(rst.next())
            {
                count=(String)rst.getString(1);
            }
            
            lcount=count.substring(1);
            //lcount="2";
            ccount=Integer.parseInt(lcount);
            ccount++;     
            C_ID="C"+ccount;
            pst.setString(1, C_ID);
            pst.execute();
            
            
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/application/HomePageScene.fxml"));
            
            Parent root=loader.load();
            Stage arg0=(Stage) ((Node)event.getSource()).getScene().getWindow();

            arg0.setTitle("FoodFox");
            Scene scene=new Scene(root,1300,700);
            
            HomePageSceneController controller=loader.getController();
            controller.getID(C_ID, fname, lname, phone, email, location, username, 50);
            
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            arg0.setScene(scene);
            arg0.setResizable(false);
            arg0.show();
           
         }
           }catch(ClassNotFoundException | SQLException e)
           {
           System.out.println("Connection failed");
           System.out.println(e);
           
       }
    }

    }
 @Override
// @FXML
//	private void initialize()
//	{
//		locationBox.setItems(locationList);
//	}
	
 public void initialize(URL url, ResourceBundle rb) {
     locationBox.setItems(locationList);
 //throw new UnsupportedOperationException("Not supported yet.");// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
 }
}