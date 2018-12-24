package com.idea.cms.config;

import com.alibaba.fastjson.JSONObject;
import com.idea.cms.utils.redis.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 管理员权限拦截器
 * @author Time
 *
 */
public class PermissionInterceptor implements HandlerInterceptor {

	@Resource
	private RedisUtil redisUtil;

	public  final static Pattern pattern = Pattern.compile("\\S*[?]\\S*");

	public static String parseSuffix(String url){
		String[] spUrl = url.toString().split("/");
		String[] res=new String[2];
		res[0]=spUrl[4];
		res[1]=spUrl[5];
		String str1= StringUtils.join(res, "_");
		return str1;
	}
	/**
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 * 权限拦截器，获取session中的权限列表
	 * 匹配当前访问接口url校验权限
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		JSONObject res = new JSONObject();
		HttpSession session = request.getSession();
		boolean flag=false;
		Object permission = session.getAttribute("permission");
		//modify by L
		if (permission==null){
			res.put("success","false");
			res.put("msg","你没有权限");
			response.getWriter().append(res.toString());
			return false;
		}
		String   sa   = permission.toString();
		sa=sa.substring(1,sa.length()-1);
		sa=sa.replaceAll(" ", "");
		String [] stringArr= sa.split(",");
		String requestUrl = request.getRequestURL().toString();
		String url=parseSuffix(requestUrl);
		flag=  Arrays.asList(stringArr).contains(url);
		if(flag){
			return true;
		}else{
			res.put("success","false");
			res.put("msg","你没有权限a");
			response.getWriter().append(res.toString());
			return false;
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}



}
