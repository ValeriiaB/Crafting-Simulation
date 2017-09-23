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


    @Override
    public boolean equals(Object o){
        if (o == null) return false;
        if (o == this) return true;
        if (!(o instanceof Mode))return false;
        Mode mode = (Mode) o;
        return  super.equals(mode) &&
                mode.getEffect().equals(this.getEffect()) &&
                mode.getActionTypeEnum().equals(this.getActionTypeEnum()) &&
                mode.getEffectChild().equals(this.getEffectChild()) &&
                mode.getModeTypeEnum().equals(this.getModeTypeEnum()) &&
                mode.getMaxValue() == this.getMaxValue() &&
                mode.getMinValue() ==this.getMinValue() &&
                mode.getMaxValueChild() == this.getMaxValueChild() &&
                mode.getMinValueChild() == this.getMinValueChild();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.getEffect().hashCode();
        result = 31 * result + this.getActionTypeEnum().hashCode();
        result = 31 * result + this.getEffectChild().hashCode();
        result = 31 * result + this.getModeTypeEnum().hashCode();
        result = 31 * result + this.getMaxValueChild();
        result = 31 * result + this.getMinValueChild();
        result = 31 * result + this.getMaxValue();
        result = 31 * result + this.getMinValue();
        return result;
    }



}

