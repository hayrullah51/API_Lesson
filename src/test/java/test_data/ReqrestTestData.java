package test_data;

import java.util.HashMap;
import java.util.Map;

public class ReqrestTestData {

    public Map<String,String> expectedDataMethod (String name, String job){

        Map<String,String> exceptedDataMap = new HashMap<>();
        exceptedDataMap.put("name",name);
        exceptedDataMap.put("job",job);

        return exceptedDataMap;

    }
}
/*
{
    "name": "morpheus",
    "job": "leader",
    "id": "342",
    "createdAt": "2022-11-08T10:39:00.113Z"
}
 */
