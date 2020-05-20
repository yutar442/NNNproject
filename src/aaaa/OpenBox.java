package aaaa;

import java.util.List;
import java.util.Scanner;

import com.naver.Actions;
import com.naver.BoxInfo;
import com.naver.PersonInfo;

import kr.co.ca.DoAction;

public class OpenBox implements DoAction {
	
	@Override
	public void action(Scanner sc) {
		
		DoAction[] actions = { new PassWordUpdate() };
		Actions info = new Actions();
		List<PersonInfo> list = info.selectAll();
		boolean isTrue = false;
		int smenu = -1;
		boolean found = false;

		System.out.println("ȸ�� ID�� �Է��ϼ���.");
		String id = sc.nextLine();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(id)) {
				isTrue = true;
			}
		}
		if (isTrue) {
			System.out.println("��ǰ ������ ��й�ȣ�� �Է��ϼ���.");
			int password = sc.nextInt();
			sc.nextLine();
			List<BoxInfo> boxList = info.boxSelectAll();
			 
			for (int i = 0; i < boxList.size(); i++) {
				if (boxList.get(i).getId().equals(id) && boxList.get(i).getPw() == password) {
					System.out.println("��ǰ������ ��й�ȣ �Է� ����");
					System.out.println("�������� ��ǰ�������� ������ �����ϴ�.");
					List<BoxInfo> resultlist = info.itemSelect(id, password, 0);
					System.out.println(resultlist);
					System.out.println("������ ��ȣ�� �������ּ���.");
					int boxnum = sc.nextInt();
					sc.nextLine();
					System.out.println(boxnum +" �� ������ ���õǾ����ϴ�.");
					System.out.println(info.itemSelect(id, password, boxnum));
					
					System.out.println("��� �ұ��?");
					System.out.println("0: ��ǰ �ֱ�, 1: ��ǰ ���� ,2: ��й�ȣ ����, 3: ������ �ݱ�");
					smenu = sc.nextInt();
					sc.nextLine();

					if (smenu < actions.length+2) {
						if ( smenu == 0) { // �޴� 0�� : ��ǰ �ֱ�
							OpenBox_Update.OpenBox_Addin(id, password, boxnum);
						} else if ( smenu == 1) { // �޴� 1�� : ��ǰ����
							OpenBox_Update.OpenBox_delete(id, password, boxnum);
						} else // �޴� 0, 1���� �ƴϸ�{
							actions[smenu-2].action(sc);
						}
					
					found = true;
					break;
					
					} else {
						System.out.println("�������� �ݽ��ϴ�.");
					}
				} 
			if(found == false) {
				System.out.println("���̵� �Ǵ� ������ ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			}
			}
		else {
			System.out.println("ȸ�� ������ ���� id�Դϴ�.");
		}

	}
}