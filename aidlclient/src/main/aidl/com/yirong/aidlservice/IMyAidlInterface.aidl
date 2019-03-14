// IMyAidlInterface.aidl
package com.yirong.aidlservice;

interface IMyAidlInterface {
     void addAccount(in Account account);

     List<Account> getAccountList();
}
