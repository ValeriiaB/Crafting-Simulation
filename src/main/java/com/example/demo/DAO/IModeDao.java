package com.example.demo.DAO;


import com.example.demo.DataBase.Mode;
import com.example.demo.EnumClasses.ActionTypeEnum;
import com.example.demo.EnumClasses.ModeTypeEnum;

import java.util.List;

public interface IModeDao extends IDAO<Mode> {
    List<Mode> selectWithParams(int itemLevel, ModeTypeEnum modeType);
    List<Mode> selectWithParams(int itemLevel, ModeTypeEnum modeType, ActionTypeEnum actionType);
}
