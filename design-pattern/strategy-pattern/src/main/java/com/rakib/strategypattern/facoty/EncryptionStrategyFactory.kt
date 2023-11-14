package com.rakib.strategypattern.facoty

import com.rakib.strategypattern.enums.EncodingPatternEnum
import com.rakib.strategypattern.`interface`.Encryptionss
import org.springframework.stereotype.Component
import java.util.*

@Component
class EncryptionStrategyFactory(
        createStrategyFactory: EncryptionStrategyFactory
) {


    fun createStrategy(encryption: Set<Encryptionss>) {
        val map = HashMap<EncodingPatternEnum, Encryptionss>()
        encryption.forEach { encryptionTypeSet ->
            map.put(encryptionTypeSet.getEncryptionType(), encryptionTypeSet)
        }
    }

    fun findEncryptionType(encodingPatternEnum: EncodingPatternEnum){
        return
    }

}