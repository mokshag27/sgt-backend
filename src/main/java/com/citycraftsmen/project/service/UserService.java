package com.citycraftsmen.project.service;

import com.citycraftsmen.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public int insertUser( Map<String,Object> body){
        String fullname=(String)body.get("name");
        String username=(String)body.get("username");
        String email=(String)body.get("email");
        String password=(String)body.get("pwd");
        int phone=Integer.parseInt((String)body.get("phone"));
        System.out.println(body);
        System.out.println(fullname+" "+username+" "+email+" "+password);
        int noOfRows= userRepository.insertUser(fullname,username,email,password,phone);

        if(noOfRows>0)
        {
            return 1;
        }
        return 0;
    }

    public Map<String,Object> login( Map<String,Object> body){
        String username=(String)body.get("username");
        String password=(String)body.get("pwd");
        return userRepository.login(username,password);
    }

    public List<Map<String, Object>> getAllCategories() {
        return userRepository.getAllCategories();
    }

    public List<Map<String, Object>> getAllSubcategories(int categoryId) {
        return userRepository.getAllSubcategories(categoryId);
    }

    public List<Map<String, Object>> getAllServices(int subcategoryId) {
        return userRepository.getAllServices(subcategoryId);
    }

    public Map<String, Object> addToCartOfService( Map<String, Object> body) {
        int userid = (int) body.get("userid");
        int service_id = (int) body.get("service_id");

        int quantity = (int) body.get("quantity");
        return userRepository.addToCartOfService(userid, service_id, quantity);
    }


    public Map<String, Object> addToCartOfPackage(Map<String, Object> body) {
        int userid = (int) body.get("userid");
        int package_id = (int) body.get("package_id");
        int quantity = (int) body.get("quantity");
        return userRepository.addToCartOfPackage(userid, package_id, quantity);
    }
    public Map<String, Object> removeFromCart(Map<String, Object> body) {
        int id = (int) body.get("id");
        return userRepository.removeFromCart(id);
    }

    public Map<String, Object> deletePackage(Map<String, Object> body) {
        int id = (int) body.get("id");
        return userRepository.deletePackage(id);
    }

    public List<Map<String, Object>> viewCart(int userId) {
        return userRepository.viewCart(userId);
    }
    public List<Map<String, Object>> getSuperSaverPacks(int categoryId) {
        return userRepository.getSuperSaverPacks(categoryId);
    }

    public List<Map<String, Object>> getCartDataService(Map<String, Object> body)
    {
        int userid = (int)body.get("userid");
        return userRepository.getCartDataService(userid);
    }

    public List<Map<String, Object>> getCartDataOfPackage(Map<String, Object> body)
    {
        int userid = (int)body.get("userid");
        return userRepository.getCartDataOfPackage(userid);

    }

    public Map<String, Object> getBill(Map<String, Object> body)
    {
        int userid = (int)body.get("userid");
        return userRepository.getBill(userid);
    }
    public Map<String, Object> bookServices(Map<String, Object> body) {
        System.out.println("Printing in service");
        int userid = (int) body.get("userid");
        System.out.println(userid);
        return new HashMap<>();
    }

    public Map<String, Object> setTime(Map<String, Object> body) {
        System.out.println("Printing in service");
        int userid = (int) body.get("userid");
        int cart_id = (int) body.get("cart_id");
        String date_time = (String) body.get("date_time");
        return userRepository.setTime(userid,cart_id,date_time);



    }



    public Map<String, Object> getWorkers() {


        return userRepository.getWorkers();



    }


}
