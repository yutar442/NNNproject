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

		System.out.println("회원 ID를 입력하세요.");
		String id = sc.nextLine();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(id)) {
				isTrue = true;
			}
		}
		if (isTrue) {
			System.out.println("물품 보관함 비밀번호를 입력하세요.");
			int password = sc.nextInt();
			sc.nextLine();
			List<BoxInfo> boxList = info.boxSelectAll();
			 
			for (int i = 0; i < boxList.size(); i++) {
				if (boxList.get(i).getId().equals(id) && boxList.get(i).getPw() == password) {
					System.out.println("물품보관함 비밀번호 입력 성공");
					System.out.println("보유중인 물품보관함은 다음과 같습니다.");
					List<BoxInfo> resultlist = info.itemSelect(id, password, 0);
					System.out.println(resultlist);
					System.out.println("보관함 번호를 선택해주세요.");
					int boxnum = sc.nextInt();
					sc.nextLine();
					System.out.println(boxnum +" 번 보관함 선택되었습니다.");
					System.out.println(info.itemSelect(id, password, boxnum));
					
					System.out.println("어떻게 할까요?");
					System.out.println("0: 물품 넣기, 1: 물품 빼기 ,2: 비밀번호 변경, 3: 보관함 닫기");
					smenu = sc.nextInt();
					sc.nextLine();

					if (smenu < actions.length+2) {
						if ( smenu == 0) { // 메뉴 0번 : 물품 넣기
							OpenBox_Update.OpenBox_Addin(id, password, boxnum);
						} else if ( smenu == 1) { // 메뉴 1번 : 물품빼기
							OpenBox_Update.OpenBox_delete(id, password, boxnum);
						} else // 메뉴 0, 1번이 아니면{
							actions[smenu-2].action(sc);
						}
					
					found = true;
					break;
					
					} else {
						System.out.println("보관함을 닫습니다.");
					}
				} 
			if(found == false) {
				System.out.println("아이디 또는 보관함 비밀번호가 틀렸습니다.");
			}
			}
		else {
			System.out.println("회원 정보에 없는 id입니다.");
		}

	}
}