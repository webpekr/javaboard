package board;

import java.util.Scanner;

public class App {

	public static void run() {
		System.out.println("텍스트 게시판 시작");

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("명령어) ");

			String command = sc.nextLine().trim();

			if (command.equals("user/system/exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}

			System.out.println("텍스트 게시판 끝");
		}
	}
}
