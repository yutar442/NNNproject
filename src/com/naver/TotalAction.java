package com.naver;

import java.util.Scanner;
import PersonInfo.PersonInformation;
import aaaa.OpenBox;
import kr.co.ca.DoAction;

public class TotalAction {
public TotalAction() {
	// TODO Auto-generated constructor stub
	DoAction[] command = {new PersonInformation() , new OpenBox()};
	int menu = -1;
	boolean isTrue = true;
	Scanner sc = new Scanner(System.in);
	
	while(isTrue) {
		System.out.println("��ǰ �������Դϴ�.");
		System.out.println("���Ͻô� �޴��� �����ϼ���");
		System.out.println("0: ȸ������ , 1: ������ ���, 2: ������ ����, 3: ������ ����, 4: ����");
		String sMenu = sc.nextLine();
		menu = Integer.parseInt(sMenu);
		
		if(menu<command.length) {
			command[menu].action(sc);
		}else {
			isTrue = false;
		}
	}
	
	System.out.println("�̿����ּż� �����մϴ�.");
	sc.close();
}
}
