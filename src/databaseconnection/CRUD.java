
package databaseconnection;



import java.sql.SQLException;
import java.util.Vector;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class CRUD  extends Application  {
Label id , name ,nickname, email , phone ;
TextField tf1 , tf2 , tf3 , tf4 , tf5 ;
Button New , update , delete , first , prev, next , last ;
FlowPane f;
BorderPane bor;
GridPane  g;
Scene scene;
Vector<ContactPerson> res;
int Next=0 , Prev=0;
    public void init() throws SQLException, ClassNotFoundException
    {
        ConnectDAO conn = new ConnectDAO();
        res = conn.gellAllContacts();
        id = new Label("Id");
        name = new Label("Name");
        nickname = new Label("Nickname");
        email = new Label("Email");
        phone = new Label("Phone");       
        tf1 = new TextField();
        tf1.setEditable(false);
        tf2 = new TextField();
        tf3 = new TextField();
        tf4 = new TextField();
        tf5 = new TextField();
        New = new Button("New");
        update = new Button("Update");
        delete = new Button("Delete");
        first = new Button("First");
        prev = new Button("Prev");
        next = new Button("Next");
        last = new Button("Last");
        f = new FlowPane();
        bor = new BorderPane();
        f.getChildren().addAll(New , update , delete , first , prev, next , last);
        g=new GridPane();
        g.addRow(0, id,tf1);
        g.addRow(1,name,tf2);
        g.addRow(2,nickname,tf3 );
        g.addRow(4,email,tf4 );
        g.addRow(5,phone,tf5 );
        g.setHgap(5);
        g.setVgap(10);
        bor.setTop(g);
        bor.setBottom(f);
        scene = new Scene(bor, 400, 250);
        if(res.size()>=0)
        {
            tf1.setText(Integer.toString(res.get(0).getId()));
            tf2.setText(res.get(0).getName());
            tf3.setText(res.get(0).getnName());
            tf4.setText(res.get(0).geteMail());
            tf5.setText(res.get(0).getcPhone());
        }

    }
        public void start(Stage primaryStage)
        {
                next.setOnAction(new EventHandler<ActionEvent>() { 
                @Override
                public void handle(ActionEvent event) {
                    getNext();
                }
                 });
                prev.setOnAction(new EventHandler<ActionEvent>() { 
                @Override
                public void handle(ActionEvent event) {
                    getPrev();
                }
                     });   
                first.setOnAction(new EventHandler<ActionEvent>() { 
                @Override
                public void handle(ActionEvent event) {
                   getFirst();
                }
                     });
                last.setOnAction(new EventHandler<ActionEvent>() { 
                @Override
                public void handle(ActionEvent event) {
                   getLast();
                }
                     });                      
            primaryStage.setTitle("CRUD App");
            primaryStage.setScene(scene);
            primaryStage.show();
        } 
        public void getNext()
        {
       
           
            if(Next+1<res.size())
            {
                    Next++;
                tf1.setText(Integer.toString(res.get(Next).getId()));
                tf2.setText(res.get(Next).getName());
                tf3.setText(res.get(Next).getnName());
                tf4.setText(res.get(Next).geteMail());
                tf5.setText(res.get(Next).getcPhone());
            }
            

        }
 public void getPrev()
        {
           
            
            if(Next-1 >= 0)
            {
                Next--;
                tf1.setText(Integer.toString(res.get(Next).getId()));
                tf2.setText(res.get(Next).getName());
                tf3.setText(res.get(Next).getnName());
                tf4.setText(res.get(Next).geteMail());
                tf5.setText(res.get(Next).getcPhone());
            }
            

        }
        public void getFirst()
        {
            if(res.size()>=0)
            {
                tf1.setText(Integer.toString(res.get(0).getId()));
                tf2.setText(res.get(0).getName());
                tf3.setText(res.get(0).getnName());
                tf4.setText(res.get(0).geteMail());
                tf5.setText(res.get(0).getcPhone());
                Next=0;
            }

        }
        public void getLast()
        {
            if(res.size()>=0)
            {
                tf1.setText(Integer.toString(res.get(res.size()-1).getId()));
                tf2.setText(res.get(res.size()-1).getName());
                tf3.setText(res.get(res.size()-1).getnName());
                tf4.setText(res.get(res.size()-1).geteMail());
                tf5.setText(res.get(res.size()-1).getcPhone());
                Next=res.size()-1;
            }

        }
 public static void main(String[] args)  {
     
launch(args);

    }
    
}
