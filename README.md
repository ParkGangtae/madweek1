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




RecyclerView를 이용해서 가로 넘겨볼 수 있는 리뷰 모음집과 영화 랭킹을 표시함

- 영화 랭킹은 각 영화에 대한 평균 별점을 소숫점 첫째 자리까지 반올림한 순서대로 나타나고 아직 리뷰가 없는 영화는 표시되지 않음

FloatingActionButton을 이용해서 리뷰를 추가하는 페이지로 넘어가는 버튼 제작

- <리뷰를 작성할 영화를 선택하세요>를 터치하면 RadioButton Dialog가 나타나서 영화를 선택할 수 있고, 텍스트가 해당 영화 제목으로 바뀜
- 리뷰를 작성하지 않으면 <작성> 버튼을 눌러도 반영되지 않음

SQLite Database를 이용해서 해당 영화, 리뷰 내용, 별점, 그리고 각 영화에 대한 평균 별점을 저장함

- 리뷰를 저장하는 Table과 각 영화에 대한 평균 별점이 저장되어 있는 Table 두 개로 나뉨

SwipeRefreshLayout을 적용해 화면을 아래로 당겼을 때 새로고침 하여 최신 리뷰를 반영하도록 함
