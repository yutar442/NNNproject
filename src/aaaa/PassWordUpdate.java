package aaaa;

import java.util.Scanner;

import com.naver.Actions;
import com.naver.BoxInfo;

import kr.co.ca.DoAction;

public class PassWordUpdate implements DoAction{

   @Override
   public void action(Scanner sc) {
      // TODO Auto-generated method stub
      System.out.println("������ ������ ��ȣ�� �Է��ϼ���.");
      int boxnum = sc.nextInt();
      sc.nextLine();
      
      System.out.println("������ ��й�ȣ�� �Է��ϼ���.");
      int pw = sc.nextInt();
      sc.nextLine();
      
      BoxInfo box = new BoxInfo(boxnum, pw);
      
      Actions ac = new Actions();
      ac.Pwupdate(box);
      
   }

}