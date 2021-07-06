package board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import board.dto.Article;

public class App {

	public static void run() {
		System.out.println("텍스트 게시판 시작");

		Scanner sc = new Scanner(System.in);
		
		List<Article> articles = new ArrayList<>();
		int lastid =  1;

		while (true) {
			System.out.print("명령어) ");

			String command = sc.nextLine().trim();
//			if (command.equals("user/article/write")) {
			if (command.equals("1")) {
				System.out.print("제목 : ");
				String title = sc.nextLine().trim();
				System.out.print("내용 : ");
				String body = sc.nextLine().trim();

				Article article = new Article();
				article.id = lastid++;
				article.regDate = "2021-07-06 12:12:12";
				article.updateDate = "2021-07-06 12:12:12";
				article.body = body;
				article.title = title;
				articles.add(article);
				System.out.printf("%d번 게시물이 생성 되었습니다.\n",article.id);
				
			}
			if (command.equals("user/system/exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}

			System.out.println("텍스트 게시판 끝");
		}
	}
}
