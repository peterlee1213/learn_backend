package com.example.s04_learn_nimbus;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;

@SpringBootTest
class S04LearnNimbusApplicationTests {

	private final String password = "abcdefgehergiuwegbgweuhfgiuwehguiwejugbniweughweiugh";

	Map<String, Object> data = new HashMap<>();

	@BeforeEach
	public void initData() {
		data.put("username", "zhangsan");
		data.put("email", "zhangsan@gmail.com");
		data.put("age", 20);
	}

	/**
	 * 测试生成使用jws签名的jwt
	 */
	@Test
	public void testSignJWS() {
		// 注意：new Payload的时候可以选择很多类型的参数，比如可以是字符串/Map对象/base64编码/JWSObject等等
		// 这句话定义了jwt的第一部分和第二部分，即「digest方法」和「payload」
		JWSObject jwsObject = new JWSObject(new JWSHeader(JWSAlgorithm.HS384), new Payload(data));

		try {
			// new MACSigner的时候注意长度要求
			jwsObject.sign(new MACSigner(password));
			// JWSObject的serialize（）方法将jwt转化成为点号分割的base64 encoded格式
			String jwt = jwsObject.serialize();
			System.out.println(jwt);
		} catch (JOSEException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 使用密钥验证上述生成的token合法性，并将payload提取出来,上述方法生成的jwt如下：
	 * eyJhbGciOiJIUzM4NCJ9.eyJlbWFpbCI6InpoYW5nc2FuQGdtYWlsLmNvbSIsImFnZSI6MjAsInVzZXJuYW1lIjoiemhhbmdzYW4ifQ.AuF8801xBytYwMhpuVAjKLh48_qNb0YugvjKUJBneh1JFLOOZZbj4fcX2YpeMIUY
	 * 
	 * @throws ParseException
	 * @throws JOSEException
	 */
	@Test
	public void testDecodeJWS() throws ParseException, JOSEException {
		JWSObject jwsObject = JWSObject.parse(
				"eyJhbGciOiJIUzM4NCJ9.eyJlbWFpbCI6InpoYW5nc2FuQGdtYWlsLmNvbSIsImFnZSI6MjAsInVzZXJuYW1lIjoiemhhbmdzYW4ifQ.AuF8801xBytYwMhpuVAjKLh48_qNb0YugvjKUJBneh1JFLOOZZbj4fcX2YpeMIUY");
		JWSVerifier verifier = new MACVerifier(password);
		if (jwsObject.verify(verifier)) {
			System.out.println(jwsObject.getPayload().toString());
		} else {
			System.out.println("验证失败");
		}
	}

}
