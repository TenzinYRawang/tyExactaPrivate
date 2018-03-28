package problemDomain;

public final class User 
{
    //Attributes
    private final long userID;
    private final String username;
    private final char[] password;
    private final String salt;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final int mailingChoice;
    private final String address;
    
    private long clientID;
    
    //Composition
    private final Role role;

    public User(User user)
    {
        this.userID = user.getUserID();
        this.username = user.getUsername();
        this.password = null;
        this.salt = null;
        this.email = user.getEmail();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.mailingChoice = user.getMailingChoice();
        this.address = user.getAddress();
        
        this.clientID = user.getClientID();
        
        this.role = Role.getRole(user.getRoleNumber());
    }
    
    public User(long userID, String username, char[] password, String salt, String email, String firstName, String lastName, int mailingChoice, String address, int roleNumber, long clientID) 
    {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mailingChoice = mailingChoice;
        this.address = address;
        
        this.clientID = clientID;
        
        this.role = Role.getRole(roleNumber);
    }

    public User(long aLong, String string, String string0, String string1, String string2, String string3, String string4) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public User(long aLong, String string, String string0, String string1, String string2, String string3, int aInt, String string4, int aInt0, int aInt1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Getters
    public long getUserID() 
    {
        return userID;
    }

    public String getUsername() 
    {
        return username;
    }

    public char[] getPassword() 
    {
        return password;
    }
    
    public String getSalt()
    {
        return salt;
    }
    
    public String getEmail()
    {
        return email;
    }

    public String getFirstName() 
    {
        return firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public int getMailingChoice() 
    {
        return mailingChoice;
    }

    public String getAddress() 
    {
        return address;
    }
    
    public long getClientID()
    {
        return clientID;
    }
    
    public Role getRole()
    {
        return role;
    }
    
    public int getRoleNumber()
    {
        return role.getRoleNumber();
    }
    
    public String getRoleName()
    {
        return role.getRoleName();
    }

    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", username=" + username + ", password=" + password + ", salt=" + salt + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", mailingChoice=" + mailingChoice + ", address=" + address + ", clientID=" + clientID + ", role=" + role + '}';
    }
}
