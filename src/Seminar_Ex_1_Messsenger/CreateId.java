package Seminar_Ex_1_Messsenger;

import java.util.List;

public interface CreateId {

    default String createId(List<String> list, String prefix) {
        String str1 = "";
        String str2 = "";
        String id;
        if (!list.isEmpty()) {
            id = list.get(list.size()-1);
            for (int i = 0; i <= id.indexOf("_"); i++) {
                str1 += id.charAt(i);
            }
            for (int i = id.indexOf("_")+1; i <= id.length()-1; i++) {
                str2 += id.charAt(i);
            }
            id = str1 + String.valueOf(Integer.parseInt(str2)+1);
        } else id = prefix;
        return id;
    }
}
