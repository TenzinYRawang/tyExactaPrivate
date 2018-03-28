/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers.email;

import java.io.*;
import java.util.Scanner;
import java.io.*;

public class EmailInvoice
{
    public String getHTML()
    {
        
            String fname;
            Scanner scan = new Scanner(System.in);

            /* enter filename with extension to open and read its content */

            //System.out.print("Enter File Name to Open (with extension like file.txt) : ");
            //fname = scan.nextLine();
            fname = "C:/Users/729557/Desktop/invoice/invoice.html";
            /* this will reference only one line at a time */

            String line = null;
            String htmlString ="";
            try
            {
                /* FileReader reads text files in the default encoding */
                FileReader fileReader = new FileReader(fname);

                /* always wrap the FileReader in BufferedReader */
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while((line = bufferedReader.readLine()) != null)
                {
                    //System.out.println(line);
                    htmlString += line;
                }

                /* always close the file after use */
                bufferedReader.close();
                System.out.println(htmlString);
            }
            catch(IOException ex)
            {
                System.out.println("Error reading file named '" + fname + "'");
            }
     
     return htmlString;    
       
    }
}