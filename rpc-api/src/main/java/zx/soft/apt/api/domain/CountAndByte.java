package zx.soft.apt.api.domain;

import java.io.Serializable;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class CountAndByte implements Serializable {

	private static final long serialVersionUID = 375898254046356660L;

	private float req_count;
	private float req_byte;

	public CountAndByte() {
		super();
	}

	public CountAndByte(float req_count, float req_byte) {
		super();
		this.req_count = req_count;
		this.req_byte = req_byte;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(req_count, req_byte);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("req_count", this.req_count).add("req_byte", this.req_byte)
				.toString();
	}

	public float getReq_count() {
		return req_count;
	}

	public void setReq_count(int req_count) {
		this.req_count = req_count;
	}

	public float getReq_byte() {
		return req_byte;
	}

	public void setReq_byte(int req_byte) {
		this.req_byte = req_byte;
	}

}
