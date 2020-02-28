## 영화 예매 시스템 구현

### 요구조건
    
- 현재 상영하는 영화(movie), 할인 정책, 할인조건 관련된 데이터가 static 으로 주어진다.
- 처음에 보고자하는 영화 id 값으로 영화를 선택한다.
    - `보고싶은 영화를 선택해주세요`
- 해당 영화가 가지고 있는 상영(screening) 데이터가 static 으로 주어지고 역시 id 값으로 회차를 선택한다.
    - `보고싶은 회차를 선택해주세요`
- 인원 수를 입력 한다.
    - `예매할 인원 수를 입력해 주세요`
- 결제 금액 계산하여 출력한다.
- 결제 수단을 선택한다.
    - `결제 수단을 선택해주세요 1) 현금 2) 카드`
- ~~현금 결제시 5% 적립 및 할인 해준다.~~ (보류)
- 각 영화들은 아래 두 할인 정책 중 한가지를 선택하여 적용할 수 있다.
    - 금액 할인 정책 : `특정 절대 금액만큼 할인해줌`
    - 비율 할인 정책 : `영화 금액의 특정 비율만큼을 할인해줌`
- [ ] 할인 조건 입력 (어느 상영에 할인을 해줄 것인가)
    - 순서 조건 : `할인해 줄 회차 순번을 입력해주세요`
    - 기간 조건 : `기간 조건에 해당하는 시작시간 종료시간을 입력해 주세요`
    ---
---

### 객체 구조

- Reservation
- Movie
- Screening
- Payment [enum]
- DiscountCondition [interface]
    - SequenceCondition
    - PeriodCondition
- DiscountPolicy [interface]
    - AmountDicountPolicy
    - PercentDiscountPolicy
    - NoneDiscountPolicy