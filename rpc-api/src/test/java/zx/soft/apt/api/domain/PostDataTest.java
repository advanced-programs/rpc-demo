package zx.soft.apt.api.domain;

import org.junit.Test;

import zx.soft.utils.json.JsonUtils;

public class PostDataTest {

	@Test
	public void test() {
		PostData postData = new PostData();
		postData.setNum(10);
		for (int i = 0; i < 10; i++) {
			postData.addInfo(new Info("访问ip地址" + i, "访问网站地址" + i, "浏览内容" + i));
		}
		System.out.println(JsonUtils.toJsonWithoutPretty(postData));
	}

}
