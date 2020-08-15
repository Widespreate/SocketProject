package demo05;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) {

        InetAddress host = null;
        try {
            //获取本机ip
            host = InetAddress.getLocalHost();
            System.out.println(host);
            //网络中任意一台
            InetAddress byName = InetAddress.getByName("www.163.com");
            System.out.println(byName);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
