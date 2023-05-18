package br.com.icaro.api.domain;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity(name = "TB_USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "ID")
	private Integer id;
	@Column(name = "NAME")
	private String name;
	@Column(unique = true, name = "EMAIL")
	private String email;
	@Column(name = "PASSWORD")
	private String password;
	
	
}
