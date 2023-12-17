package com.rakib.strategypattern.`interface`

import com.rakib.strategypattern.enums.EncodingPatternEnum

class Md5Encryption : Encryptionss {
    override fun encryption(toBeEncrypted: String) {
        System.out.println("Encrypted by MD5")
    }

    override fun getEncryptionType(): EncodingPatternEnum {
        return EncodingPatternEnum.MD5
    }
}