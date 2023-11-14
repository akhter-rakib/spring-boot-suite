package com.rakib.strategypattern.`interface`

import com.rakib.strategypattern.enums.EncodingPatternEnum

class SHA1Encryption : Encryptionss {
    override fun encryption(toBeEncrypted: String) {
        System.out.println("Encrypted by SHA1")
    }

    override fun getEncryptionType(): EncodingPatternEnum {
        return EncodingPatternEnum.SHA1
    }
}