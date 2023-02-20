package com.bai1.reposiroty;

import org.springframework.stereotype.Repository;

@Repository
public class SandWichRepository implements ISanWichRepository {
    @Override
    public String save(String[] sandWich) {
        String result = "";
        for (String x : sandWich) {
            result += x + "  ";
        }
        return result;
    }
}
