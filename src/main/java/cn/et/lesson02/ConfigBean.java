package cn.et.lesson02;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;

/**
 * 通过注解产生Bean
 * 
 * 方法的返回值就是他Bean的类型
 * @author Administrator
 *
 */
@Configuration
public class ConfigBean {
	/**
	 * 这里相当于配置文件中的
	 * <bean id="druidStatView" class="cn.XXX.ServletRegistrationBean"/>
	 * @return
	 */
	@Bean
	public ServletRegistrationBean druidStatView() {
		ServletRegistrationBean srb = new ServletRegistrationBean();
		srb.setName("DruidStatView");
		//构造一个servlet
		StatViewServlet svs = new StatViewServlet();
		//需要一个servlet
		srb.setServlet(svs);
		//需要拦截的路径
		String url = "/druid/*";
		//需要一个集合,表示能拦截多个路径
		List<String> urls = new ArrayList<String>();
		urls.add(url);
		srb.setUrlMappings(urls);
		
		//查看访问情况的用户名和密码
		//用户名密码是键值对的形式  new一个map集合
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
		linkedHashMap.put("loginUsername", "admin");
		linkedHashMap.put("loginPassword", "123456");
		srb.setInitParameters(linkedHashMap);
		return srb;
	}
}
