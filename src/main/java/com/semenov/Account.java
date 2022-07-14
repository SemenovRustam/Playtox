package com.semenov;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {
    private String id;
    private Integer money;
}
