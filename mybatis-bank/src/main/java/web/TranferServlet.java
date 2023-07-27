package web;

import Exceptions.MoneyNotEnoughException;
import Exceptions.TransferException;
import service.AccountService;
import service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*@WebServlet("/transfer")*/
public class TranferServlet extends HttpServlet {
    private AccountService accountService=new AccountServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fromActno = request.getParameter("fromActno");
        String toActno = request.getParameter("toActno");
        double money = Double.parseDouble(request.getParameter("money"));
        //调用业务层的业务方法完成 转账
        try {
            accountService.tranfer(fromActno,toActno,money);
            //调用View完成展示结果
            response.sendRedirect("success.html");
        } catch (MoneyNotEnoughException e) {
            response.sendRedirect("error1.html");
        } catch (TransferException e) {
            response.sendRedirect("error2.html");
        }
    }
}
