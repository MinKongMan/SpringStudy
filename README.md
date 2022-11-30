# SpringStudy
스프링 공부


# 서버
  ### Web 서버란?
  - 클라이언트로부터 HTTP요청을 받아 정적 컨텐츠(.html, jpg, .css파일 등)를 제공하는 컴퓨터 프로그램
  > 정적 컨텐츠는 바로 자원을 제공하지만 동적 컨텐츠는 클라이언트의 Request를 WAS서버에 보냄.
  > #### Apache란?
  > > 아파치 소프트웨어 재단에서 만든 웹서버<br/>
  > > 정적인 데이터들에 대한 클라이언트의 요청을 데이터로 만들어서 응답한다.<br/>

  - 데이터를 전송하기 위해 HTTP 프로토콜을 사용
  
  ### Was 써버란?
  - DB 조회나 로직 처리를 요구하는 동적 컨텐츠를 제공하기 위해 만들어진 Application Server
  - Web Container 혹은 Servlet Container라고 불림.
  > #### Tomcat란?
  > > 아파치 소프트웨어 재단의 웹 어플리케이션 서버로서, 자바 서블릿을 실행시키고 JSP가 포함되어 있는 웹페이지 생성<br/>
  > > JSP와 서블릿 처리, 서블릿 수명 주기 관리<br/>

  ### Servlet이란?
  - Dynamic Web Page를 만들 때 사용되는 자바 기반의 웹 애플리케이션 프로그래밍 기술
  > 1. 클라이언트 요청에 대해 동적으로 작용하는 웹 어플리케이션 컴포넌트
  > 2. html을 사용해서 요청에 응답
  > 3. Java thread를 통해 작동된다.
  > 4. MVC 패턴 중 Controller로 이용된다.
  
# DI, Ioc
   ### DI
   - 의존성 주입 방식으로, 보다 상위 클래스(전체를 아우를 수 있는)를 생성하고<br/> 
   구현하고자 하는 기능에서 상속을 통해 클래스를 생성하고 의존성 주입을 한다.
   > 1. @Autowired, 생성자, Setter 3가지 방식으로 의존성 주입이 가능하다.
   > 2. 클래스간의 결합도가 낮아져서 유연성이 높아진다.
   
   ### Ioc
   - 제어의 역전으로, 개발자가 직접 객체 생성이나 코드의 흐름을 프로그래밍 하는 것이 아닌 <br/>
   프레임워크가 사용하는 파일에 작성하면 이를 토대로 프레임워크가 객체를 생성하고 반환하는 동작을 함.
   
# 스레드 풀
  - 작업 처리에 사용되는 스레드를 제한된 개수만큼 정해놓고 작업 큐에 들어오는 작업들을 쓰레드가 맡아 처리.<br/>
  -> 사용 이유 : 병렬 작업 처리가 많아지면 스레드 개수가 증가되고, 그에 따른 스레드 생성과 스케줄링으로 인한 CPU가 바빠져 메모리 사용량 증가
     즉 성능 저하로 이어질 수 있다.
  
  
# Dispatcher Servlet
  - 디스패처 서블릿은 클라이언트의 모든 요청을 한 곳으로 받아 처리한다. 요청에 맞는 Handler로 요청을 전달하고 실행 결과를 <br/>Http Response 형태로 만들어서 반환한다.
  > 1. front-controller의 역할을 하는 dispatcher servlet이 request를 받는다.
  > 2. Dispatcher servlet이 적절한 controller를 선택하는 일을 Handler Mapping에게 요청한다.
  > 3. HandlerMapping은 적절한 Controller를 찾는다.
  > 4. Dispatcher Servlet은 선택된 controller의 비즈니스 로직실행 작업을 HandlerAdpater에게 위임한다.
  > 5. HandlerAdpater가 controller의 비지니스 로직을 호출하고 결과를 ModelAndView객체에 담아서 Dispatcher Servlet으로 return
  > 6. Dispatcher Servlet이 ViewResolver를 활용하여 결과를 보여줄 View를 가져온다.
  > 7. View 객체에게 Dispatcher Servlet이 응답 결과 생성을 요청한다. <br/>
  
    ```
      HandlerMapping은 원하는 handler(request URL에 알맞는 메소드)를 가져오는 역할
    ```
