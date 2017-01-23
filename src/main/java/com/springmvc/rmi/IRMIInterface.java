package com.springmvc.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 * 开放接口
 *                       
 * @Filename: IRMIInterface.java
 * @Version: 1.0
 * @Author: yanrp 燕如朋
 * @Email: 
 *
 */
public interface IRMIInterface extends Remote {
    void sayHello(String name) throws RemoteException;

    String getSomeThing(String name) throws RemoteException;
}
