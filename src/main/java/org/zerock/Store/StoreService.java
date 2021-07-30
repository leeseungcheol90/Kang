package org.zerock.Store;

import java.util.Arrays;
import java.util.Optional;

//로직 위주의 클래스
//메서드 우선 설계
//파라미터와 리턴 타입으로 데이터 위주
//생성자 의미 - ready
//멤버 변수 - 누적/상태/조력자
//고객이 원하는 기능을 가지는 비즈니스 로직을 가지고 있다.
public class StoreService { // 로직 위주의 클래스

    private StoreDTO[] storeDTOS;

    public StoreService(StoreDTO[] storeDTOS) {
        this.storeDTOS = storeDTOS;
    }

    public StoreDTO findByMenuName(String menuName) {
        Optional<StoreDTO> result=
                Arrays.stream(this.storeDTOS).filter(storeDTO -> storeDTO.getMenu().equals(menuName)).findFirst();
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

}