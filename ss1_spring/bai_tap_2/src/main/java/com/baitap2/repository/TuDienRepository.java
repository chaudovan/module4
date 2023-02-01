package com.baitap2.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TuDienRepository implements ITuDienRepository{
    static private Map<String,String> map = new HashMap<>();
    static {
        map.put("Hello","Xin Chào");
        map.put("Bye","Tạm Biệt");
        map.put("Good","Tốt");
        map.put("Cry","Khóc");
        map.put("Smile","Cười");
    }
    @Override
    public String traTu(String keyWord) {
        return map.get(keyWord);
    }
}
