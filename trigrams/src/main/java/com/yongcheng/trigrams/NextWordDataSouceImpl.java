package com.yongcheng.trigrams;

public class NextWordDataSouceImpl implements IDataSource<String> {

	private IDataSource<String> nextLineDataSource;

	private String[] wordsInCurrentLine = null;

	private int index = -1;
	private int length = 0;

	public String getNext() {

		if (this.index == this.length - 1 && this.length != 0) {
			this.wordsInCurrentLine = null;
		}

		if (this.wordsInCurrentLine == null) {
			String nextLine = this.nextLineDataSource.getNext();

			if (nextLine == null) {
				return null;
			}

			this.wordsInCurrentLine = nextLine.split(" ");
			this.index = -1;
			this.length = this.wordsInCurrentLine.length;
		}

		return this.wordsInCurrentLine[++this.index];
	}
}
