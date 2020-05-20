package aaaa;

import java.util.Scanner;

import com.naver.Actions;
import com.naver.BoxInfo;

import kr.co.ca.DoAction;

public class PassWordUpdate implements DoAction{

   @Override
   public void action(Scanner sc) {
      // TODO Auto-generated method stub
      System.out.println("변경할 보관함 번호를 입력하세요.");
      int boxnum = sc.nextInt();
      sc.nextLine();
      
      System.out.println("변경할 비밀번호를 입력하세요.");
      int pw = sc.nextInt();
      sc.nextLine();
      
      BoxInfo box = new BoxInfo(boxnum, pw);
      
      Actions ac = new Actions();
      ac.Pwupdate(box);
      
   }

}