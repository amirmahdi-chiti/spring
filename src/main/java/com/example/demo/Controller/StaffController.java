package com.example.demo.Controller;

import com.example.demo.Model.Staff;
import com.example.demo.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    StaffService staffService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Staff staff){
        System.out.println("**************************");
        staffService.add(staff);

    }
    @RequestMapping("/get")
    public void  getAll(){

        System.out.println( staffService.getById(0));
    }
    @RequestMapping("/getByName")
    public List<Staff> getByName(@RequestParam("name")String name){
        System.out.println("---------------");
        System.out.println(staffService.getByName(name));
        return staffService.getByName(name);
    }
    @RequestMapping("/getByEmail")
    public List<Staff> getByEmail(@RequestParam("email")String email){
        System.out.println("---------------");
        System.out.println(staffService.getByEmail(email));
        return staffService.getByName(email);
    }

    @RequestMapping("/update/{id}")
    public void UpdateEmail(@PathVariable("id") long id,@RequestParam("email")String email){
        System.out.println("++++++++++");
        staffService.updateCustomerContacts(email,id);
    }

    @RequestMapping("/delete")
    public void deleteById(@RequestParam("id") Long id){
        System.out.println("/////////////");
        staffService.deleteCustomer(id);
    }
}
