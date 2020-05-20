package aaaa;

import java.util.List;
import java.util.Scanner;

import com.naver.Actions;
import com.naver.BoxInfo;

public class OpenBox_Update {

	public static void OpenBox_Addin(String id, int password, int boxnum) {

		Scanner sc = new Scanner(System.in);
		Actions info = new Actions();
		String item1 = null;
		String item2 = null;
		String item3 = null;
		boolean loop = true;

		while (loop) {
			List<BoxInfo> resultlist = info.itemSelect(id, password, boxnum);
			System.out.println(resultlist);
			
			item1 = resultlist.get(0).getItem1();
			item2 = resultlist.get(0).getItem2();
			item3 = resultlist.get(0).getItem3();
			
			System.out.println("어느칸에 물건을 넣을까요?");
			System.out.println("0: 첫번째, 1: 두번째, 2: 세번쨰");
			int menu = -1;
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 0:
				if (item1 == null) {
					System.out.println("첫번째 물건을 넣으세요.");
					item1 = sc.nextLine();
					info.BoxUpdate(id, item1, item2, item3);
					break;
				} else {
					System.out.println("그 칸엔 이미 물건이 들어있습니다.");
					break;
				}
			case 1:
				if (item2 == null) {
					System.out.println("두번째 물건을 넣으세요.");
					item2 = sc.nextLine();
					info.BoxUpdate(id, item1, item2, item3);
					break;
				} else {
					System.out.println("그 칸엔 이미 물건이 들어있습니다.");
					break;
				}
			case 2:
				if (item3 == null) {
					System.out.println("세번째 물건을 넣으세요.");
					item3 = sc.nextLine();
					info.BoxUpdate(id, item1, item2, item3);
					break;
				} else {
					System.out.println("그 칸엔 이미 물건이 들어있습니다.");
					break;
				}
			}
			System.out.println("현재 보관중인 물품은 다음과 같습니다.");
			System.out.println(info.itemSelect(id, password, boxnum));
			System.out.println("추가할 물건이 남았나요?");
			System.out.println("0: 예, 1: 아니오");
			int yn = -1;
			yn = sc.nextInt();
			sc.nextLine();

			if (yn == 1) {
				loop = false;
			}
		}
	}

	public static void OpenBox_delete(String id, int password, int boxnum) {

		String item1;
		String item2;
		String item3;
		boolean loop = true;

		while (loop) {
			Scanner sc = new Scanner(System.in);
			Actions info = new Actions();
			System.out.println("어떤 물건을 뺄까요?");
			List<BoxInfo> resultlist = info.itemSelect(id, password, boxnum);
			System.out.println(resultlist);
			item1 = resultlist.get(0).getItem1();
			item2 = resultlist.get(0).getItem2();
			item3 = resultlist.get(0).getItem3();
			System.out.println("0: 첫번째, 1: 두번째, 2: 세번째");
			int menu = -1;
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 0:
				if (item1 != null) {
					System.out.println("첫번쨰 물건을 회수합니다.");
					// 회수처리
					info.BoxUpdate(id, null, item2, item3);

					break;
				} else {
					System.out.println("첫번째 물건이 존재하지 않습니다.");
					break;
				}
			case 1:
				if (item2 != null) {
					System.out.println("두번째 물건을 회수합니다.");
					// 회수처리
					info.BoxUpdate(id, item1, null, item3);
					break;
				} else {
					System.out.println("두번째 물건이 존재하지 않습니다.");
					break;
				}

			case 2:
				if (item3 != null) {
					System.out.println("세번째 물건을 회수합니다.");
					// 회수처리
					info.BoxUpdate(id, item1, item2, null);
					break;
				} else {
					System.out.println("세번째 물건이 존재하지 않습니다.");
					break;
				}
			}
			System.out.println("현재 보관중인 물품은 다음과 같습니다.");
			System.out.println(info.itemSelect(id, password, boxnum));
			System.out.println("회수할 물건이 남았나요?");
			System.out.println("0: 예, 1: 아니오");
			int yn = -1;
			yn = sc.nextInt();
			sc.nextLine();

			if (yn == 1) {
				loop = false;
			}

		}

	}
}