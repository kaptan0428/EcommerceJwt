package com.example.ecommerceJwt.service;

import com.example.ecommerceJwt.model.User;
import com.example.ecommerceJwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service // to mark class that contain business logic, perform operations, or coordinate tasks within an application's service layer.
public class UserService {

    private UserRepository userRepository;
    private TokenService tokenService;

    @Autowired
    public UserService(UserRepository userRepository, TokenService tokenService) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }



    public String registerUser(User user){
        Optional<User> userOptional = userRepository.getUserByUserName(user.getUserName());
        if(userOptional.isPresent()){
            return "User with given userName already exist, try again !!!";
        }
        if(user.getUserName() == null){
            return "Enter valid user name, try again !!!";
        }
        if(user.getPassword1() == null || user.getPassword2() == null){
            return "Enter valid password, try again !!!";
        }
        if(user.getPassword1().equals(user.getPassword2())){
            userRepository.save(user);
            return user.toString();
        }
        return "password mismatched, try again !!!";
    }

    public String loginUser(String userName, String password){
        Optional<User> userOptional = userRepository.getUserByUserName(userName);

        if(userOptional.isPresent()){
            User user = userOptional.get();
            if(user.getPassword1().equals(password)){
                return "{" +
                        "\"message\":"+"Successfully Logged in\",\n"+
                        "\"data\": "+user+",\n"+
                        "\"username\": "+user.getUserName()+",\n"+
                        "\"Email: " + user.getEmail()+ "\n"+
                        "\"token: " + tokenService.createTokenFunction(user.getUserId()) +
                        "}";
            }
        }

        return "Enter valid username and password";
    }
}
