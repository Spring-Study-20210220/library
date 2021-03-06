package com.library.study.demo.repository;

import com.library.study.demo.user.Admin;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AdminRepositoryTest {
    @Autowired
    private AdminRepository adminRepository;
    private Admin admin;

    @BeforeAll
    void SetUp(){
        admin = new Admin("아이디바꿈", "이름", "pwd");

    }

    @Test
    void adminSaveTest(){
        adminRepository.save(admin);
        Admin findAdmin = adminRepository.findById("아이디바꿈").orElse(null);
        assertThat(findAdmin.getName(), is(admin.getName()));
    }


}
