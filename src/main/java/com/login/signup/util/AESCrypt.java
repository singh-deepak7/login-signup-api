package com.login.signup.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AESCrypt {

    /**
     * AES CBC encryption
     *
     * @param message String to be encrypted
     * @param key     The key
     * @param iv      IV, Need and key Same length
     * @return Return encrypted ciphertext , Encoded as base64
     */
    public static String encryptCBC(String message, String key, String iv) {
        final String cipherMode = "AES/CBC/PKCS5Padding";
        final String charsetName = "UTF-8";
        try {
            byte[] content = new byte[0];
            content = message.getBytes(charsetName);
//
            byte[] keyByte = key.getBytes(charsetName);
            SecretKeySpec keySpec = new SecretKeySpec(keyByte, "AES");
//
            byte[] ivByte = iv.getBytes(charsetName);
            IvParameterSpec ivSpec = new IvParameterSpec(ivByte);
            Cipher cipher = Cipher.getInstance(cipherMode);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
            byte[] data = cipher.doFinal(content);
            final Base64.Encoder encoder = Base64.getEncoder();
            final String result = encoder.encodeToString(data);
            return result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * AES CBC Decrypt
     *
     * @param messageBase64 Ciphertext ,base64 code
     * @param key           The key , Same as when encrypting
     * @param iv            IV, Need and key Same length
     * @return Decrypted data
     */
    public static String decryptCBC(String messageBase64, String key, String iv) {
        final String cipherMode = "AES/CBC/PKCS5Padding";
        final String charsetName = "UTF-8";
        try {
            final Base64.Decoder decoder = Base64.getDecoder();
            byte[] messageByte = decoder.decode(messageBase64);
//
            byte[] keyByte = key.getBytes(charsetName);
            SecretKeySpec keySpec = new SecretKeySpec(keyByte, "AES");
//
            byte[] ivByte = iv.getBytes(charsetName);
            IvParameterSpec ivSpec = new IvParameterSpec(ivByte);
            Cipher cipher = Cipher.getInstance(cipherMode);
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
            byte[] content = cipher.doFinal(messageByte);
            String result = new String(content, charsetName);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * AES ECB encryption
     *
     * @param message String to be encrypted
     * @param key     The key
     * @return Return encrypted ciphertext , Encoded as base64
     */
    public static String encryptECB(String message, String key) {
        final String cipherMode = "AES/ECB/PKCS5Padding";
        final String charsetName = "UTF-8";
        try {
            byte[] content = new byte[0];
            content = message.getBytes(charsetName);
//
            byte[] keyByte = key.getBytes(charsetName);
            SecretKeySpec keySpec = new SecretKeySpec(keyByte, "AES");
            Cipher cipher = Cipher.getInstance(cipherMode);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] data = cipher.doFinal(content);
            final Base64.Encoder encoder = Base64.getEncoder();
            final String result = encoder.encodeToString(data);
            return result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * AES ECB Decrypt
     *
     * @param messageBase64 Ciphertext ,base64 code
     * @param key           The key , Same as when encrypting
     * @return Decrypted data
     */
    public static String decryptECB(String messageBase64, String key) {
        final String cipherMode = "AES/ECB/PKCS5Padding";
        final String charsetName = "UTF-8";
        try {
            final Base64.Decoder decoder = Base64.getDecoder();
            byte[] messageByte = decoder.decode(messageBase64);
//
            byte[] keyByte = key.getBytes(charsetName);
            SecretKeySpec keySpec = new SecretKeySpec(keyByte, "AES");
            Cipher cipher = Cipher.getInstance(cipherMode);
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] content = cipher.doFinal(messageByte);
            String result = new String(content, charsetName);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * test
     */
 /*   public static void main(String[] args) {
        String key = "49346A3CD8BFD3F9100B4CE9DAED72B1";
        String iv = "9836565498764147";
        //B5vet9zrTaD1FsTrJscUWQ==
        String msg = "ja1matad1";
        {
            String encrypt = AESCrypt.encryptCBC(msg, key, iv);
            System.out.println(encrypt);
            String decryptStr = AESCrypt.decryptCBC(encrypt, key, iv);
            System.out.println(decryptStr);
        }
        {
            String encrypt = AESCrypt.encryptECB(msg, key);
            System.out.println(encrypt);
            String decryptStr = AESCrypt.decryptECB(encrypt, key);
            System.out.println(decryptStr);
        }
    }*/



}
