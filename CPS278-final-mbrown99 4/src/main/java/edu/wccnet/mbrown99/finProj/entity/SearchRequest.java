package edu.wccnet.mbrown99.finProj.entity;

public class SearchRequest {
	private String searchType;
	private String inputText;
	
	public SearchRequest() {
		
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getInputText() {
		return inputText;
	}

	public void setInputText(String inputText) {
		this.inputText = inputText;
	}

	@Override
	public String toString() {
		return "SearchRequest [searchType=" + searchType + ", inputText=" + inputText + "]";
	}

}
