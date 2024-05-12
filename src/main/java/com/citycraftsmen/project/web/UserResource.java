package com.citycraftsmen.project.web;

import com.citycraftsmen.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class UserResource {
    @Autowired
    UserService userService;
    @PostMapping("/register")
    public int insertUser(@RequestBody Map<String,Object> body){
        System.out.println(body);
        return userService.insertUser(body);
    }
    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody Map<String,Object> body){
        return userService.login(body);
    }

    @GetMapping("/categories")
    public List<Map<String, Object>> getAllCategories() {
        return userService.getAllCategories();
    }

    @GetMapping("/subcategories/{category_id}")
    public List<Map<String, Object>> getAllSubcategories(@PathVariable int category_id) {
        return userService.getAllSubcategories(category_id);
    }

    @GetMapping("/services/{subcategoryId}")
    public List<Map<String, Object>> getAllServices(@PathVariable int subcategoryId) {
        return userService.getAllServices(subcategoryId);
    }

    @PostMapping("/addToCartOfService")
    public Map<String, Object> addToCartOfService(@RequestBody Map<String, Object> body) {
        return userService.addToCartOfService(body);
    }

    @PostMapping("/addToCartOfPackage")
    public Map<String, Object> addToCartOfPackage(@RequestBody Map<String, Object> body) {
        return userService.addToCartOfPackage(body);
    }

    @PostMapping("/deleteService")
    public Map<String, Object> removeFromCart(@RequestBody Map<String, Object> body) {
        return userService.removeFromCart(body);
    }

    @PostMapping("/deletePackage")
    public Map<String, Object> deletePackage(@RequestBody Map<String, Object> body) {
        return userService.deletePackage(body);
    }

//    @GetMapping("/view-cart/{userId}")
//    public List<Map<String, Object>> viewCart(@PathVariable int userId) {
//        return userService.viewCart(userId);
//    }
    @GetMapping("/super-saver-packs/{category_id}")
    public List<Map<String, Object>> getSuperSaverPacks(@PathVariable int category_id) {
        return userService.getSuperSaverPacks(category_id);
    }


    @PostMapping("/getCartDataService")
    public List<Map<String, Object>> getCartDataService(@RequestBody Map<String, Object> body) {
        return userService.getCartDataService(body);
    }

    @PostMapping("/getCartDataOfPackage")
    public List<Map<String, Object>> getCartDataOfPackage(@RequestBody Map<String, Object> body) {
        return userService.getCartDataOfPackage(body);
    }

    @PostMapping("/getBill")
    public Map<String, Object> getBill(@RequestBody Map<String, Object> body) {
        return userService.getBill(body);
    }

    @PostMapping("/bookServices")
    public Map<String, Object> bookServices(@RequestBody Map<String, Object> body) {
        System.out.println("Printing in resource");
        return userService.bookServices(body);
    }

    @PostMapping("/setTimer")
    public Map<String, Object> setTime(@RequestBody Map<String, Object> body) {
        return userService.setTime(body);
    }

    @GetMapping("/getWorkers")
    public Map<String, Object> getWorkers() {
        return userService.getWorkers();
    }

}
