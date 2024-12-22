package com.renodesor.taam.taambff.client;

import com.renodesor.taam.generated.client.api.DefaultApi;
import com.renodesor.taam.taambff.config.ApiConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = ApiConfiguration.TAAM_ACTIVITY_CLIENT_NAME, url = "${ACTIVITY_SERVER_URL}", configuration = ApiConfiguration.class)
public interface ActivityApiClient extends DefaultApi
{
}
