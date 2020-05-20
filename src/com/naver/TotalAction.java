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
		System.out.println("물품 보관소입니다.");
		System.out.println("원하시는 메뉴를 선택하세요");
		System.out.println("0: 회원정보 , 1: 보관함 등록, 2: 보관함 열기, 3: 보관함 변경, 4: 종료");
		String sMenu = sc.nextLine();
		menu = Integer.parseInt(sMenu);
		
		if(menu<command.length) {
			command[menu].action(sc);
		}else {
			isTrue = false;
		}
	}
	
	System.out.println("이용해주셔서 감사합니다.");
	sc.close();
}
}
