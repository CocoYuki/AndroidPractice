// IMyAidlInterface.aidl
package aidl;

interface IMyAidlInterface {
     void addAccount(in Account account);

     List<Account> getAccountList();
}
