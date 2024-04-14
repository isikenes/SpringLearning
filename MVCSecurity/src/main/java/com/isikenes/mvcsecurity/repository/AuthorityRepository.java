package com.isikenes.mvcsecurity.repository;

import com.isikenes.mvcsecurity.entity.Authority;
import com.isikenes.mvcsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, User> {
}
