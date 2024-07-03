package com.devnic.pezeshasimplemoneytransfersystem.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Locale;

/**
 * @author Nicholas Nzovia
 * @On 03/07/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Slf4j
public class GenerateRandomUUIDUtil {
    public static String generateUniqueUUIDString(){
        String uniqueUUID = RandomStringUtils.randomAlphanumeric(12).toLowerCase(Locale.ROOT);
        log.info("UUID generated"+uniqueUUID);
        return uniqueUUID;
    }
}
