package com.api.utils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class PageUtils {
    public static <T> Page<T> convertListToPage(List<T> list, Pageable pageable) {
        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), list.size());

        // Kiểm tra nếu start >= list.size() thì trả về page rỗng
        if (start >= list.size()) {
            return new PageImpl<>(List.of(), pageable, list.size());
        }

        List<T> sublist = list.subList(start, end);
        return new PageImpl<>(sublist, pageable, list.size());
    }
}
