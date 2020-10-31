package com.polykhel.sbp.service.demo;

import com.polykhel.sbp.service.QueryService;
import com.polykhel.sbp.service.filter.LongFilter;
import com.polykhel.sbp.service.filter.StringFilter;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class BaseEntityQueryService extends QueryService<BaseEntity> {

    public Specification<BaseEntity> createSpecification(BaseEntityCriteria criteria) {
        Specification<BaseEntity> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = Objects.requireNonNull(specification).and(buildSpecification(criteria.getId(), BaseEntity_.id));
            }
            if (criteria.getName() != null) {
                specification = Objects.requireNonNull(specification).and(buildStringSpecification(criteria.getName(), BaseEntity_.name));
            }
        }
        return specification;
    }

    static class BaseEntityCriteria {
        LongFilter id;
        StringFilter name;

        public LongFilter getId() {
            return id;
        }

        public StringFilter getName() {
            return name;
        }
    }
}
