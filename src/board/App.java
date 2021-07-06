package board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import board.dto.Article;
import board.util.Util;

public class App {

	public static void run() {

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
			menuView();
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
//			else if (command.equals("user/article/detail")) {
			else if (command.startsWith("4")) {
				if(!command.contains("?")) {
					System.err.println("아이디를 입력해 주세요.");
					continue;
				}
				String queryString = command.split("\\?",2)[1];
				String[] queryStringBits = queryString.split("&");				
				
			
				
				int	id=0;
								
				for(String queryStringBit : queryStringBits ) {
					String[] queryStringBitBits = queryStringBit.split("=",2);
					
					System.out.println(queryStringBitBits.length);
					if(queryStringBitBits.length < 2) {
						System.err.println("아이디를 입력해 주세요.");
						break;
					}
						
					String paramName = queryStringBitBits[0];
					String paramvalue = queryStringBitBits[1];
					
					if(paramName.equals("id")) {
						id = Integer.parseInt(paramvalue);
					}					
				}				
				if(id==0) {
					System.err.println("아이디를 입력해 주세요.");
					continue;
				}	
				
				Article foundArticle = null;
				for(Article article : articles) {
					if(article.id==id) {
						foundArticle = article;
						break;
					}
				}
				
				if(foundArticle == null) {
					System.out.printf("%d번 게시물은 존재 하지 않습니다.\n", id);
					continue;
				}
				
				articles.remove(foundArticle);
				System.out.printf("%d번 게시물을 삭제 하였습니다.\n", id);
				
				
				
				
			}
			else if (command.startsWith("3")) {
				if(!command.contains("?")) {
					System.err.println("아이디를 입력해 주세요.");
					continue;
				}
				String queryString = command.split("\\?",2)[1];
				String[] queryStringBits = queryString.split("&");				
				
			
				
				int	id=0;
								
				for(String queryStringBit : queryStringBits ) {
					String[] queryStringBitBits = queryStringBit.split("=",2);
					
					System.out.println(queryStringBitBits.length);
					if(queryStringBitBits.length < 2) {
						System.err.println("아이디를 입력해 주세요.");
						break;
					}
						
					String paramName = queryStringBitBits[0];
					String paramvalue = queryStringBitBits[1];
					
					if(paramName.equals("id")) {
						id = Integer.parseInt(paramvalue);
					}					
				}				
				if(id==0) {
					System.err.println("아이디를 입력해 주세요.");
					continue;
				}	
				
				Article foundArticle = null;
				for(Article article : articles) {
					if(article.id==id) {
						foundArticle = article;
						break;
					}
				}
				
				if(foundArticle == null) {
					System.out.printf("%d번 게시물은 존재 하지 않습니다.\n", id);
					continue;
				}
				
				System.out.printf("번호 : %d\n",foundArticle.id);
				System.out.printf("작성일자 : %s\n",foundArticle.regDate);
				System.out.printf("업데이트일자 : %s\n",foundArticle.updateDate);
				System.out.printf("제목 : %s\n",foundArticle.title);
				System.out.printf("내용 : %s\n",foundArticle.body);
				
			}
//			if (command.equals("user/system/exit")) {
			if (command.equals("0")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			System.out.println("텍스트 게시판 끝");
		}
	}

	private static void menuView() {
		System.out.println("--------------텍스트 게시판 -----------------");
		System.out.println("등록:1 리스트:2  선택게시물:3?id=게시물번호  삭제:4?id=게시물번호   종료:0");
		
	}
}