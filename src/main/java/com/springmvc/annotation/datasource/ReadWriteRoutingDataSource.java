package com.springmvc.annotation.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.util.StringUtils;

public class ReadWriteRoutingDataSource
		extends AbstractRoutingDataSource {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReadWriteRoutingDataSource.class);

	protected Object determineCurrentLookupKey() {
		String routingDataSourceType = ReadWriteRoutingDataSourceHolder.get();
		if (StringUtils.isEmpty(routingDataSourceType)) {
			routingDataSourceType = RoutingDataSourceType.MASTER.toString();
		}
		ReadWriteRoutingDataSourceHolder.clear();

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("############## ReadWriteRoutingDataSource:" + routingDataSourceType + " ##############");
		}

		return routingDataSourceType;
	}
}
