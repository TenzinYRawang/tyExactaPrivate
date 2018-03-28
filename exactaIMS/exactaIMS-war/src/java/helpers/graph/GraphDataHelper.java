
package helpers.graph;

//import exactaBean.GraphDataBean;
import java.sql.SQLException;
import java.util.ArrayList;
import sessionBeans.stateless.GraphSLSB;

/**
 *
 * @author 729557
 */
public class GraphDataHelper 
{
    String yAxis = "";
    String xAxis = "";
    GraphSLSB gdb = new GraphSLSB();
    
     public String getxAxis() throws SQLException 
    {
         ArrayList<String> threadList = gdb.getRevenue();
     
            //for(String myValue:threadList)
            for(int i=0; i<=10; i++)
            {
                String myValue= threadList.get(i);
                //System.out.println("DEBUG!!!: " + myValue);
                String value[] = myValue.split("::");
                xAxis += "\"" + value[0] + "\",";
            }
            xAxis +="\"0:00";
            xAxis +="\"";
    
            
                    
        
        return xAxis;
    }
     
    public String getyAxis() throws SQLException 
    {
       GraphSLSB gdb = new GraphSLSB();
       ArrayList<String> threadList = gdb.getRevenue();
       
        //System.out.println("ArrayList: " + threadList);
     
            //for(String myValue:threadList)
           for(int i=0; i<=10; i++)
            {
                String myValue= threadList.get(i);
                String value[] = myValue.split("::");
                yAxis += "\"" + value[1] + "\",";
            }
              yAxis +="\"0:00";
              yAxis +="\"";
              
        return yAxis;
    }
     
   
    
}
