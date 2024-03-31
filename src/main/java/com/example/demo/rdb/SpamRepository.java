package com.example.demo.rdb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpamRepository extends JpaRepository<SpamEntity, Integer> {

    SpamEntity findByMessage(String message);

}
