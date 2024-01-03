# MadTicket
"몰입캠프 영화상영회" 예매하고 리뷰 작성까지!

## Outline
MadTicket은 몰입캠프 영화 상영회에서 보일 20개의 영화를 함께 보고 싶은 2분반 구성원과 예매를 하고 후기도 작성할 수 있는 앱입니다.

세 개의 탭은 각각 Members, Movie Gallery, Review로 구성되어 있습니다.

**개발환경**
- Android Studio (Java)
- Adobe Illustrator, Adobe Photoshop  

<br>

## Team
박강태(카이스트 전자 19), 정지연(성균관대 소프트웨어 21)

<br>

## Details

### Intro & TabLayout

<img src = "https://github.com/ParkGangtae/madweek1/assets/51894747/8b251be1-dee4-44d3-9a25-ffe6204b580b.jpg" width = 20% height = 20%>

앱을 처음 실행했을 때 2초간 나타나는 로딩화면을 splash로 구현

<img src = "https://github.com/ParkGangtae/madweek1/assets/51894747/fb8eb347-4b31-49aa-84b1-0346b4d8f0ac.jpg" width = 50% height = 50%>

TabLayout을 적용해 TabPagerAdapter를 이용해 각 Fragment를 볼 수 있도록 구현

<br>

### Tab 1: Members
구성원의 프로필을 보고 영화를 예매할 수 있는 탭

### 프로필

- 영화 상영회에 참여할 수 있는 2분반 구성원들의 자기소개 프로필을 보여주는 탭이다. 자기소개 프로필에는 이름 뿐만 아니라 생년월일, MBTI, 연락처, 프로필 사진이 존재한다.  해당 데이터들은 JSON 데이터 형식을 이용하여 RecyclerView로 보여주었다.

<img src = "https://github.com/ParkGangtae/madweek1/assets/127393132/546981b2-e59f-447d-92f3-a4b68ba39aa6.jpg" width = 15% height = 15% >

<img src = "https://github.com/ParkGangtae/madweek1/assets/127393132/d7be5b1e-9ac8-48e5-9689-779c6a36a0e4" width = 15% height = 15% >
<ima src = "https://github.com/ParkGangtae/madweek1/assets/127393132/3a8c8f91-3f4c-448e-8fc6-d74183615a01" width = 15% height = 15% >
  
- 구성원의 프로필을 CardView로 만들었기 때문에 상영회에 참여하고 싶은 구성원들은 예매하기 버튼을 눌러서 각자 영화를 예매할 수 있다.
- 맨 상단에는 SearchView를 추가하여 검색하고 싶은 이름, 생년월일, MBTI, 연락처 중 원하는 텍스트를 입력하고 Submit하면 해당 데이터의 위치로 스크롤이 이동한다. 또한 SearchView의 X 버튼을 누르게 된다면 Tab 1의 최상단으로 이동한다.

<img src = "https://github.com/ParkGangtae/madweek1/assets/127393132/546981b2-e59f-447d-92f3-a4b68ba39aa6" width = 15% height = 15% >

Tab1의 구성원 프로필 

  <img src = "https://github.com/ParkGangtae/madweek1/assets/127393132/3a8c8f91-3f4c-448e-8fc6-d74183615a01" width = 15% height = 15% >
 

Search View 기능 실행 

### 예매하기

- 상영회에 참여하고 싶은 2분반 구성원은 본인의 프로필을 검색한 후, 예매하기 버튼을 누를 수 있다.
- 예매창이 뜨기 전까지 로딩 아이콘이 실행된다.
- 예매창에는 영화에 대한 포스터 사진들이 2행에 걸쳐 Horizontal ScrollView로써 나타난다. 또한 포스터 밑으로 영화에 대한 기본적인 정보들이 제공된다. 영화의 이름 및 관람 연령, 장르, 개봉날짜가 표시된다.
- 각 영화 별로 개별 상영관과 상영 시간표들이 존재하고, 각 시간에 따라 이용할 수 있는 좌석과 전체 좌석을 볼 수 있다. 해당 좌석의 수는 데이터베이스와 연결하여 관리하였다. (SQLite)
- 데이터베이스에는 Seat 테이블이 존재하고 테이블에는 id, time_id, seat_id가 존재하며 id가 primary keyd이다. time_id별로 seat_id를 count 하여 상영 시간에 따른 이용 좌석의 갯수를 관리하였다.

 <img src = "https://github.com/ParkGangtae/madweek1/assets/127393132/82f1b94f-fc9a-424c-958d-e9b4ad60847e" width = 15% height = 15% >

로딩 중 아이콘

<img src = "https://github.com/ParkGangtae/madweek1/assets/127393132/42b20a25-bb4b-4992-b268-b19b273fa201" width = 15% height = 15% >

영화 포스터 및 상영 시간표

