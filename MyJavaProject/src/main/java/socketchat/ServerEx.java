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
			System.out.println("Ŭ���̾�Ʈ���� ������ �ּ���");
			socket = server.accept();
			System.out.println("����Ǿ����ϴ�.");
			inData = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			outData = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while(true) {
				String str = inData.readLine();
				if(str.contentEquals("goodbye")) {
					System.out.println("���� ����");
					break;
				}
				System.out.println("Ŭ���̾�Ʈ:  " + str);
				System.out.print("������ :  ");
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
				System.out.println("ä�õ��� ���� �߻�");
			}
		}

	}

}
