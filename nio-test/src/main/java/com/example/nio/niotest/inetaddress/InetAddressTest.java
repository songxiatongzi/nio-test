package com.example.nio.niotest.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author songxia tongzi
 * @date 2020/11/24 18:12
 */
public class InetAddressTest {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        String hostName = localHost.getHostName();
        String address = localHost.getAddress().toString();
        String hostAddress = localHost.getHostAddress();
        String hostName1 = localHost.getHostName();
        System.out.println(hostName + " " + address + "-" +hostAddress + "-" + hostName1);


    }
}
