package kr.co.greenart;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

// 서블릿처럼 Annotation 설정 가능.
// 패턴에서 /* '*' 는 모든 요청에 대해서 filter를 거쳐가게 한다.
// 인코딩 같이 변하지 않는 값은 상수나, InitParameter로 설정해준다.web.xml에서도 설정 가능.

@WebFilter(filterName = "EncodingFilter", urlPatterns = "/*", initParams = @WebInitParam(name = "encoding", value = "UTF-8"))
public class EncodingFilter implements Filter {
	private String encoding;
// initparameter는 사용할 값을 하나 설정 해주는 것.
// config객체에 이름과 값이 들어가 있다.(@WebInitParam(name = "encoding", value = "UTF-8")에 설정되어있음;
// web.xml에 initParam을 설정해주면 서버가 구동될 때 생성, 여기에서는 클래스가 로딩 될 때 생성.
// web.xml에서 설정하면, 흐름이 위에서 아래로 흐르며, 먼저 적은 값이 먼저 적용된다.
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// init메소드는 객체가 생성될 때 한 번 호출.
		encoding = filterConfig.getInitParameter("encoding");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 모든 요청에 대해 서블릿이 동작하기 전에 인코딩 시킴.
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response);		
	}
}
