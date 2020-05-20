package PersonInfo;
import java.util.Scanner;

import PersonInfo.Enroll.InsertPerson;
import PersonInfo.Search.PersonSelectCommand;
import kr.co.ca.DoAction;

public class PersonInformation implements DoAction{

	int num = -1;
	
	@Override
	public void action(Scanner sc) {
		System.out.println("ȸ�� ������ ���Ͻø� 0��, ȸ�� ������ ���Ͻø� 1�� �Է����ּ���.");
		String sNum = sc.nextLine();
		num = Integer.parseInt(sNum);
		if(num == 0) {
			new InsertPerson().action1(sc);
		}else if(num == 1) {
			new PersonSelectCommand().action2(sc);;
		}else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
		
		
		
	}

}
