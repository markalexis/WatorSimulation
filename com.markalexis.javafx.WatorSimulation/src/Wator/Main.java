package Wator;
	


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;


public class Main extends Application {
	//Buttons
	Button bthRun = new Button("Run Model");
	//Text
	TextArea textStatus = new TextArea();
	//Graphics
	GraphicsContext gcMain = null;
		
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			//------WATOR app ------------------------------------------------------------------------------
			// MD Alexis code
			//Grid to arrange buttons and text controls
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.TOP_LEFT);
			grid.setPrefWidth(400);
			//TODO: One column may be better, or a multicolumn single row for buttons.
			ColumnConstraints col1 = new ColumnConstraints();
		     col1.setPercentWidth(90);
		     col1.setMinWidth(200);
		     ColumnConstraints col2 = new ColumnConstraints();
		     col2.setPercentWidth(10);
		     col2.setMinWidth(200);
		     grid.getColumnConstraints().addAll(col1,col2);
		     
			grid.setHgap(10);
			grid.setVgap(10);
			//grid.setGridLinesVisible(true);  //Turn this on for debug and layout
			javafx.geometry.Insets ins = new javafx.geometry.Insets(5,5,5,5);
			grid.setPadding(ins);
			//Fill the grid with controls
			Text scenetitle = new Text("Modeler");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			grid.add(scenetitle, 0, 0, 2, 1);
			//Add Buttons-----------------------------------------
			bthRun.setOnAction(bthHandlerRun);
			grid.add(bthRun,0,2);
			//grid.add(child, columnIndex, rowIndex); //Syntax Note
			
			//Add textArea control to show results
			textStatus.setPrefRowCount(10);
			textStatus.setPrefColumnCount(100);
			textStatus.setWrapText(false);
			textStatus.setPrefWidth(300);
					
			grid.add(textStatus, 0, 3);
			//------------------------------- Canvas --------------------------------------------
			Canvas canvas = new Canvas(300, 300);
			gcMain = canvas.getGraphicsContext2D();
	        grid.add(canvas, 0, 4);
	        
			//------------------------------- Chart ---------------------------------------------
			final CategoryAxis xAxis = new CategoryAxis();
	        final NumberAxis yAxis = new NumberAxis();
	        //final BarChart barchartResults = new BarChart<>(xAxis,yAxis);
	        final AreaChart areachartResults = new AreaChart<>(xAxis,yAxis);
	        
	        areachartResults.setTitle("Results Chart");
	        xAxis.setLabel("Year");       
	        yAxis.setLabel("Population");
	        //Series
	        //TODO:  Connect this to an observable list in ModelUtility
	        //final XYChart.Series<int[], double[]> seriesBalance = new XYChart.Series();
	        final XYChart.Series<String, Double> seriesBalance = new Series<String, Double>();
	        seriesBalance.setName("Balance"); 
	        //seriesBalance.setData(MU.balanceDataList);
	        //areachartResults.setData(MU.balanceDataList);
	        //Add the Series to the chart
	        areachartResults.getData().addAll(seriesBalance);
	        
			
			grid.add(areachartResults,0,5);
			//------------------------------------------------------------------------------------
			//Below lines are from initial project setup
			//--------------------------------------------------------------------------------------
			//Scene scene = new Scene(root,600,400);
			Scene scene = new Scene(grid,1200,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	//---------------Drawing functions ------------------------------------------------------
	private void drawShapes(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(10, 60, 30, 30);
        gc.strokeOval(60, 60, 30, 30);
        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
        gc.fillPolygon(new double[]{10, 40, 10, 40},
                       new double[]{210, 210, 240, 240}, 4);
        gc.strokePolygon(new double[]{60, 90, 60, 90},
                         new double[]{210, 210, 240, 240}, 4);
        gc.strokePolyline(new double[]{110, 140, 110, 140},
                          new double[]{210, 210, 240, 240}, 4);
    }
	//-------------- Event Handlers ---------------------------------------------------------
			public EventHandler<ActionEvent> bthHandlerRun = new EventHandler<ActionEvent>(){
				//
				//Action When "Run" is pressed,
				//
				@Override
			    public void handle(ActionEvent e) 
				{
					//TODO: Run the model
					//Print out a result
					String msg = "WATOR Model Start....."; textStatus.appendText( msg +"\n");
					drawShapes(gcMain);
				    msg = "WATOR Model Ended ....."; textStatus.appendText( msg +"\n"); 
			    }
			};
}//End of the aaplication
