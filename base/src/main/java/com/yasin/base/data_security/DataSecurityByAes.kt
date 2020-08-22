package com.yasin.base.data_security

import javax.crypto.Cipher
import java.security.SecureRandom
import android.util.Base64
import javax.crypto.spec.SecretKeySpec


/**
 * create by yasin
 * email yasinleng@163.com
 */
class DataSecurityByAes: DataSecurity {
    val AES="AES"

    override fun encrypt(message: String, password: String):String {
        val result = createCipher(password,true).doFinal(message.toByteArray())
        return Base64.encodeToString(result, Base64.NO_WRAP)
    }

    override fun decode(message: String,password: String): String {
        val buffer = Base64.decode(message, Base64.NO_WRAP)
        val encrypted = createCipher(password,false).doFinal(buffer)
        return String(encrypted)
    }

    fun createCipher(password: String,isEncrypt:Boolean):Cipher{
        val cipher = Cipher.getInstance(AES)
        val skeySpec = SecretKeySpec(password.toByteArray(), AES)
        val random = SecureRandom()
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, random)
        if (isEncrypt)
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, random)
        else
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, random)

        return cipher
    }

}