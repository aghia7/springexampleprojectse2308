package kz.aitu.springprojectexamplese2308.services.interfaces;

import kz.aitu.springprojectexamplese2308.models.User;

import java.util.List;

public interface UserServiceInterface {
    List<User> getAll();
    User getById(int id);
    List<User> getBySurname(String surname);
    User create(User user);
}
