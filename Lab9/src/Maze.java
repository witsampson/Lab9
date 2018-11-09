import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Maze extends Application {

	public static void main(String[] args) {
		

	}

	@Override
	public void start(Stage PrimaryStage) throws Exception {
		
		File file1 = new File("./src/Lab9.1.txt");
		File file2 = new File("./src/Lab9.2.txt");
		
		ArrayList fileArray = new ArrayList();
		fileArray.add(file1);
		fileArray.add(file2);
		
		Random rand = new Random();
		int chosenFile = rand.nextInt(2);
		int chosenMaze = (int) fileArray.get(chosenFile);
		
		
		
		
		
		
		
		Group root = new Group();
		Scene scene = new Scene(root,500,500,Color.WHITE);
		PrimaryStage.setTitle("MAZE");
		PrimaryStage.setScene(scene);
		PrimaryStage.show();
		
	}

}
