package model;
import enums.StaffRole;


public abstract class Staff {
 
    private String staffId;
    private String name;
    private String email;
    private String password;
    private String phonenum;
    private boolean isAvailable;
    private final StaffRole role;

    public Staff(String staffId, String name, String email,
            String password, String phonenum,
            boolean isAvailable, StaffRole role) {
        
        this.staffId = staffId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phonenum = phonenum;
        this.isAvailable = isAvailable;
        this.role = role;
    }
    
        //getters 
    
    public String getStaffId() {return staffId;}

    public String getName() {return name;}

    public String getEmail() {return email;}

    public String getPassword() {return password;}

    public String getPhonenum() {return phonenum;}

    public boolean IsAvailable() {return isAvailable;}

    public StaffRole getRole() {return role;}

    // setters  
    
    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public void setIsAvailable(boolean available) {
        this.isAvailable = available;
    }
    
    
    
}
