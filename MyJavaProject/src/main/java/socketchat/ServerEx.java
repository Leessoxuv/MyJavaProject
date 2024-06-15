package socketchat;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerEx {

	public static void main(String[] args) {
		BufferedReader inData = null;
		BufferedWriter outData = null;
		ServerSocket server = null;
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);
		try {
			server = new ServerSocket(3333);
			System.out.println("클라이언트들은 연결해 주세요");
			socket = server.accept();
			System.out.println("연결되었습니다.");
			inData = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			outData = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while(true) {
				String str = inData.readLine();
				if(str.contentEquals("goodbye")) {
					System.out.println("연결 종료");
					break;
				}
				System.out.println("클라이언트:  " + str);
				System.out.print("보내기 :  ");
				String strout = scanner.nextLine();
				outData.write(strout + "\n");
				outData.flush();
			}
		} catch(IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				scanner.close();
				socket.close();
				server.close();
			} catch(IOException e) {
				System.out.println("채팅도중 오류 발생");
			}
		}

	}

}
