package cn.hg.test;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestApp
{
	@Test
	public void testQuery()
	{
		String userName = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/test";
		try(Connection conn = DriverManager.getConnection(url, userName, password)) {
			DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
			System.out.println(create.select().from("t_user").getSQL());
			for (String s : create.selectFrom(cn.hg.jooq.tables.Test.TEST).fetch(cn.hg.jooq.tables.Test.TEST.NAME))
			{
				System.out.println(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
