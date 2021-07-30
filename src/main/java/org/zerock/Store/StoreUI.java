package org.zerock.Store;

import java.util.*;

//입출력 위주의 클래스(System.out.println 등의 메서드들...)
public class StoreUI {
    private Scanner scanner; // 여러 메서드들이 공유 상태
    private StoreService storeService; // 협력자 - 의존성

    public StoreUI(Scanner scanner, StoreService storeService) {
        this.scanner = scanner;
        this.storeService = storeService;
    }

    public void fnMenu() {
        System.out.println("원하시는 메뉴가 뭔가요?");
        String menuStr=this.scanner.nextLine();
        System.out.println(menuStr);
        StoreDTO tmp=storeService.findByMenuName(menuStr);
        System.out.println(tmp.getName());
    }

}
