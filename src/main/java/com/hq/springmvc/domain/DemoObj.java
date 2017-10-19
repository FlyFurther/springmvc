package com.hq.springmvc.domain;

import lombok.Data;

/**
 * Created by hq on 17/10/15.
 */
@Data
public class DemoObj {
    private Long id;
    private String name;

    public DemoObj() {
        super();
    }

    public DemoObj(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}
