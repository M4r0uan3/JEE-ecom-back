package org.sid.billing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
//@RefreshScope
public class ConsulConfigRestController {
//    @Value("${token.accessTockenTimeout}")
//    private long accessTockenTimeout;
//    @Value("${token.refreshTockenTimeout}")
//    private long refreshTockenTimeout;
    private MyConsulConfig myConsulConfig;
    private MyVaultConfig myVaultConfig;

    public ConsulConfigRestController(MyConsulConfig myConsulConfig, MyVaultConfig myVaultConfig) {
        this.myConsulConfig = myConsulConfig;
        this.myVaultConfig = myVaultConfig;
    }

    @GetMapping("/myConfig")
    public Map<String, Object> myConfig(){
        return Map.of("consuleConfig", myConsulConfig, "vaultConfig",myVaultConfig);
    }
}
