package kz.aitu.springprojectexamplese2308.services;

import kz.aitu.springprojectexamplese2308.exceptions.UserNotFoundException;
import kz.aitu.springprojectexamplese2308.models.User;
import kz.aitu.springprojectexamplese2308.repositories.UserRepositoryInterface;
import kz.aitu.springprojectexamplese2308.services.interfaces.UserServiceInterface;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface {
    private final UserRepositoryInterface repo;

    public UserService(UserRepositoryInterface repo) {
        this.repo = repo;
    }
    @Override
    public List<User> getAll() {
        return repo.findAll(Sort.by("id"));
    }

    @Override
    public User getById(int id) {

        return repo.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

    }

    @Override
    public List<User> getBySurname(String surname) {
        return repo.findBySurname(surname);
    }

    @Override
    public User create(User user) {
        return repo.save(user);
    }
}
