package com.weitest.wms.service.dto.filter;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.util.List;

public class InstantFilter extends RangeFilter<Instant> {

    private static final long serialVersionUID = 1L;

    /**
     * <p>Constructor for InstantFilter.</p>
     */
    public InstantFilter() {
    }

    /**
     * <p>Constructor for InstantFilter.</p>
     *
     * @param filter a InstantFilter object.
     */
    public InstantFilter(final InstantFilter filter) {
        super(filter);
    }

    /** {@inheritDoc} */
    @Override
    public InstantFilter copy() {
        return new InstantFilter(this);
    }

    /** {@inheritDoc} */
    @Override
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    public InstantFilter setEquals(Instant equals) {
        super.setEquals(equals);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    public InstantFilter setNotEquals(Instant equals) {
        super.setNotEquals(equals);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    public InstantFilter setIn(List<Instant> in) {
        super.setIn(in);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    public InstantFilter setNotIn(List<Instant> notIn) {
        super.setNotIn(notIn);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    public InstantFilter setGreaterThan(Instant equals) {
        super.setGreaterThan(equals);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    public InstantFilter setLessThan(Instant equals) {
        super.setLessThan(equals);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    public InstantFilter setGreaterThanOrEqual(Instant equals) {
        super.setGreaterThanOrEqual(equals);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    public InstantFilter setLessThanOrEqual(Instant equals) {
        super.setLessThanOrEqual(equals);
        return this;
    }

}
