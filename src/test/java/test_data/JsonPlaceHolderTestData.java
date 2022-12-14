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

    public String expectedDataInString(int userId, String title, boolean completed ){
        String expectedData = "{\n" +
                "                 \"userId\": "+userId+",\n" +
                "                 \"title\": \""+title+"\",\n" +
                "                 \"completed\": "+completed+"\n" +
                "               }";

        return expectedData;
    }
}
/*
{
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
               }
 */
