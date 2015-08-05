package ejb;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 * At least on WildFly 8, if you have all 3 annotations on
 * a no-interface bean, it cannot be @EJB-injected into JSF,
 * but if you have only 2 (@Local and @Remote) it can. Go figure.
 * @author Ian
 */
@Stateless
@Local
@Remote
// @WebService
@Named
public class DemoSLSB {
	
	@Resource
	SessionContext context;
	
	@PostConstruct
	public void installed() {
		System.out.println("DemoSLSB.installed()");
	}

	public String sayHello() {
		if (context != null) {
			Class<?> invoked = context.getInvokedBusinessInterface();
			System.out.println("sayHello invoked via " + invoked.getName());
		}
		return "Hello from a Demo SLSB";
	}
}
