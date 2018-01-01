package cn.et.lesson03.food.entity;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import com.sun.xml.internal.ws.message.ByteArrayAttachment;

public class Result {
	/**
	 * ������Ϣ״̬
	 * 0��ʾʧ��
	 * 1��ʾ�ɹ�
	 */
	private int code;
	/**
	 * ʧ���Ժ����Ϣ
	 */
	private String message;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		if(message!=null && message.length()>1000){
			return message.substring(0,1000);
		}
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * 
	 * ��дsetMessage�������쳣�Ķ�ջ��Ϣ���õ�message��
	 * @param e
	 */
	public void setMessage(Exception msg) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		msg.printStackTrace(new PrintStream(baos));
		this.message = new String(baos.toByteArray());
	}
	
}
