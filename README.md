## 영화 예매 시스템 구현

### 요구조건

- [x] 데이터 세팅
    - [x] MovieRepository 영화 순번 (id), 영화 제목(title), 러닝타임(runningTime), 가격(fee), 할인 정책(discountPolicy) 
    - [x] ScreeningRepository 영화(movie), 상영회차(sequence), 시작 시간(whenScreened)
- [x] 영화 선택 (Movie)
    - [x] 처음에 보고자하는 영화 id 값으로 영화를 선택한다. ("보고싶은 영화를 선택해주세요")
    - [x] "1. 기생충 144분 9000원"
- [x] 상영 회차 선택 (Screening)
    - [x] 보고 싶은 상영 회차를 해당 회차를 입력하여 선택한다. ("보고싶은 회차를 선택해주세요")
    - [x] "기생충 1회차 14:00 ~ 종료시간"
- [x] 인원 수 입력 (audienceCount)
    - [x] "예매 인원 수를 입력해 주세요"
- [ ] 결제
    - [x] 할인 적용 후 최종 금액 계산
    - [ ] 결제 수단 선택 ("결제 수단을 선택해주세요 1) 현금 2) 카드")
    - [ ] 현금 결제 시 5% 할인
    - [ ] 결제 확인 메세지
- [ ] 예매
    - [ ] 결제 확인 시 예매 인스턴스 생성
    - [ ] 예매 확인 메세지 출력 ("기생충 1회차 2명 예약 되었습니다")
- [x] 각 영화들은 아래 두 할인 정책 중 한가지를 선택하여 적용할 수 있다.
    - [x] 금액 할인 정책 : "특정 절대 금액만큼 할인해줌"
    - [x] 비율 할인 정책 : "영화 금액의 특정 비율만큼을 할인해줌"
- [x] 할인 조건 입력 (어느 상영에 할인을 해줄 것인가)
    - [x] 순서 조건 
    - [x] 기간 조건

---
### 객체 구조

- Reservation
- Movie
- Screening
- Payment [enum]
- ConfirmResponse [enum]
- DiscountCondition [interface]
    - SequenceCondition
    - PeriodCondition
- DiscountPolicy [interface]
    - AmountDicountPolicy
    - PercentDiscountPolicy
    - NoneDiscountPolicy