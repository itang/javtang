package javtang;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ListsTest extends Assert {

    @Test
    public void concat() {
        List<String> list1 = newArrayList("1", "2");
        List<String> list2 = newArrayList("3", "4");
        List<String> list3 = newArrayList("5", "6");
        List<String> ret = Lists.concat(list1, list2, list3);
        assertThat(ret, equalTo((List<String>) newArrayList("1", "2", "3", "4", "5", "6")));
    }
}
