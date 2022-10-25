package kr.co.ezen;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrivateMethodCall {

   public static void main(String[] args) {
      Hello hello = new Hello();
      //hello.main1();      //private이라서 외부 호출 불가
      
      /*
       * http://localhost:8080/ezen/hello 실행 시 main1() 호출된다.
       *    - reflection api를 사용했기 때문에 가능하다.
       *       - 클래스 정보를 얻고 다룰 수 있는 강력한 기능 제공
       *       - java.lang.reflect 패키지를 제공
       */
      try {
         /*
          * Hello 클래스의 Class 객체(클래스의 정보를 담고있는 객체)를 얻어 온다.
          *       - 클래스 파일(*.class)이 메모리에 올라갈때,
          *         클래스마다 Class 객체가 하나씩 생성된다.
          */
         Class helloClass = Class.forName("kr.co.ezen.Hello");
         Hello hello2 = (Hello) helloClass.newInstance(); //Class객체가 가진 정보로 객체 생성
         
         Method main1 = helloClass.getDeclaredMethod("main1");
         main1.setAccessible(true); //private인 main1()을 접근가능하게 한다.
         
         main1.invoke(hello2);
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {e.printStackTrace();}
      
      
   }
}