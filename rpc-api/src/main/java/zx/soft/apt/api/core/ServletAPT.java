package zx.soft.apt.api.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zx.soft.apt.api.domain.QpsAndTps;
import zx.soft.apt.api.domain.ResError;
import zx.soft.apt.api.redis.RedisClient;
import zx.soft.utils.json.JsonUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ServletAPT extends HttpServlet {

	private static final long serialVersionUID = -5723210860421800789L;

	//	private static final DateFormat KEY_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

	// 请求总次数
	private static final AtomicLong REQUEST_COUNT = new AtomicLong(0L);
	// 请求总字节大小
	private static final AtomicLong REQUEST_BYTE = new AtomicLong(0L);

	private static final ObjectMapper MAPPER = JsonUtils.getObjectMapper();

	private static final RedisClient REDIS_CLIENT = new RedisClient();
	private static final String KEY = "cache-qps-tps";

	// 缓存上一次获取的数值
	private static QpsAndTps qpsAndTpsLast = new QpsAndTps(0, 0);

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Set<String> jsonStrs = REDIS_CLIENT.smembers(KEY);
		// 转换成对象
		QpsAndTps qpsAndTps = null;
		for (String jsonStr : jsonStrs) {
			qpsAndTps = MAPPER.readValue(jsonStr.substring(1, jsonStr.length() - 1), QpsAndTps.class);
		}
		if (qpsAndTps == null) {
			qpsAndTps = qpsAndTpsLast;
		} else {
			qpsAndTpsLast = qpsAndTps;
		}
		// 测试数据
		List<QpsAndTps> r = new ArrayList<>();
		r.add(qpsAndTps);
		MAPPER.writeValue(response.getOutputStream(), r);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		// 接受Json字符串
		String json = "";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));) {
			String str = null;
			while ((str = br.readLine()) != null) {
				json += str;
			}
		}
		// 统计次数和字节数
		REQUEST_COUNT.addAndGet(1L);
		REQUEST_BYTE.addAndGet(json.getBytes("UTF-8").length + 0L); // request.getContentLength()
		// 解析POST数据
		//		PostData postData = MAPPER.readValue(json, PostData.class);
		response.setContentType("application/json");
		MAPPER.writeValue(response.getOutputStream(), new ResError(200, "ok"));
	}

}
