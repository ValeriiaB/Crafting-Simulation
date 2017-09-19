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

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
@Transactional
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
public class ModeDaoAndServiceTest {

    @Autowired
    private ModeDao modeDao;

    static final Long ID = 6L;

    @Test
    public void testSelect() {
        Mode mode = new Mode("effect", ModeTypeEnum.SUFFIX, 1, 1, ActionTypeEnum.ADD, 1, 1, "effectChild" );
        mode.setName("name");
        mode.setItemLevel(1);
        mode.setId(ID);
        modeDao.insert(mode);
        mode = modeDao.select(ID);
        assertNotNull(mode);
    }

    @Test
    public void testUpdate(){
        Mode mode = new Mode("effect", ModeTypeEnum.SUFFIX, 1, 1, ActionTypeEnum.ADD, 1, 1, "effectChild" );
        mode.setName("newName");
        mode.setItemLevel(1);
        mode.setId(ID);
        modeDao.update(mode);
        mode = modeDao.select(ID);
        assertEquals("newName", mode.getName());
    }

    @Test
    public void testDelete(){
        modeDao.delete(ID);
        assertNull(modeDao.select(ID));
    }
}
