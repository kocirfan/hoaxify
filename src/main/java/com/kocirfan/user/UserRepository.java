package com.kocirfan.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    //JPQL ile Query yazımı
//    @Query(value = "Select u from User u")
//    Page<UserProjection> getAllUsersProjection(Pageable page);

}
