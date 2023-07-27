package service.impl;

import Dao.AccountDao;
import Dao.impl.AccountDaoImpl;
import Exceptions.MoneyNotEnoughException;
import Exceptions.TransferException;
import org.apache.ibatis.session.SqlSession;
import pojo.Account;
import service.AccountService;
import utils.SqlSessionUtil;
import web.TranferServlet;

public class AccountServiceImpl implements AccountService {

    //动态生成AccountDao的实现类
    private AccountDao accountDao=SqlSessionUtil.openSession().getMapper(AccountDao.class);
    @Override
    public void tranfer(String fromActno, String toActno, double money) throws MoneyNotEnoughException, TransferException {
        //添加事务控制代码
        SqlSession sqlSession = SqlSessionUtil.openSession();

        //1.判断转出账户是否充足(select)
        Account fromAct = accountDao.selectByActno(fromActno);
        if (fromAct.getBalance() < money){
            //2.如果转出账户余额不足，提示用户()
            throw new MoneyNotEnoughException("转账账户余额不足");
        }
        Account toAct = accountDao.selectByActno(toActno);
        fromAct.setBalance(fromAct.getBalance()-money);
        toAct.setBalance(toAct.getBalance()+money);
        //3.如果转出账户月充足，更新转出账户(update)
        int count = accountDao.updateByActno(fromAct);
        //4.更新转入账户余额(update)
        count += accountDao.updateByActno(toAct);
        if (count !=2) {
            throw new TransferException("转账异常,未知原因!!!");
        }
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }
}
