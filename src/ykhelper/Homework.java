package ykhelper;

import java.util.ArrayList;
import java.util.Scanner;

public class Homework {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      System.out.println("입력할 데이터 개수를 적어주세요.");
      int N = sc.nextInt(); //첫번째 줄 : 데이터의 수 입력받기

      ArrayList<Integer> input = new ArrayList<Integer>();
      ArrayList<Integer> find = new ArrayList<Integer>();
      
      if(N >= 1 && N <= 50000) { //입력받는 데이터 수의 조건
         System.out.println(N + "개의 정렬 된 데이터를 입력해주세요.");
         for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            input.add(num); //두번째 줄 :정렬 된 N개의 수를 입력받음         
         } // for
      }     
      else {
         System.out.println("데이터 입력 범위를 초과하였습니다.");
         return;
      } // if - else
      
      System.out.println("찾고싶은 데이터의 개수를 입력하세요.");
      int findCnt = sc.nextInt(); //세번째 줄 : 데이터에서 찾아야 할 특정한 수의 개수
   
      System.out.println(findCnt + "개의 찾고싶은 데이터 값을 입력해주세요.");
      for (int j = 0; j < findCnt; j++) { //findCnt개의 수를 입력받음   
         int findNum = sc.nextInt();
         find.add(findNum); //입력받은 수를 find리스트에 저장   
      } // for
      
      //데이터 비교 후 찾은 데이터의 위치 출력하기
      for (int x = 0; x < find.size(); x++) {
         int point = 1; //첫번째 위치는 1
         for (int y = 0; y < input.size(); y++) {
            if(find.get(x)==input.get(y)) {
               System.out.println(point);
               break; // 입력은 서로 '다른' 수가 되기 때문에 같은거 만나면 바로 if그만 두면 됨
            } 
            else { //비교할 데이터가 같아질 때 까지 point값 증가
               point++;
            } // inner if - else
            
            if(point > input.size()) { //찾으려는 수가 입력받은 데이터에 존재하지 않을 경우
               System.out.println("0"); //0을 출력
            } // inner if
         } // inner for         
      } // for
   } // main
}