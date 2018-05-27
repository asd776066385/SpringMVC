package com.base.utils;

import java.util.UUID;

/***
 * @author lxl
 *
 */
public class DBKey {
	
	/**
	 * 生成DBKey
	 * @return
	 */
	public static String getDBKey(){
        return UUID.randomUUID().toString().replace("-", "");
    }
	
}
