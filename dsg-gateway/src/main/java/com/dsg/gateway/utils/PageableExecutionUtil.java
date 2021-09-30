package com.dsg.gateway.utils;

import com.dsg.common.core.constant.DsgConstant;
import com.dsg.common.core.entity.QueryRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import reactor.core.publisher.Flux;

/**
 * @author MrBird
 */
public abstract class PageableExecutionUtil {

    public static <T> Flux<T> getPages(Query query, QueryRequest request, Class<T> clazz,
                                             ReactiveMongoTemplate template) {
        Sort sort = Sort.by("id").descending();
        if (StringUtils.isNotBlank(request.getField()) && StringUtils.isNotBlank(request.getOrder())) {
            sort = DsgConstant.ORDER_ASC.equals(request.getOrder()) ?
                    Sort.by(request.getField()).ascending() :
                    Sort.by(request.getField()).descending();
        }
        Pageable pageable = PageRequest.of(request.getPageNum(), request.getPageSize(), sort);
        return template.find(query.with(pageable), clazz);
    }
}
