package exa17oraclemongo;


import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.io.FileNotFoundException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.bson.Document;

public class Exa17oraclemongo {

    public static Connection conexion=null;
    
     public static Connection getConexion() throws SQLException  {
        String usuario = "hr";
        String password = "hr";
        String host = "localhost"; // tambien puede ser una ip como "192.168.1.14"
        String puerto = "1521";
        String sid = "orcl";
        String ulrjdbc = "jdbc:oracle:thin:" + usuario + "/" + password + "@" + host + ":" + puerto + ":" + sid;
        
           
            conexion = DriverManager.getConnection(ulrjdbc);
            return conexion;
        }
     
    public static void closeConexion() throws SQLException {
      conexion.close();
      }
    public void MostrarPedidos(){
        //Conexion a mongo
        MongoClient cli = new MongoClient("localhost", 27017);
        //Base de datos
        MongoDatabase base = cli.getDatabase("tenda");
        //Obtenemos la colección
        MongoCollection<Document> colection = base.getCollection("pedidos");
        //C
        FindIterable<Document> cursor = colection.find();
        //Usamos un iterador para recorrer el cursor.
        MongoCursor<Document> iterator = cursor.iterator();
        while (iterator.hasNext()) {
            Document obj = iterator.next();
            System.out.println(obj.toString());
        }
        //Cerramos el cliente
        cli.close();
    }
    public static void main(String[] args) throws FileNotFoundException, SQLException {
        //Exa17oraclemongo oramon =new Exa17oraclemongo();
        
    
    
    }
}

