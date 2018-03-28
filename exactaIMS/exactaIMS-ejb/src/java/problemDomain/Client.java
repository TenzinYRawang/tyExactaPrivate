package problemDomain;

import java.util.ArrayList;

public final class Client
{
    private final long clientID;
    private String name;
    private String css;
    private String logo;
    private String email;
    private String url;
    private String phoneNumber;
    
    //Compostion
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Company> companies = new ArrayList<>();
    private ArrayList<Site> sites = new ArrayList<>();
    
    public Client(long clientID, String name, String css, String logo, String email, String url, String phoneNumber) 
    {
        this.clientID = clientID;
        this.name = name;
        this.css = css;
        this.logo = logo;
        this.email = email;
        this.url = url;
        this.phoneNumber = phoneNumber;
    }

    public long getClientID() 
    {
        return clientID;
    }

    public String getName() 
    {
        return name;
    }

    public String getCss() 
    {
        return css;
    }

    public String getLogo() 
    {
        return logo;
    }

    public String getEmail() 
    {
        return email;
    }

    public String getUrl() 
    {
        return url;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public void setCss(String css) 
    {
        this.css = css;
    }

    public void setLogo(String logo) 
    {
        this.logo = logo;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public void setUrl(String url) 
    {
        this.url = url;
    }

    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }
}
