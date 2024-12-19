package org.springframework.service.impl;
import org.springframework.dao.UserDAO;
import org.springframework.entity.User;
import org.springframework.service.UserService;
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;
    public UserServiceImpl() {
        System.out.println("UserServiceImpl()");
    }
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @Override
    public int insert() {
        System.out.println("UserService.insert()");
        return userDAO.insert();
    }
    @Override
    public int delete() {
        System.out.println("UserService.delete()");
        return userDAO.delete();
    }
    @Override
    public int update() {
        System.out.println("UserService.update()");
        return userDAO.update();
    }
    @Override
    public User select() {
        System.out.println("UserService.select()");
        return userDAO.select();
    }
}