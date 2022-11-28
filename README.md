# SpringStudy
스프링 공부


# 서버
  ### Web 서버
  - 데이터를 전송하기 위해 HTTP 프로토콜을 사용
  ### Was 써버

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
  > 7. View 객체에게 Dispatcher Servlet이 응답 결과 생성을 요청한다. 
    ```
      HandlerMapping은 원하는 handler(request URL에 알맞는 메소드)를 가져오는 역할
    ```
