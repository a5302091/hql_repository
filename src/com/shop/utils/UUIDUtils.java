package com.shop.utils;

import java.util.UUID;

/**
 * �������������
 * @author Administrator
 *
 */

public class UUIDUtils {
	
	//���ɼ�����ķ���
	public static  String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}

}
