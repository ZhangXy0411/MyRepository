package service;

import Exceptions.MoneyNotEnoughException;
import Exceptions.TransferException;

public interface AccountService {
    public void tranfer(String fromActno,String toActno,double money) throws MoneyNotEnoughException, TransferException;
}
