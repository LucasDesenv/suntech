package br.com.suntech;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import br.com.suntech.dto.UserDTO;

@Sql(scripts = { "/script/shutdown.sql" }, executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
@Sql(scripts = { "/script/user.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class UserControllerInteTest extends SpringTest {
	
	private static final String URL_FIND_USERS = "/v1/api/user/{filter}";

	@Test
	@Rollback
	public void mustReturnUserFindindByName() {
		configureUrl(URL_FIND_USERS);
		ResponseEntity<String> responseEntity = this.restTemplate.getForEntity(url, String.class, "Luca");
		Assertions.assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());
		List<UserDTO> usersFound = fromJson(responseEntity);
		Assertions.assertThat(usersFound).hasSize(1);
		Assertions.assertThat(usersFound).first().extracting("id").containsOnly(Integer.valueOf(1));
	}
	
	@Test
	@Rollback
	public void mustReturnUserFindindByEmail() {
		configureUrl(URL_FIND_USERS);
		ResponseEntity<String> responseEntity = this.restTemplate.getForEntity(url, String.class, "ukasheitich@gma");
		Assertions.assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());
		List<UserDTO> usersFound = fromJson(responseEntity);
		Assertions.assertThat(usersFound).hasSize(1);
		Assertions.assertThat(usersFound).first().extracting("id").containsOnly(Integer.valueOf(1));
	}
	
	@Test
	@Rollback
	public void mustReturnUserFindindByUsername() {
		configureUrl(URL_FIND_USERS);
		ResponseEntity<String> responseEntity = this.restTemplate.getForEntity(url, String.class, "my");
		Assertions.assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());
		List<UserDTO> usersFound = fromJson(responseEntity);
		Assertions.assertThat(usersFound).hasSize(1);
		Assertions.assertThat(usersFound).first().extracting("id").containsOnly(Integer.valueOf(1));
	}
	
	@Test
	@Rollback
	public void mustReturn204IfNotFound() {
		configureUrl(URL_FIND_USERS);
		ResponseEntity<String> responseEntity = this.restTemplate.getForEntity(url, String.class, "Apple Juice");
		Assertions.assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.NO_CONTENT.value());
		Assertions.assertThat(responseEntity.getBody()).isNullOrEmpty();
	}
	
	@Test
	@Rollback
	public void musterReturnUsers() {
		configureUrl(URL_FIND_USERS);
		ResponseEntity<String> responseEntity = this.restTemplate.getForEntity(url, String.class, "a");
		Assertions.assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());
		List<UserDTO> usersFound = fromJson(responseEntity);
		Assertions.assertThat(usersFound).hasSize(2);
		Assertions.assertThat(usersFound).extracting("id").containsOnly(Integer.valueOf(1),Integer.valueOf(2));
	}

	private List<UserDTO> fromJson(ResponseEntity<String> responseEntity) {
		List<UserDTO> usersFound = new Gson().fromJson(responseEntity.getBody(),new TypeToken<List<UserDTO>>(){}.getType());
		return usersFound;
	}

}
