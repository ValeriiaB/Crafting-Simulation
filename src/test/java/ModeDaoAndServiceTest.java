import com.example.demo.DAO.ModeDao;
import com.example.demo.DataBase.Mode;
import com.example.demo.EnumClasses.ActionTypeEnum;
import com.example.demo.EnumClasses.ModeTypeEnum;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
@Transactional
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
public class ModeDaoAndServiceTest {

    @Autowired
    private ModeDao modeDao;


    @Test
    public void testSelect() {
        Mode mode = new Mode("effect", ModeTypeEnum.SUFFIX, 1, 1, 1, ActionTypeEnum.ADD, 1, 1, 1,"effectChild" );
        mode.setName("name");
        mode.setItemLevel(1);
        mode = modeDao.insert(mode);
        Long id = mode.getId();
        Mode selectedMode = modeDao.select(id);
        assertEquals(mode, selectedMode);
        modeDao.delete(id);
    }
    @Test
    public void testSelectWithNotEqualNames() {
        Mode mode = new Mode("effect", ModeTypeEnum.SUFFIX, 1, 1, 1, ActionTypeEnum.ADD, 1, 1, 1,"effectChild" );
        mode.setName("name");
        mode.setItemLevel(1);
        mode = modeDao.insert(mode);
        Long id = mode.getId();
        Mode selectedMode = modeDao.select(id);
        mode.setName("another");
        assertNotEquals(mode, selectedMode);
        modeDao.delete(id);
    }

    @Test
    public void testUpdate(){
        Mode mode = new Mode("effect", ModeTypeEnum.SUFFIX, 1, 1, 1, ActionTypeEnum.ADD, 1, 1, 1, "effectChild" );
        mode.setName("name");
        mode.setItemLevel(1);
        mode = modeDao.insert(mode);
        long id = mode.getId();
        Mode updatedMode = new Mode("effect", ModeTypeEnum.SUFFIX, 1, 1, 1, ActionTypeEnum.ADD, 1, 1, 1, "effectChild" );
        updatedMode.setName("newName");
        updatedMode.setItemLevel(1);
        updatedMode.setId(id);
        modeDao.update(updatedMode);
        updatedMode = modeDao.select(id);
        assertNotEquals(updatedMode, mode);
        modeDao.delete(id);
    }

    @Test
    public void testDelete(){
        Mode mode = new Mode("effect", ModeTypeEnum.SUFFIX, 1, 1, 1, ActionTypeEnum.ADD, 1, 1, 1, "effectChild" );
        mode.setName("name");
        mode.setItemLevel(1);
        mode = modeDao.insert(mode);
        long id = mode.getId();
        modeDao.delete(id);
        assertNull(modeDao.select(id));
    }

    @Test
    public void testSelectByModeTypeAndItemLevelLEToGivenValue(){
        Mode mode1 = new Mode("effect", ModeTypeEnum.SUFFIX, 1, 1, 1, ActionTypeEnum.ADD, 1, 1, 1, "effectChild" );
        mode1.setName("name1");
        mode1.setItemLevel(-1);
        Mode mode2 = new Mode("effect", ModeTypeEnum.SUFFIX, 1, 1, 1, ActionTypeEnum.ADD, 1, 1, 1, "effectChild" );
        mode2.setName("name2");
        mode2.setItemLevel(-2);
        Mode mode3 = new Mode("effect", ModeTypeEnum.SUFFIX, 1, 1, 1, ActionTypeEnum.ADD, 1, 1, 1, "effectChild" );
        mode3.setName("name3");
        mode3.setItemLevel(1);
        mode1 = modeDao.insert(mode1);
        mode2 = modeDao.insert(mode2);
        mode3 = modeDao.insert(mode3);
        ArrayList<Mode> expectedList = new ArrayList();
        expectedList.add(mode1);
        expectedList.add(mode2);
        ArrayList<Mode> list = new ArrayList<Mode> (modeDao.selectWithParams(-1, ModeTypeEnum.SUFFIX));
        assertEquals(expectedList, list);
        modeDao.delete(mode1.getId());
        modeDao.delete(mode2.getId());
        modeDao.delete(mode3.getId());

    }
}
