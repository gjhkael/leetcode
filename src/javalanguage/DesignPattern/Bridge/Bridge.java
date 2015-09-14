package javalanguage.DesignPattern.Bridge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by hy on 2015/9/11.
 */

/*

1)连接Oracle 8/8i/9i/10g/11g（thin模式）

Class.forName("oracle.JDBC.driver.OracleDriver").newInstance();

String url="JDBC:oracle:thin:@localhost:1521:orcl"       //orcl为Oracle数据库的SID

String user="test";

String password="test";

Connection con=DriverManager.getConnection(url,user,password);

2)连接DB2数据库

Class.forName("com.ibm.db2.jcc.DB2Driver");

String url="JDBC:db2://localhost:5000/testDb";

String user="test"; String password="test";

Connection con=DriverManager.getConnection(url,user,password);

3)连接MySQL数据库

Class.forName("com.mysql.jdbc.Driver");

String url="JDBC:mysql://localhost:8080/testDB";

String user="test"; String password="test";

Connection con=DriverManager.getConnection(url,user,password);

4)连接SQL Server2000数据库

Class.forName("com.microsoft.JDBC.sqlserver.SQLServerDriver");

String url="JDBC:microsoft:sqlserver://localhost:1433;DatabaseName=testDb";

String user="test"; String password="test";

Connection con=DriverManager.getConnection(url,user,password);

5)连接PostgreSQL数据库

Class.forName("org.postgresql.Driver");

String url="JDBC:postgresql://localhost/testDb";

String user="test"; String password="test";

Connection con=DriverManager.getConnection(url,user,password);

6)连接Access数据库

Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

String url="JDBC:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+application.getRealPath("/Data/testDb/mdb");

Connection conn=DriverManager.getConnection(url,"","");

7连接Sybase数据库

Class.forName("com.sybase.JDBC.SybDriver");

String url="JDBC:sybase:Tds:localhost:5007/testDb";

Properties pro=System.getProperties();

pro.put("user","userId");

pro.put("password","user_password");

Connection con=DriverManager.getConnection(url,pro);

8连接informix数据库

Class.forName("com.informix.JDBC.ifxDriver");

String url="JDBC:informix-sqli:localhost:1533/testDb:INFORMIXSERVER=myserver"user=testUser;password=testpassword"; Connection con=DriverManager.getConnection(url);


 */

public class Bridge {
    public static void main(String[] args){
        Bridge1 bridge1 = new myBridge();
        Sourceable source1 = new SourceSub1();
        bridge1.setSource(source1);
        bridge1.method();

        Sourceable source2 = new SourceSub2();
        bridge1.setSource(source2);
        bridge1.method();
    }
}

interface Sourceable{
    public void method();
}

class SourceSub1 implements Sourceable{
    @Override
    public void method() {
        System.out.println("this is the first sub");
    }
}

class SourceSub2 implements Sourceable{

    @Override
    public void method() {
        System.out.println("this is the second sub");
    }
}

abstract class Bridge1{
    private Sourceable source;
    public void method(){
        source.method();
    }

    public Sourceable getSource(){
        return source;
    }
    public void setSource(Sourceable source){
        this.source = source;
    }
}

class myBridge extends Bridge1{
    public void method(){
        getSource().method();
    }
}