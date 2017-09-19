package com.example.demo.DataBase;

import com.example.demo.DataBase.BaseModel;
import com.example.demo.EnumClasses.ActionTypeEnum;
import com.example.demo.EnumClasses.ModeTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Mode")

public class Mode extends BaseModel implements Serializable {

    @NotNull
    private String effect;
    @NotNull
    private ModeTypeEnum modeTypeEnum;
    @NotNull
    private int minValue;
    @NotNull
    private int maxValue;
    @NotNull
    private ActionTypeEnum actionTypeEnum;
    private int minValueChild;
    private int maxValueChild;
    private String effectChild;

}

