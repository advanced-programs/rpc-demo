package zx.soft.apt.api.domain;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class PostData implements Serializable {

	private static final long serialVersionUID = -2119507001878177237L;

	private int num;
	private List<Info> infos;

	public PostData() {
		super();
	}

	public PostData(int num, List<Info> infos) {
		super();
		this.num = num;
		this.infos = infos;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public List<Info> getInfos() {
		return infos;
	}

	public void setInfos(List<Info> infos) {
		this.infos = infos;
	}

	public void addInfo(Info info) {
		if (this.infos == null)
			this.infos = new LinkedList<>();
		this.infos.add(info);
	}

}
