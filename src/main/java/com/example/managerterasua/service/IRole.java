package com.example.managerterasua.service;

import com.example.managerterasua.model.Role;

public interface IRole extends GenericService<Role> {
    Role findByName(String name);
}
