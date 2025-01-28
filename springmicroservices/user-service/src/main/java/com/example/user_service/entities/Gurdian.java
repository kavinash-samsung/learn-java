package com.example.user_service.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverrides({
    @AttributeOverride(
        name="name",
        column=@Column(name="gurdian_name")
    ),
    @AttributeOverride(
        name="email",
        column = @Column(name="gurdian_email")
    ),
    @AttributeOverride(
        name = "mobile",
        column = @Column(name="gurdian_mobile")
    )
})
public class Gurdian {
    private String name;
    private String email;
    private String mobile;
}
