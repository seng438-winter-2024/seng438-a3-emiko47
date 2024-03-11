package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jfree.data.KeyedValues;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {
	
	@Test
	public void calculateColumnTotalForTwoValues() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(1, 0);
	            will(returnValue(2.5));
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    // verify
	    assertEquals(result, 10.0, .000000001d);
	    // tear-down: NONE in this test method
	}
	
	@Test
	public void calculateColumnTotalForFiveValues() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(5));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(1, 0);
	            will(returnValue(2.5));
	            one(values).getValue(2, 0);
	            will(returnValue(2.5));
	            one(values).getValue(3, 0);
	            will(returnValue(2.5));
	            one(values).getValue(4, 0);
	            will(returnValue(7.5));
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    // verify
	    assertEquals(result, 22.5, .000000001d);
	    // tear-down: NONE in this test method
	}
	
	@Test
	public void calculateColumnTotalOfEmptyTable() {
	 // setup
	 Mockery mockingContext = new Mockery();
	 final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(0));
	            one(values).getColumnCount();
	            will(returnValue(0));
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    // verify
	    assertEquals(result, 0.0, .000000001d);
	    // tear-down: NONE in this test method
	}
	
	@Test
	public void calculateColumnTotalWithOutOfBoundIndex() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(1, 0);
	            will(returnValue(2.5));
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 3);
	    // verify
	    assertEquals(result, 0.0, .000000001d);
	    // tear-down: NONE in this test method
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void calculateColumnTotalWithInvalidDataObject() {
		DataUtilities.calculateColumnTotal(null, 1);
	}
	
	// calculateRowTotal
	@Test
	public void calculateRowTotalForTwoValues() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(0, 1);
	            will(returnValue(2.5));
	        }
	    });
	    double result = DataUtilities.calculateRowTotal(values, 0);
	    // verify
	    assertEquals(result, 10.0, .000000001d);
	    // tear-down: NONE in this test method
	}
	
	@Test
	public void calculateRowTotalForFiveValues() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(5));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(0, 1);
	            will(returnValue(2.5));
	            one(values).getValue(0, 2);
	            will(returnValue(2.5));
	            one(values).getValue(0, 3);
	            will(returnValue(2.5));
	            one(values).getValue(0, 4);
	            will(returnValue(7.5));
	        }
	    });
	    double result = DataUtilities.calculateRowTotal(values, 0);
	    // verify
	    assertEquals(result, 22.5, .000000001d);
	    // tear-down: NONE in this test method
	}
	
	@Test
	public void calculateRowTotalOfEmptyTable() {
	 // setup
	 Mockery mockingContext = new Mockery();
	 final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(0));
	            one(values).getColumnCount();
	            will(returnValue(0));
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    // verify
	    assertEquals(result, 0.0, .000000001d);
	    // tear-down: NONE in this test method
	}
	
	@Test
	public void calculateRowTotalWithOutOfBoundIndex() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(0, 1);
	            will(returnValue(2.5));
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 3);
	    // verify
	    assertEquals(result, 0.0, .000000001d);
	    // tear-down: NONE in this test method
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void calculateRowTotalWithInvalidDataObject() {
		DataUtilities.calculateRowTotal(null, 1);
	}
	
	// createNumberArray
	@Test
	public void testCreateNumberArrayNormalCase() {
	 double[] data = {1.0, 2.0, 3.0};
	    Number[] result = DataUtilities.createNumberArray(data);
	    System.out.println(result);
	    assertArrayEquals("Array should contain Number equivalents of double values",
	                         new Number[]{1.0, 2.0, 3.0}, result);
	}
	
	@Test
	public void testCreateNumberArrayEmptyArray() {
	    double[] data = {};
	    Number[] result = DataUtilities.createNumberArray(data);
	    assertEquals("Resulting array should be empty", 0, result.length);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNumberArrayNullCase() {
	    DataUtilities.createNumberArray(null);
	}
	
	@Test
	public void testCreateNumberArraySingleElement() {
	    double[] data = {42.0};
	    Number[] result = DataUtilities.createNumberArray(data);
	    assertArrayEquals("Array should contain a single Number equivalent of double value",
	                      new Number[]{42.0}, result);
	}
	
	@Test
	public void testCreateNumberArrayLargeArray() {
	    double[] data = new double[1000];
	    for(int i = 0; i < data.length; i++) {
	        data[i] = i;
	    }
	    Number[] result = DataUtilities.createNumberArray(data);
	    Number[] expected = new Number[1000];
	    for(int i = 0; i < expected.length; i++) {
	        expected[i] = i;
	    }
	    assertArrayEquals("Large arrays should be equal", expected, result);
	}
	
	@Test
	public void testCreateNumberArraySpecialValues() {
	    double[] data = {Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};
	    Number[] result = DataUtilities.createNumberArray(data);
	    Number[] expected = {Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};
	    for (int i = 0; i < expected.length; i++) {
	        assertEquals("Special value should be equal",
	            expected[i].doubleValue(), result[i].doubleValue(), 0.0);
	    }
	}

	// createNumberArray2D() 
	@Test
    public void testCreateNumberArray2DNormalCase() {
        double[][] data = {{1.0, 2.0}, {3.0, 4.0}};
        Number[][] result = DataUtilities.createNumberArray2D(data);
        assertArrayEquals("Array should contain Number equivalents of double values",
                          new Number[][]{{1.0, 2.0}, {3.0, 4.0}}, result);
    }

    @Test
    public void testCreateNumberArray2DEmptyArray() {
        double[][] data = {};
        Number[][] result = DataUtilities.createNumberArray2D(data);
        assertEquals("Resulting array should be empty", 0, result.length);
    }

    @Test
    public void testCreateNumberArray2DSubArrayEmpty() {
        double[][] data = {{}, {1.0, 2.0}};
        Number[][] result = DataUtilities.createNumberArray2D(data);
        assertEquals("First sub-array should be empty", 0, result[0].length);
        assertArrayEquals("Second sub-array should contain Numbers",
                          new Number[]{1.0, 2.0}, result[1]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateNumberArray2DNullCase() {
        DataUtilities.createNumberArray2D(null);
    }

    @Test
    public void testCreateNumberArray2DSingleElement() {
        double[][] data = {{42.0}};
        Number[][] result = DataUtilities.createNumberArray2D(data);
        assertArrayEquals("Array should contain a single sub-array with a single Number",
                          new Number[][]{{42.0}}, result);
    }

    @Test
    public void testCreateNumberArray2DVariedLength() {
        double[][] data = {{1.0}, {2.0, 3.0}};
        Number[][] result = DataUtilities.createNumberArray2D(data);
        assertArrayEquals("First sub-array should contain a single Number",
                          new Number[]{1.0}, result[0]);
        assertArrayEquals("Second sub-array should contain two Numbers",
                          new Number[]{2.0, 3.0}, result[1]);
    }

    @Test
    public void testCreateNumberArray2DSpecialValues() {
        double[][] data = {{Double.NaN, Double.POSITIVE_INFINITY}, {Double.NEGATIVE_INFINITY}};
        Number[][] result = DataUtilities.createNumberArray2D(data);
        assertEquals("Special value NaN should be equal",
                     Double.NaN, result[0][0].doubleValue(), 0.0);
        assertEquals("Special value POSITIVE_INFINITY should be equal",
                     Double.POSITIVE_INFINITY, result[0][1].doubleValue(), 0.0);
        assertEquals("Special value NEGATIVE_INFINITY should be equal",
                     Double.NEGATIVE_INFINITY, result[1][0].doubleValue(), 0.0);
    }
    
    // getCumulativePercetages
    
    @Test
    public void testGetCumulativePercentagesNormalCase() {
    	// setup
	    Mockery mockingContext = new Mockery();
	    final KeyedValues values = mockingContext.mock(KeyedValues.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getKeys();
	            will(returnValue(new int[] {0, 1, 2}));
	            one(values).getValue(0);
	            will(returnValue(5));
	            one(values).getValue(1);
	            will(returnValue(9));
	            one(values).getValue(2);
	            will(returnValue(2));
	        }
	    });

        KeyedValues result = DataUtilities.getCumulativePercentages(values);
        
        // verify
        assertEquals("The first value should be 5/16", 0.3125, result.getValue(0).doubleValue(), 0.0001);
        assertEquals("The second value should be (5+9)/16", 0.875, result.getValue(1).doubleValue(), 0.0001);
        assertEquals("The third value should be 1.0", 1.0, result.getValue(2).doubleValue(), 0.0001);
    }

    @Test
    public void testGetCumulativePercentagesEmptyCase() {
    	// setup
	    Mockery mockingContext = new Mockery();
	    final KeyedValues values = mockingContext.mock(KeyedValues.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getKeys();
	            will(returnValue(new int[] {}));
	        }
	    });

        KeyedValues result = DataUtilities.getCumulativePercentages(values);

        assertTrue("Resulting KeyedValues should be empty", result.getKeys().isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCumulativePercentagesNullCase() {
        DataUtilities.getCumulativePercentages(null);
    }

    @Test
    public void testGetCumulativePercentagesSingleElement() {
    	// setup
	    Mockery mockingContext = new Mockery();
	    final KeyedValues values = mockingContext.mock(KeyedValues.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getKeys();
	            will(returnValue(new int[] {0}));
	            one(values).getValue(0);
	            will(returnValue(5));        
	        }
	    });

        KeyedValues result = DataUtilities.getCumulativePercentages(values);

        assertEquals("The single value should have a cumulative percentage of 1.0", 1.0, result.getValue(0).doubleValue(), 0.0001);
    }
    @Test
    public void calculateColumnTotalForNegativeValues() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(-2.5));
                one(values).getValue(1, 0);
                will(returnValue(-3.5));
                one(values).getValue(2, 0);
                will(returnValue(-4.5));
            }
        });
        double result = DataUtilities.calculateColumnTotal(values, 0);
        // verify
        assertEquals(result, -10.5, .000000001d);
    }


    @Test
    public void calculateRowTotalForNegativeValues() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(-2.5));
                one(values).getValue(0, 1);
                will(returnValue(-3.5));
                one(values).getValue(0, 2);
                will(returnValue(-4.5));
            }
        });
        double result = DataUtilities.calculateRowTotal(values, 0);
        // verify
        assertEquals(result, -10.5, .000000001d);
    }

    //This test tests the Clone() method from the data utilities class,
    //It tests the scenario where the input array contains a null value and expects the method to clone
    
    //we expect the test to pass and clone the array with the null value.
    @Test
    public void testCloneArrayWithNullPart() {
        double[][] source = {
        		{12, 21, 11}, 
        		{34, 43, 54},
        		null
        };
        
        double[][] result = DataUtilities.clone(source);
        assertNotNull(result);
        assertNotNull(result[0]); 
        assertNull(result[1]);
        assertNotNull(result[2]); 
    }


    //This test tests the createNumberArray() method from the data utilities class
    //It test the scenario where the values used to create the array include both negative and positive floats 
    
    //we expect the test to pass and create the array with the values given
    @Test
    public void testCreateNumberArrayWithMixedValues() {
        double[] data = {1.0, -2.0, 3.5, -4.2};
        Number[] result = DataUtilities.createNumberArray(data);
        assertArrayEquals("Array should contain Number equivalents of double values",
                new Number[]{1.0, -2.0, 3.5, -4.2}, result);
    }

  
    //This test tests the createNumberArray2D() method from the data utilities class
    //It test the scenario where the values used to create the 2D array include both negative and positive floats
    
    //we expect the test to pass and create the 2D array with the values given
    @Test
    public void testCreateNumberArray2DWithMixedValues() {
        double[][] data = {{1.0, -2.0}, {3.5, -4.2}};
        Number[][] result = DataUtilities.createNumberArray2D(data);
        assertArrayEquals("Array should contain Number equivalents of double values",
                new Number[][]{{1.0, -2.0}, {3.5, -4.2}}, result);
    }

  

    @Test
    public void testGetCumulativePercentagesWithNegativeValues() {
        // setup
        Mockery mockingContext = new Mockery();
        final KeyedValues values = mockingContext.mock(KeyedValues.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getKeys();
                will(returnValue(new int[] {0, 1, 2}));
                one(values).getValue(0);
                will(returnValue(-5));
                one(values).getValue(1);
                will(returnValue(-3));
                one(values).getValue(2);
                will(returnValue(-2));
            }
        });

        KeyedValues result = DataUtilities.getCumulativePercentages(values);

        // verify
        assertEquals("The first value should be -5/16", -0.3125, result.getValue(0).doubleValue(), 0.0001);
        assertEquals("The second value should be (-5-3)/16", -0.5625, result.getValue(1).doubleValue(), 0.0001);
        assertEquals("The third value should be 1.0", 1.0, result.getValue(2).doubleValue(), 0.0001);
    }
    
    @Test
    public void testEqualForTwoPositiveArraysThatAreEqual() {
        double[][] arr1 = {
               {12, 21, 11},
               {34, 43, 54},
               {67, 68, 69}
        };
        
        double[][] arr2 = {
               {12, 21, 11},
               {34, 43, 54},
               {67, 68, 69}
        };
        
       boolean result = DataUtilities.equal(arr1, arr2);
       assertEquals(true, result);
    }

    @Test
    public void testEqualForTwoPositiveArraysThatAreNotEqual() {
        double[][] arr1 = {
               {12, 21, 11},
               {34, 43, 54},
               {67, 68, 69}
        };
        
        double[][] arr2 = {
               {123, 245, 75},
               {4, 5, 85},
               {35, 185, 142}
        };
        
       boolean result = DataUtilities.equal(arr1, arr2);
       assertEquals(false, result);
    }

    @Test
    public void testEqualForTwoArraysThatAreNull() {
        double[][] arr1 = null;
        double[][] arr2 = null;
        
       boolean result = DataUtilities.equal(arr1, arr2);
       assertEquals(false, result);
    }

    @Test
    public void testEqualForWhenArrayBIsNull() {
        double[][] arr1 = {
               {12, 21, 11},
               {34, 43, 54},
               {67, 68, 69}
        };
        
        double[][] arr2 = null;
        
       boolean result = DataUtilities.equal(arr1, arr2);
       assertEquals(false, result);
    }

    
    //This test tests the equal() method from method from the data utilities class,
    //In this scenario, one of the arrays is left null and compared to the other fully populated array
    
    //we expect the test to pass as we're expecting a false.
    @Test
    public void testEqualForWhenArrayAIsNull() {
        double[][] arr1 = null;
        
        double[][] arr2 = {
               {12, 21, 11},
               {34, 43, 54},
               {67, 68, 69}
        };
        
       boolean result = DataUtilities.equal(arr1, arr2);
       assertEquals(false, result);
    }

    //This test tests the equal() method from method from the data utilities class,
    //In this scenario, one of the array is a different legnth than the other.
    
    //we expect this test to pass as we're expecting a false
    @Test
    public void testEqualForWhenArraysAreDifferentLengths() {
        double[][] arr1 = {
                {2, 6, 8}
        };
        
        double[][] arr2 = {
               {12, 21, 11},
               {34, 43, 54},
               {67, 68, 69}
        };
        
       boolean result = DataUtilities.equal(arr1, arr2);
       assertEquals(false, result);
    }
    
    @Test
    public void testClonePositiveArray() {
        double[][] source = {
               {12, 21, 11},
               {34, 43, 54},
               {67, 68, 69}
        };
        
       double[][] result = DataUtilities.clone(source);
       assertEquals(source.length, result.length);
       assertArrayEquals(source[0], result[0], 0.001);
    }
    
    

    @Test
    public void calculateColumnTotalForMixedValues() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);	
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(2.5));
                one(values).getValue(1, 0);
                will(returnValue(-3.5));
                one(values).getValue(2, 0);
                will(returnValue(4.5));
            }
        });
        double result = DataUtilities.calculateColumnTotal(values, 0);
        // verify
        assertEquals(result, 3.5, .000000001d);
    }


}