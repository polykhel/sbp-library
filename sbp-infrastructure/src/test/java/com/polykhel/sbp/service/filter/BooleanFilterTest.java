package com.polykhel.sbp.service.filter;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BooleanFilterTest {

    private BooleanFilter filter;

    private Boolean value = true;

    @BeforeEach
    public void setup() {
        filter = new BooleanFilter();
    }

    @Test
    public void testConstructor() {
        assertThat(filter.getEquals()).isNull();
        assertThat(filter.getNotEquals()).isNull();
        assertThat(filter.getSpecified()).isNull();
        assertThat(filter.getIn()).isNull();
        assertThat(filter.getNotIn()).isNull();
        assertThat(filter.toString()).isEqualTo("BooleanFilter []");
    }

    @Test
    public void testCopy() {
        final BooleanFilter copy = filter.copy();
        assertThat(copy).isNotSameAs(filter);
        assertThat(copy.getEquals()).isNull();
        assertThat(copy.getNotEquals()).isNull();
        assertThat(copy.getSpecified()).isNull();
        assertThat(copy.getIn()).isNull();
        assertThat(copy.getNotIn()).isNull();
        assertThat(copy.toString()).isEqualTo("BooleanFilter []");
    }

    @Test
    public void testSetEquals() {
        Filter<Boolean> chain = filter.setEquals(value);
        assertThat(chain).isEqualTo(filter);
        assertThat(filter.getEquals()).isEqualTo(value);
    }

    @Test
    public void testSetNotEquals() {
        Filter<Boolean> chain = filter.setNotEquals(value);
        assertThat(chain).isEqualTo(filter);
        assertThat(filter.getNotEquals()).isEqualTo(value);
    }

    @Test
    public void testSetSpecified() {
        Filter<Boolean> chain = filter.setSpecified(true);
        assertThat(chain).isEqualTo(filter);
        assertThat(filter.getSpecified()).isEqualTo(true);
    }

    @Test
    public void testSetIn() {
        List<Boolean> list = new LinkedList<>();
        Filter<Boolean> chain = filter.setIn(list);
        assertThat(chain).isEqualTo(filter);
        assertThat(filter.getIn()).isEqualTo(list);
    }

    @Test
    public void testSetNotIn() {
        List<Boolean> list = new LinkedList<>();
        Filter<Boolean> chain = filter.setNotIn(list);
        assertThat(chain).isEqualTo(filter);
        assertThat(filter.getNotIn()).isEqualTo(list);
    }

    @Test
    public void testEquals() {
        final BooleanFilter filter2 = new BooleanFilter();
        assertThat(filter).isEqualTo(filter2);
        filter.setEquals(value);
        filter2.setEquals(value);
        assertThat(filter).isEqualTo(filter2);
        filter.setNotEquals(value);
        filter2.setNotEquals(value);
        assertThat(filter).isEqualTo(filter2);
        filter.setSpecified(false);
        assertThat(filter2).isNotEqualTo(filter);
        filter2.setSpecified(false);
        assertThat(filter).isEqualTo(filter2);
        filter.setIn(Lists.newArrayList(value, value));
        assertThat(filter2).isNotEqualTo(filter);
        filter2.setIn(Lists.newArrayList(value, value));
        assertThat(filter).isEqualTo(filter2);
        filter.setNotIn(Lists.newArrayList(value, value));
        assertThat(filter2).isNotEqualTo(filter);
        filter2.setNotIn(Lists.newArrayList(value, value));
        assertThat(filter).isEqualTo(filter2);
        final BooleanFilter filter3 = new BooleanFilter();
        filter3.setEquals(value);
        assertThat(filter3).isNotEqualTo(filter);
        assertThat(filter3).isNotEqualTo(filter2);
    }

    @Test
    public void testHashCode() {
        final BooleanFilter filter2 = new BooleanFilter();
        assertThat(filter.hashCode()).isEqualTo(filter2.hashCode());
        filter.setEquals(value);
        filter2.setEquals(value);
        assertThat(filter.hashCode()).isEqualTo(filter2.hashCode());
        filter.setNotEquals(value);
        filter2.setNotEquals(value);
        assertThat(filter.hashCode()).isEqualTo(filter2.hashCode());
        filter.setSpecified(false);
        filter2.setSpecified(false);
        assertThat(filter.hashCode()).isEqualTo(filter2.hashCode());
        filter.setIn(Lists.newArrayList(value, value));
        filter2.setIn(Lists.newArrayList(value, value));
        assertThat(filter.hashCode()).isEqualTo(filter2.hashCode());
        filter.setNotIn(Lists.newArrayList(value, value));
        filter2.setNotIn(Lists.newArrayList(value, value));
        assertThat(filter.hashCode()).isEqualTo(filter2.hashCode());
    }

    @Test
    public void testToString() {
        filter.setEquals(value);
        filter.setNotEquals(value);
        filter.setSpecified(true);
        filter.setIn(new LinkedList<>());
        filter.setNotIn(new LinkedList<>());
        String str = value.toString();
        assertThat(filter.toString()).isEqualTo("BooleanFilter [equals=" + str + ", notEquals=" + str + ", specified=true, in=[], notIn=[]]");
    }
}