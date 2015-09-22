package zx.soft.apt.api.domain;

import java.io.Serializable;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * 用户上网浏览信息
 *
 * @author wanggang
 *
 */
public class Info implements Serializable {

	private static final long serialVersionUID = -6615843546571430346L;

	private String ip;
	private String visisted_url;
	private String content;

	public Info() {
		super();
	}

	public Info(String ip, String visisted_url, String content) {
		super();
		this.ip = ip;
		this.visisted_url = visisted_url;
		this.content = content;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(ip, visisted_url, content);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("ip", this.ip).add("visisted_url", this.visisted_url)
				.add("content", this.content).toString();
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getVisisted_url() {
		return visisted_url;
	}

	public void setVisisted_url(String visisted_url) {
		this.visisted_url = visisted_url;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
