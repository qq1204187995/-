package sever;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket s=null;
		try {
			s=new Socket("127.0.0.1",8888);
			System.out.println("服务器连接"+s.getInetAddress().getHostAddress());
			System.out.println("客户端端口号"+s.getPort());
			PrintWriter out =new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
			BufferedReader in =new BufferedReader(new InputStreamReader(s.getInputStream()));
			while(true) {
				Scanner sc=new Scanner(System.in);
				System.out.println("客户端");
				String st=sc.nextLine();
				out.println(st);
				if(st.equals("exit")) {
					break;
				}
				String msg=in.readLine();
				System.out.println("接受服务器消息："+msg);
			}	
			System.out.println("客服端退出");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
