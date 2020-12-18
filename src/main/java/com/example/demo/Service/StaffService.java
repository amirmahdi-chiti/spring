package com.example.demo.Service;

import com.example.demo.Model.Staff;
import com.example.demo.Repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {


    @Autowired
    StaffRepository staffRepository;

    public void add(Staff staff){
        staffRepository.save(staff);
    }

    public Staff getById(long id) {
        return staffRepository.findById(id).orElse(null);
    }

    public List<Staff> getByName(String name) {
        return staffRepository.getSpeicalStaff(name);
    }

    public List<Staff> getByEmail(String email) {
        return staffRepository.getSpeicalStaff2(email);
    }

    public void updateCustomerContacts(String email,long id) {
        Staff myStaff = getById(id);
        myStaff.setEmail(email);
        staffRepository.save(myStaff);
    }
    public void deleteCustomer(long id){
        staffRepository.deleteById(id);
    }

}
