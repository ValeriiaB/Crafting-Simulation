package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class BaseModel implements Serializable {
    private long id;
}
