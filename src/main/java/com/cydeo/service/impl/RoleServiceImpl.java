package com.cydeo.service.impl;

import com.cydeo.dto.RoleDTO;
import com.cydeo.entity.Role;
import com.cydeo.repository.RoleRepository;
import com.cydeo.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleDTO> listAllRoles() {
        //controller calling me anf=d requesting all the roles
        //so.. i need to  go to db and bring all the roles from there

        //bring all the roles
        List<Role> roleList=roleRepository.findAll();

        //convert entity to dto- Mapper


        return null;
    }

    @Override
    public RoleDTO findById(Long id) {
        return null;
    }
}
