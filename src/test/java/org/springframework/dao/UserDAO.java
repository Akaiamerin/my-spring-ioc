package org.springframework.dao;
import org.springframework.entity.User;
public interface UserDAO {
    int insert();
    int delete();
    int update();
    User select();
}