package ejb;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.jws.WebService;

/**
 * For the no-interface view, you probably want @LocalBean
 * instead of @Local if you have other views (Remote, WebService)
 * @author Ian Darwin
 */
@Stateless
@LocalBean
@Remote
@WebService
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
