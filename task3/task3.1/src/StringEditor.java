class StringEditor {
	private String originalString;
	private String[] wordArray;

	StringEditor(String originalString) {
		setOriginalString(originalString);
	}

	public void setOriginalString(String originalString) {
		this.originalString = originalString;
	}

	public String[] getWordArray() {
		return wordArray;
	}
	public void setWordArray(String[] wordArray) {
		this.wordArray = wordArray;
	}

	public void parseToArray() {
		String[] tempArray = this.originalString.split(" ");
		setWordArray(tempArray);
	}
}