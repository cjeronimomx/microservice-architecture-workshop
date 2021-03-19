package com.cjeronimo.demo.driver.adapter.outbound.rest.fallback;


import com.cjeronimo.demo.driver.adapter.inbound.rest.payload.ResponseDTO;
import com.cjeronimo.demo.driver.adapter.outbound.rest.DriverClient;
import com.cjeronimo.demo.driver.domain.model.vo.DriverVO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

//TODO: 3.1 Create com.cjeronimo.demo.driver.adapter.outbound.rest.fallback package
//TODO: 3.2 Create DriverHystrixFallback class
//TODO: 3.3 Annotate this class with @Component
@Component
public class DriverHystrixFallback implements DriverClient {
    @Override
    public ResponseEntity<ResponseDTO<DriverVO>> get(long driverId) {
        return ResponseEntity.ok(ResponseDTO.ok("Fallback", DriverVO.builder().build()));
    }
}
