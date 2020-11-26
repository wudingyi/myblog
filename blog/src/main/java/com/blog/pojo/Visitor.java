package com.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Visitor {

    private String ip;

    @Override
    public String toString() {
        return "Visitor{" +
                "ip='" + ip + '\'' +
                '}';
    }
}
