package com.yongcheng.trigrams;

import static org.mockito.Mockito.when;
import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NextWordDataSouceImplTest {

	@InjectMocks
	private final NextWordDataSouceImpl underTest = new NextWordDataSouceImpl();

	@Mock
	private IDataSource<String> nextLineDatasource;

	@Test
	public void test_that_getNext_return_I_at_first_time() {

		// --Arrange
		when(this.nextLineDatasource.getNext()).thenReturn("I wish I may ")
				.thenReturn("I wish I might");

		// --Action
		String word = this.underTest.getNext();

		// --Assert
		Assert.assertEquals("I", word);
	}

	@Test
	public void test_that_getNext_return_wish_at_second_time() {

		// --Arrange
		when(this.nextLineDatasource.getNext()).thenReturn("I wish I may ")
				.thenReturn("I wish I might");

		// --Action
		this.underTest.getNext();
		String word = this.underTest.getNext();

		// --Assert
		Assert.assertEquals("wish", word);
	}

	@Test
	public void test_that_getNext_return_might_at_last_time() {

		// --Arrange
		when(this.nextLineDatasource.getNext()).thenReturn("I wish I may ")
				.thenReturn("I wish I might").thenReturn(null);

		// --Action

		String temp = null;
		String lastWord = null;
		while (true) {
			temp = this.underTest.getNext();
			if (temp == null) {
				break;
			}
			lastWord = temp;
		}
		// --Assert
		Assert.assertEquals("might", lastWord);
	}
}
