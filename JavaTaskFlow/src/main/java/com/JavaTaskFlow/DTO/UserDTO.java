package com.JavaTaskFlow.DTO;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.JavaTaskFlow.models.AuthProvider;
import com.JavaTaskFlow.models.Project;
import com.JavaTaskFlow.models.Role;
import com.JavaTaskFlow.models.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserDTO(
    String id,
    @NotBlank(message = "O nome não pode estar em branco")
    String name,
    @NotBlank(message = "O email não pode estar em branco")
    @Email(message = "O email deve ser válido")
    String email,
    @NotBlank(message = "A senha não pode estar em branco")
    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
    String password,
    String profileImageUrl,
    AuthProvider authProvider,
    String companyId,
    Role role,
    Set<Project> projects,
    Instant createdAt,
    Instant updatedAt
) implements Serializable {

    private static final long serialVersionUID = 1L;

    
    public UserDTO(User obj) {
        this(
            obj.getId(),
            obj.getName(),
            obj.getEmail(),
            obj.getPassword(),
            obj.getProfileImageUrl(),
            obj.getAuthProvider(),
            obj.getCompanyId(),
            obj.getRole(),
            obj.getProjects() == null ? new HashSet<>() : new HashSet<>(obj.getProjects()),
            obj.getCreatedAt(),
            obj.getUpdatedAt()
        );
    }

    public User fromDTO(UserDTO objDto) {
        return new User(
            objDto.name(),
            objDto.email(),
            objDto.profileImageUrl(),
            objDto.authProvider(),
            objDto.companyId(),
            objDto.role(),
            objDto.password()
        );
    }
}