package javtang;

import java.util.List;

public abstract class Lists {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static <T> List<T> concat(List list1, List... ls) {
        if (ls == null || ls.length == 0) {
            return list1;
        }
        List ret = list1;
        for (List l : ls) {
            ret.addAll(l);
        }
        return ret;
    }
}
