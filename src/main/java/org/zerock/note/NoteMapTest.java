package org.zerock.note;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NoteMapTest {

    public static void main(String[] args) {
        Map<String, ArrayList<NoteDTO>>  noteMap=new HashMap<>();
        String who="user1";
        NoteDTO newbie=NoteDTO.builder().who("user2").whom("user1").content("커피한잔?").build();
        ArrayList<NoteDTO> noteDTOS=noteMap.get(who);

        //기존에 아무런 쪽지가 없다.
        if (noteDTOS==null) {
            ArrayList<NoteDTO> noteList=new ArrayList<>();
            noteList.add(newbie);
            noteMap.put(who,noteList);
        } else {
            noteDTOS.add(newbie);
        }
    }
}
