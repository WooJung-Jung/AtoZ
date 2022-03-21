# AtoZ

<h2>Ground Rule</h2>
<li>1. 코드리뷰 요청오면 바로 바로 리뷰하기</li>
<li>2. 팀원 의견 경청하기</li>
<li>3. 정시 퇴근</li>
<li>4. 1 commit 당 1 기능</li>
<li>5. 1 commit 당 100줄 이내</li>
<li>6. 의미 있는 리뷰 남기기</li>
<li>7. Commit시 코드를 작성하면서 외부 자료에서 알아낸 특이점 있을 시 공유하기</li>
<li>8. Commit 제목은 의미와 의도를 알 수 있도록 하기</li>

<h2>Git Branch 전략</h2>
![image](https://user-images.githubusercontent.com/101777810/159229234-1e4d39f6-f560-4297-989d-621105e77b77.png)


<h2>Git 커밋 메세지 스타일 가이드</h2>
<p>참조: https://siyoon210.tistory.com/56</p>
<h3>메시지 구조</h3>
<p>커밋 메시지는 세가지 파트로 나누고 각 파트는 빈줄을 두어서 구분합나다.</p>
<pre>
<p>type: subject</p>
<p>body(옵션)</p>
<p>footer(옵션)</p>
</pre>
<ul style="list-style-type: square;">
  <li>type : 어떤 의도로 커밋했는지를 type에 명시합니다. 자세한 사항은 아래서 설명하겠습니다.</li>
  <li>subject : 최대 50글자가 넘지 않도록 하고&nbsp;마침표는 찍지 않습니다. 영문으로 표기하는 경우 동사(원형)을 가장 앞에 두고 첫글자는 대문자로 표기합니다.&nbsp;</li>
  <li>body: 긴 설명이 필요한 경우에 작성합니다. <b>어떻게</b> 했는지가 아니라,&nbsp;<b>무엇</b>을 <b>왜 </b>했는지 작성합니다. 최대 75글자를 넘기지 않도록 합니다.</li>
  <li>footer : issue tracker ID를 명시하고 싶은 경우에 작성합니다.</li></ul><h3>타입 type</h3><ul style="list-style-type: square;"><li><b>feat</b> : 새로운 기능 추가</li>
  <li><b>fix</b> : 버그 수정</li><li><b>docs</b> : 문서의 수정</li><li><b>style</b> : (코드의 수정&nbsp;없이) 스타일(style)만 변경(들여쓰기 같은 포맷이나 세미콜론을 빼먹은 경우)</li>
  <li><b>refactor</b> : 코드를 리펙토링</li><li><b>test</b> : Test 관련한 코드의 추가, 수정</li><li><b>chore</b> : (코드의 수정&nbsp;없이)&nbsp;설정을 변경</li></ul>
<h3>커밋 메시지 예제</h3>
<pre>feat: Summarize changes in around 50 characters or less
