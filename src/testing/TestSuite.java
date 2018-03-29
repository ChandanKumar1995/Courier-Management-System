package testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
					testAccount.class,
					testAdmin.class,
					testCustomer.class,
					testEmployee.class,
					testManager.class
					})
public class TestSuite {



}
