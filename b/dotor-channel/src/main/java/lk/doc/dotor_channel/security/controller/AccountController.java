package lk.doc.dotor_channel.security.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.doc.dotor_channel.security.entities.User;
import lk.doc.dotor_channel.security.services.AppUserDetailsService;
import lk.doc.dotor_channel.security.util.CustomErrorType;

/**
 * @author Kavish Manjitha Perera
 */
@RestController
@RequestMapping("account")
@CrossOrigin
public class AccountController {

  public static final Logger logger = LoggerFactory.getLogger(AccountController.class);

  @Autowired
  private AppUserDetailsService userService;

  @PostMapping("/register")
  public ResponseEntity<?> createUser(@RequestBody User newUser) {
    if (userService.loadUserByUsername(newUser.getUsername()) != null) {

      logger.error("username Already exist " + newUser.getUsername());
      return new ResponseEntity(
          new CustomErrorType("user with username " + newUser.getUsername() + "already exist "),
          HttpStatus.CONFLICT);
    }
    return new ResponseEntity<User>(userService.save(newUser), HttpStatus.CREATED);
  }

  @RequestMapping("/login")
  public Principal user(Principal principal) {
    logger.info("user logged " + principal);
    return principal;
  }

}
