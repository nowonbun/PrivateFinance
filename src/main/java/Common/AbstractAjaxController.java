package Common;

import javax.servlet.http.HttpServletResponse;

public abstract class AbstractAjaxController extends AbstractController {

	protected void returnAjax(HttpServletResponse res, Object data) {
		try {
			res.setContentType("content-type: application/json; charset=utf-8");
			res.getWriter().println(JsonConverter.create(data));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}