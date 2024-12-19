package org.springframework.service;
import org.springframework.entity.User;
public interface UserService {
    int insert();
    int delete();
    int update();
    User select();
}