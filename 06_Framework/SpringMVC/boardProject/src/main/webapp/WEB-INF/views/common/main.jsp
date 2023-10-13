<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 프로젝트</title>

     <%-- 
        <jsp:include page="jsp파일경로" /> 

        - JSP 액션 태그 (jsp에 기본 내장된 태그)
        - 다른 jsp 파일의 코드를 현재 위치에 추가(포함)
        - jsp 파일 경로는 webapp 폴더를 기준으로 작성
        - 코드 재사용성 증가가 된다!!!
    --%>
     <jsp:include page="/WEB-INF/views/common/common.jsp" />

</head>
<body>

    <main>
        <%-- header.jsp 추가(포함) --%>
        <jsp:include page="/WEB-INF/views/common/header.jsp" />

        <section class="content">
            <section class="content-1">
        
            </section>

            <section class="content-2">

            <%-- 어떤 scope에도 loginMember가 없거나 null이면 --%>
            <c:if test="${empty loginMember}">
                <form action="/member/login" method="POST" id="loginFrm">
                    <fieldset class="id-pw-area">
                        <section>
                            <input type="text" name="memberEmail" 
                                placeholder="이메일" autocomplete="off" value="" >

                            <input type="password" name="memberPw" placeholder="비밀번호">                  
                        </section>
                        <section>
                            <button>로그인</button>
                        </section>
                    </fieldset>

                    <label>
                        <input type="checkbox" name="saveId"  > 아이디 저장
                    </label>

                    <article class="signup-find-area">
                        <a href="/member/signup">회원가입</a>
                        <span>|</span>
                        <a href="#">ID/PW 찾기</a>
                    </article>
                </form>
            </c:if>

            <%-- loginMember가 존재하는 scope가 있을 때 --%>
            <c:if test="${not empty loginMember}">

                <article class="login-area">

                    <a href="/myPage/profile">
                        <img id="memberProfile" src="/resources/images/user.png">
                    </a>
                
                    <div class="my-info">
                        <div>
                            <a href="/myPage/info" id="nickname">${loginMember.memberNickname}</a>
                            <a href="/member/logout" id="logoutBtn">로그아웃</a>
                        </div>

                        <p>${loginMember.memberEmail}</p>
                    </div>

                </article>
            
            </c:if>


                
            </section>
        </section>
    </main>
    
    <%-- footer --%>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <!-- main.js 추가 -->
    <script src="/resources/js/main.js"></script>
</body>
</html>