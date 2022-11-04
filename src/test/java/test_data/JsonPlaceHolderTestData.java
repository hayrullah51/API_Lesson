package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    public Map<String, Object> expectedDataMethod(Integer userId, String  title, Boolean completed ) {
        Map<String, Object> expextedDataMap = new HashMap<>();

        if (userId!=null){
            expextedDataMap.put("userId", userId);
        }
        if (title!=null){
            expextedDataMap.put("title", title);
        }
        if (completed!=null){
            expextedDataMap.put("completed", completed);
        }



        return expextedDataMap;
    }
}
