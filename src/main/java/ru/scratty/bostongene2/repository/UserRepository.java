package ru.scratty.bostongene2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.scratty.bostongene2.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);
}
