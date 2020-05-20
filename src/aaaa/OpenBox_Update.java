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
			
			System.out.println("���ĭ�� ������ �������?");
			System.out.println("0: ù��°, 1: �ι�°, 2: ������");
			int menu = -1;
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 0:
				if (item1 == null) {
					System.out.println("ù��° ������ ��������.");
					item1 = sc.nextLine();
					info.BoxUpdate(id, item1, item2, item3);
					break;
				} else {
					System.out.println("�� ĭ�� �̹� ������ ����ֽ��ϴ�.");
					break;
				}
			case 1:
				if (item2 == null) {
					System.out.println("�ι�° ������ ��������.");
					item2 = sc.nextLine();
					info.BoxUpdate(id, item1, item2, item3);
					break;
				} else {
					System.out.println("�� ĭ�� �̹� ������ ����ֽ��ϴ�.");
					break;
				}
			case 2:
				if (item3 == null) {
					System.out.println("����° ������ ��������.");
					item3 = sc.nextLine();
					info.BoxUpdate(id, item1, item2, item3);
					break;
				} else {
					System.out.println("�� ĭ�� �̹� ������ ����ֽ��ϴ�.");
					break;
				}
			}
			System.out.println("���� �������� ��ǰ�� ������ �����ϴ�.");
			System.out.println(info.itemSelect(id, password, boxnum));
			System.out.println("�߰��� ������ ���ҳ���?");
			System.out.println("0: ��, 1: �ƴϿ�");
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
			System.out.println("� ������ �����?");
			List<BoxInfo> resultlist = info.itemSelect(id, password, boxnum);
			System.out.println(resultlist);
			item1 = resultlist.get(0).getItem1();
			item2 = resultlist.get(0).getItem2();
			item3 = resultlist.get(0).getItem3();
			System.out.println("0: ù��°, 1: �ι�°, 2: ����°");
			int menu = -1;
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 0:
				if (item1 != null) {
					System.out.println("ù���� ������ ȸ���մϴ�.");
					// ȸ��ó��
					info.BoxUpdate(id, null, item2, item3);

					break;
				} else {
					System.out.println("ù��° ������ �������� �ʽ��ϴ�.");
					break;
				}
			case 1:
				if (item2 != null) {
					System.out.println("�ι�° ������ ȸ���մϴ�.");
					// ȸ��ó��
					info.BoxUpdate(id, item1, null, item3);
					break;
				} else {
					System.out.println("�ι�° ������ �������� �ʽ��ϴ�.");
					break;
				}

			case 2:
				if (item3 != null) {
					System.out.println("����° ������ ȸ���մϴ�.");
					// ȸ��ó��
					info.BoxUpdate(id, item1, item2, null);
					break;
				} else {
					System.out.println("����° ������ �������� �ʽ��ϴ�.");
					break;
				}
			}
			System.out.println("���� �������� ��ǰ�� ������ �����ϴ�.");
			System.out.println(info.itemSelect(id, password, boxnum));
			System.out.println("ȸ���� ������ ���ҳ���?");
			System.out.println("0: ��, 1: �ƴϿ�");
			int yn = -1;
			yn = sc.nextInt();
			sc.nextLine();

			if (yn == 1) {
				loop = false;
			}

		}

	}
}