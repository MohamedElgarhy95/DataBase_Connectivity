
package databaseconnection;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.Vector;

public class ConnectDAO {
   Connection connection;
String url ;
String user ;
String password ;
    public ConnectDAO() throws SQLException, ClassNotFoundException
    {
        url = "jdbc:postgresql://localhost:5432/address_book";
        user = "postgres";
        password = "ahmedali98";
            connect();
    }
    private void connect() throws SQLException, ClassNotFoundException
    {
        try {

           Class.forName("org.postgresql.Driver");

           } catch(ClassNotFoundException e ){
                     e.getMessage();
           }

        try {
              connection = DriverManager.getConnection(url, user, password);
              System.out.println("Connection good");

           } catch (SQLException ex) {
               Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
               JOptionPane.showMessageDialog(null, "Failed To Connect");
           }

    }
 public Vector<ContactPerson> gellAllContacts() throws SQLException, ClassNotFoundException {
        Vector<ContactPerson> contacts = new Vector<>();

        try {
            Statement stm = connection.createStatement();
            String queryString = new String("select * from cantact");
            ResultSet resultSet = stm.executeQuery(queryString);

            ContactPerson contact = new ContactPerson();
            while (resultSet.next()) {
                resultSet.getInt("id");
                contact = new ContactPerson();

                contact.setId(resultSet.getInt("id"));
                contact.setName(resultSet.getString("name"));
                contact.setnName(resultSet.getString("nick_name"));
                contact.setAddress(resultSet.getString("address"));
                contact.sethPhone(resultSet.getString("home_phone"));
                contact.setwPhone(resultSet.getString("work_phone"));
                contact.setcPhone(resultSet.getString("cell_phone"));
                contact.seteMail(resultSet.getString("email"));
                contact.setWebSite(resultSet.getString("web_site"));
                contact.setProf(resultSet.getString("profession"));
                contact.setbDate(resultSet.getDate("birthday"));
                contacts.add(contact);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contacts;
    }

public static void main(String[] args) throws SQLException, ClassNotFoundException {
     
/*ConnectDAO conn = new ConnectDAO();

Vector<ContactPerson> res = conn.gellAllContacts();
System.out.println(res.size());
for(int i=0;i<res.size();i++)
{
System.out.println(res.get(i).getName());
}*/

    }
    
}
