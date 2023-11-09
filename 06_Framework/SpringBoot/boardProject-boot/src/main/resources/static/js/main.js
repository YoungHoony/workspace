function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postcode').value = data.zonecode;
            document.getElementById("address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("detailAddress").focus();
        }
    }).open();
}

// 쿠키 얻어오기 함수 

// 변수에 함수 대입 (== 변수로 인식)
// - 해당 변수가 해석될 때 까지 변수에 대입된 함수 호출 불가
const getCookie = (key) => {

  // 현재 존재하는 쿠키를 모두 얻어옴
  const cookies = document.cookie; // 'saveId=member01@naver.com'

  // 배열.map(()=>{}) : 
  // 배열 내 요소를 하나씩 순차접근 후
  // 함수 수행 후 반환되는 결과를
  // 새로운 배열에 담아서 반환              

  //  ['testCookie=테스트', 'saveId=member01@naver.com']

  // cookies 문자열을 '; ' 구분자로해서 배열 생성 후
  // map을 이용해서 cookies의 요소를 '='로 나누어 2차원 배열 생성
  const list = cookies.split('; ').map(entry => entry.split('='));

  // list를 JS 객체로 옮겨 담기
  const obj = {}; // 비어있는 객체 생성

  for(let i=0 ; i<list.length ; i++){
    obj[ list[i][0] ] = list[i][1];
  }

  return obj[key];
} 


// 쿠키에 saveId 가 있을 경우
// 이메일 input 태그에 value로 추가
// + 아이디 저장 체크박스가 체크 되어있게 하기
const memberEmail = document.querySelector("input[name='memberEmail']");
const saveId = document.querySelector("input[name='saveId']");

// 화면에 이메일 input, 체크 박스가 있을 경우
if(memberEmail != null && saveId != null){

  // 쿠키에서 key가 "saveId"인 요소의 값을 얻어옴
  const email = getCookie("saveId"); 

  if(email != undefined){ // saveId가 있을 경우
    memberEmail.value = email; // input 값 대입
    saveId.checked = true; // 체크
  }
}


// -----------------------------------------------------------

/* 이메일, 비밀번호 미 입력 시 로그인 시도 막기 */

// 로그인 form 태그
const loginFrm = document.getElementById("loginFrm");


// 로그인 form태그 있을 경우(로그인 X 상태)
if(loginFrm != null){

  // 로그인 form태그가 submit 되는 것을 감지했을 때 함수 수행
  loginFrm.addEventListener("submit", e => {

    const memberEmail 
      = document.querySelector("input[name='memberEmail']");

    const memberPw
      = document.querySelector("input[name='memberPw']");

    // 이메일 미입력 시
    if(memberEmail.value.trim().length == 0){
      alert("이메일을 입력 해주세요");

      memberEmail.value = ''; // 입력된 공백 제거
      memberEmail.focus(); // 이메일 input에 커서 깜박이게 하기
      
      // submit 이벤트 발생 시 form태그의 기본 이벤트(제출) 제거
      e.preventDefault(); 
      return;
    }

    // 비밀번호 미입력 시
    if(memberPw.value.trim().length == 0){
      alert("비밀번호를 입력 해주세요")
      memberPw.value = '';
      memberPw.focus();
      e.preventDefault();
      return;
    }
    
  });

}
