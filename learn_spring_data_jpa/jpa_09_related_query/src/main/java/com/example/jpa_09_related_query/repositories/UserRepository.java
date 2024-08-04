package com.example.jpa_09_related_query.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.ListCrudRepository;

import com.example.jpa_09_related_query.domains.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends ListCrudRepository<User, Long> {

    @EntityGraph("User.roles")
    Optional<User> findItemById(Long id);
}
