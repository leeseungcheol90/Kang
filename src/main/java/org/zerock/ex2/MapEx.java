package org.zerock.ex2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapEx {

    public static void main(String[] args) {
        //key, value
        Map<String,String[]> map=new HashMap<String,String[]>();
        map.put("kor",new String[]{"불고기","비빔밥"});
        map.put("jap",new String[]{"스시","라멘"});
        map.put("wes",new String[]{"피자","스파게티"});

        String[] arr=map.get("wes");
        System.out.println(Arrays.toString(arr));
    }
}
