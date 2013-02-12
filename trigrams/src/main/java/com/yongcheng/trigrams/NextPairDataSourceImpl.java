package com.yongcheng.trigrams;

public class NextPairDataSourceImpl implements IDataSource<Pair> {

	private IDataSource<String> nextLineDataSource;

	private String previousLine = null;

	private String[] wordsInCurrentLine = null;
	private String currentLine = null;
	private int index = -1;
	private int length = 0;

	public NextPairDataSourceImpl(IDataSource<String> nextLineDataSource) {
		super();
		this.nextLineDataSource = nextLineDataSource;
	}

	public Pair getNext() {

		if (this.wordsInCurrentLine == null || this.index == this.length - 2) {
			this.previousLine = this.currentLine;
			this.currentLine = this.nextLineDataSource.getNext();

			// --the end of the file
			if (this.currentLine == null) {
				return null;
			}

			// --new Paragraph
			if (this.currentLine.trim().length() == 0) {

			}

			this.wordsInCurrentLine = this.currentLine.split(" ");
			this.index = -1;
			this.length = this.wordsInCurrentLine.length;
		}

		this.index++;
		if (this.index == this.length - 2) {
			return new Pair(this.wordsInCurrentLine[this.index] + " "
					+ this.wordsInCurrentLine[this.index + 1], null);
		}

		return new Pair(this.wordsInCurrentLine[this.index] + " "
				+ this.wordsInCurrentLine[this.index + 1],
				this.wordsInCurrentLine[this.index + 2]);
	}
}
