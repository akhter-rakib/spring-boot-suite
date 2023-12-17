package com.rakib.strategypattern.`interface`

import com.rakib.strategypattern.enums.EncodingPatternEnum

interface Encryptionss {
    fun encryption(toBeEncrypted: String)
    fun getEncryptionType(): EncodingPatternEnum
}