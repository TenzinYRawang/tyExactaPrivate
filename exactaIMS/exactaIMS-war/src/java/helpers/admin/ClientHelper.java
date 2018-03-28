package helpers.admin;

import java.util.ArrayList;
import javax.servlet.ServletContext;
import problemDomain.Client;

public class ClientHelper 
{
    public String getClientTable(ServletContext application)
    {
        ArrayList<Client> clients = (ArrayList<Client>)application.getAttribute("clients");
        
        StringBuffer table = new StringBuffer();
        
        table.append("<table class='client_table'>")
                .append("<tr class='client_table_row'>")
                    .append("<th class='client_tableheader_cell'>Client Name</th>")
                    .append("<th class='client_tableheader_cell'>Client CSS</th>")
                    .append("<th class='client_tableheader_cell'>Client Logo</th>")
                    .append("<th class='client_tableheader_cell'>Email</th>")
                    .append("<th class='client_tableheader_cell'>URL</th>")
                    .append("<th class='client_tableheader_cell'>Phone Number</th>")
                    .append("<th class='client_tableheader_cell'>Edit</th>")
                    .append("<th class='client_tableheader_cell'>Delete</th>")
                .append("</tr>");
        
        for(int i = 1; i < clients.size(); i++)
        {
            Client c = clients.get(i);
            table.append("<tr class='client_table_row'>")
                    .append("<td class='client_table_cell'>")
                    .append(c.getName())
                    .append("</td>")
                    .append("<td class='client_table_cell'>")
                    .append(c.getCss())
                    .append("</td>")
                    .append("<td class='client_table_cell'>")
                    .append(c.getLogo())
                    .append("</td>")
                    .append("<td class='client_table_cell'>")
                    .append(c.getEmail())
                    .append("</td>")
                    .append("<td class='client_table_cell'>")
                    .append(c.getUrl())
                    .append("</td>")
                    .append("<td class='client_table_cell'>")
                    .append(c.getPhoneNumber())
                    .append("</td>")
                    .append("<td class='client_table_cell'><a href='#editclient' onclick='loadeditclient(")
                    .append(c.getClientID())
                    .append(");'>Edit</a><form id='")
                    .append(c.getClientID())
                    .append("' hidden><input value='")
                    .append(c.getName())
                    .append("'><input value='")
                    .append(c.getCss())
                    .append("'><input value='")
                    .append(c.getLogo())
                    .append("'><input value='")
                    .append(c.getEmail())
                    .append("'><input value='")
                    .append(c.getUrl())
                    .append("'><input value='")
                    .append(c.getPhoneNumber())
                    .append("'></form></td>")
                    .append("<td class='client_table_cell'><a href='deleteclient?id=")
                    .append(c.getClientID())
                    .append("'>Delete</a></td>")
                    .append("</tr>");
        }
        
        table.append("</table>");
        
        return table.toString();
    }
    
    public Client getClient(long id, ServletContext application)
    {
        ArrayList<Client> clients = (ArrayList<Client>)application.getAttribute("clients");
        
        for(Client c: clients)
        {
            if(c.getClientID() == id)
            {
                return c;
            }
        }
        
        return null;
    }
}
