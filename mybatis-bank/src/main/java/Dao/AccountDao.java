package Dao;

import pojo.Account;

public interface AccountDao {
    //根据账号查询账户信息
    Account selectByActno(String actno);
    //更新账户信息
    int updateByActno(Account act);
}
