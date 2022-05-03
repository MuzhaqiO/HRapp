package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.entity.Users;

import java.util.Collection;

public interface UsersServiceInterface {
    Users create(Users users);
    Collection<Users> list(int limit);
    Users get(Long userId);
    Users update(Users users);
    Boolean delete(Long userId);
}
