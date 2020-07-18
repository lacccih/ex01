package org.zerock.domain;

public class SearchCriteria extends Criteria {

	private String serachType;
	
	private String kryword;

	public String getSerachType() {
		return serachType;
	}

	public void setSerachType(String serachType) {
		this.serachType = serachType;
	}

	public String getKryword() {
		return kryword;
	}

	public void setKryword(String kryword) {
		this.kryword = kryword;
	}

	@Override
	public String toString() {
		return "SearchCriteria [serachType=" + serachType + ", kryword=" + kryword + "]";
	}
	
}
