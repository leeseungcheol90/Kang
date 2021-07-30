package org.zerock.Store;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StoreDTO[] dtos=new StoreDTO[] {
                StoreDTO.builder().name("만보성").menu("짬뽕").lat(11.33).lng(3.14).score(8.2).build(),
                StoreDTO.builder().name("후니도니").menu("치즈까스").lat(13.33).lng(3.8).score(9.2).build(),
                StoreDTO.builder().name("실낙원").menu("짜장").lat(7.33).lng(7.14).score(8.2).build(),
                StoreDTO.builder().name("다담").menu("한식").lat(9.33).lng(5.14).score(9.2).build()
        };

        Scanner scanner=new Scanner(System.in);
        StoreService service=new StoreService(dtos);
        FindMenuUI ui=new FindMenuUI(scanner,service);
        ui.doJob();
        // StoreUI storeUI=new StoreUI(scanner,service);
        // storeUI.fnMenu();
    }

}