package com.rakib.strategypattern.`interface`

import com.rakib.strategypattern.enums.EncodingPatternEnum

class SHA2Encryption : Encryptionss {
    override fun encryption(toBeEncrypted: String) {
        System.out.println("Encrypted by SHA2")
    }

    override fun getEncryptionType(): EncodingPatternEnum {
        return EncodingPatternEnum.SHA2
    }
}