package com.example.demo.DAO;

import com.example.demo.DataBase.Mode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.example.demo.EnumClasses.ActionTypeEnum.ADD;
import static com.example.demo.EnumClasses.ModeTypeEnum.PREFIX;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class ModeDAOTest {
    @Autowired
    ModeDAO modeDAO;

    @Test
    public void Test1(){
        modeDAO.insert(new Mode("asas",1,"assa",PREFIX,1,1,ADD,1,1,"sjjs"));
        assertEquals(1, modeDAO.selectAll().size());
    }
}