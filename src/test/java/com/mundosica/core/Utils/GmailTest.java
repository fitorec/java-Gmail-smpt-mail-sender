package com.mundosica.core.Utils;

import org.junit.Test;

public class GmailTest {

	@Test
	public void testSendDirecto() {
		Gmail.send(
				"login", "some.user@gmail.com",
				"password", "secret",
				"to", "edw_inkisidor@hotmail.com",
				"cc", "chanerec@gmail.com",
				"bcc", "eymard@gmail.com",
				"subject", "prueba de email",
				"body", "<h1>Esto es una prueba de envio de correos</h1><p>exitosa!!</p>"
		);
	}
	
	@Test
	public void testConfigYSend() {
		//Esto quizas en el archivo de configuracion
		Gmail.config(
				"username", "some.user@gmail.com", //alias de login
				"pass", "**secret**", //alias de password
				"to", "edw_inkisidor@hotmail.com",
				"cc", "chanerec@gmail.com",
				"bcc", "eymard@gmail.com"
		);
		//esto en donde se envia el correo previamente ya configurado los parametros
		Gmail.send(
				"title", "prueba de email",//alias de subject
				"msg", "<h1>Esto es una prueba de envio de correos</h1><p>exitosa!!</p>"
		);
	}
}
