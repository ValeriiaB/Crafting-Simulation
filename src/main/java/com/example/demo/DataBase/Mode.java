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
import java.util.Random;

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
    @Transient
    private int currentValue;
    @NotNull
    private ActionTypeEnum actionTypeEnum;
    private int minValueChild;
    private int maxValueChild;
    @Transient
    private int currentValueChild;
    private String effectChild;


    @Override
    public boolean equals(Object o){
        if (o == null) return false;
        if (o == this) return true;
        if (!(o instanceof Mode))return false;
        Mode mode = (Mode) o;
        return  super.equals(mode);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    public void setRandomCurrentValues(){
        Random random = new Random();
        this.setCurrentValue(random.nextInt(this.getMaxValue() - this.getMinValue() + 1) + this.getMinValue());
        if(this.getEffectChild() != null)
            this.setCurrentValueChild(random.nextInt(this.getMaxValueChild() - this.getMinValueChild() + 1) + this.getMinValueChild());
    }



}

