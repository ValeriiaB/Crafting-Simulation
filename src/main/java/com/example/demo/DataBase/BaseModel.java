package com.example.demo.DataBase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass

public class BaseModel implements Serializable {
    @Id
    @GeneratedValue
    @NotNull
    private long id;
}
