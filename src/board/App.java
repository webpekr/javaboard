package board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import board.dto.Article;
import board.util.Util;

public class App {

	public static void run() {
		System.out.println("텍스트 게시판 시작");

		Scanner sc = new Scanner(System.in);

		List<Article> articles = new ArrayList<>();
		int lastid = 1;
		
		long beforeTime = System.currentTimeMillis();
		for(int i=0;i<10;i++) {
			Article article = new Article();
			article.id = lastid++;
			article.regDate = Util.getNowDateStr();
			article.updateDate = Util.getNowDateStr();
			article.body = "내용 : " + article.id;
			article.title = "제목 : " + article.id;
			articles.add(article);						
		}
		long afterTime = System.currentTimeMillis();
		long secDiffTime = (afterTime - beforeTime)/1000;
		System.out.println("실행시간(m) : "+secDiffTime);
		

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
				article.regDate = Util.getNowDateStr();
				article.updateDate = Util.getNowDateStr();
				article.body = body;
				article.title = title;
				articles.add(article);
				System.out.printf("%d번 게시물이 생성 되었습니다.\n", article.id);

			}
//			else if (command.equals("user/article/list")) {
			else if (command.equals("2")) {
				System.out.printf("번호\t제목\t\t작성날짜\n");

				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
					System.out.printf("%d)\t%s\t%s\t\n", article.id, article.title, article.regDate);
				}
//				for(Article article : articles) {
//					System.out.printf("%d)\t%s\t%s\t\n",article.id,article.title,article.regDate);
//				}

			}
			if (command.equals("user/system/exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}

			System.out.println("텍스트 게시판 끝");
		}
	}
}
