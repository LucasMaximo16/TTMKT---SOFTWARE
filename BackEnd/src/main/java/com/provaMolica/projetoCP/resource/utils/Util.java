package com.provaMolica.projetoCP.resource.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

public class Util {
    public static PageRequest createPagination(Integer page, Integer size, Boolean isAsc, String campoOrdenado,
                                               String campoPadrao) {
        return PageRequest.of(
                    page != null ? page : 0,
                    size != null ? size : 10,
                    Sort.by(
                            isAsc != null ? isAsc ? Sort.Direction.ASC : Sort.Direction.DESC : Sort.Direction.ASC,
                            StringUtils.isEmpty(campoOrdenado) ? campoPadrao : campoOrdenado));
    }
}
