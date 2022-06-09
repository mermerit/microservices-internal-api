package com.example.userservice.service;

import com.example.userservice.VO.Department;

import com.example.userservice.VO.ResponceVo;
import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private RestTemplate restTemplate;


    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return repository.save(user);
    }

    public ResponceVo getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponceVo vo = new ResponceVo();
        User user = repository.findByUserId(userId);

        Department department =
                restTemplate.getForObject("http://localhost:8092/departments/" + user.getDepartmentId()
                        ,Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return  vo;
    }
}
