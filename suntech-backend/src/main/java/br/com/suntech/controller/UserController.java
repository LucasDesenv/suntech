package br.com.suntech.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.suntech.domain.IUser;
import br.com.suntech.dto.UserDTO;
import br.com.suntech.service.UserService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/v1/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @CrossOrigin(origins = "http://localhost:8090")
    @ApiOperation(value = "User finding GET API")
    public ResponseEntity<String> filterUsers(@RequestParam(name = "filter", required = true) String filter) {
		List<UserDTO> usersFound = convert(userService.findByFilter(filter));
		if (CollectionUtils.isEmpty(usersFound)){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
        return new ResponseEntity<>(new Gson().toJson(usersFound), HttpStatus.OK);

	}

	private List<UserDTO> convert(List<? extends IUser> findByFilter) {
		return findByFilter.stream().map(UserDTO::new).collect(Collectors.toList());
	}
}
