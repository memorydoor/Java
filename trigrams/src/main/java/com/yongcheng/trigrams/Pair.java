package com.yongcheng.trigrams;

import java.io.Serializable;

public class Pair implements Serializable {

	private static final long serialVersionUID = -1986857497107432351L;
	private String left = null;
	private String rigth = null;

	public Pair() {
	}

	public Pair(String left, String rigth) {
		super();
		this.left = left;
		this.rigth = rigth;
	}

	public String getLeft() {
		return this.left;
	}

	public void setLeft(String left) {
		this.left = left;
	}

	public String getRigth() {
		return this.rigth;
	}

	public void setRigth(String rigth) {
		this.rigth = rigth;
	}

}
