package com.example.demo.DAO;

import com.example.demo.DataBase.Mode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

import static com.example.demo.EnumClasses.ActionTypeEnum.ADD;
import static com.example.demo.EnumClasses.ModeTypeEnum.PREFIX;
import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
public class ModeDAOSpringDataTest {
    @Autowired
    ModeDAOSpringData modeDAOSpringData;

    @Test
    public void Test1(){

        modeDAOSpringData.insert(new Mode("asas",1,"assa",PREFIX,1,1,ADD,1,1,"sjjs"));
        List<Mode> list = modeDAOSpringData.selectAll();
         assertEquals(1,list.size());

    }

}