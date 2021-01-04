package test;

import com.NGU.ssh.DAO.Imp.MemberDaoImp;
import com.NGU.ssh.Model.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/*嵌入Spring里面去测试*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:Beans.xml")
/*嵌入Spring里面去测试*/

//@Transactional//除查以外的操作
@Transactional(readOnly = true)//查询数据库时，只能查，干别的不行！
public class MemberDaoImpTest {
    @Resource(name = "memberDaoImp")
    MemberDaoImp memberDaoImp;
    @Resource(name = "member")
    Member member;

    @Test
    public void getMemberActList() {
//        member.setMember_account("ppt");
//        List<Member> list = memberDaoImp.getMemberActList();

    }
}