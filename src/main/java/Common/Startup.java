package Common;

import javax.servlet.http.HttpServlet;

public class Startup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Startup() {
		super();
	}

	public void init() {
		FactoryDao.initializeMaster();
		System.out.println("Startup");
	}
}
