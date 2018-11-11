import java.io.File;
import java.util.Random;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

 

public class Maze extends Application {

	 ImageView myImageView;
	 ImageView wallImageView;
	 int x = 0;
	 int y = 0;
	 int read;
	 GridPane myPane = new GridPane();
	 
	 
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage PrimaryStage) throws Exception {
		
		
		File file1 = new File("./src/Lab9.1.txt");
		File file2 = new File("./src/Lab9.2.txt");
		
		File fileArray [] = new File[2];
		fileArray[0] = file1;
		fileArray[1] = file2;
		
		Random rand = new Random();
		int chosenFile = rand.nextInt(2);
		File chosenMaze = fileArray[chosenFile];
		
		Scanner myScanner = new Scanner(chosenMaze);
		System.out.println(myScanner);
		while (myScanner.hasNextLine()){
			String line = myScanner.nextLine();
			Scanner lineScan = new Scanner(line);
			lineScan.useDelimiter(" ");
		System.out.println(lineScan);
			while (lineScan.hasNext()) {
				read = lineScan.nextInt();
				if (read == 1) {
					Image wall = new Image("file:src/wall.jpg");
					wallImageView = new ImageView(wall);
					wallImageView.setFitWidth(50);
					wallImageView.setFitHeight(50);
					myPane.add(wallImageView, x, y);
				}
				System.out.println(read);
				x=x+10;
				if (read == 0) {
					
				//do nothing	
				}			
			}
			y = y +1;
			
		}
		
		System.out.println("Something");
		Image wall = new Image("file:src/wall.jpg");
		wallImageView = new ImageView(wall);
		wallImageView.setFitWidth(50);
		wallImageView.setFitHeight(50);
		wallImageView.setX(x);
		wallImageView.setY(y);
		
		Image image1 = new Image("file:src/hero.png");
		myImageView = new ImageView(image1);
		myImageView.setFitWidth(50);
		myImageView.setFitHeight(50);
		myImageView.setX(x);
		myImageView.setY(y);
		
		
		
		Image image = new Image("file:src/maze_background.jpg");
		ImagePattern pattern = new ImagePattern(image);
		
		
		
	
		
		Group root = new Group(myImageView);
		Scene scene = new Scene(root,500,500,Color.WHITE);
		scene.setFill(pattern);
		PrimaryStage.setTitle("MAZE");
		scene.setOnKeyPressed(this::listenUp);
		PrimaryStage.setScene(scene);
		PrimaryStage.show();
		
	}
	
	public void listenUp(KeyEvent event)
	{
		KeyCode myCode = event.getCode();
		
		if(myCode == KeyCode.A)
		{
			myImageView.setX(x-=10);
			
			
		}
		else if(myCode == KeyCode.D)
		{
			myImageView.setX(x+=10);
			
		}
		else if(myCode == KeyCode.S)
		{
			myImageView.setY(y+=10);
				
		}
		else if(myCode == KeyCode.W)
		{
			myImageView.setY(y-=10);
	
		}
		
		
	

	}
	
}