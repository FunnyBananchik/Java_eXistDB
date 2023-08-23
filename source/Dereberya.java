import javax.xml.xquery.*;
import com.xqj2.XQConnection2;
import net.xqj.exist.*;
import java.io.*;


public class Dereberya {
    public static void main(String[] args) throws IOException, XQException {
        XQDataSource db = new ExistXQDataSource();
        db.setProperty("serverName", "localhost");
        db.setProperty("port", "8080");
        db.setProperty("user","admin");
        db.setProperty("password","admin");
        XQConnection2 con2 =(XQConnection2)db.getConnection();
        File file = new File("C:/DB/BOOKS/books.xml");
        XQItem item = con2.createItemFromDocument(new FileInputStream(file), null, null);
        con2.insertItem(file.getName(), item, null);
        XQExpression exp = con2.createExpression();
        XQSequence res = exp.executeQuery("for $b in doc('books.xml')//book return $b");
        System.out.println("ֲûגמה טח xml פאיכא");
        while (res.next()) {
           System.out.println(res.getItemAsString(null));
        }
        res.close();
        exp.close();
        con2.close();

    }
}