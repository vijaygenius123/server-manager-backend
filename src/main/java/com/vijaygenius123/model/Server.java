package com.vijaygenius123.model;

import com.vijaygenius123.enumaration.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Server {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    @NotEmpty(message = "IP Address Cannot Be Empty")
    private String ipAddress;
    private String name;
    private String memory;
    private String type;
    private String imageUrl;
    private Status status;
}
