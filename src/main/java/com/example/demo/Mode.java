package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mode {
    
    private String name;
    private int itemLevel;
    private String effect;

    public String toString(){
        return this.name + " " + this.itemLevel + " " + this.effect;
    }
}
