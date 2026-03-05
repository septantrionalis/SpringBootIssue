package com.example.springbootissue.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum HierarchyType {

    RN(19);

    private final int order;

}
