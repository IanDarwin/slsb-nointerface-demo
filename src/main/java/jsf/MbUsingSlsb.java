package jsf;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import ejb.DemoSLSB;

@ManagedBean
public class MbUsingSlsb {

	@EJB
	private DemoSLSB theEjb;

	public String getGreeting() {
		return theEjb.sayHello();
	}
}
