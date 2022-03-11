package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
//	public void setId()
//        {
//             
//        }
  
	public static void main(String[] args) {
            
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		try 
		{
			Parent root=FXMLLoader.load(getClass().getResource("/application/login.fxml"));
                        Scene scene=new Scene(root,1300,700);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			arg0.setTitle("FoodFox"); //arg0 is the primary stage
			arg0.setScene(scene);
			arg0.setResizable(false);
			arg0.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
