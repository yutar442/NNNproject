package PersonInfo;
import java.util.Scanner;

import PersonInfo.Enroll.InsertPerson;
import PersonInfo.Search.PersonSelectCommand;
import kr.co.ca.DoAction;

public class PersonInformation implements DoAction{

	int num = -1;
	
	@Override
	public void action(Scanner sc) {
		System.out.println("회원 가입을 원하시면 0을, 회원 정보를 원하시면 1을 입력해주세요.");
		String sNum = sc.nextLine();
		num = Integer.parseInt(sNum);
		if(num == 0) {
			new InsertPerson().action1(sc);
		}else if(num == 1) {
			new PersonSelectCommand().action2(sc);;
		}else {
			System.out.println("잘못 입력하셨습니다.");
		}
		
		
		
	}

}
