package Common;

import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

public class Startup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerManager.getLogger(Startup.class);
	public Startup() {
		super();
	}

	public void init() {
		logger.info("This finance system is starting.");
		FactoryDao.initializeMaster();
	}
}
