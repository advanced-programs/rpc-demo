package zx.soft.apt.api.domain;

import java.io.Serializable;

import com.google.common.base.MoreObjects;

/**
 * 响应结果
 *
 * @author wanggang
 *
 */
public class ResError implements Serializable {

	private static final long serialVersionUID = -8385788670716202618L;

	private int error_code;
	private String error_msg;

	public ResError() {
		super();
	}

	public ResError(int error_code, String error_msg) {
		super();
		this.error_code = error_code;
		this.error_msg = error_msg;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("error_code", this.error_code).add("error_msg", this.error_msg)
				.toString();
	}

	public int getError_code() {
		return error_code;
	}

	public void setError_code(int error_code) {
		this.error_code = error_code;
	}

	public String getError_msg() {
		return error_msg;
	}

	public void setError_msg(String error_msg) {
		this.error_msg = error_msg;
	}

}
