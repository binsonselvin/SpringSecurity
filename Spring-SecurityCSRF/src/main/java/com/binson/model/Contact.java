package com.binson.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Contact {
	
	/*
	 * @NotBlank --> trimmed length should be greater than 0
	 * @NotEmpty --> length should be greater than 0
	 * @NotNull --> values should not be null
	 */
	
	@NotBlank(message = "Name cannot be empty")
	private String name;
	
	@NotBlank(message = "phoneno cannot be empty")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Please enter only numeric values")
	@Size(min=10, max=10, message = "Phoneno length should be 10 digit")
	private String phoneno;
	
	@NotBlank(message="this field is required email")
	@Email
	private String email;
	
	private String subject;
	
	@NotBlank
	@Size(min=10, max = 45)
	private String message;
	
}
