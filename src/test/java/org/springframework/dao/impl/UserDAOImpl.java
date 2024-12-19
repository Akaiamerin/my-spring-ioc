package org.springframework.dao.impl;
import org.springframework.dao.UserDAO;
import org.springframework.entity.User;
public class UserDAOImpl implements UserDAO {
    private User user;
    public UserDAOImpl() {
        System.out.println("UserDAOImpl()");
    }
    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public int insert() {
        System.out.println("userDAO.insert()");
        return 0;
    }
    @Override
    public int delete() {
        System.out.println("userDAO.delete()");
        return 0;
    }
    @Override
    public int update() {
        System.out.println("userDAO.update()");
        return 0;
    }
    @Override
    public User select() {
        System.out.println("userDAO.select()");
        return user;
    }
}