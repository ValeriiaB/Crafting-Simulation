package com.example.demo;

import com.example.demo.EnumClasses.ActionTypeEnum;
import com.example.demo.EnumClasses.ModeTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Mode extends BaseIdClass implements Serializable {

    private String name;
    private int itemLevel;
    private String effect;
    private ModeTypeEnum modeTypeEnum;
    private int minValue;
    private int maxValue;
    private ActionTypeEnum actionTypeEnum;
    private int minValueChild;
    private int maxValueChild;
    private String effectChild;

}

