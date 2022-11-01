package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    public Map<String, Object> expectedDataMethod(Integer userId, String  title, Boolean completed ) {
        Map<String, Object> expextedDataMap = new HashMap<>();
        expextedDataMap.put("userId", 1);
        expextedDataMap.put("title", "quis ut nam facilis et officia qui");
        expextedDataMap.put("completed", false);

        return expextedDataMap;
    }
}
