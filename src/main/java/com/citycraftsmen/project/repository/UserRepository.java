package com.citycraftsmen.project.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public int insertUser(String fullname,String username,String email,String password,int phone){
        return jdbcTemplate.update("EXEC events_portal.sp_register_users ?,?,?,?,?",fullname,username,email,password,phone);
    }
    public Map<String,Object> login(String username, String password){
        return jdbcTemplate.queryForMap("EXEC events_portal.sp_login ?,?",username,password);
    }

    public List<Map<String, Object>> getAllCategories() {
        return jdbcTemplate.queryForList("EXEC city_craftsmen.sp_get_all_categories");
    }

    public List<Map<String, Object>> getAllSubcategories(int categoryId) {
        return jdbcTemplate.queryForList("EXEC city_craftsmen.sp_get_all_subcategories ?",categoryId);
    }

    public List<Map<String, Object>> getAllServices(int subcategoryId) {
        return jdbcTemplate.queryForList("EXEC city_craftsmen.sp_get_all_services ?", subcategoryId);
    }
    public Map<String, Object> addToCartOfService(int userId, int serviceId, int quantity)
    {
        return jdbcTemplate.queryForMap("EXEC city_craftsmen.sp_add_to_cart_of_service ?, ?, ?", userId, serviceId, quantity);
    }


    public Map<String, Object> addToCartOfPackage(int userId, int package_id, int quantity)
    {
        return jdbcTemplate.queryForMap("EXEC city_craftsmen.sp_add_to_cart_of_package ?, ?, ?", userId, package_id, quantity);
    }

    public Map<String, Object> removeFromCart(int id) {
        return jdbcTemplate.queryForMap("EXEC city_craftsmen.sp_delete_service ?",id);
    }
    public Map<String, Object> deletePackage(int id) {
        return jdbcTemplate.queryForMap("EXEC city_craftsmen.sp_delete_package ?",id);
    }

    public List<Map<String, Object>> viewCart(int userId) {
        return jdbcTemplate.queryForList("SELECT * FROM city_craftsmen.cart WHERE user_id = ?", userId);
    }
    public List<Map<String, Object>> getSuperSaverPacks(int categoryId) {
        return jdbcTemplate.queryForList("EXEC city_craftsmen.sp_get_super_saver_packs ?", categoryId);
    }

    public List<Map<String, Object>> getCartDataService(int userid) {
        return jdbcTemplate.queryForList("city_craftsmen.sp_getCartDataService ?", userid);
    }

    public List<Map<String, Object>> getCartDataOfPackage(int userid) {
        return jdbcTemplate.queryForList("EXEC  city_craftsmen.sp_getCartDataOfPackage ?", userid);
    }

    public Map<String, Object> getBill(int userid) {
        return jdbcTemplate.queryForMap("EXEC  city_craftsmen.sp_generate_bill ?", userid);
    }



    public Map<String, Object> setTime(int userid,int cart_id,String date_time) {
        return jdbcTemplate.queryForMap("EXEC  city_craftsmen.sp_assign_worker_and_book_service ?,?,?", cart_id,date_time,userid);
    }



    public Map<String, Object> getWorkers() {
        return jdbcTemplate.queryForMap("EXEC  city_craftsmen.getWorkers");
    }







}