- 원하는 영화와 상영관, 상영 시간을 고른 후 TimeCard를 누르게 되면 TimeCard의 배경 색상이 바뀌게 되며 선택되었음을 알 수 있게 표시해주었다. 그런 후에 예매 확정을 누르게 되면 예매에 성공하였다는 알림창이 뜨게 되고, 모바일 티켓이 발행된다.
- 또한 데이터베이스에 존재하는 해당 영화와 시간의 이용할 수 있는 좌석 갯수가 1씩 감소하게 된다. 예매를 확정한 후 예매창을 다시 들어갔을 때, 이용좌석의 갯수가 줄어든 것을 확인할 수 있다.
<img src = "https://github.com/ParkGangtae/madweek1/assets/127393132/e025c839-ca6d-4df4-ad36-aee616747beb" width = 15% height = 15% >

아이언맨 3를 선택함

 <img src = "https://github.com/ParkGangtae/madweek1/assets/127393132/9cd674bd-7e8e-4a6c-822b-a024c247edca" width = 15% height = 15% >

예매확정 버튼 누름

<img src = "https://github.com/ParkGangtae/madweek1/assets/127393132/1dceb910-2b20-440d-9578-7e24f8a25c4b" width = 15% height = 15% >
모바일 티켓 발행

<img src = "https://github.com/ParkGangtae/madweek1/assets/127393132/6f663e4c-7983-47d3-ba06-cb49b8ba4cd8" width = 15% height = 15% >

아이언맨 3 좌석 갯수 감소
<img src = "https://github.com/ParkGangtae/madweek1/assets/127393132/ae456975-9c99-4e88-aee3-7e00ad85032c" width = 15% height = 15% >

이용할 수 없는 좌석 선택

<img src = "https://github.com/ParkGangtae/madweek1/assets/127393132/c3a346fa-69a8-4ea0-8e5e-2d023c258253" width = 15% height = 15% >

예매 실패

- 또한 팝업창 최상단에 위치해있는 X 버튼을 누르면 예매창을 닫을 수 있다.
- 우측 하단에 존재하는 Scroll Down 버튼을 누르면 스크롤이 어디에 있든 창의 최하단으로 자동 스크롤이 되어 예매 확정 버튼을 편리하게 누를 수 있다.

- 또한 팝업창 최상단에 위치해있는 X 버튼을 누르면 예매창을 닫을 수 있다.
- 우측 하단에 존재하는 `ScrollDown` 버튼을 누르면 스크롤이 어디에 있든 창의 최하단으로 자동 스크롤이 되어 예매 확정 버튼을 편리하게 누를 수 있다.

<img src = "https://github.com/ParkGangtae/madweek1/assets/127393132/e025c839-ca6d-4df4-ad36-aee616747beb" width = 15% height = 15% >
창 닫기 버튼 

 <img src = "https://github.com/ParkGangtae/madweek1/assets/127393132/9cd674bd-7e8e-4a6c-822b-a024c247edca" width = 15% height = 15% >

Scroll Down 버튼
<br>

### Tab 2: Movie Gallery
상영작 20개의 포스터와 예고편을 볼 수 있는 탭

<img src = "https://github.com/ParkGangtae/madweek1/assets/51894747/c10569bd-f9d9-4b25-8c5a-541f897aeef0.jpg" width = 20% height = 20%>  

<img src = "https://github.com/ParkGangtae/madweek1/assets/51894747/445774f6-80ec-4489-a651-70e3f53ec944.jpg" width = 20% height = 20%>

LinearLayout (horizontal)에 GridView 2개를 배치해 두 열이 각각 따로 움직일 수 있게 레이아웃 제작

포스터는 3:4 비율로 수정 한 후 앱 컨셉에 맞게 Photoshop을 이용해 편집 과정을 거침

- drawable 폴더에 저장

포스터를 터치하면 DialogView가 나타나 유튜브 영화 예고편이 실행됨

<br>

### Tab 3: Review
영화 리뷰를 작성하고 평균 별점 랭킹을 볼 수 있는 탭

<img src = "https://github.com/ParkGangtae/madweek1/assets/51894747/df2a37de-cb24-4961-bb33-2f0aab3b7708.jpg" width = 20% height = 20%>  

<img src = "https://github.com/ParkGangtae/madweek1/assets/51894747/f849a826-ca16-4f4a-bac5-cb4220f528a2.jpg" width = 20% height = 20%>

RecyclerView를 이용해서 가로 넘겨볼 수 있는 리뷰 모음집과 영화 랭킹을 표시함

- 영화 랭킹은 각 영화에 대한 평균 별점을 소숫점 첫째 자리까지 반올림한 순서대로 나타나고 아직 리뷰가 없는 영화는 표시되지 않음

FloatingActionButton을 이용해서 리뷰를 추가하는 페이지로 넘어가는 버튼 제작

- <리뷰를 작성할 영화를 선택하세요>를 터치하면 RadioButton Dialog가 나타나서 영화를 선택할 수 있고, 텍스트가 해당 영화 제목으로 바뀜
- 리뷰를 작성하지 않으면 <작성> 버튼을 눌러도 반영되지 않음

SQLite Database를 이용해서 해당 영화, 리뷰 내용, 별점, 그리고 각 영화에 대한 평균 별점을 저장함

- 리뷰를 저장하는 Table과 각 영화에 대한 평균 별점이 저장되어 있는 Table 두 개로 나뉨

SwipeRefreshLayout을 적용해 화면을 아래로 당겼을 때 새로고침 하여 최신 리뷰를 반영하도록 함
