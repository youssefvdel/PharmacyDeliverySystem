package model;

import enums.StaffRole;

public class Administrator extends Staff {

    public Administrator(String staffId, String name, String email
            , String password, String phonenum,
            boolean isAvailable) {
        super(staffId, name, email, password, phonenum, isAvailable, StaffRole.ADMIN);
    }

    // UC-01
    public void manageInventory() {
        
    }
     //UC-02
    public void assignCourier() {
        
    }

    public void updateOrderStatus() {
      
    }
 

} 