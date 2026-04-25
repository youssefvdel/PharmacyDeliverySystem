package model;

import enums.StaffRole;

public class Courier extends Staff{


    public Courier(String staffId, String name, String email,
                   String password, String phoneNumber,
                   boolean isAvailable) {

        super(staffId, name, email, password, phoneNumber, isAvailable, StaffRole.COURIER);
    }
    
        public boolean checkAvailability() {
        return IsAvailable();
    }

    public void confirmDelivery() {
        setIsAvailable(true);
    }


}