package problemDomain;

import java.util.Objects;

public final class Role 
{
    private final int roleNumber;
    private final String roleName;
    
    //singletonish
    private static Role customer;
    private static Role employee;
    private static Role manager;
    private static Role admin;
    
    public static Role getRole(int roleNumber)
    {
        switch(roleNumber)
        {
            case 0:
                if(customer == null)
                {
                    customer = new Role(0, "customer");
                }
                return customer;
            case 1:
                if(employee == null)
                {
                    employee = new Role(1, "employee");
                }
                return employee;
            case 2:
                if(manager == null)
                {
                    manager = new Role(2, "manager");
                }
                return manager;
            case 3:
                if(admin == null)
                {
                    admin = new Role(3, "admin");
                }
                return admin;
            default:
                return null;
        }
    }
    
    private Role(int roleNumber, String roleName)
    {
        this.roleNumber = roleNumber;
        this.roleName = roleName;
    }

    public int getRoleNumber() 
    {
        return roleNumber;
    }

    public String getRoleName() 
    {
        return roleName;
    }
    
    public static Role getCustomer()
    {
        return getRole(0);
    }
    
    public static Role getEmployee()
    {
        return getRole(1);
    }
    
    public static Role getManager()
    {
        return getRole(2);
    }
    
    public static Role getAdmin()
    {
        return getRole(3);
    }
    
//    @Override
//    public boolean equals(Object o)
//    {
//        if(o instanceof Role)
//        {
//            Role r = (Role)o;
//            
//            if(r.getRoleName().equals(roleName) && r.getRoleNumber() == roleNumber)
//            {
//                return true;
//            }
//            else
//            {
//                return false;
//            }
//        }
//        else
//        {
//            return false;
//        }
//    }
}
