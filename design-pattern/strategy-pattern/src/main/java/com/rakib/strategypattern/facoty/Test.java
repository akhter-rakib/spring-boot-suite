package com.rakib.strategypattern.facoty;

import com.rakib.strategypattern.enums.EncodingPatternEnum;

import org.apache.tomcat.util.net.openssl.ciphers.Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class Test {

    Map<EncodingPatternEnum, Encryptionss> map;

    @Autowired
    public Test(Set<Encryption> encryptionSet) {
        createStrategy(encryptionSet);
    }
    private void createStrategy(Set<Encryption> encryptionSet){
        map = new HashMap<EncodingPatternEnum, Encryption>();
        encryptionSet.stream().forEach(encryption -> map.put(encryption.getEncryptionType, encryption))
        );
    }

}
