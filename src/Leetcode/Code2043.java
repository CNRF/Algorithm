package Leetcode;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/simple-bank-system/
 * @author mingxing.wang
 * @date 2022/3/18 12:44
 */
public class Code2043 {
    int length;
    HashMap<Integer,Long> map=new HashMap<>();
    public void Bank(long[] balance) {
        this.length=balance.length;
        for (int i = 0; i < balance.length; i++) {
            this.map.put(i+1,balance[i]);
        }
    }

    public boolean transfer(int account1, int account2, long money) {
        if (checkAccount(account1) &&checkAccount(account2)&&(map.get(account1)>=money)) {
            map.put(account1,map.get(account1)-money);
            map.put(account2,map.get(account2)+money);
            return true;
        }
        return false;
    }
    //存款
    public boolean deposit(int account, long money) {
        if (checkAccount(account) ) {
            map.put(account,map.get(account)+money);
            return true;
        }
        return false;
    }
    //取款
    public boolean withdraw(int account, long money) {
        if (checkAccount(account) &&(map.get(account)>=money)) {
            map.put(account,map.get(account)-money);
            return true;
        }
        return false;
    }
    //校验帐号是否存在
    public boolean checkAccount(int account){
        return length>=account;
    }

}
