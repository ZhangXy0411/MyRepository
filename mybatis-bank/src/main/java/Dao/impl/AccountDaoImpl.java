package Dao.impl;

import Dao.AccountDao;
import org.apache.ibatis.session.SqlSession;
import pojo.Account;
import utils.SqlSessionUtil;

public class AccountDaoImpl implements AccountDao {
    @Override
    public Account selectByActno(String actno) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Account account = (Account) sqlSession.selectOne("pojo.Account.selectByActno", actno);
        return account;
    }

    @Override
    public int updateByActno(Account act) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.update("pojo.Account.updateByActno",act);
        return count;
    }
}
