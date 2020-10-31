package com.polykhel.sbp.service.demo;

import com.polykhel.sbp.service.QueryService;
import com.polykhel.sbp.service.filter.LongFilter;
import org.springframework.data.jpa.domain.Specification;

/**
 * This class is just a compile - test.
 */
public class ChildEntityQueryService extends QueryService<ChildEntity> {

    public Specification<ChildEntity> createSpecification(ChildEntityCriteria criteria) {
        Specification<ChildEntity> specification = Specification.where(null);
        if (criteria.getParentId() != null) {
            specification = specification.and(buildReferringEntitySpecification(criteria.getParentId(), ChildEntity_.parent, ParentEntity_.id));
        }
        return specification;
    }

    static class ChildEntityCriteria extends BaseEntityQueryService.BaseEntityCriteria {
        LongFilter parentId;

        public LongFilter getParentId() {
            return id;
        }
    }

}
