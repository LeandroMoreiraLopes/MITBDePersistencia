package br.edu.infnet.pedidos.model.persistance;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

public class jdbcUtilTest {

	@Test
	public void test() {
		try (Connection obterConexao = JdbcUtil.obterConexao();)
		{
			Assert.assertTrue("conectado", true);
		} catch (Exception e) {
			fail();
		}
	}

}
