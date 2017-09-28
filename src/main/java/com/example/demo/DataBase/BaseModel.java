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
    @NotNull
    private String name;
    @NotNull
    private int itemLevel;

    @Override
    public boolean equals(Object o){
        if (o == null) return false;
        if (o == this) return true;
        if (!(o instanceof BaseModel))return false;
        BaseModel item = (BaseModel) o;
        return  item.getId()== this.getId();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.getId());
        return result;
    }
}
