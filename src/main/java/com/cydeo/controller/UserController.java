package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.ResponseWrapper;
import com.cydeo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @RolesAllowed("ADMIN")
    public ResponseEntity<ResponseWrapper> getUsers(){
      List<UserDTO> userDTOList=userService.listAllUsers();
      return ResponseEntity.ok(new ResponseWrapper("Users are successfully retrived",userDTOList, HttpStatus.OK));
    }

    @GetMapping("/{userName}")
    @RolesAllowed("ADMIN")
    public ResponseEntity<ResponseWrapper> getUserByUserName(@PathVariable("userName") String userName){
        UserDTO userDTO=userService.findByUserName(userName);
        return ResponseEntity.ok(new ResponseWrapper("User successfully retrieved",userDTO,HttpStatus.OK));

    }

    @PostMapping
    @RolesAllowed("ADMIN")
    public ResponseEntity<ResponseWrapper> createUser(@RequestBody UserDTO user){
        userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper("User is successfully created",HttpStatus.CREATED));
    }

    @PutMapping()
    @RolesAllowed("ADMIN")
    public ResponseEntity<ResponseWrapper> updateUser(@RequestBody UserDTO user){

        userService.update(user);
        return ResponseEntity.ok(new ResponseWrapper("User successfully updated",user,HttpStatus.OK));
    }

    @DeleteMapping("/{userName}")
    @RolesAllowed("ADMIN")
    public ResponseEntity<ResponseWrapper> deleteUser(@PathVariable("userName") String userName){
        userService.deleteByUserName(userName);
       // return ResponseEntity.ok(new ResponseWrapper("user is successfully deleted",HttpStatus.OK));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseWrapper("user is successfully deleted",HttpStatus.CREATED));
       //204 NO_CONTENT
    }
}
