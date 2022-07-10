package com.mycompany.ems.service;

import com.mycompany.ems.model.Login;
import org.springframework.data.repository.CrudRepository;

public interface LoginService extends CrudRepository<Login,Integer> {
}
