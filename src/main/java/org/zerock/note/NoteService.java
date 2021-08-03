package org.zerock.note;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NoteService {
    Map<String, ArrayList<NoteDTO>> map=new HashMap<>();
    Integer index=0;

    public Integer add(NoteDTO noteDTO) {
        String owner=noteDTO.getWhom();
        noteDTO.setNum(++index);
        if (map.get(owner)==null) {
            ArrayList<NoteDTO> noteDTOS=new ArrayList<>();
            noteDTOS.add(noteDTO);
            map.put(owner,noteDTOS);
        } else {
            map.get(owner).add(noteDTO);
        }
        return index;
    }

    public ArrayList<NoteDTO> getList(String owner) {
        return map.get(owner);
    }


}
