/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.client.ml;

import org.elasticsearch.client.Validatable;
import org.elasticsearch.client.ValidationException;
import org.elasticsearch.client.core.PageParams;
import org.elasticsearch.common.Nullable;
import org.elasticsearch.common.ParseField;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class GetDataFrameAnalyticsRequest implements Validatable {

    public static final ParseField ALLOW_NO_MATCH = new ParseField("allow_no_match");

    private final List<String> ids;
    private Boolean allowNoMatch;
    private PageParams pageParams;

    /**
     * Helper method to create a request that will get ALL Data Frame Analytics
     * @return new {@link GetDataFrameAnalyticsRequest} object for the id "_all"
     */
    public static GetDataFrameAnalyticsRequest getAllDataFrameAnalyticsRequest() {
        return new GetDataFrameAnalyticsRequest("_all");
    }

    public GetDataFrameAnalyticsRequest(String... ids) {
        this.ids = Arrays.asList(ids);
    }

    public List<String> getIds() {
        return ids;
    }

    public Boolean getAllowNoMatch() {
        return allowNoMatch;
    }

    /**
     * Whether to ignore if a wildcard expression matches no data frame analytics.
     *
     * @param allowNoMatch If this is {@code false}, then an error is returned when a wildcard (or {@code _all})
     *                    does not match any data frame analytics
     */
    public GetDataFrameAnalyticsRequest setAllowNoMatch(boolean allowNoMatch) {
        this.allowNoMatch = allowNoMatch;
        return this;
    }

    public PageParams getPageParams() {
        return pageParams;
    }

    public GetDataFrameAnalyticsRequest setPageParams(@Nullable PageParams pageParams) {
        this.pageParams = pageParams;
        return this;
    }

    @Override
    public Optional<ValidationException> validate() {
        if (ids == null || ids.isEmpty()) {
            return Optional.of(ValidationException.withError("data frame analytics id must not be null"));
        }
        return Optional.empty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GetDataFrameAnalyticsRequest other = (GetDataFrameAnalyticsRequest) o;
        return Objects.equals(ids, other.ids)
            && Objects.equals(allowNoMatch, other.allowNoMatch)
            && Objects.equals(pageParams, other.pageParams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ids, allowNoMatch, pageParams);
    }
}
