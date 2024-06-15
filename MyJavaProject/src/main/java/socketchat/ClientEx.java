package socketchat;

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientEx {

	public static void main(String[] args) {
		BufferedReader inData = null;
		BufferedWriter outData = null;
		ServerSocket server = null;
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);
		try {
			socket = new Socket("localhost", 3333);
			inData = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			outData = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while(true) {
				System.out.print("보내기 : ");
				String strout = scanner.nextLine();
				if(strout.equalsIgnoreCase("goodbye")) {
					outData.write(strout + "\n");
					outData.flush();
					break;
				}
				outData.write(strout + "\n");
				outData.flush();
				String str = inData.readLine();
				System.out.println("서버 : " + str);
			}
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		finally {
		}

	}

}
