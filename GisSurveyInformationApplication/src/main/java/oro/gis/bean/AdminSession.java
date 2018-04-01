package oro.gis.bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AdminSession 
{
	public static boolean reloginRequired(HttpServletRequest request)
	{
		boolean reLogin = false;
		HttpSession session = request.getSession(false);
		if(session.getAttribute("logged")==null)
			reLogin = true;
		return reLogin;
	}

}
