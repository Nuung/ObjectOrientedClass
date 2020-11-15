# ObjectOrientedClass
> Code for ObjectOrientedClass in winter semester.

- OOP 초점, 예제 부터 시작하고 MVC 패턴으로 프로젝트까지
- 매주 실습 자료 (실 과제 자료 제외) 
- 자바 소켓 프로그래밍으로 멀티 채팅 서버 - 클라이언트 구조 구현화
- 기반으로 만든 **Sejong Univ- 트랙 제도 이수 확인 프로그래밍**

<a href="https://github.com/Nuung/ObjectOrientedClass/projects/1"> Go To ' TO DO ' </a>

<div align = "center">
    <img src="https://github.com/Nuung/ObjectOrientedClass/blob/master/images/buildpath.png" width="40%" />
    <img src="https://github.com/Nuung/ObjectOrientedClass/blob/master/images/수업예제진행사진.png" width="40%" />
</div>


## Multi Chatting Program
> 소켓 프로그래밍 + Thread / View / Server / Simple Model / Controller 분화로 가볍게 만든 멀티 채팅 프로그래밍

``` Gson이라는 외부라이브러리로 String을 json으로 처리해서 메세지를 처리함! ``` -> 참고 해 주세요 [Gson](https://github.com/google/gson)


### 시물레이션

<div align = "center">
    <img src="https://github.com/Nuung/ObjectOrientedClass/blob/master/images/multiChat_img3.png" width="70%" />
    <img src="https://github.com/Nuung/ObjectOrientedClass/blob/master/images/multiChat_img4.png" width="70%" />
    <img src="https://github.com/Nuung/ObjectOrientedClass/blob/master/images/multiChat_img5.png" width="70%" />
    <img src="https://github.com/Nuung/ObjectOrientedClass/blob/master/images/multiChat_img6.png" width="70%" />
</div>


### Project 구조

- 프로젝트 핵심 부분
<div align = "center">
    전체 프로젝트 파일 구조 및 형태는 아래와 같습니다. </br>
    <img src="https://github.com/Nuung/ObjectOrientedClass/blob/master/images/multiChat_img1.png" width="70%" /></br>
    Server 에서 만드는 Socket. </br>
    <img src="https://github.com/Nuung/ObjectOrientedClass/blob/master/images/multiChat_server_socket.png" width="70%" /></br>
    Controller 부분. </br>
    <img src="https://github.com/Nuung/ObjectOrientedClass/blob/master/images/multiChat_img2.png" width="70%" /></br>
    Controller Socket 이어주기. </br>
    <img src="https://github.com/Nuung/ObjectOrientedClass/blob/master/images/multiChat_controller_img1.png" width="70%" /></br>
</div>

- 프로젝트 디버깅 및 스레드 생성되는 부분 보기
<div align = "center">
    <img src="https://github.com/Nuung/ObjectOrientedClass/blob/master/images/multiChat_debug1.png" width="70%" /></br>
    <img src="https://github.com/Nuung/ObjectOrientedClass/blob/master/images/multiChat_debug2.png" width="70%" /></br>
</div>


### Class 구조 - UML
- 편의상 인텔리제이로 바꿔서,,, 이클립스 플러그인이 안먹어서,, 핵심만 뽑아낸 UML입니다.

<div align = "center">
    전체 프로젝트 파일 구조 및 형태는 아래와 같습니다. </br>
    <img src="https://github.com/Nuung/ObjectOrientedClass/blob/master/images/multiChat_UML.png" width="70%" /></br>
<div>
